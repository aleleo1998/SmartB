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
		    </h4> La registrazione è avvenuta con successo.</h4>
		    <p> Procedi con il Login </p>
		    <a href="Login.jsp"><p id="loginButton"> Login </p></a>
		    
					<div class="copy-text"></div>
		</div>
		
			<div class="col-md-8 banner-sec">
            	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                	 <ol class="carousel-indicators">
                    	<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    	<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    	<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                  	 </ol>
            
            <div class="carousel-inner" role="listbox">
    			<div class="carousel-item active">
      				<img class="d-block img-fluid" src="../image/unisacampus.jpg" id="img1" alt="First slide">
      					<div class="carousel-caption d-none d-md-block">
        					<div class="banner-text">
            					<h2>Condividi Unisa</h2>
            						<p>L'offerta didattica di UNISA è tra le più ampie e variegate del Sud Italia e consente di scegliere tra ben 80 corsi di studio, che spaziano dalle scienze della vita e della salute alle scienze esatte, dagli ambiti umanistico e giuridico-economico a quelli ingegneristico ed informatico.</p>
        					</div>	
  						</div>	
    			</div>
    			
    				<div class="carousel-item">
      					<img class="d-block img-fluid" src="../image/unisacampus2.jpg" id="img2" alt="First slide">
      						<div class="carousel-caption d-none d-md-block">
        						<div class="banner-text">
            						<h2>Condividi Unisa</h2>
            							<p>L'offerta didattica di UNISA è tra le più ampie e variegate del Sud Italia e consente di scegliere tra ben 80 corsi di studio, che spaziano dalle scienze della vita e della salute alle scienze esatte, dagli ambiti umanistico e giuridico-economico a quelli ingegneristico ed informatico.</p>
        						</div>	
    						</div>
    				</div>
    
    			<div class="carousel-item">
      				<img class="d-block img-fluid" src="../image/unisacampus3.jpg" id="img3" alt="First slide">
      					<div class="carousel-caption d-none d-md-block">
        					<div class="banner-text">
            					<h2>Condividi Unisa</h2>
            						<p>L'offerta didattica di UNISA è tra le più ampie e variegate del Sud Italia e consente di scegliere tra ben 80 corsi di studio, che spaziano dalle scienze della vita e della salute alle scienze esatte, dagli ambiti umanistico e giuridico-economico a quelli ingegneristico ed informatico.</p>
        					</div>	
    					</div>
  				</div>
            </div>	   
		    
		</div>
	</div>
</div>
</div>
</section>		
		
</div>


<div id="footer">
		<%@include file="../html/footer.html"%>
	</div>


</body>
</html>