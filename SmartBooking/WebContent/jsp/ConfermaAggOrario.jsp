<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SmartBooking: registrazione completata</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="../css/SuccessReg.css">
</head>
<body>

<div id="menu">
		<%@include file="menu.jsp"%>
	</div>
	


<div id="container">

<section class="login-block">
    <div class="container">
	<div class="row">
		<div class="col-md-4 login-sec" id="formLogin">
			<div id="contLogo">
                <img src="../image/logo.png" id="logoReg" alt=""/>
            </div>
		    <h2>Complimenti!</h2>
		    </h4> L'aggiunta dell'orario è avvenuta con successo.</h4>
		    <a href="InfoDocente.jsp?mat=<%=utente.getMatricola()%>"><p id="loginButton"> Torna sul profilo </p></a>
		    
					<div class="copy-text"></div>
		</div>
		
    					</div>
  				</div>
            </div>	   
		    
	
</section>		
		




<br>
<br>
<br>
<br>

<div id="footer">
		<%@include file="../html/footer.html"%>
	</div>


</body>
</html>