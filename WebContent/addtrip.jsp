<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>

    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Add Trip</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
	<script type="text/javascript">
		$(function () {
				$("#fromDate").blur(function () {
					element = $(this);
// 					alert(element.val());
					$.get("trip",
							{"action":"calcToDate",
							"packageId":$("input[name=packageId]").val(),
							"fromDate":element.val()
							},
							function (response,status){
								if(status=="success"){
									$("#toDate").val(response)
								}
							})
				});
		});
	</script>

<div class="container">
	<form action="trip" method="post">
		<input type="hidden" name="action" value="createtrip">
		<table class="table">
			<tr>
				<td>
					<label><strong>Package</strong></label>
				</td>
				<td>
					<input type="hidden" name="packageId"  value="${tripPackage.packageId }" />
					<input type="text" name="packageId" readonly="readonly" value="${tripPackage.packageName }" />
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>From City</strong></label>
				</td>
				<td>
<!-- 					<input type="text" name="fromCity" placeholder="e.g Mumbai" /> -->
						<select name="fromCity" id="fromCity" >
							<option value="Select" disabled>Select</option>
							<option value="Mumbai">Mumbai</option>
							<option value="Pune">Pune</option>
							<option value="Bhopal">Bhopal</option>
							<option value="Kota">Kota</option>
							<option value="Delhi">Delhi</option>
						</select>
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>From Date</strong></label>
				</td>
				<td>
					<input id="fromDate" type="datetime-local" min="${curtime }" name="fromDate" placeholder="e.g 01-01-2020 10:10"/> 
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>Days</strong></label>
				</td>
				<td>
					<input  type="text"  readonly="readonly" name="days" value="${tripPackage.packageDays }"/>
				</td>
			</tr>
			<tr>
				<td>
					<label><strong>To Date</strong></label>
				</td>
				<td>
					<input id="toDate" type="datetime-local"  readonly="readonly" name="toDate" placeholder="e.g 01-01-2020 10:10"/>
				</td>
			</tr>
			<tr>
					<td align="right">
						<button type="submit" class="btn btn-success">Add Trip</button>
						</td>
						<td>
						<button type="reset" class="btn btn-danger">Reset</button>
					</td>
				</tr>
			</table>
	</form>
</div>

<jsp:include page="footer.jsp"/>