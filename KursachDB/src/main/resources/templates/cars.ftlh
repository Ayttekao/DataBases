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
                                    <option value="All">All</option>
                                    <#if bodyTypes?has_content>
                                        <#list bodyTypes as bodyType>
                                            <option value="${bodyType.name_body_type}">${bodyType.name_body_type}</option>
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
                                     <option value="All">All</option>
                                     <#if makes?has_content>
                                         <#list makes as make>
                                             <option value="${make.name_brand}">${make.name_brand}</option>
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
                                    <option value="All">All</option>
                                    <#if gearBoxes?has_content>
                                        <#list gearBoxes as gearBox>
                                            <option value="${gearBox.switching_type}">${gearBox.switching_type}</option>
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
                                    <option value="All">All</option>
                                    <#if capacities?has_content>
                                        <#list capacities as capacity>
                                            <option value="${capacity.number_of_seats}">${capacity.number_of_seats}</option>
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
                                    <#if car.picture.picture_name?has_content>
                                        <img src="../static/images/${car.picture.picture_name}" alt="">
                                    <#else>
                                        <img src="../static/images/product-3-720x480.jpg" alt="">
                                    </#if>

                                </div>
                                <div class="down-content">
                            <span>
                                <sup>$</sup>${car.price}
                            </span>

                                    <h4>${car.brand.name_brand} ${car.model}</h4>

                                    <p>
                                        <i class="fa fa-dashboard"></i> ${car.engine.engine_name} &nbsp;&nbsp;&nbsp;
                                        <i class="fa fa-cog"></i> ${car.gearBox.switching_type} &nbsp;&nbsp;&nbsp;
                                        <i class="fa fa-flag"></i> ${car.country.name} &nbsp;&nbsp;&nbsp;
                                        <i class="fa fa-car"></i> ${car.bodyType.name_body_type} &nbsp;&nbsp;&nbsp;
                                    </p>

                                    <ul class="social-icons">
                                        <li><a href="car-details">+ View Car</a></li>
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

            <#--<div class="row">
                <div class="col-lg-4">
                    <div class="trainer-item">
                        <div class="image-thumb">
                            <img src="../static/images/product-1-720x480.jpg" alt="">
                        </div>
                        <div class="down-content">
                            <span>
                                <del><sup>$</sup>11999 </del> &nbsp; <sup>$</sup>11779
                            </span>

                            <h4>Lorem ipsum dolor sit amet, consectetur</h4>

                            <p>
                                <i class="fa fa-dashboard"></i> 130 000km &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cube"></i> 1800 cc &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cog"></i> Manual &nbsp;&nbsp;&nbsp;
                            </p>

                            <ul class="social-icons">
                                <li><a href="car-details">+ View Car</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="trainer-item">
                        <div class="image-thumb">
                            <img src="../static/images/product-2-720x480.jpg" alt="">
                        </div>
                        <div class="down-content">
                            <span>
                                <del><sup>$</sup>11999 </del> &nbsp; <sup>$</sup>11779
                            </span>

                            <h4>Lorem ipsum dolor sit amet, consectetur</h4>

                            <p>
                                <i class="fa fa-dashboard"></i> 130 000km &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cube"></i> 1800 cc &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cog"></i> Manual &nbsp;&nbsp;&nbsp;
                            </p>

                            <ul class="social-icons">
                                <li><a href="car-details">+ View Car</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="trainer-item">
                        <div class="image-thumb">
                            <img src="../static/images/product-3-720x480.jpg" alt="">
                        </div>
                        <div class="down-content">
                            <span>
                                <del><sup>$</sup>11999 </del> &nbsp; <sup>$</sup>11779
                            </span>

                            <h4>Lorem ipsum dolor sit amet, consectetur</h4>

                            <p>
                                <i class="fa fa-dashboard"></i> 130 000km &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cube"></i> 1800 cc &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cog"></i> Manual &nbsp;&nbsp;&nbsp;
                            </p>

                            <ul class="social-icons">
                                <li><a href="car-details">+ View Car</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="trainer-item">
                        <div class="image-thumb">
                            <img src="../static/images/product-4-720x480.jpg" alt="">
                        </div>
                        <div class="down-content">
                            <span>
                                <del><sup>$</sup>11999 </del> &nbsp; <sup>$</sup>11779
                            </span>

                            <h4>Lorem ipsum dolor sit amet, consectetur</h4>

                            <p>
                                <i class="fa fa-dashboard"></i> 130 000km &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cube"></i> 1800 cc &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cog"></i> Manual &nbsp;&nbsp;&nbsp;
                            </p>

                            <ul class="social-icons">
                                <li><a href="car-details">+ View Car</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="trainer-item">
                        <div class="image-thumb">
                            <img src="../static/images/product-5-720x480.jpg" alt="">
                        </div>
                        <div class="down-content">
                            <span>
                                <del><sup>$</sup>11999 </del> &nbsp; <sup>$</sup>11779
                            </span>

                            <h4>Lorem ipsum dolor sit amet, consectetur</h4>

                            <p>
                                <i class="fa fa-dashboard"></i> 130 000km &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cube"></i> 1800 cc &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cog"></i> Manual &nbsp;&nbsp;&nbsp;
                            </p>

                            <ul class="social-icons">
                                <li><a href="car-details">+ View Car</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="trainer-item">
                        <div class="image-thumb">
                            <img src="../static/images/product-6-720x480.jpg" alt="">
                        </div>
                        <div class="down-content">
                            <span>
                                <del><sup>$</sup>11999 </del> &nbsp; <sup>$</sup>11779
                            </span>

                            <h4>Lorem ipsum dolor sit amet, consectetur</h4>

                            <p>
                                <i class="fa fa-dashboard"></i> 130 000km &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cube"></i> 1800 cc &nbsp;&nbsp;&nbsp;
                                <i class="fa fa-cog"></i> Manual &nbsp;&nbsp;&nbsp;
                            </p>

                            <ul class="social-icons">
                                <li><a href="car-details">+ View Car</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>-->

            <br>
                
            <#--<nav>
              <ul class="pagination pagination-lg justify-content-center">
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                  </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                  </a>
                </li>
              </ul>
            </nav>-->

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