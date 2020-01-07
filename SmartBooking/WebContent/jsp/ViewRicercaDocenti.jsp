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
	<%@include file="../html/menu.html"%>
</div>

<div id="container">

<!-- Search form -->
<div id="searchBar">

<!-- Search form -->
<form class="form-inline md-form form-sm mt-0" id="search">
	<a href="#"><i class="fas fa-search" aria-hidden="true"></i></a>
  <input class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Search"
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
    </tr>
  </thead>
  <tbody>
  	<tr>
  	
  	<% for(int i=0;i<list.size();i++){ %>
  	<form name="form"+i action="../RicercaDocentiServlet">
      <th scope="row"><label id="nome"><%= list.get(i).getNome()%></label> <label id="cognome"><%=list.get(i).getCognome()%></label></th>
      <td><p id="ufficio"><%=list.get(i).getUfficio()%><p></td>
      <td><a href="RegView.jsp"><i class="fas fa-info-circle"></i></a></td>
      <td><button name="add"><i class="fas fa-user-plus"></i></button></td> <!--  Aggiungi docente icon -->
      <td><button name="remove"><i class="fas fa-user-minus"></i></button></td> <!-- Rimuovi docente icon -->
      </form>
    </tr>
   
    <% } %>

  </tbody>
</table>

</div>

<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>