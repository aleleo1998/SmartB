<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smartbooking: Richieste di modifica orario</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../css/ViewRichiesteModOrario.css">
<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>

<%
RichiestaModOrarioModel rm = new RichiestaModOrarioModel();

LinkedList<RichiestaModOrario> richieste = (LinkedList<RichiestaModOrario>) rm.doRetrieveAll();

%>
</head>
<body>

<script type="text/javascript">

function accDecRichiesta(idRichiesta, stat){
	
	console.log(idRichiesta);
	
	 $.post("../GestisciRischiesteModOrarioServlet", { id : idRichiesta, stato : stat },
			   function(data) {
		 		 if(data=="ok")
		 		$( "#row"+idRichiesta ).remove();
			   });
	
}



</script>

<div id="menu">
	<%@include file="menu.jsp"%>
</div>

<div id="container">


<%
    	Utente u = null;
    	u = (Utente) request.getSession().getAttribute("segreteria");
    	if(u == null){  	
%>

		<h1 style="text-align:center">Non sei autorizzato</h1>
		
	<%} else { %>
	
		<div id="titleContainer">

<h1>Richieste per modificare l'orario</h1>

</div>




<table class="table table-striped" id="tabellaRichiesteModOreario">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Matricola docente</th>
      <th scope="col">Ora di inizio</th>
      <th scope="col">Ora di fine</th>
      <th scope="col">Giorno</th>
      <th scope="col">Giorno da eleminare</th>
      <th scope="col">Prova</th>
    </tr>
  </thead>
  <tbody>
  
  <% for(RichiestaModOrario r : richieste){ %>
  	<tr id="row<%= r.getId()%>">
  	
  	
      <td><%= r.getMatricolaDocente() %></td>
      <td><%= r.getOraInizio() %></td>
      <td><%= r.getOraFine() %></td>
      <td><%= r.getGiorno() %></td>
      <td><%= r.getGiornoPrecedente() %></td>
      <td>
      		<button name="accetta" class="accDecButton" onclick="accDecRichiesta('<%= r.getId() %>','acc')"><i class="fas fa-check"></i></button>
      		<button name="accetta" class="accDecButton" onclick="accDecRichiesta('<%= r.getId() %>','dec')"><i class="fas fa-times"></i></button>
      </td>
    </tr>
   
    <% } %>

  </tbody>
</table>
	
	
	
	<%} %>
	
	</div>
	<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>













