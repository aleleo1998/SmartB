<%@page import="Model.Docente"%>
<%@page import="Model.DocenteModel"%>
<%@page import="Model.RichiestaModOrario"%>
<%@page import="Model.SegreteriaModel"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Model.RichiestaModOrarioModel"%>
<%@page import="Model.Segreteria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmartBooking: area segreteria</title>
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>
<% Model.Segreteria segreteria = (Segreteria) request.getSession().getAttribute("segreteria"); %>
<% Model.RichiestaModOrarioModel mom = new RichiestaModOrarioModel();
LinkedList<Model.RichiestaModOrario> orari = (LinkedList<RichiestaModOrario>) mom.doRetrieveAll(); %>

<!--  CSS -->
<link rel="stylesheet" href="../css/ProfiloStudente.css">

</head>
<body>

<div id="menu">
	<%@include file="menu.jsp"%>
</div>

<div id="container">

    <div class="container-fluid well span6">
	<div class="row-fluid">
        <div class="span2" >
		    <img id="image" src="../image/default.jpg" class="img-circle">
        </div>
        
        <br/>
        
        <div class="span8">
            <h3><%= segreteria.getNome() %> <%= segreteria.getCognome() %> </h3>
            <h6>Email: <%= segreteria.getEmail() %></h6>
            <h6>Matricola: <%= segreteria.getMatricola() %></h6>
        </div>  
        
<table class="table table-striped" id="tableRicevimenti">
  <thead class="thead-dark">
  <tr>
  	<th>Richieste di ricevimento</th>
  </tr>
    <tr>
      <th scope="col">Id richiesta</th>
      <th scope="col">Docente</th>
      <th scope="col">Esamina richiesta</th>
      
    </tr>
  </thead>
  <tbody id="tbody">
  <% if(orari.size() == 0){ %>
	  
	  <tr>
	  <td>
	  	<p>Non ci sono nuove richieste.</p>
	  </td><td></td><td></td>
	  </tr>
	  
	 <% } %>

   <% for(RichiestaModOrario ora : orari){ %> 
  	<tr>
      <td><p id="idRichiesta"><%=ora.getId()%></p></td>
      <%
      	DocenteModel dm = new DocenteModel();
      	Docente d = dm.doRetrieveByKey(ora.getMatricolaDocente());
      %>
      <td><p id="docente"><%=d.getNome()%> <%=d.getCognome()%></p></td>
      
      <td><a href="###"><button><i class="fas fa-angle-double-right"></i></button></a></td>
 	
    </tr>
    
    <% } %>

  </tbody>
</table>




<a href="ViewRicercaDocenti.jsp"><button id="buttonRicerca">Modifica orario apertura al pubblico</button></a>
<a href="ViewRicercaDocenti.jsp"><button id="buttonRicerca">Inserisci docente</button></a>
  
	</div>
	</div>
</div>

<div id="footer">
	<%@include file="../html/footer.html" %>
</div>


</body>
</html>