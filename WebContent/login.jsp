<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<%@ include file="header.jsp" %>

    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Login Here</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
<link rel="stylesheet" type="text/css" href="css/formstyle.css"/>
<br>
<div class="container">
		<form action="login" method="post" id="loginform">
		<input type="hidden" name="action"value="login">
			<table class="table table-hover">
			<core:if test="${msg != null }">
				<tr>
					<td colspan="2">${requestScope.msg}</td>
				</tr>
			</core:if>
				<tr>
					<td>
						<label> <strong>User Type</strong></label>
					</td>
					<td>
						<select name="userType" id="userType" >
							<option value="Admin">Admin</option>
							<option value="Customer">Customer</option>
						</select>
						<span class="error" id="euserType">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label > <strong>Email Id </strong></label> 
					</td>
					<td>
						<input type="text" name="emailId" id="emailId" placeholder="example@gmail.com" /><span class="error" id="eemailId">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label ><strong> Password </strong></label>
					</td>
					<td>
						<input  type="password" name="password" id="password" placeholder="Abc@123"/><span class="error" id="epassword">*</span>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<a href="#">Forget Password</a>	|
						<a href="custregistration.jsp">New Registration</a>
					</td>
				</tr>
				<tr>
					<td align="right">
						<button type="submit" class="btn btn-success">Login</button>
						</td>
						<td>
						<button type="reset" class="btn btn-danger">Reset</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

<%@ include file="footer.jsp"  %>