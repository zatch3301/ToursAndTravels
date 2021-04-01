<%@page import="com.zatch.toursandtravels.pojo.Package"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	List<Package> packagelist = (List<Package>)session.getAttribute("packagelist");
%>    

<%-- 	<%= %> is same as out.println()
	known as expression tag of jsp
	use to print java objects --%>
<%-- <%=packagelist%>   --%>

<%@ include file="header.jsp" %>

 <link rel="stylesheet" type="text/css" href="css\formstyle.css"/>
<!-- <style type="text/css"> -->
/*   	a{ */
/* 		text-decoration: none; */
/* 		font-weight: bold; */
/* 	} */
<!-- </style> -->
    <div class="bradcam_area " style="background-image: url('imgs/pic3.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text text-center">
                        <h3>Package List</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
<br>
<br>
<div class="container">
<table width="100%" align="center" border="1" class="table table-hover">
<!-- 	<caption>Package List</caption> -->
	<%String msg = (String)request.getAttribute("msg"); %>
			<%
		String adminEamil = (String)session.getAttribute("adminEamil");
		String customerEmail = (String)session.getAttribute("customerEmail");
		%>
	<%if(msg != null){ %>
	<tr>
		<td colspan="10">
			<%=msg %>
		</td>
	</tr>
	<%} %>
	<thead class="thead-dark">
	<tr>
		<th>Id</th>
		<th>Image</th>
		<th>Name</th>
		<th>Location</th>
		<th>Type</th>
		<th>Days</th>
		<th>Price</th>
		<th>Details</th>
<%-- 		<% if( adminEamil !=null && customerEmail==null){ %> --%>
		<th colspan="4">Action's</th>
<%-- 		<% } %> --%>
	</tr>
	</thead>
	<%for(Package pkg : packagelist){ %>
	<tr>
		<td><%=pkg.getPackageId() %></td>
		<td><img src="image?action=showImage&packageId=<%=pkg.getPackageId() %>" width="180px" height="180px" alt="No Img" /></td>
		<td><%=pkg.getPackageName() %></td>
		<td><%=pkg.getPackageLocation() %></td>
		<td><%=pkg.getPackageType() %></td>
		<td><%=pkg.getPackageDays() %></td>
		<td><%=pkg.getPackagePrice() %></td>
		<td><%=pkg.getPackageDetails() %></td>
		<!-- action on package -->

		<% if( adminEamil !=null && customerEmail==null){ %>
		<td>
			<a class="btn btn-primary" href="trip?action=addtrip&packageId=<%=pkg.getPackageId() %>" onclick="return confirm('Do you wanna add a trip')">Trip</a>
		</td>
		<td>
			<a class="btn btn-success" href="package?action=update&packageId=<%=pkg.getPackageId() %>" onclick="return confirm('Do you wanna update this package')">Update</a>
		</td>
		<td>
			<a class="btn btn-danger" href="package?action=delete&packageId=<%=pkg.getPackageId() %>" onclick="return confirm('Do you wanna delete this package')">Delete</a>
		</td>
		<% }%>
		<td>
			<a class="btn btn-dark" href="trip?action=showtripbypackage&packageId=<%=pkg.getPackageId() %>">Trip's</a>
		</td>
	</tr>
	<%} %>
</table>
</div>
<%@ include file="footer.jsp" %>