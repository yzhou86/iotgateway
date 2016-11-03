<%@ include file='common.jsp' %>

<body style="font-family: 'Open Sans', serif;background-image:url('<c:url value="/resources/login.jpg" />');background-repeat:no-repeat;background-size:100%;">
<h1><span style="color:white;">Cisco IoT Cloud Service<span></h1>
<table style="border:0px;">
<tr>
<td>Username:</td>
<td><input type="text" length="100" value="${uname}" /></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" length="100" value="${passwd}" /></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Login" onclick="window.location.href='<c:url value="/device" />'" /></td>
</tr>
</table>
</body>
</html>