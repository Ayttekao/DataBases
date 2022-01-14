<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

    <title>PHPJabbers.com | Free Car Dealer Website Template</title>

    <link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="../static/css/font-awesome.css">

    <link rel="stylesheet" href="../static/css/style.css">

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


<!-- ***** Header Area Start ***** -->
<#import "blocks/header.ftlh" as h>

<header class="header-area header-sticky">
    <@h.page>
    </@h.page>
</header>
<!-- ***** Header Area End ***** -->

<!-- ***** Contact Us Area Starts ***** -->
<section class="section" id="contact-us" style="margin-top: 0">
    <div class="container-fluid">
        <div class="contact-form section-bg" style="background-image: url(../static/images/contact-1-720x480.jpg)">
            <div class="container">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1">
                        <div class="cta-content">
                            <br>
                            <br>
                            <h2><em>Login</em> to the site</h2>
                            <p>Ut consectetur, metus sit amet aliquet placerat, enim est ultricies ligula</p>
                        </div>
                    </div>
                </div>
            </div>
            <form id="contact" action="/login" method="post">
                <div class="row">
                    <div class="col-md-6 col-sm-12">
                        <fieldset>
                            <input name="customer_name" type="text" placeholder="Your Name*" required="">
                        </fieldset>
                    </div>
                    <div class="col-md-6 col-sm-12">
                        <fieldset>
                            <input name="customer_password" type="password" placeholder="Your Password*" required="">
                        </fieldset>
                    </div>
                    <div class="col-md-2">
                        <fieldset>
                            <button type="submit" id="form-submit" class="main-button">Sign in</button>
                        </fieldset>
                    </div>
                    <div class="col-md-7">
                        <p>
                            Don't have an account? <a href="registration">Register now</a>
                        </p>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                </div>
            </form>
        </div>
    </div>
</section>
<!-- ***** Contact Us Area Ends ***** -->

<!-- ***** Footer Start ***** -->
<#import "blocks/footer.ftlh" as f>
<footer>
    <@f.page></@f.page>
</footer>
<!-- ***** Footer End ***** -->

<!-- jQuery -->
<script src="../static/js/jquery-2.1.0.min.js"></script>

<!-- Bootstrap -->
<script src="../static/js/popper.js"></script>
<script src="../static/js/bootstrap.min.js"></script>

<!-- Plugins -->
<script src="../static/js/scrollreveal.min.js"></script>
<script src="../static/js/waypoints.min.js"></script>
<script src="../static/js/jquery.counterup.min.js"></script>
<script src="../static/js/imgfix.min.js"></script>
<script src="../static/js/mixitup.js"></script>
<script src="../static/js/accordions.js"></script>

<!-- Global Init -->
<script src="../static/js/custom.js"></script>

</body>
</html>