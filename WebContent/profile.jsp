<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="header.jsp" %>  


    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Profile</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
	<div class="container">
	<table class="table table-striped table-dark">
		<tr>
			<td>Name </td><th>${user.custName }</th>
		</tr>
		<tr>
			<td>Email Id </td><th>${user.custEmailId }</th>
		</tr>
		<tr>
			<td>Mobile No </td><th>${user.custMobileNo }</th>
		</tr>
		<tr>
			<td>Password </td><th>************</th>
		</tr>
		<tr>
			<td>Address </td><th>${user.custAddress }</th>
		</tr>
		<tr>
			<td>
				<core:url var="edit" value="customer">
					<core:param name="action" value="edit" />
					<core:param name="custId" value="${customer.custId }" />
				</core:url>
				<a href="${edit }" onclick="return confirm('Do you want to edit your profile')">Edit Profile</a>
			</td>
		</tr>
	</table>
	`</div>

<%@ include file="footer.jsp" %>