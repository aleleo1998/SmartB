<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smartbooking: cambio password</title>
<!-- Bootstrap -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../css/CambioPassword.css">

</head>
<body>

<div id="menu">
	<%@include file="../html/menu.html"%>
</div>

<div id="container">


<div id="form">
<form>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputEmail3" placeholder="Inserisci la vecchia password">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Nuova password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Inserisci la nuova password">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Conferma password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Conferma nuova password">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Modifica password</button>
    </div>
  </div>
</form>
</div>

</div>


</div>

<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>