<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smartbooking: Ricerca docente</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>

<!--  JAVASCRIPT -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../javascript/ViewRicercaDocenti.js" type="text/javascript"></script>

<link rel="stylesheet" href="../css/ViewRicercaDocenti.css">
<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>
<%
DocenteModel m = new DocenteModel();
LinkedList<Docente> list = (LinkedList<Docente>) m.doRetrieveAll(); 
%>
</head>
<body>

<div id="menu">
	<%@include file="menu.jsp"%>
</div>

<%if(tipo!=0){ %>

<div id="container">

<!-- Search form -->
<div id="searchBar">

<!-- Search form -->

<p id="cerca">Ricerca docente </p>
<form class="form-inline md-form form-sm mt-0" id="search">
	<a id="searchButton" href="#"><i class="fas fa-search" aria-hidden="true"></i></a>
  <input class="form-control form-control-sm ml-3 w-75" id="nameDoc" type="text" placeholder="Cognome* Nome*"
    aria-label="Search">
</form>



</div>

<table class="table table-striped" id="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Docente</th>
      <th scope="col">Ufficio</th>
      <th scope="col">Informazioni docente</th>
      <th scope="col">Aggiungi ai miei docenti</th>
      <th scope="col">Rimuovi dai miei docenti</th>
      <th scope="col">Richiedi incontro</th>
    </tr>
  </thead>
  <tbody id="tbody">
  	<% for(Docente d : list){ %>
  	<tr>
  	
      <th scope="row">
      
      <label name="nome" id="nome"><%= d.getNome()%></label> <label name="cognome" id="cognome"><%=d.getCognome()%></label>
      
      </th>
      <td><p id="ufficio"><%=d.getUfficio()%><p></td>
      <td>
      	<form action="InfoDocente.jsp?mat=<%=d.getMatricola()%>">
      	<input id="matricolaDocente" style="display:none;" name="mat" value="<%=d.getMatricola()%>"/>
      	<button type="submit" href="InfoDocente.jsp?mat=<%=d.getMatricola()%>"><i class="fas fa-info-circle"></i></button>
      	</form>	
      </td>
 	
      	<td>
      		<form name="form" action="../addDocenteListaPreferiti">
    			<input id="matricolaDocente" style="display:none;" name="matricolaDocente" value="<%=d.getMatricola()%>"/>
    		
      			<button name="add" id=<%="addButton"+d.getMatricola()%> class="addButton"><i id="addIcon" class="fas fa-user-plus"></i></button> <!--  Aggiungi docente icon -->
      		</form>
      	</td>
      	<td>
      		<form name="form" action="../removeDocenteListaPreferiti">
    			<input class="rowMatricola" id="matricolaDocente" style="display:none;" name="matricolaDocente" value="<%=d.getMatricola()%>"/>
    		
      			<button name="remove" id=<%="removeButton"+d.getMatricola()%> class="removeButton"><i id="rmvIcon" class="fas fa-user-minus"></i></button>  <!-- Rimuovi docente icon -->
      		</form>
     	</td> 
     	<td>
    		<form name="form" action="../VisualizzaOrariDocente">
    			<input id="matricolaDocente" style="display:none;" name="matricolaDocente" value="<%=d.getMatricola()%>"/>
    		
      			<button name="prenota" id=<%="prenota"+d.getMatricola()%> class="prenotaButton">Visualizza orari</button> 
      		</form>
    	</td>
    </tr>
    
    <% } %>

  </tbody>
</table>

</div>

<%}else{ %>
<h1 style="text-align:center">Non sei autorizzato</h1>
<%} %>

<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>