<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>
</head>
<body>
<div id="menu">
	<%@include file="menu.jsp"%>
</div>

<%if(tipo==1){ %>

<div id="container">

	<form method="POST" id="creaRichiesta" action="../creaRichiestaModificaOrario">
  <div class="form-group">
    <label for="exampleFormControlSelect1">Orari Inizio</label>
    <select name = "orarioInizio" class="form-control"  form = "creaRichiesta">
     					<option value="08:00">08:00</option>
					  <option value="08:30">08:30</option>
					  <option value="09:00">09:00</option>
					  <option value="09:30">09:30</option>
					  <option value="10:00">10:00</option>
					  <option value="10:30">10:30</option>
					  <option value="11:00">11:00</option>
					  <option value="11:30">11:30</option>
					  <option value="12:00">12:00</option>
					  <option value="12:30">12:30</option>
					  <option value="13:00">13:00</option>
					  <option value="13:30">13:30</option>
					  <option value="14:00">14:00</option>
					  <option value="14:30">14:30</option>
					  <option value="15:00">15:00</option>
					  <option value="15:30">15:30</option>
					  <option value="16:00">16:00</option>
					  <option value="16:30">16:30</option>
					  <option value="17:00">17:00</option>
					  <option value="17:30">17:30</option>
					  <option value="18:00">18:00</option>
					  <option value="18:30">18:30</option>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleFormControlSelect1">Orario Fine</label>
    <select  name = "orarioFine" class="form-control" form = "creaRichiesta" >
      <option value="08:00">08:00</option>
					  <option value="08:30">08:30</option>
					  <option value="09:00">09:00</option>
					  <option value="09:30">09:30</option>
					  <option value="10:00">10:00</option>
					  <option value="10:30">10:30</option>
					  <option value="11:00">11:00</option>
					  <option value="11:30">11:30</option>
					  <option value="12:00">12:00</option>
					  <option value="12:30">12:30</option>
					  <option value="13:00">13:00</option>
					  <option value="13:30">13:30</option>
					  <option value="14:00">14:00</option>
					  <option value="14:30">14:30</option>
					  <option value="15:00">15:00</option>
					  <option value="15:30">15:30</option>
					  <option value="16:00">16:00</option>
					  <option value="16:30">16:30</option>
					  <option value="17:00">17:00</option>
					  <option value="17:30">17:30</option>
					  <option value="18:00">18:00</option>
					  <option value="18:30">18:30</option>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleFormControlSelect1">Giorno Nuovo</label>
    <select  name = "giornoNuovo" class="form-control"  form = "creaRichiesta">
      				<option value="lunedi">Lunedì</option>
					  <option value="martedi">Martedì</option>
					  <option value="mercoledi">Mercoledì</option>
					  <option value="giovedi">Giovedì</option>
					  <option value="venerdi">Venerdì</option>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleFormControlSelect1">Giorno Precedente</label>
    <select name = "giornoVecchio" class="form-control" form = "creaRichiesta">
    					<option value="lunedi">Lunedì</option>
    					<option value="martedi">Martedì</option>
					  <option value="mercoledi">Mercoledì</option>
					  <option value="giovedi">Giovedì</option>
					  <option value="venerdi">Venerdì</option>
    </select>
  </div>
  
  <button type="submit" class="btn btn-primary">Inoltra Richiesta</button>
 
 
</form>
</div>

<%}else{ %>
<h1 style="text-align:center">Non sei autorizzato</h1>
<%} %>

<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>