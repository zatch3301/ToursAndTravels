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

    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Add Package</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
<br>
	<div class="container">
	<form action="package" method="post" onsubmit="return validate()" enctype="multipart/form-data">
	<div class="card card-outline-secondary">
	              <div class="card-header">
                <h3 class="mb-0">Add New Package</h3>
              </div>

		<input type= "hidden" name="action" value="add">
			<table class="table table-hover">
				<% 
				String msg =(String)request.getAttribute("msg");
				if(msg!=null)
				{ %>
				<tr>
					<td colspan="2">
						out.println(msg);
					</td>
				</tr>
				<% }%>

 			<tr>
				<td><label><strong>Image</strong></label></td>
				<td><input type="file" name="packageImage"/><span class="error">*</span></td>
			</tr>
			<tr>
					<td>
						<label><strong>Package Name</strong></label>
					</td>
					<td>
						<input type="text" name="packageName" placeholder="Enter package name"
						 class="valid" onblur="validateOnBlur(this)"/><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Location</strong></label>
					</td>
					<td>
						<input type="text" name="packageLocation" placeholder="Enter Package Location" 
						class="valid" onblur="validateOnBlur(this)" /><span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Type</strong></label>
					</td>
					<td>
						<input type="text" name="packageType" 
						placeholder="e.g Holiday Package" class="valid" onblur="validateOnBlur(this)"/><span 
						class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Days</strong></label>
					</td>
					<td>
						<input type="number" name="packageDays" min="1"
						placeholder="e.g 5 " class="valid" onblur="validateOnBlur(this)"/><span 
						class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Price</strong></label>
					</td>
					<td>
						<input type="number" name="packagePrice" min="100" step="0.1"
						placeholder="e.g 25000.00" class="valid" onblur="validateOnBlur(this)"/><span 
						class="error">*</span>
					</td>
				</tr>
				<tr>
					<td>
						<label><strong>Details</strong></label>
					</td>
					<td>
						<textarea rows="4" cols="20" name="packageDetails" 
						placeholder="Package Description" class="valid"></textarea><span 
						class="error">*</span>
					</td>
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
		</div>
	</form>
	</div>
	<br>
 <%@ include file="footer.jsp" %> 