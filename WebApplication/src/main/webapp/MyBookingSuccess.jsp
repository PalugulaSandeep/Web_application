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
<title>Success MyBooking Page</title>
</head>
<body>

<div align="center">
<h1> Your  Booked  Details</h1>


<% ArrayList<LoginBean> vp = (ArrayList) request.getAttribute("ar"); %>


<TABLE>
<TR>
<TH>Name</TH>
<TH>Address</TH>
<TH>Doj</TH>
<TH>Rcapacity</TH>
</TR>
<%
Iterator<LoginBean> iterator = vp.iterator();
if(request.getAttribute("ar")!=null){
while(iterator.hasNext()){
LoginBean loginbean = iterator.next();
%>
<tr>
<td><%=loginbean.getName()%></td>
<td><%=loginbean.getAddress()%></td>
<td><%=loginbean.getDoj() %></td>
<td><%=loginbean.getRcapacity()%>



</tr>

<%
}

}
%>
</TABLE>
<a href="loginsucess.jsp">Back</a>

</body>
</html>