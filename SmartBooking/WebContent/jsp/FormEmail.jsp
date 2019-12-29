<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form action="../EmailSendingServletContattaci" method="post" style="color:black; margin-top: 50px" >
		<table border="0" width="50%" align="center">
			<caption><h2>Invia E-Mail</h2></caption>
			
			<tr>
				<td width="50%">E-Mail mittente</td>
				<td><input type="text" name="email-mittente" size="50"/></td>
			</tr>
			<tr>
				<td width="50%">Nome </td>
				<td><input type="text" name="nome" size="50"/></td>
			</tr>
			<tr>
				<td>Oggetto </td>
				<td><input type="text" name="subject" size="50"/></td>
			</tr>
			<tr>
				<td>Messaggio </td>
				<td><textarea rows="10" cols="51" name="content"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Invia"/></td>
			</tr>
		</table>
	</form>



</body>
</html>