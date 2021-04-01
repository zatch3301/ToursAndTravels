<%@page import="com.zatch.toursandtravels.pojo.Package"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="css\formstyle.css"/>
<script type="text/javascript">
function reSetForm()
{
	var elements = document.getElementsByClassName("error");
	for (var i = 0; i < elements.length; i++) 
	{
		elements[i].innerHTML="*";
	}
}
	
	function validate()
	{
		reSetForm()
		
		
		fields = document.getElementsByClassName('valid');
		for (var i = 0; i < fields.length; i++) 
		{
			if(fields[i].value=="")
			{
				fields[i].nextSibling.innerHTML = "<br/>Please Fill The Field";
				return false;
			}
		}
		return true;
	}
</script>


	<%
		Package packageObj = (Package)request.getAttribute("packageobj");
	%>
	
	    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Update Package</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
<br><br>
<div class="container">
	<form action="package" method="post" onsubmit="return validate()" enctype="multipart/form-data">
		<input type= "hidden" name="action" value="update">
				<table class="table">
				<tr>
					<td><label><strong>Package Id</strong></label></td>
					<td><input readonly="readonly" type="text" name="packageId" value="<%=packageObj.getPackageId() %>"/></td>
				</tr>
				<tr>
					<td><label><strong>Image</strong></label></td>
					<td><input type="file" name="packageImage"/><span class="error">*</span><br>
					<img alt="No img" src="image?action=showImage&packageId=<%=packageObj.getPackageId() %>" width="150px" height="150px">
					</td>
				</tr>
				<tr>
					<td><label><strong>Package Name</strong></label></td>
					<td><input type="text" name="packageName" value="<%=packageObj.getPackageName() %>" placeholder="<%=packageObj.getPackageName() %>" class="valid"/><span class="error">*</span></td>
				</tr>
				<tr>
					<td><label><strong>Package Location</strong></label></td>
					<td><input type="text" name="packageLocation" value="<%=packageObj.getPackageLocation() %>" placeholder="<%=packageObj.getPackageLocation() %>" class="valid"/><span class="error">*</span></td>
				</tr>
				<tr>
					<td><label><strong>Package Type</strong></label></td>
					<td><input type="text" name="packageType" value="<%=packageObj.getPackageType() %>" placeholder="<%=packageObj.getPackageType() %>" class="valid"/><span class="error">*</span></td>
				</tr>
				<tr>
					<td><label><strong>Package Days</strong></label></td>
					<td><input type="number" name="packageDays" value="<%=packageObj.getPackageDays() %>" placeholder="<%=packageObj.getPackageDays() %>" class="valid"/><span class="error">*</span></td>
				</tr>
				<tr>
					<td><label><strong>Package Price</strong></label></td>
					<td><input type="number" name="packagePrice" value="<%=packageObj.getPackagePrice() %>" placeholder="<%=packageObj.getPackagePrice() %>" class="valid"/><span class="error">*</span></td>
				</tr>
				<tr>
					<td><label><strong>Package Details</strong></label></td>
					<td><textarea rows="4" cols="20" name="packageDetails" placeholder="<%=packageObj.getPackageDetails() %>" class="valid"><%=packageObj.getPackageDetails() %></textarea></td>
				</tr>
				<tr>
					<td align="right">
						<button type="submit" class="btn btn-success">Submit</button>
						</td>
						<td>
						<button type="reset" class="btn btn-danger">Reset</button>
					</td>
				</tr>
				</table>
		</fieldset>
	</form>
</div>
<%@ include file="footer.jsp" %>
