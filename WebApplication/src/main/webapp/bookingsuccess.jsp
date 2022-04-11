<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sella.Service.*"%>
<%@ page import="com.sella.Bean.*"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking SuccessfulPage</title>
<style>
table
{
width: 70%;
}
</style>
</head>
<body>

<div align="center">
<h1> Room Booked Your Details:</h1>


<% ArrayList<LoginBean> vp = (ArrayList) request.getAttribute("ar"); %>


<TABLE>
<TR>
<TH>Name</TH>
<TH>EMAIL</TH>
<TH>Address</TH>
<TH>Hostelname</TH>
<TH>Rcapacity</TH>
<TH>Doj</TH>
</TR>
<%
Iterator<LoginBean> iterator = vp.iterator();
if(request.getAttribute("ar")!=null){
while(iterator.hasNext()){
LoginBean loginbean = iterator.next();
%>
<tr style: bgcolor="lightgray" align = "center">
<td><%=loginbean.getName()%></td>
<td><%=loginbean.getEmail()%></td>
<td><%=loginbean.getAddress()%></td>
<td><%=loginbean.getHostelname() %></td>
<td><%=loginbean.getRcapacity()%>
<td><%=loginbean.getDoj() %></td>



</tr>

<%
}

}
%>
</TABLE>
</div>
<a href="Main.html">Logout</a><br><br>
<a href="loginsucess.jsp">Back</a>

</body>
</html>