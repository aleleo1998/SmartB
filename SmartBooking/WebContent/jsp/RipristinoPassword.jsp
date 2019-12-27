<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmartBooking: ripristino password</title>
<!-- Bootstrap -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../css/RipristinoPassword.css">

</head>
<body>

<div id="menu">
	<%@include file="../html/menu.html"%>
</div>

<div id="container">


<div id="form">
<form>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Email istituzionale</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" placeholder="mariorossi@studenti.unisa.it">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Ripristina password</button>
    </div>
  </div>
</form>

<p>
	Verrà inviata una mail all'indirizzo e-mail istituzionale contenente il link per l'inserimento di una nuova password.
</p>

</div>

</div>


</div>

<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>