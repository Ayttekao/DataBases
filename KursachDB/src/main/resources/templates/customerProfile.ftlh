<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

    <title>PHPJabbers.com | Free Car Dealer Website Template</title>

    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="../../static/css/font-awesome.css">

    <link rel="stylesheet" href="../../static/css/style.css">

</head>

<body>

<!-- ***** Preloader Start ***** -->
<div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
        <span class="dot"></span>
        <div class="dots">
            <span></span>
            <span></span>
            <span></span>
        </div>
    </div>
</div>
<!-- ***** Preloader End ***** -->

<!-- ***** Blog Start ***** -->
<section class="section" id="our-classes">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="section-heading">
                    <h2>Hello <em>${customer.username}</em></h2>
                    <img src="../../static/images/features-first-icon.png" alt="First One">
                    <h4>${customer.email}</h4>
                </div>
            </div>
            <div class="col-md-8">
                <div class="section-heading">
                    <h2>Personal <em>Area</em></h2>
                    <img src="../../static/images/line-dec.png" alt="">
                    <p>Nunc urna sem, laoreet ut metus id, aliquet consequat magna. Sed viverra ipsum dolor, ultricies fermentum massa consequat eu.</p>
                </div>
            </div>
        </div>
        <div class="row" id="tabs">
            <div class="col-lg-4">
                <ul>
                    <li><a href='#tabs-1'>Change email</a></li>
                    <li><a href='#tabs-2'>Change username</a></li>
                    <li><a href='#tabs-3'>Change password</a></li>
                </ul>
            </div>
            <div class="col-lg-8">
                <section class='tabs-content'>
                    <article id='tabs-1'>
                        <form action="/user/profile/#{customer.customer_id}/editEmail" method="post">
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Email:</label>
                                <div class="col-sm-8">
                                    <input name="email" type="text" pattern="^[^\s@]+@([^\s@.,]+\.)+[^\s@.,]{2,}$"
                                           class="form-control" placeholder="some@some.com (Your new Email)"
                                           value="<#if customer??>${customer.email}</#if>" required="">
                                </div>
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button class="btn btn-primary" type="submit">Change</button>
                        </form>
                    </article>
                    <article id='tabs-2'>
                        <form action="/user/profile/#{customer.customer_id}/editUsername" method="post">
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">User Name :</label>
                                <div class="col-sm-8">
                                    <input type="text" name="username" value="<#if customer??>${customer.username}</#if>"
                                           class="form-control" placeholder="User name" />
                                </div>
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button class="btn btn-primary" type="submit">Change</button>
                        </form>
                    </article>
                    <article id='tabs-3'>
                        <form action="/user/profile/#{customer.customer_id}/editPassword" method="post"
                              oninput='up2.setCustomValidity(up2.value != up.value ? "Passwords do not match." : "")'>
                        <div class="form-group row">
                            <div class="col-sm-8">
                                <p>
                                    <label for="password1">Password:</label>
                                    <input id="password1" class="form-control" type=password required name=up>
                                <p>
                                    <label for="password2">Confirm password:</label>
                                    <input id="password2" class="form-control" type=password name=up2>
                                <p>
                            </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button class="btn btn-primary" type="submit">Change</button>
                        </form>
                    </article>
                </section>
            </div>
        </div>
    </div>
</section>
<!-- ***** Blog End ***** -->

<!-- ***** Header Area Start ***** -->
<#import "blocks/header.ftlh" as h>

<header class="header-area header-sticky">
    <@h.page>
    </@h.page>
</header>
<!-- ***** Header Area End ***** -->



<!-- ***** Footer Start ***** -->
<#import "blocks/footer.ftlh" as f>
<footer>
    <@f.page></@f.page>
</footer>
<!-- ***** Footer End ***** -->

<!-- jQuery -->
<script src="../../static/js/jquery-2.1.0.min.js"></script>

<!-- Bootstrap -->
<script src="../../static/js/popper.js"></script>
<script src="../../static/js/bootstrap.min.js"></script>

<!-- Plugins -->
<script src="../../static/js/scrollreveal.min.js"></script>
<script src="../../static/js/waypoints.min.js"></script>
<script src="../../static/js/jquery.counterup.min.js"></script>
<script src="../../static/js/imgfix.min.js"></script>
<script src="../../static/js/mixitup.js"></script>
<script src="../../static/js/accordions.js"></script>

<!-- Global Init -->
<script src="../../static/js/custom.js"></script>

</body>
</html>