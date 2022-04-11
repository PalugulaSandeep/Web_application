<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Success Page</title>
</head>
<body>

<div align="center">
<%@page import="java.util.ArrayList"%>
<%@ page import="com.sella.Bean.*"%>
<%@page import="java.util.Iterator"%>
<div align="center">

<% ArrayList<LoginBean> vp = (ArrayList) request.getAttribute("ar"); %>

<TABLE >
<TR>
<TH>Hostel Available in Entered Location</TH>
</TR>
<%
Iterator<LoginBean> iterator = vp.iterator();
if(request.getAttribute("ar")!=null){
while(iterator.hasNext()){
LoginBean viewproduct = iterator.next();
%>
<tr>
<td><%=viewproduct.getHostelname()%></td>
</tr>
<%
}

}
%>

</TABLE>
<a href="loginsucess.jsp"/><button>Back</button></div></a>
<a href="Booking.html"/><button>Booking</button></div></a>

</div>
</body>
</html>