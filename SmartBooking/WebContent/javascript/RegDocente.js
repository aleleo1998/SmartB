
$(document).ready(function(){
	
	
	
	$("#buttonRegistrazione").click(function(){
		
			if(checkNome()==1 && checkCognome()==1 && checkMatricola()==1 && checkUfficio()==1 &&checkMail()==1){
				//alert("Si può procedere alla registrazione");
				$("#form").submit();
			}	
			else{
				alert("Errore. non è possibile effettuare il submit");
			}
	});
	
});

/**
 * controlla nome
 * @returns 1 se nome OK, 0 altrimenti
 */
function checkNome(){
	var nome = $("#nome").val();  //ottengo valore campo nome
	var expr = /^[A-Za-z]{1,10}$/;
	if(nome.match(expr)){
		//alert("Nome corretto");
		return 1;
	}else{
		alert("Nome non corretto"); 
		return 0;
	}
}

/**
 * Controlla cognome
 * @returns 1 se cognome OK, 0 altrimenti
 */
function checkCognome(){
	var cognome = $("#cognome").val();  //ottengo valore campo nome
	var expr = /^[A-Za-z]{1,20}$/;
	if(cognome.match(expr)){
		//alert("Cognome corretto");
		return 1;
	}else{
		alert("Cognome non corretto");
		return 0;
	}
		
}

/**
 * Controlla se la matricola esiste già nel database (associata a un docente)
 * @returns 0 se già presente nel DB, 1 altrimenti
 */
function checkMatricola(){
	var matricola = $("#matricola").val();  //ottengo valore campo matricola
	var expr = /^[0-9]{10}$/;
	if(!matricola.match(expr)){
		alert("Matricola non corretta");
		return 0;
	}
	else{
		//alert("matricola OK"); 
		
		$.ajax({            //AJAX CON JQUERY
			type : 'Post',   //TIPO DI CHIAMATA
			data : {matricola : matricola},  //COPPIE NOME-VALORE DA PASSARE ALLA SERVLET
			async: false,
			url : '../CheckMatricolaDocenteServlet',  //SERVLET DA RICHIAMARE IN MANIERA ASINCRONA
			success : function resultServelt(result) {  //FUNZIONE DA ESEGUIRE IN CASO DI SUCCESSO
				if(result == "0"){
					//alert("result == 0. Matricola già esistente nel DB");
					flag = 0;
				}else if(result == "1"){
					//alert("result == 1. La matricola non esiste nel DB");
					flag = 1;
				}else{
					//alert("Errore.");
					flag = 0;
				}
			}
			
		}); /*fine ajax*/
	}
	return flag;
}	



/**
 * controlla campo ufficio
 * @returns 1 se campo ufficio OK, 0 altrimenti
 */
function checkUfficio(){
	var ufficio = $("#ufficio").val();  //ottengo valore campo ufficio
	var expr = /^[A-Za-z0-9]{1,20}$/;
	if(ufficio.match(expr)){
		//alert("Ufficio Corretto");
		return 1;
	}else{
		alert("Ufficio non corretto");
		return 0;
	}
}

/**
 * controlla se l'email inserita è già presente nel db (associata a un docente)
 * @returns 0 se indirizzo email esiste già nel DB, 1 altrimenti
 */
function checkMail(){
	var flag;
	var email = $("#email").val();    //ottengo valore campo email
	var expr = /^\w+([\.-]?\w+)*@studenti[.]{1}unisa[.]{1}it$/;
	if(email.length < 20 || email.length > 50){
		alert("Email non corretta");
		return 0;
	}else{
		//alert("Formato email corretto");  //arriva
		
		$.ajax({            //AJAX CON JQUERY
			type : 'Post',   //TIPO DI CHIAMATA
			data : {email : email},  //COPPIE NOME-VALORE DA PASSARE ALLA SERVLET
			async: false,
			url : '../CheckMailDocenteServlet',  //SERVLET DA RICHIAMARE IN MANIERA ASINCRONA
			success : function resultServelt(result) {  //FUNZIONE DA ESEGUIRE IN CASO DI SUCCESSO
				//alert("ajax--> valore restituito dalla servlet CheckMailServlet: "+result);
				if(result == "0"){
					//alert("result == 0. Indirizzo email già esistente nel DB");
					flag = 0;
				}else if(result == "1"){
					//alert("result == 1. L'indirizzo email non esiste nel DB");
					flag = 1;
				}else{
					//alert("Errore.");
					flag = 0;
				}
			}
			
		}); /*fine ajax*/
	}
	return flag;
}
