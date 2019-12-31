/**
 * 
 */

$(document).ready(function(){
	
	$("#searchButton").click(function(){
		var docente = $("#nameDoc").val();
		alert(posizione);
		//alert(docente);
		
		$.ajax({            //AJAX CON JQUERY
			type : 'Post',   //TIPO DI CHIAMATA
			data : {docente : docente},  //COPPIE NOME-VALORE DA PASSARE ALLA SERVLET
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
	
	
	checkAddRemove();
	
	
});






function checkAddRemove(){

var addButton = document.getElementsByClassName("addButton");  //riferimento a tutti i button di aggiunta alla lista preferiti

var removeButton = document.getElementsByClassName("removeButton");  //riferimento a tutti i button di remove alla lista preferiti

var matricole = document.getElementsByClassName("rowMatricola");  //riferimento alle matricole di tutti i docenti della lista

var i;

for(i=0;i<addButton.length;i++)
{
	var matricolaDocente = matricole[i].value;  //ottiene valore
	//alert(matricolaDocente);
	
	//var prezzoUnitario = array2[i].innerHTML;  //modifica valore	
	
	//$(".addButton").attr("disabled",true);
	
	$.ajax({            //AJAX CON JQUERY
		type : 'Post',   //TIPO DI CHIAMATA
		async : false,
		data : {matricolaDocente : matricolaDocente},  //COPPIE NOME-VALORE DA PASSARE ALLA SERVLET
		url : '../TrovaCorrispondenzaDocenteStudenteServlet',  //SERVLET DA RICHIAMARE IN MANIERA ASINCRONA
		success : function resultServlet(result) {  //FUNZIONE DA ESEGUIRE IN CASO DI SUCCESSO
			//alert("ajax--> valore restituito dalla servlet: "+result);
			if(result == "esiste"){  //corrispondenza trovata
				//alert("#addButton"+i);
				$("#addButton"+matricolaDocente).attr("disabled",true);
				$("#removeButton"+matricolaDocente).attr("disabled",false);
			}else{
				$("#addButton"+matricolaDocente).attr("disabled",false);
				$("#removeButton"+matricolaDocente).attr("disabled",true);
			}
		}
		
	}); /*fine ajax*/
	
}

};