<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<script type="text/javascript" src="js/validation/custregistration.js"></script>
<link rel="stylesheet" type="text/css" href="css/formstyle.css"/>

<%@ include file="header.jsp" %>

    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Update Customer Profile</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<div class="container">
		<form action="customer" method="post" onsubmit="return validate()">
		<input type= "hidden" name="action" value="updatecustomer">
			<table class="table">
			
			<tr>
					<td colspan="2">
						${requestScope.msg}
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>ID</strong></label>
					</td>
					<td>
						<input type="text" name="custId" readonly="readonly" value="${customerObj.custId }"/>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Name</strong></label>
					</td>
					<td>
						<input type="text" name="custName" value="${customerObj.custName }" placeholder="enter full name" class="valid" onblur="validateOnBlur(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Email Id</strong></label>
					</td>
					<td>
						<input type="text" name="custEmailId" value="${customerObj.custEmailId }" placeholder="example@gmail.com" class="valid" onblur="validateOnBlur(this)" /><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Mobile No </strong></label>
					</td>
					<td>
						<input type="text" name="custMobileNo" value="${customerObj.custMobileNo }" placeholder="e.g 9874563210" class="valid" onblur="validateOnBlur(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Password</strong></label>
					</td>
					<td>
						<input type="password" name="custPassword" value="${customerObj.custPassword }" id="custPassword" placeholder="e.g Abc@123" class="valid" onblur="validateOnBlur(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Confirm Password</strong></label>
					</td>
					<td>
						<input type="password" name="custConfirmPassword" value="${customerObj.custPassword }" placeholder="e.g Abc@123" class="valid" onblur="isPasswordMatch(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Address</strong></label>
					</td>
					<td>
						<textarea rows="4" cols="20" name="custAddress" placeholder="here your full Address" class="valid">${customerObj.custAddress }</textarea><span class="error">*</span>
					</td>
				</tr>
					<tr>
					<td align="right">
						<button type="submit" class="btn btn-success">Update</button>
						</td>
						<td>
						<button type="reset" class="btn btn-danger">Reset</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="footer.jsp" %>