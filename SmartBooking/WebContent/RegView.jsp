<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="RegView.css">

<!------ Include the above in your HEAD tag ---------->
<meta charset="UTF-8">
<title>SmartBooking: Registrazione</title>
</head>
<body>

	<div id="menu">
		<%@include file="menu.jsp %>
	</div>
	
	<div id="body">
	
	<div class="container register" id="spaceup">
                <div class="row">
                    <div class="col-md-3 register-left">
                    <div id="contLogo">
                        <img src="logo.png" id="logoReg" alt=""/>
                        </div>
                        <h3>Registrazione studente</h3>
                        <p>Hai già un account SmartBooking? Effettua l'accesso</p>
                        <input type="submit" id="loginButton" name="" value="Login"/><br/>
                    </div>
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading" id="homeInsert">Inserisci i tuoi dati</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="nome" placeholder="Nome *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="cognome" placeholder="Cognome *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" id="matricola" placeholder="Matricola *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="male" checked>
                                                    <span>M</span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="female">
                                                    <span>F</span> 
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="email" id="email" class="form-control" placeholder="Email *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="password" placeholder="Password *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="confermaPassword" placeholder="Conferma password *" value="" />
                                        </div>
                                        
                                        <input type="submit" class="btnRegister"  value="Registrati"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
	
	</div>
	
	<div id="footer">
		<%@include file="footer.jsp" %>
	</div>

</body>
</html>