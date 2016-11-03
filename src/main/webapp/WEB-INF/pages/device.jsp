<%@ include file='common.jsp' %>

<script>

</script>
<style>
table {
    border-collapse: collapse;
    width: 100%;
    font-size: 16px;
}
table, th, td {
   border: 1px solid black;
   height: 50px;
}
</style>
<body style="color:white;font-family: 'Open Sans', serif;background-image:url('<c:url value="/resources/iot.jpg" />');background-repeat:no-repeat;background-size:100%;">
<h1>Cisco IoT Cloud Service - Device Privacy Data</h1>
<h3>Device List</h3>
		<table id='devices' style="">
		<tbody><tr><td>Device</td><td>Message Count</td><td>Messages</td></tr>
		${deviceTable}
		</tbody>
        </table>

</body>
</html>