/**
 * 
 */

$(document).ready(function() {
		$('.buttonRemove').click(function(){

			var matricola = $(this).attr("id");	
			alert(matricola);

			$.ajax({            //AJAX CON JQUERY
				type : 'Post',   //TIPO DI CHIAMATA
				data : {matricola : matricola},  //COPPIE NOME-VALORE DA PASSARE ALLA SERVLET
				url : '../RimuoviDocenteServlet',  //SERVLET DA RICHIAMARE IN MANIERA ASINCRONA
				success : alert("Docente Eliminato correttamente")//FUNZIONE DA ESEGUIRE IN CASO DI SUCCESSO
			}); /*fine ajax*/

		});

		
}); 



