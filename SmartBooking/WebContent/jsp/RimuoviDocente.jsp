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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> <!-- JQuery -->
<script type="text/javascript" src="../javascript/RimuoviDocenteJS.js"></script>

<link rel="stylesheet" href="../css/RimuoviDocente.css">
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
      <th scope="col">Matricola</th>
      <th scope="col">Email</th>
      <th scope="col">Ufficio</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  	<tr>
  	<% for(Docente d : list){ %>
      <th scope="row"><%= d.getNome()+" "+d.getCognome()%></th>
      <td><%= d.getMatricola() %></td>
      <td><%= d.getEmail() %></td>
      <td><%= d.getUfficio() %></td>
      <td><button class="buttonRemove" id="<%=d.getMatricola()%>"><i class="fas fa-user-minus"></i></button></td>  <!-- Rimuovi docente icon -->
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