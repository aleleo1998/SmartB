<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="../css/HomeDocente.css">
<script type="text/javascript" src="../javascript/AvatarJS.js"></script>

<title>Smartbooking: HomepageDocente</title>


<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>

<%
DocenteModel m = new DocenteModel();

String matricola=(String)session.getAttribute("Utente");
Docente doc = m.doRetrieveByKey(matricola);
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
      				<button type="submit" class="btn btn-primary">Modifica Orari Ricevimento</button>
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
      
      
      <!-- FORM ACCETTA/RIFIUTA RICEVIMENTI -->
      
      <!--  -->
    </div>
  </div>
  </div>
  </div>
  </div>   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div id="footer">
		<%@include file="../html/footer.html"%>
	</div>

</body>
</html>