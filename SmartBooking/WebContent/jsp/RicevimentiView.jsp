<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SmartBooking</title>
<%@ page import="Model.*"%>
<%@ page import ="java.util.*" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	$(".id").hide();
});
</script>
</head>
<body>
<div id="menu">
	<%@include file="../html/menu.html"%>

</div>

<div>
<%
Collection<Ricevimento> rv =(Collection) request.getSession().getAttribute("ricevimenti");
%><table class="table table-striped" id="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id ricevimento</th>
      <th scope="col">Matricola studente</th>
      <th scope="col">Data della prenotazione</th>
      <th scope="col">Data del ricevimento</th>
      <th scope="col">Stato</th>
      <th scope="col">Accetta</th>
      <th scope="col">Rifiuta</th>
      
    </tr>
    </thread>
    <tbody><% 
for(Ricevimento r : rv)
{%><tr>
	<td><%= r.getId()%></td>
	<td><%= r.getMatStudente()%></td>
	<td><%= r.getDataPrenotazione()%></td>
	<td><%= r.getData()%></td>
	<td><%= r.getStato()%></td>
	<%if(!(r.getStato().equals("Accettato"))){ %>
	<td><form action="../AccettaRicevimentoServlet" method="Post"><button style="height:40px;width:40px"><i class="fas fa-check"></i></button><input type="text" name="id" class="id" value='<%= r.getId() %>'></form></td>
    <td><button style="height:40px;width:40px"><i class="far fa-times-circle"></i></button><input type="text" name="id" class="id" value='<%= r.getId() %>'></td>
    <%} else{%>
    <td></td><td></td>
    <%} %>
	</tr><%
}
%>
    </tbody>
    </table>
</div>

<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>