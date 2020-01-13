<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="Model.*"%>
<%@ page import ="java.util.*" %>
<meta charset="ISO-8859-1">
<title>SmartBooking</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/7606041806.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../css/OrarioDocente.css">
<script>
$(document).ready(function(){
	$("#matricolaDocente").hide();
});


function controllo(id)
{
	
	if(document.getElementById(id).value=="")
		{
		    alert("Non ci sono date disponibili");
		}
	else
		{
		document.getElementById(id+"i").submit();
		}
}
</script>
</head>
<body>
<div id="menu">
	<%@include file="menu.jsp"%>
</div>



<% Collection<Disponibilita> orari=(Collection) request.getSession().getAttribute("orari"); %>

<table class="table table-striped" id="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Matricola professore</th>
      <th scope="col">Ora</th>
      <th scope="col">Data disponibile</th>
      <th scope="col">Prenota</th>
   </tr>
    </thread>
  <tbody>
  <%
  String ora="";
  Date d;
  Calendar calendar;
  Date dataOd;;
  int mese=0;
  int i;
  for(Disponibilita ds : orari)
  {
	    calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		d=new Date();
		dataOd=new Date();
		calendar.set(d.getYear()+1900,d.getMonth(),1);
		d=calendar.getTime();
		mese=d.getMonth();
		i=1;
		%><form action="../PrenotaRicevimento" id="<%=ds.getOra()%>i"><tr>
		<td><%=ds.getMatricolaDocente()%></td>
		<td><%=ds.getOra()%></td>
		<td>
		<input type="text" name="matricolaDocente" id="matricolaDocente" value=<%=ds.getMatricolaDocente()%>>
		<select name="date" id="<%=ds.getOra() %>"><%
		while(d.getMonth()==mese)
		{
		if(ds.getGiorno().equals("lunedi"))
		{
			if(d.getDay()==1)
			{
				if((d.after(dataOd) || (d.equals(dataOd))))
				{
				System.out.println(d);
				System.out.println("a001");
				String data= i+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
				%><option value=<%=data%>><%= data %></option><%
				}
			}
			
			
		}
		if(ds.getGiorno().equals("martedi"))
		{
			if(d.getDay()==2)
			{
				if((d.after(dataOd) || (d.equals(dataOd))))
				{
				System.out.println(d);
				System.out.println("a001");
				String data= i+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
				%><option value=<%=data%>><%=data%></option><%
				}
			}
		}
		
		if(ds.getGiorno().equals("mercoledi"))
		{
			if(d.getDay()==3)
			{
				if((d.after(dataOd) || (d.equals(dataOd))))
				{
				System.out.println(d);
				System.out.println("a001");
				String data= i+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
				%><option value=<%=d %>><%=data%></option><%
				}
			}
		}
		if(ds.getGiorno().equals("giovedi"))
		{
			if(d.getDay()==4)
			{
				if((d.after(dataOd) || (d.equals(dataOd))))
				{
				System.out.println(d);
				System.out.println("a001");
				String data= i+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
				%><option value=<%=data %>><%=data%></option><%
				}
			}
		}
		
		if(ds.getGiorno().equals("venerdi"))
		{
			if(d.getDay()==5)
			{
				if((d.after(dataOd) || (d.equals(dataOd))))
				{
				System.out.println(d);
				System.out.println("a001");
				String data= i+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
				%><option value=<%=data %>><%=data %></option><%
				}
			}
		}
			i++;
		calendar.add(calendar.DAY_OF_MONTH,1);
		d=calendar.getTime();
		}
		%></td></select></form><td><button  onclick="controllo('<%=ds.getOra()%>')">Prenota</button></td></tr>
	  <%
  }
  
  
  %>
  
  
  </tbody>
    <div id="footer">
	<%@include file="../html/footer.html"%>
</div>
</body>
</html>