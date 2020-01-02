<%@page import="Model.ListaPreferitiModel"%>
<%@page import="Model.Docente"%>
<%@page import="Model.DocenteModel"%>
<%@page import="Model.Ricevimento"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Model.RicevimentoModel"%>
<%@page import="Model.Studente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>

<!--  CSS -->
<link rel="stylesheet" href="../css/ProfiloStudente.css">

<meta charset="UTF-8">
<title>SmartBooking: il mio profilo</title>
<% Model.Studente studente = (Studente) request.getSession().getAttribute("studente"); %>
<%
Model.RicevimentoModel rm = new RicevimentoModel();
LinkedList<Ricevimento> ricevimenti = (LinkedList<Ricevimento>) rm.doRetrieveAllByStudent(studente); 
%>
<%
ListaPreferitiModel lpm = new ListaPreferitiModel();
LinkedList<Docente> preferiti = new LinkedList<Docente>();
preferiti = (LinkedList<Docente>) lpm.getAllDocenti(studente);
%>
</head>
<body>

<!------ Include the above in your HEAD tag ---------->

<div id="menu">
	<%@include file="../html/menu.html"%>
</div>

<div id="container">

    <div class="container-fluid well span6">
	<div class="row-fluid">
        <div class="span2" >
		    <img id="image" src="../image/default.jpg" class="img-circle">
        </div>
        
        <br/>
        
        <div class="span8">
            <h3><%= studente.getNome() %> <%= studente.getCognome() %> </h3>
            <h6>Email: <%= studente.getEmail() %></h6>
            <h6>Matricola: <%= studente.getMatricola() %></h6>
        </div>  
        
<table class="table table-striped" id="tableRicevimenti">
  <thead class="thead-dark">
  <tr>
  	<th>Richieste di ricevimento</th>
  </tr>
    <tr>
      <th scope="col">Id richiesta</th>
      <th scope="col">Data Prenotazione</th>
      <th scope="col">Data Incontro</th>
      <th scope="col">Docente</th>
      <th scope="col">Stato</th>
    </tr>
  </thead>
  <tbody id="tbody">
  <% for(Ricevimento r : ricevimenti){ %> 
  	<tr>
  	
      <th scope="row">
      
      <label name="nome" id="nome"><%=r.getId()%></label>
      
      </th>
      <td><p id="dataPrenotazione"><%=r.getDataPrenotazione()%></p></td>
      <td><p id="dataIncontro"><%=r.getData() %></p></td>
      <% DocenteModel dm = new DocenteModel();
      	Docente docente = dm.doRetrieveByKey(r.getMatDocente());
      	
      %>
      <td><p id="docente"><%=docente.getNome() %> <%= docente.getCognome() %></p></td>
      
      <% if(r.getStato() == null)
    	 	r.setStato("Non valutato");	 
      %>
      <td><p id="stato"><%= r.getStato() %></p></td>
 	
    </tr>
    
    <% } %>

  </tbody>
</table>


<table class="table table-striped" id="tableListaDocenti">
  <thead class="thead-dark">
  <tr>
  	<th>La mia lista docenti</th>
  </tr>
    <tr>
      <th scope="col">Docente</th>
      <th scope="col">Ufficio</th>
      <th scope="col">Nuova richiesta di ricevimento</th>
      <th scope="col">Rimuovi dai preferiti</th>
    </tr>
  </thead>
  <tbody id="tbody">
  <% for(Docente d : preferiti){ %> 
  	<tr>
  
      <td><p id="docente"><%=d.getNome()%> <%=d.getCognome()%></p></td>
      <td><p id="ufficio"><%=d.getUfficio()%></p></td>
      <td><a href="#####"></a><i class="far fa-comment-dots"></i></td>
      <td>
      	<form action="../removeDocenteListaPreferiti">
      		<button><i class="fas fa-user-slash"></i> </button>
      		<input type="text" id="matricolaDocente" name="matricolaDocente" value="<%=d.getMatricola()%>" style="display:none;"></input>
      	</form>	
      </td>
    </tr>
    
    <% } %>

  </tbody>
</table>

<a href="ViewRicercaDocenti.jsp"><button id="buttonRicerca">Ricerca docente</button></a>
  
	</div>
	</div>
</div>

<div id="footer">
	<%@include file="../html/footer.html" %>
</div>

</body>
</html>