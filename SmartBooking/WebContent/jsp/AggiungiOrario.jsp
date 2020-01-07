<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smartbooking: Aggiungi orario</title>
<!-- Bootstrap -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../css/AggiungiOrario.css">

</head>
<body>

<script>
//Material Select Initialization
$(document).ready(function() {
});


function showForm(){
	
	var num = $( "#numOrari" ).val();
	
	num = parseInt(num);
	
	console.log(num);
	
	for(var i = 1; i<=num; i++){
	
	$( "#aggOrario" ).append('<h2 id="rowTitle">Giorno '+i+'</h2>'+
			'<div class="form-group row">'+
			'	<label for="inputEmail3" class="col-sm-2 col-form-label">Giorno</label>'+
			'    <div class="col-sm-10">'+
			'      <select name="giorno'+i+'" form="aggOrario">'+
			'		  <option value="lunedi">Lunedì</option>'+
			'		  <option value="martedi">Martedì</option>'+
			'		  <option value="mercoledi">Mercoledì</option>'+
			'		  <option value="giovedi">Giovedì</option>'+
			'		  <option value="venerdi">Venerdì</option>'+
			'	  </select>'+
			'    </div>'+
			'  </div>'+
			'  <div class="form-group row">'+
			'    <label for="inputPassword3" class="col-sm-2 col-form-label">Orario di inizio</label>'+
			'    <div class="col-sm-10">'+
			'      <select name="oraInizio'+i+'" form="aggOrario">'+
			'		  <option value="08:00">08:00</option>'+
			'		  <option value="08:30">08:30</option>'+
			'		  <option value="09:00">09:00</option>'+
			'		  <option value="09:30">09:30</option>'+
			'		  <option value="10:00">10:00</option>'+
			'		  <option value="10:30">10:30</option>'+
			'		  <option value="11:00">11:00</option>'+
			'		  <option value="11:30">11:30</option>'+
			'		  <option value="12:00">12:00</option>'+
			'		  <option value="12:30">12:30</option>'+
			'		  <option value="13:00">13:00</option>'+
			'		  <option value="13:30">13:30</option>'+
			'		  <option value="14:00">14:00</option>'+
			'		  <option value="14:30">14:30</option>'+
			'		  <option value="15:00">15:00</option>'+
			'		  <option value="15:30">15:30</option>'+
			'		  <option value="16:00">16:00</option>'+
			'		  <option value="16:30">16:30</option>'+
			'		  <option value="17:00">17:00</option>'+
			'		  <option value="17:30">17:30</option>'+
			'		  <option value="18:00">18:00</option>'+
			'		  <option value="18:30">18:30</option>'+
			'	  </select>'+
			'    </div>'+
			'  </div>'+
			'  <div class="form-group row">'+
			'    <label for="inputPassword3" class="col-sm-2 col-form-label">Orario di fine</label>'+
			'    <div class="col-sm-10">'+
			'    <div class="mdb-select md-form">'+
			'      <select name="oraFine'+i+'" form="aggOrario">'+
			'		  <option value="08:00">08:00</option>'+
			'		  <option value="08:30">08:30</option>'+
			'		  <option value="09:00">09:00</option>'+
			'		  <option value="09:30">09:30</option>'+
			'		  <option value="10:00">10:00</option>'+
			'		  <option value="10:30">10:30</option>'+
			'		  <option value="11:00">11:00</option>'+
			'		  <option value="11:30">11:30</option>'+
			'		  <option value="12:00">12:00</option>'+
			'		  <option value="12:30">12:30</option>'+
			'		  <option value="13:00">13:00</option>'+
			'		  <option value="13:30">13:30</option>'+
			'		  <option value="14:00">14:00</option>'+
			'		  <option value="14:30">14:30</option>'+
			'		  <option value="15:00">15:00</option>'+
			'		  <option value="15:30">15:30</option>'+
			'		  <option value="16:00">16:00</option>'+
			'		  <option value="16:30">16:30</option>'+
			'		  <option value="17:00">17:00</option>'+
			'		  <option value="17:30">17:30</option>'+
			'		  <option value="18:00">18:00</option>'+
			'		  <option value="18:30">18:30</option>'+
			'	  </select>'+
			'	  </div>'+
			'    </div>'+
			'  </div>');
	
	}
	
	$( "#aggOrario" ).append('<input type="hidden" name="numOrari" value="'+num+'" />'+
			'<div class="form-group row">'+
			'	<div class="col-sm-10">'+
			'	<button type="submit" class="btn btn-primary">Aggiungi orario</button>'+
			'	</div>'+
			'	</div>');
	
	
	$( "#form" ).show("slow");
	$( "#form2" ).hide("slow");
	console.log("ciao");
	
}

</script>


<div id="menu">
	<%@include file="menu.jsp"%>
</div>

<div id="container">

<div id="form2">

	<div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Quanti orari vuoi aggiungere?</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" id="numOrari" min="1" max="5" />
    </div>
  </div>
  
  <button type="submit" class="btn btn-primary" onClick="showForm()">Avanti</button>


</div>


<div id="form" style="display: none">
<form action="../AggiungiOrarioServlet" id="aggOrario" method="POST">
  
</form>
</div>

</div>


<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>