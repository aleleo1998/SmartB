<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="../css/HomeDocente.css">
<script type="text/javascript" src="../javascript/AvatarJS.js"></script>

<title>Smartbooking: HomepageDocente</title>


<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>

<%
DocenteModel m = new DocenteModel();
RicevimentoModel r = new RicevimentoModel();
String matricola=(String)session.getAttribute("Utente");
Docente doc = m.doRetrieveByKey(matricola);
LinkedList<Docente> list = (LinkedList<Docente>) m.doRetrieveAll(); 
LinkedList<Ricevimento> listRicevimenti = (LinkedList<Ricevimento>) r.doRetrieveTodayByDocente(matricola);
%>

</head>
<body>

	<div id="menu">
		<%@include file="menu.jsp" %> 
	</div>
	
	<!--  Info Docente -->

    <div class="container profile">
  <div class="row">
    <div class="span12">
      <div class="well well-small clearfix">
        <div class="row-fluid">
             <div class="span1">
				    <div class="avatar">
				      <img class="round" width="90" height="90" avatar="<%=doc.getCognome()%> <%=doc.getNome()%>">
				     </div>
				  
			</div>  
          <div class="span4">
             <h2><%=doc.getCognome() %> <%=doc.getNome() %></h2> 
            <ul class="unstyled">
              <li><i class="icon-envelope"></i> <h4>Email: <%=doc.getEmail() %> </h4></li>
              <li><h4> Ufficio: <%=doc.getUfficio() %> </h4></li>
            </ul>
          </div>
          <div class="span6">
          <ul class="inline stats">
               <li>
                 <div class="col-sm-12">
      				<button type="submit" onclick="location.href='richiestaModificaOrario.jsp';" class="btn btn-primary">Modifica Orari Ricevimento</button>
   				 </div>
                 
              </li>
              <li>
                <div class="col-sm-12">
      				<button type="submit" class="btn btn-primary">Annulla Ricevimento</button>
   				</div>
              </li>
               
          </ul>
            <div><!--/span6-->
            </div><!--/row-->
      </div>
      <!--info docente-->
      
 
    </div>
  </div>
  </div>
  </div>
  </div>   
  
  
     <!-- FORM ACCETTA/RIFIUTA RICEVIMENTI -->
      
      <!--  -->
      
   <!-- Form visualizza i ricevimenti di oggi -->
      <div id="ricevimentiOggi">
		  <table class="table table-striped" id="table">
		  <h5>Ricevimenti di oggi</h3>
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">id Richiesta</th>
			      <th scope="col">Data</th>
			      <th scope="col">Studente</th>
			    </tr>
			  </thead>
			  <tbody id="tbody">
			  		<td colspan="3">
			  	<% 
			  	if(listRicevimenti.size()==0){ %>
				      <label name="idRichiesta" id="idRichiesta">Non sono presenti ricevimenti</label> 
			    <%} else{%></td>
			    
			  	<% for(Ricevimento ric : listRicevimenti){ %>
			  	<tr>
			  	
			      <td><p id="idRichiesta"><%= ric.getId()%></p> </td>
			      <td><p id="data"><%=ric.getData()%><p></td>
			      <td><p id="matricolaStudente"><%=ric.getMatStudente()%><p></td>
			      
			     
			    </tr>
			    
			    <% }} %>
			
			  </tbody>
		</table>
      </div>
      
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div id="footer">
		<%@include file="../html/footer.html"%>
	</div>

</body>
</html>