CREATE extension if not exists pgcrypto;

UPDATE customer SET customer_password = crypt(customer_password, gen_salt('bf', 8));