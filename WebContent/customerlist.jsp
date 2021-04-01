<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  

<%@ include file="header.jsp" %>  
 <link rel="stylesheet" type="text/css" href="css\formstyle.css"/>
<style type="text/css">
  	a{
		text-decoration: none;
		font-weight: bold;
	}
</style>
    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Customer List</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
<br>
<br>
<div class="container">
	<table width="70%" align="center" border="1" class="table table-hover">
<!-- 		<caption>Customer List</caption> -->
			<thead class="thead-dark">
			<core:if test="${msg != null }">
				<tr>
					<td colspan="8"> ${msg } </td>
				</tr>
			</core:if>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile.No</th>
					<th>Password</th>
					<th>Address</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="customer" items="${customerlist }">
					<tr>
						<td>${customer.custId }</td>
						<td>${customer.custName }</td>
						<td>${customer.custEmailId }</td>
						<td>${customer.custMobileNo }</td>
						<td>${customer.custPassword }</td>
						<td>${customer.custAddress }</td>
						
						<td>
							<core:url var="edit" value="customer">
								<core:param name="action" value="edit"/>
								<core:param name="custId" value="${customer.custId }"/>
							</core:url>
							<a href="${edit }" onclick="return confirm('Co you want to Edit this record?')">Edit</a>
						</td>
						<td>
							<core:url var="delete" value="customer">
								<core:param name="action" value="delete"/>
								<core:param name="custId" value="${customer.custId }"/>
							</core:url>
							<a href="${delete }" onclick="return confirm('Co you want to delete this record?')">Delete</a>
						</td>
					</tr>
				</core:forEach>
				<core:if test="${customerlist == null }">
					<tr>
						<td colspan="5"> No Customer Found!</td>
					</tr>
				</core:if>
			</tbody>
	</table>
<%-- 	${sessionScope.customerlist} --%>
	
	</div>
<%@ include file="footer.jsp" %>