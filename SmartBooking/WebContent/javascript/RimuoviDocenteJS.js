/**
 * 
 */

$(document).ready(function() {
		
		$('.buttonRemove').click(function(){
			alert("Cc");
			var matricola = $(this).attr("id");	
			//alert("click su "+ matricola);
		
		
			$("#conferma").click(function(){
				
				//alert("elimino "+ matricola);
		
				
				$.ajax({            //AJAX CON JQUERY
					type : 'Post',   //TIPO DI CHIAMATA
					data : {matricola : matricola},  //COPPIE NOME-VALORE DA PASSARE ALLA SERVLET
					url : '../RimuoviDocenteServlet',  //SERVLET DA RICHIAMARE IN MANIERA ASINCRONA
					success : function result(){
						$("#myModal").attr("aria-hidden",true);
						alert("Docente eliminato correttamente")//FUNZIONE DA ESEGUIRE IN CASO DI SUCCESSO
						window.location.href=window.location.href;
					}
				});  /*fine ajax*/
	
			});
		});
		
}); 







