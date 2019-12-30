/**
 * 
 */

$(document).ready(function(){
	
	$("#searchButton").click(function(){
		var docente = $("#nameDoc").val();
		//alert(docente);
		
		$.ajax({            //AJAX CON JQUERY
			type : 'Post',   //TIPO DI CHIAMATA
			data : {docente : docente, id : 0},  //COPPIE NOME-VALORE DA PASSARE ALLA SERVLET
			url : '../FindServlet',  //SERVLET DA RICHIAMARE IN MANIERA ASINCRONA
			success : function resultServlet(result) {  //FUNZIONE DA ESEGUIRE IN CASO DI SUCCESSO
				//alert("ajax--> valore restituito dalla servlet FindServlet: "+result);
				if(result == "Errore")
					alert("Spiacente. Il docente non è presente nel DB");
				else
					$("#tbody").html(result);
			}
			
		}); /*fine ajax*/
		
	}); 
	
	
});