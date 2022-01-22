<!DOCTYPE html>
<html lang="en">
<#include "blocks/security.ftlh">

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

<!-- ***** Call to Action Start ***** -->
<section class="section section-bg" id="call-to-action" style="background-image: url(../static/images/banner-image-1-1920x500.jpg)">
    <div class="container">
        <div class="row">
            <div class="col-lg-10 offset-lg-1">
                <div class="cta-content">
                    <br>
                    <br>
                    <h2>Our <em>Cars</em></h2>
                    <p>Ut consectetur, metus sit amet aliquet placerat, enim est ultricies ligula</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ***** Call to Action End ***** -->

<!-- ***** Fleet Starts ***** -->
<section class="section" id="trainers">
    <div class="container">
        <br>
        <br>
        <div class="contact-form">
            <form action="#" id="contact">
                <div class="row">
                    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
                        <div class="form-group">
                            <label>Body Type:</label>

                            <select name="bodyTypeSelect">
                                <option value="">All</option>
                                <#if bodyTypes?has_content>
                                    <#list bodyTypes as bodyType>
                                        <option value="${bodyType.id}">${bodyType.name}</option>
                                    </#list>
                                <#else>
                                    No body types
                                </#if>
                            </select>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
                        <div class="form-group">
                            <label>Make:</label>

                            <select name="makeTypeSelect">
                                <option value="">All</option>
                                <#if makes?has_content>
                                    <#list makes as make>
                                        <option value="${make.id}">${make.name}</option>
                                    </#list>
                                <#else>
                                    No make
                                </#if>
                            </select>
                        </div>
                    </div>

                    <#--<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
                        <div class="form-group">
                            <label>Upper price limit:</label>

                            <input type="number" step="0.01" name="priceLimit" pattern="[0-9]+">
                             &lt;#&ndash;<select>
                                  <option value="">-- All --</option>
                                  <option value="">-- All --</option>
                                  <option value="">-- All --</option>
                                  <option value="">-- All --</option>
                             </select>&ndash;&gt;
                        </div>
                    </div>-->

                    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
                        <div class="form-group">
                            <label>Gearbox:</label>

                            <select name="gearBoxTypeSelect">
                                <option value="">All</option>
                                <#if gearBoxes?has_content>
                                    <#list gearBoxes as gearBox>
                                        <option value="${gearBox.id}">${gearBox.switchingType} (${gearBox.numberOfGears} speed)</option>
                                    </#list>
                                <#else>
                                    No make
                                </#if>
                            </select>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
                        <div class="form-group">
                            <label>Number of seats:</label>

                            <select name="numSeatsTypeSelect">
                                <option value="">All</option>
                                <#if capacities?has_content>
                                    <#list capacities as capacity>
                                        <option value="${capacity.id}">${capacity.numberOfSeats}</option>
                                    </#list>
                                <#else>
                                    No make
                                </#if>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4 offset-sm-4">
                    <div class="main-button text-center">
                        <button type="submit">Search</button>
                    </div>
                </div>
                <br>
                <br>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
            </form>
        </div>

        <div class="row">
            <#if cars?has_content>
                <#list cars as car>
                    <div class="col-lg-4">
                        <div class="trainer-item">
                            <div class="image-thumb">
                                <#if car.picture.name?has_content>
                                    <img src="../static/images/${car.picture.name}" alt="">
                                <#else>
                                    <img src="../static/images/product-3-720x480.jpg" alt="">
                                </#if>

                            </div>
                            <div class="down-content">
                            <span>
                                <sup>$</sup>${car.price}
                            </span>

                                <h4>${car.brand.name} ${car.model}</h4>

                                <p>
                                    <i class="fa fa-dashboard"></i> ${car.engine.name} &nbsp;&nbsp;&nbsp;
                                    <i class="fa fa-cog"></i> ${car.gearBox.switchingType} (${car.gearBox.numberOfGears} speed) &nbsp;&nbsp;&nbsp;
                                    <i class="fa fa-flag"></i> ${car.country.name} &nbsp;&nbsp;&nbsp;
                                    <i class="fa fa-car"></i> ${car.bodyType.name} &nbsp;&nbsp;&nbsp;
                                </p>

                                <ul class="social-icons">
                                    <li><a href="/cars/${car.car_id}">+ View Car</a></li>
                                    <#if isAdmin>
                                        <li><a href="/cars/${car.car_id}/edit">+ Edit Car</a></li>
                                        <li>
                                            <a>
                                                <form action="/cars/${car.car_id}/delete" method="post">
                                                    <button class="btn btn-primary" type="submit">Delete Car</button>
                                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                                </form>
                                            </a>
                                        </li>
                                    </#if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </#list>
            <#else>
                <section class="section section-bg" id="call-to-action" style="background-image: url(../static/images/banner-image-1-1920x500.jpg)">
                    <div class="container">
                        <div class="cta-content">
                            <h2>The search has not given any <em>results</em></h2>
                            <p>We are definitely expanding our range.</p>
                        </div>
                    </div>
                </section>
            </#if>
        </div>

        <br>

    </div>
</section>
<!-- ***** Fleet Ends ***** -->


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