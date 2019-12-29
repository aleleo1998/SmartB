/**
 * 
 */

$(document).ready(function(){
	
	
	
	$("#footer").click(function(){
		
		alert("checkNome: "+checkNome());
		alert("checkCognome: "+checkCognome());
		alert("checkMatricola: "+checkMatricola());
		alert("checkPassword: "+checkPassword());
		alert("checkConfermaPassword: "+checkConfermaPassword());
		alert("checkMail: "+checkMail());
		
		/*
			if(checkNome()==1 && checkCognome()==1 && checkMatricola()==1 && 
					checkPassword()==1 && checkConfermaPassword()==1 && checkMail()==1){
				alert("valori ok");
						$("#form").submit();
			}	
			else{
				alert("Errore. non è possibile effettuare il submit");
			}
		*/

	});
	
});



function checkNome(){
	var nome = $("#nome").val();  //ottengo valore campo nome
	var expr = /^[A-Za-z]{1,10}$/;
	if(nome.match(expr)){
		alert("Nome corretto");
		return 1;
	}else{
		alert("Nome non corretto"); 
		return 0;
	}
}

function checkCognome(){
	var cognome = $("#cognome").val();  //ottengo valore campo nome
	var expr = /^[A-Za-z]{1,20}$/;
	if(cognome.match(expr)){
		alert("Cognome corretto");
		return 1;
	}else{
		alert("Cognome non corretto");
		return 0;
	}
		
}

function checkMatricola(){
	var matricola = $("#matricola").val();  //ottengo valore campo matricola
	var expr = /^[0-9]{10}$/;
	if(matricola.match(expr)){
		alert("Matricola corretta");
		return 1;
	}else{
		alert("Matricola non corretta");
		return 0;
	}
}

function checkMail(){
	var email = $("#email").val();    //ottengo valore campo email
	var expr = /^\w+([\.-]?\w+)*@studenti[.]{1}unisa[.]{1}it$/;
	if(email.length < 20 || email.length > 50){
		alert("Email non corretta");
		return 0;
	}else{
		alert("Formato email corretto");  //arriva
		
		$.ajax({            //AJAX CON JQUERY
			type : 'Post',   //TIPO DI CHIAMATA
			data : {email : email},  //COPPIE NOME-VALORE DA PASSARE ALLA SERVLET
			async: false,
			url : '../CheckMailServlet',  //SERVLET DA RICHIAMARE IN MANIERA ASINCRONA
			success : function resultServelt(result) {  //FUNZIONE DA ESEGUIRE IN CASO DI SUCCESSO
				alert("ajax--> valore restituito dalla servlet CheckMailServlet: "+result);
				if(result == "0"){
					alert("result == 0. Indirizzo email già esistente nel DB");
					return 0;
				}else if(result == "1"){
					alert("result == 1. L'indirizzo email non esiste nel DB");
					return 1;
				}else{
					alert("Errore.");
					return 0;
				}
			}
			
		}); /*fine ajax*/
	}
}

function checkPassword(){
	var password = $("#password").val();  //ottengo valore campo password
	var expr = /^[A-Za-z0-9]{1,20}$/;
	if(password.match(expr)){
		alert("Password corretta");
		return 1;
	}else{
		alert("Password non corretta");
		return 0;
	}
		
}

function checkConfermaPassword(){
	var password = $("#password").val();  //ottengo valore campo password
	var confermaPassword = $("#confermaPassword").val();  //ottengo valore campo confermaPassword
	if(password == confermaPassword){
		alert("Le password coincidono");
		return 1;
	}else{
		alert("Le password non coincidono");
		return 0;
	}
}