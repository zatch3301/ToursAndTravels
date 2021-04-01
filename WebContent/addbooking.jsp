<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="header.jsp"/>

 <link rel="stylesheet" type="text/css" href="css\formstyle.css"/>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Book your Trip</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script>

	function caltotalamount() {
		noofperspon = $("input[name='noOfPerson']").val();
		price = $("input[name='pakagePrice']").val();
		$("input[name=totalamount]").val(noofperspon*price);
	}
	
	$(function () {
		$("input[name='noOfPerson']").blur(function () {
			caltotalamount();
		});
		$("input[name='noOfPerson']").click(function () {
			caltotalamount();
		});
	});
	
</script>   
  <div class="container">
    <form action="booking" method="post">
		<input type="hidden" name="action" value="bookthetrip">
		<table class="table">
			<tr>
				<td>
					<label><strong>Customer Email</strong></label>
				</td>
				<td>
					<input type="text" name="custEmailId" value="${customerEmail }" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>Booking Trip Id</strong></label>
				</td>
				<td>
					<input type="text" name="tripId" value="${bookedTrip.tripId}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>Package Name</strong></label>
				</td>
				<td>
					${bookedTrip.pkg.packageName}
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>From</strong></label>
				</td>
				<td>
					${bookedTrip.fromCity}
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>To</strong></label>
				</td>
				<td>
					${bookedTrip.pkg.packageLocation}
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>From Date</strong></label>
				</td>
				<td>
					<fmt:parseDate var="from" value="${bookedTrip.fromDate }" type="both" pattern="yyyy-MM-dd'T'HH:mm"/>
					<fmt:formatDate var="f" value="${from}" type="both" timeStyle="short" dateStyle="medium"/>
					${f }
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>To Date</strong></label>
				</td>
				<td>
					<fmt:parseDate var="to" value="${bookedTrip.toDate }" type="both" pattern="yyyy-MM-dd'T'HH:mm"/>
					<fmt:formatDate var="t" value="${to}" type="both" timeStyle="short" dateStyle="medium"/>
					${t }
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>No.of Persons</strong></label>
				</td>
				<td>
					<input type="number" name="noOfPerson" min="1" min="20" step="1" value="1" required="required"/>
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>Price per Person</strong></label>
				</td>
				<td>
					<input type="hidden" name="pakagePrice" value="${bookedTrip.pkg.packagePrice }"/>
					${bookedTrip.pkg.packagePrice }
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>Total Amount</strong></label>
				</td>
				<td>
					<input type="number" name="totalamount" value="${bookedTrip.pkg.packagePrice }" readonly="readonly"/>
				</td>
			</tr>
			<tr>
					<td align="right">
						<button type="submit" class="btn btn-success">Book Trip</button>
						</td>
						<td>
						<button type="reset" class="btn btn-danger">Reset</button>
					</td>
				</tr>
		</table>
	</form>
    </div>
    
<jsp:include page="footer.jsp"/>