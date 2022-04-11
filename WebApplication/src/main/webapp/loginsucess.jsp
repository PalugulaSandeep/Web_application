<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>

<body onload="startTime()" style="background-color:LightSalmon">

<script>
function startTime() {
const today = new Date();
let h = today.getHours();
let m = today.getMinutes();
let s = today.getSeconds();
m = checkTime(m);
s = checkTime(s);
document.getElementById('txt').innerHTML = "Time:"+h + ":" + m + "m:" + s+"s";
setTimeout(startTime, 1000);
}


function checkTime(i) {
if (i < 10) {i = "0" + i};
return i;
}
</script>
<div id="txt"></div>
<div align="center">
<h3>Login Sucessful.....</h3>
<h1>&#128079;</h1>
<h1>Operations You can Perform</h1>
<a href="ProfileUpdate.html"><button>Profile</button></a><br><br>
<a href="Search.html"><button>Search</button><br><br></a>
<a href="Booking.html"><button>Booking</button><br><br></a>
<a href="MyBookingCheck.html"><button>MyBookings</button></a><br><br>
<a href="Main.html"><button>Logout</button></a>
</div>
</body>
</html>