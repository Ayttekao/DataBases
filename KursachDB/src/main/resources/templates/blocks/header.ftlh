<#macro page>
    <#include "security.ftlh">
    <!-- ***** Header Area Start ***** -->
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="/index" class="logo">Car Dealer<em> Website</em></a>
                    <!-- ***** Logo End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a href="/index">Home</a></li>
                        <li><a href="/cars">Cars</a></li>
                        <#if isAdmin>
                            <li><a href="/cars/add">Add car</a></li>
                            <li><a href="/user">Users List</a></li>
                        </#if>
                        <#if known>
                            <li><a href="">${name}</a></li>
                        <#else>
                            <li class="dropdown">
                                <a class="dropdown-toggle active" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Account</a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="/login">Login</a>
                                    <a class="dropdown-item" href="/registration">Registration</a>
                                </div>
                            </li>
                        </#if>
                        <#if known>
                            <div class="main-button">
                                <form action="/logout" method="post">
                                    <button class="btn btn-primary" type="submit">Sign Out</button>
                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                </form>
                            </div>
                        </#if>
                    </ul>
                    <a class='menu-trigger'>
                        <span>Menu</span>
                    </a>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
    <!-- ***** Header Area End ***** -->
</#macro>