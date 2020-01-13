<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SmartBooking</title>
<%@ page import="Model.*"%>
<%@ page import ="java.util.*" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../css/Ricevimenti.css">
<script>
$(document).ready(function(){
	$(".id").hide();
	$(".op").hide();
	$(".form").hide();
	$(".annulla").hide();
	$(".canc").hide();
	$("#formCancella").hide();
	$("#buttonDate").hide();

	$(".button").click(function()
	{
		$(".form").show();
		$(".annulla").show();
		$(".canc").show();
		$(".button").hide();
		$(".accept").hide();
		});
	
	$(".annulla").click(function(){
		$(".form").hide();
		$(".annulla").hide();
		$(".canc").hide();
		$(".button").show();
		$(".accept").show();
	});
	
});
</script>
<script>
function controllo(id)
{
	testo=document.getElementById(id).value;
	alert(testo)
	if(testo=="")
		{
		alert("Devi inserire una motivazione per l'annullamento")
		}
	else
	{
	document.getElementById(id+"i").submit();
	}
}

function controllo_data()
{

	var x=document.getElementById("insertData").value;

	var arr1=x.split("-");
    var d=new Date(); //data odierna
	var d1=new Date(arr1[0],arr1[1]-1,arr1[2]); //data selezionata
	var r1=d.getTime(); //timestamp data odierna
	var r2=d1.getTime();
	if(r1>r2)
		{
		 document.getElementById("add").innerHTML="La data che hai inserito è precedente a quella odierna";
		 document.getElementById("formCancella").style.display="none";
		 document.getElementById("buttonDate").style.display="none";
		}
	else
		{
		document.getElementById("add").innerHTML="";
			
		document.getElementById("formCancella").style.display="block";
		document.getElementById("buttonDate").style.display="block";
	
	
		}
	
	
}
</script>
</head>
<body>


</div>
<div id="container">

<div id="menu">
	<%@include file="../html/menu.html"%>
<div>
<%
Collection<Ricevimento> rv =(Collection) request.getSession().getAttribute("ricevimenti");

%><table class="table table-striped" id="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id ricevimento</th>
      <th scope="col">Matricola studente</th>
      <th scope="col">Data della prenotazione</th>
      <th scope="col">Data del ricevimento</th>
      <th scope="col">Stato</th>
      <th scope="col">Accetta</th>
      <th scope="col">Rifiuta</th>
      
    </tr>
    </thread>
    <tbody><% 
    
    String name="nome";
    String data="";
for(Ricevimento r : rv)
	{
	 data=(r.getData().getDate()+1)+"/"+(r.getData().getMonth()+1)+"/"+(r.getData().getYear()+1900);
	%><tr>
	<td><%= r.getId()%></td>
	<td><%= r.getMatStudente()%></td>
	<td><%= r.getDataPrenotazione()%></td>
	<td><%=data%></td>
	<td><%= r.getStato()%></td>
	<%if(!(r.getStato().equals("Accettato"))){ %>
	<td>
	    <form action="../AccettaRicevimentoServlet" method="Post">
	    <button class="accept" style="height:40px;width:40px"><i class="fas fa-check"></i>
	    </button><input type="text" name="id" class="id"  value='<%= r.getId() %>'>
	    <input type="text" class="op" name="operazione" value="1">
	    </form>
	</td>
    <td>
      <form class="form" id="<%=r.getId()%>i"  action="../AccettaRicevimentoServlet" method="Post">
      <input type="text" style="height:30px;width:300px" placeholder="inserisci una breve motivazione" id='<%= r.getId() %>' name="motivazioneCancellazione"><br>
      <input type="text" name="id" class="id"  value='<%= r.getId() %>'>
      <input type="text" class="op" name="operazione" value="2">
      </form>
      <input class="canc" type="submit" style="margin-top:10px" value="cancella appuntamento" onclick="controllo(<%=r.getId() %>)">
      <button style="margin-top:10px" class="annulla">Annulla operazione</button>
     <button class="button" style="height:40px;width:40px"><i class="far fa-times-circle"></i></button>
    
   </td>
    <%} else{%>
    <td></td>
    <td>
      <form class="form" id="<%=r.getId()%>i" action="../AccettaRicevimentoServlet" method="Post">
      <input type="text" style="height:30px;width:300px" placeholder="inserisci una breve motivazione" id='<%= r.getId() %>' name="motivazioneCancellazione"><br>
      
       
      <input type="text" name="id" class="id" value='<%= r.getId() %>'>
      <input type="text" class="op" name="operazione" value="2">
      </form>
       <input class="canc" type="submit" style="margin-top:10px" value="cancella appuntamento" onclick="controllo(<%=r.getId()%>)">
   
       <button style="margin-top:10px" class="annulla" value="<%=r.getId() %>">Annulla operazione</button>
     <button class="button" style="height:40px;width:40px"><i class="far fa-times-circle"></i></button>
    </td>
    
    <%} %>
	</tr><%
}
%>
    </tbody>
    </table>
    <form action="../CancellaGiornataAppServlet" id="genericoi">
    <div id="dataIns" style="text-align:center">
    <input type="date"  id="insertData" name="insertData" onchange="controllo_data()"> <a id="add">Cancella giornata di appuntamento</a>
    </div>
    <div id="formCancella" style="text-align:center">
    
    <input type="text" id="generico" style="height:30px;width:300px;margin-top:25px" placeholder="inserisci una breve motivazione" name="motivazioneCancellazione"><br>
    </form>
     </div>
       <div style="margin-left:44.5%;margin-top:25px">
      <button  id="buttonDate" value="cancella appuntamento" onclick="controllo('generico')">Cancella appuntamento</button>
     </div>

</div>
<div id="footer">
	<%@include file="../html/footer.html"%>
</div>

</body>
</html>