package com.example.kursachdb.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Customer implements UserDetails {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customer_id;

    @Column(name = "customer_name")
    private String username;

    @Column(name = "customer_password")
    private String customer_password;

    @Column(name = "email")
    private String email;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "customer_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return customer_password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return customer_id != null && Objects.equals(customer_id, customer.customer_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


