<%@page import="java.util.*"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<core:set var="cdate" value="<%=LocalDateTime.now()%>"/>
<fmt:parseDate var="curdate" value="${cdate }" type="both" pattern="yyyy-MM-dd'T'HH:mm"/>
<%@ include file="header.jsp" %>

 <link rel="stylesheet" type="text/css" href="css\formstyle.css"/>
 
     <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Trip List</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
 <div>
 	<table class="table" style="margin: 10px auto; width: 90%">
 		<thead class="thead-dark">
 			<tr>
 				<th>Id</th>
 				<th>Package Name</th>
 				<th>Source</th>
 				<th>Destination</th>
 				<th>Price(<small>per person</small>)</th>
 				<th>From Date</th>
 				<th>To Date</th>
 			<core:if test="${adminEamil != null || customerEmail != null }">
 				<th colspan="2">Action</th>
 			</core:if>
 			</tr>
 		</thead>
 		<tbody>
 			<core:forEach var="trip" items="${triplist }">
 			<tr>
 				<td>${trip.tripId }</td>
 				<td>${trip.pkg.packageName }</td>
 				<td>${trip.fromCity }</td>
 				<td>${trip.pkg.packageLocation }</td>
 				<td> &#8377; ${trip.pkg.packagePrice }</td>
<%--  				<td>${trip.fromDate }</td> --%>
				<td>
					<fmt:parseDate var="from" value="${trip.fromDate }" type="both" pattern="yyyy-MM-dd'T'HH:mm"/>
					<fmt:formatDate var="f" value="${from}" type="both" timeStyle="short" dateStyle="medium"/>
					${f }
				</td>
<%--  				<td>${trip.toDate }</td> --%>
				<td>
					<fmt:parseDate var="to" value="${trip.toDate }" type="both" pattern="yyyy-MM-dd'T'HH:mm"/>
					<fmt:formatDate var="t" value="${to}" type="both" timeStyle="short" dateStyle="medium"/>
					${t }
				</td>
				<core:if test="${ adminEamil != null && customerEmail == null }">
					<td><a class="btn btn-primary" href="login.jsp" onclick="return confirm('Do you wanna Edit this trip')">Edit</a></td>
					<td><a class="btn btn-danger" href="login.jsp" onclick="return confirm('Do you wanna Delete this trip')">Delete</a></td>
					</core:if>
				<core:if test="${adminEmail == null and customerEmail != null }">
					<core:if test="${curdate.compareTo(from)<0}">
						<td><a class="btn btn-primary" href="booking?action=booktrip&tripId=${trip.tripId }"  onclick="return confirm('Do you wanna book this trip')">Book</a></td>
					</core:if>
					<core:if test="${curdate.compareTo(from)>0}">
						<td><a class="btn btn-danger">Can't Book</a></td>
					</core:if>
					<td><a class="btn btn-info" href="#" onclick="return confirm('Do you wanna edit this trip')">Edit</a></td>
				</core:if>
 			</tr>
 			</core:forEach>
 		</tbody>
 	</table>
 </div>  
 
<%@ include file="footer.jsp" %>