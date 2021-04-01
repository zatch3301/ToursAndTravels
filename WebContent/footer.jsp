<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <<style>

footer{
    background-color: #237964;
    }
   
footer .item form input[type="submit"] {
    background-color: #28303e75;
    }
footer .copyright {
    background-color: #3a333159;
    }

</style>
    
		<footer>
            <div class="container">
                <ul>
                    <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                    <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                    <li><a href="#"><i class="fab fa-google-plus-g"></i></a></li>
                </ul>
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-12">
                        <div class="item">
                            <h4 class="text-uppercase">Contact us</h4>
                            <p class="address">
                                123 Second Street Fifth <br>
                                Mumbai,<br>
                                Maharashtra, India<br>
                                +91 916 727 4084
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-12">
                        <div class="item">
                            <h4 class="text-uppercase">additional links</h4>
                            <ul>
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Terms and conditions</a></li>
                                <li><a href="#">Privacy policy</a></li>
                                <li><a href="#">News</a></li>
                                <li><a href="#">Contact us</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-12">
                        <div class="item date">
                            <h4 class="text-uppercase">resent posts</h4>
                            <p><a href="#">01/03/2019</a></p>
                            <p><a href="#">08/05/2019</a></p>
                            <p><a href="#">01/03/2019</a></p>
                            <p><a href="#">08/05/2019</a></p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-12">
                        <div class="item">
                            <h4 class="text-uppercase">newsletter</h4>
                            <form>
                                <input type="text" placeholder="Name">
                                <input type="email" placeholder="Email">
                                <input type="submit" value="Submit">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright text-center">
                <p>Copyright 2020  Design by <a href="https://gaganv.me">Gagan</a></p>
            </div>
        </footer>
        
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
		 <script>
            $(function () {
                
                'use strict'; 
                $('.navbar ul li a.search').click(function (e) {
                    e.preventDefault();
                });
                $('.navbar a.search').click(function () {
                    $('.navbar form').fadeToggle();
                });
            })
        </script>
        <!-- FlexSlider -->
	    <script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
	    <script type="text/javascript">
	    $(function() {
	    $('.flexslider').flexslider({
	          animation: "fade"
	    });
		
		$(function() {
			$('.show_menu').click(function(){
					$('.menu').fadeIn();
					$('.show_menu').fadeOut();
					$('.hide_menu').fadeIn();
			});
			$('.hide_menu').click(function(){
					$('.menu').fadeOut();
					$('.show_menu').fadeIn();
					$('.hide_menu').fadeOut();
			});
		});
	  });
	</script>
    </body>
</html>