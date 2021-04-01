<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<%@ include file="header.jsp" %>
<link rel="stylesheet" type="text/css" href="css/formstyle.css"/>
<script type="text/javascript" src="js/validation/custregistration.js"></script>
<script type="text/javascript" src="jquery/jquery-3.5.1.js"></script>
<script type="text/javascript">
	
	$(function() {
		$("input[name=custEmailId]").blur(function() {
			element=$(this);
		$.post("customer",			//Servlet URL where we want to send request.
				{"action":"EmailVerification","custEmailId":$(this).val()},
				function(response,status){
					if(status=="success")
						element.next().html(response)
					else
						element.next().html(status)
				});
		});
	})
	
</script>

    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Customer Registration</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>

<div class="container">
		<div >
		<form action="customer" method="post" onsubmit="return validate()">
		<input type= "hidden" name="action" value="addcustomer">
		<fieldset>
			<table class="table table-hover">
			<tr>
					<td colspan="2">
						${requestScope.msg}
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Name</strong></label>
					</td>
					<td>
						<input type="text" name="custName" placeholder="enter full name" class="valid" onblur="validateOnBlur(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Email Id</strong></label>
					</td>
					<td>
						<input type="text" name="custEmailId" placeholder="example@gmail.com" class="valid" onblur="validateOnBlur(this)" /><span class="error" id="validemail">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Mobile No </strong></label>
					</td>
					<td>
						<input type="text" name="custMobileNo" placeholder="e.g 9874563210" class="valid" onblur="validateOnBlur(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Password</strong></label>
					</td>
					<td>
						<input type="password" name="custPassword" id="custPassword" placeholder="e.g Abc@123" class="valid" onblur="validateOnBlur(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Confirm Password</strong></label>
					</td>
					<td>
						<input type="password" name="custConfirmPassword" placeholder="e.g Abc@123" class="valid" onblur="isPasswordMatch(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Address</strong></label>
					</td>
					<td>
						<textarea rows="4" cols="20" name="custAddress" placeholder="here your full Address" class="valid"></textarea><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<a  href="login.jsp">Already Register</a>
					</td>
				</tr>
					<tr>
					<td align="right">
						<button type="submit" class="btn btn-success">Register</button>
					</td>
					<td>
						<button type="reset" class="btn btn-danger">Reset</button>
					</td>
				</tr>
			</table>
		</fieldset>
		</form>
		</div>
</div>
<%@ include file="footer.jsp" %>