/**
 * 
 */

$(document).ready(function(){
	alert("CIAO");
	$(".delete").click(function(){
		alert(id);
		//rimuovi(this.id); //chiama la funzione invia passando come paramentro l'id appena passato		
	})	  
});
	
function rimuovi(id){
	$.ajax({
		type : 'Post',
		data : {matricola : id},
		url : '../RemoveDocenteServlet',
	})
}

