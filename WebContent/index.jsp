<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
<%@ include file="header.jsp" %>

            <div class="slider_container" >
				<div class="flexslider"> 
			      <ul class="slides"> 
			    	<li> 
			    		<img src="imgs/banner/banner.png" alt="" title=""/>
			    		<div class="flex-caption">
		                     <div class="caption_title_line"><h2>  </h2><p>  </p></div>
		                </div>
			    	</li>
			    	<li>
			    		<img src="imgs/banner/banner2.png" alt="" title=""/>
			    		<div class="flex-caption">
		                     <div class="caption_title_line"><h2>  </h2><p>  </p></div>
		                </div>
			    	</li>
			    	<li>
			    		<img src="imgs/banner/banner3.png" alt="" title=""/>
			    		<div class="flex-caption">
		                     <div class="caption_title_line"><h2>  </h2><p>  </p></div>
		                </div>
			    	</li>
			    </ul>
			  </div>
		   </div>
		   
<!-- 	link	    -->
<div style="margin: auto;  width: 30%; text-align: center; align-items: center;">
<!-- <a href="package">Package List</a> &nbsp;&nbsp;  -->
<!-- <a href="addpackage.jsp">Add Packages</a> &nbsp;&nbsp;  -->
<!-- <a href="customer">Customer List</a> &nbsp;&nbsp;  -->
<!-- <a href="custregistration.jsp">Customer Registration</a> &nbsp; &nbsp; -->
<!-- <a href="login.jsp">Login</a> &nbsp; &nbsp; -->
<!-- <a href="login?action=logout">Logout</a> -->
<h2>${msg }</h2>
<h1>
<core:if test="${adminEmail != null }">
	Welcome Admin
</core:if>
<core:if test="${customerEmail != null}">
	Welcome  ${user.custName }
</core:if>
</h1>
</div>

<!-- 		links end -->
    <!-- popular_destination_area_start  -->
    <div class="popular_destination_area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section_title text-center mb_70">
                        <h3>Popular Destination</h3>
                        <p>
                        	Holiday Tours and Travels  was created to inspire people to travel far and travel often. We believe life was not meant to be lived in one place. Here you will find travel inspiration, as well as how to work for yourself while you see the world. 
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="imgs/destination/1.png" alt="">
                        </div>
                        <div class="content">
                            <a class="d-flex align-items-center" href="trip?action=showtripbypackage&packageId=19"> Mumbai </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="imgs/destination/2.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Brazil </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="imgs/destination/3.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">America </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="imgs/destination/4.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Nepal  </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="imgs/destination/5.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Maldives </p>
                            
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single_destination">
                        <div class="thumb">
                            <img src="imgs/destination/6.png" alt="">
                        </div>
                        <div class="content">
                            <p class="d-flex align-items-center">Indonesia</p>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- popular_destination_area_end  -->


<%@ include file="footer.jsp" %>