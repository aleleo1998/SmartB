<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!--  JAVASCRIPT -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../javascript/RegDocente.js" type="text/javascript"></script>

<!-- CSS -->
<link rel="stylesheet" href="../css/RegDocente.css">

<!------ Include the above in your HEAD tag ---------->
<meta charset="UTF-8">
<title>SmartBooking: Registrazione Docente</title>
</head>
<body>

	<div id="menu">
		<%@include file="../html/menu.html"%>
	</div>
	
	<div id="container">
	
	<div class="container register" id="spaceup">
                <div class="row">
                    <div class="col-md-3 register-left">
                    <div id="contLogo">
                        <img src="../image/logo.png" id="logoReg" alt=""/>
                     </div>
                        <h3>Registrazione Docente</h3>
                       
                    </div>
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <form name="form" id="form" action="../RegistrazioneDocenteServlet">
                                <h3 class="register-heading" id="homeInsert">Inserisci dati docente</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="cognome" id="cognome" placeholder="Cognome *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="matricola" id="matricola" placeholder="Matricola *" value="" />
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
                                            <input type="text" class="form-control" name="ufficio" id="ufficio" placeholder="Ufficio *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="email" name="email" id="email" class="form-control" placeholder="Email *" value="" />
                                        </div>
                                        
                    
                                        
                                    </div>
                                           <p id="buttonRegistrazione"> Inserisci Docente </p>
                                    
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
	
	</div>
	
	<div id="footer">
		<%@include file="../html/footer.html" %>
	</div>

</body>
</html>