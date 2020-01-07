<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="../css/FormEmail.css">

<!--  JAVASCRIPT -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../javascript/FormEmailJS.js" type="text/javascript"></script>


<%@ page import="Model.*"%>
<%@ page import="java.util.*"%>

<%
DocenteModel m = new DocenteModel();
StudenteModel s = new StudenteModel();

String matricola=(String)session.getAttribute("Utente");
Docente doc = m.doRetrieveByKey(matricola);

LinkedList<Studente> listStudenti = (LinkedList<Studente>) s.doRetrieveAll(); 

%>
<meta charset="ISO-8859-1">
<title>Form Email</title>

</head>
<body>

	<div id="menu">
		<%@include file="menu.jsp" %> 
	</div>

	<div class="col-xl-8 offset-xl-2 py-5">
         <form name="form" id="form" method="post" action="../EmailSendingServlet" role="form">

                    <div class="messages"></div>

                    <div class="controls">

                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="form_name">Nome *</label>
                                    <input id="form_name" type="text" id="name" name="name" class="form-control" value="<%=doc.getNome()%>" placeholder="Please enter your firstname *" required="required" data-error="Firstname is required.">
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="form_lastname">Cognome *</label>
                                    <input id="form_lastname" type="text" id="surname" name="surname" class="form-control" value="<%=doc.getCognome()%>" placeholder="Please enter your lastname *" required="required" data-error="Lastname is required.">
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="form_email">From *</label>
                                    <input id="form_email" type="email" id="emailMittente" name="emailMittente" value="<%=doc.getEmail()%>" class="form-control" placeholder="Please enter your email *" required="required" data-error="Valid email is required.">
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                 
                        
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="form_email">To *</label>			
                                    <input id="form_email" type="email" id="emailDestinatario" name="emailDestinatario" class="form-control" placeholder="Please enter an email *" required="required" data-error="Valid email is required.">
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                 
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="form_email">Oggetto *</label>
                                    <input id="form_email" type="text" id="subject" name="subject" class="form-control" placeholder="Please enter your subject *" required="required" data-error="Valid email is required.">
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                 
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="form_message">Messaggio *</label>
                                    <textarea id="form_message" id="message" name="message" class="form-control" placeholder="Message for me *" rows="4" required="required" data-error="Please, leave us a message."></textarea>
                                    <div class="help-block with-errors"></div>
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
							<div class="col-md-12">
                            	<!--  <p id="buttonInvia"> Invia </p> -->
                                  <input type="submit" id="buttonInvia" class="btn btn-success btn-send" value="Invia ">                                             
                                 <input type="reset" id="buttonReset" class="btn btn-success btn-send" value="Annulla ">
                           
                            </div>
                        </div>
                    </div>

           </form>
	</div>


	<div id="footer">
		<%@include file="../html/footer.html"%>
	</div>

  <!--
  
  <form action="../EmailSendingServletContattaci" method="post" style="color:black; margin-top: 50px" >
		<table border="0" width="50%" align="center">
			<caption><h2>Invia E-Mail</h2></caption>
			
			<tr>
				<td width="50%">E-Mail mittente</td>
				<td><input type="text" name="email-mittente" size="50"/></td>
			</tr>
			<tr>
				<td width="50%">Nome </td>
				<td><input type="text" name="nome" size="50"/></td>
			</tr>
			<tr>
				<td>Oggetto </td>
				<td><input type="text" name="subject" size="50"/></td>
			</tr>
			<tr>
				<td>Messaggio </td>
				<td><textarea rows="10" cols="51" name="content"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Invia"/></td>
			</tr>
		</table>
	</form>

-->

</body>
</html>