<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<link rel="icon" type="image/jpg" href="imgs/makemytripfav.jpg">
        <title>makeMytrip</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script type="text/javascript" src="jquery/jquery-3.5.1.js"></script>
        <link rel="stylesheet" href="css/fontawesome.min.css">
        <link rel="stylesheet" href="css/sliderstyles.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans|Roboto">
    
    </head>
    <body>
      <header id="home">  
        <nav class="navbar navbar-expand-lg navbar-light text-capitalize">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"><img src="imgs/makemytrip.png" width="180px" alt="#" /></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#show-menu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="show-menu">
                    <ul class="navbar-nav ml-auto">
                     	<li class="nav-item .search-container">
                            <a class="nav-link search" href="#"><i class="fas fa-search"></i></a>
                            <form>
                                <input type="search">
                            </form>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="package">Package's</a>
                        </li>
                      <core:if test="${ adminEamil != null && customerEmail == null }">
                        <li class="nav-item">
                            <a class="nav-link" href="addpackage.jsp">Add Package</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="customer">Customer's</a>
                        </li>
                      </core:if>
                        <li class="nav-item">
                            <a class="nav-link" href="trip">Trip's</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#about">About</a>
                        </li>
                      <core:if test="${ adminEamil == null && customerEmail != null }">
                        <li class="nav-item">
                            <a class="nav-link" href="profile.jsp">Profile</a>
                        </li>
                        </core:if>
                      <core:if test="${ adminEamil == null && customerEmail == null }">
                        <li class="nav-item">
<!--                             <a class="nav-link" href="custregistration.jsp" title="Registration"><i class="far fa-user"></i></a> -->
							<a class="nav-link" href="custregistration.jsp" title="Registration">Registration</a>
                        </li>
                        <li class="nav-item">
<!--                             <a class="nav-link" href="login.jsp" title="sign In"><i class="fas fa-sign-in-alt"></i></a> -->
                            <a class="nav-link" href="login.jsp" title="sign In"><i class="fas fa-sign-in-alt"></i></a>
                        </li>
                      </core:if>
                      <core:if test="${ adminEamil != null && customerEmail == null }">
                      		<li class="nav-item">
<!--                             <a class="nav-link" href="index.jsp" title="sign In"><i class="fas fa-sign-in-alt"></i></a> -->
                            <a class="nav-link" href="index.jsp" title="${adminEamil }"><b>Welcome <i>Admin</i></b></a>
                        </li>
                      </core:if>
                      <core:if test="${ adminEamil == null && customerEmail != null }">
                      		<li class="nav-item">
<!--                             <a class="nav-link" href="index.jsp" title="sign In"><i class="fas fa-sign-in-alt"></i></a> -->
                            <a class="nav-link" href="index.jsp" title="${customerEmail }"><b>Welcome <i>${user.custName }</i></b></a>
                        </li>
                      </core:if>
                      <core:if test="${ adminEamil != null || customerEmail != null }">
                        <li class="nav-item">
<!--                             <a class="nav-link" href="login?action=logout" title="sign Out"><i class="fas fa-sign-out-alt"></i></a> -->
                            <a class="nav-link" href="login?action=logout" title="sign Out"><i class="fas fa-sign-out-alt"></i></a>
                        </li>
                       </core:if>
                    </ul>
                </div>
            </div>
        </nav>
      </header>