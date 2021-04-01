<%@page import="java.util.*"%>
<%@page import="java.time.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<core:set var="bdate" value="${booking.bookingDate}"/>
<fmt:parseDate var="bookingdate" value="${bdate }" type="both" pattern="yyyy-MM-dd'T'HH:mm"/>
<%@ include file="header.jsp" %>
    <jsp:include page="header.jsp"/>
	
    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Enjoy your trip :)</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="container">
    <div class="row">
    	<div class="col">
     		&nbsp; ${msg}
     	</div>
     </div>
    <div class="row">
    	<div class="col">
    		<table class="table table-striped table-dark">
    				<tr align="center">
    					<th colspan="2">Booking Details</th>
    				</tr>
    				<tr >
    					<th>Booking Id</th>
						<th>${booking.bookingId}</th>    					
    				</tr>
    				<tr>
    					<th>Trip Id</th>
						<th>${booking.tripId}</th>    					
    				</tr>
    				<tr>
    					<th>Booking Date</th>
						<th>${bookingdate}</th>			
    				</tr>
    				<tr>
    					<th>No of Person</th>
						<th>${booking.noOfPersons}</th>    					
    				</tr>
    				<tr>
    					<th>Booking Amount</th>
						<th>${booking.totalAmount}</th>    					
    				</tr>
    				<tr>
    					<th>Booking Status</th>
						<th>${booking.bookingStatus}</th>    					
    				</tr>
    			</tbody>
    		</table>
     	</div>
     </div>
     </div>

    
     <%@ include file="footer.jsp" %>