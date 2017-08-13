<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="resources/css/style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		
		$(document).ready(function(){
           $("button#prev").click(function(){
               alert("hi I am prev");
           }) 
           $("button#next").click(function(){
				var index = $("#index").val();
				alert(index);
        	   $.ajax({
                  type  :   'get' ,
                   url  :   'next',
                   data :   {get_param :'next',get_index : index},
                   dataType :   'html',
                   success :    function(){}
               });
           }) 
        });
	</script>
<title>Insert title here</title>
</head>
<body>

<h1>This is view</h1>

		<display:table name="page" pagesize="${page.fullListSize}" requestURI="getPage">
			<display:column property="id" title="ID" class="col-sm-1 col-id"></display:column>
			<display:column property="firstName" title="First Name" class="col-md-1"></display:column>
			<display:column property="lastName" title="Last Name" class="col-md-1"></display:column>
			<display:column property="birthDate" title="Date of Birth" class="col-md-1"></display:column>
			<display:column property="gender" title="Gender" class="col-md-1"></display:column>
			<display:column property="hireDate" title="Hired Date" class="col-md-1"></display:column>
		</display:table>
				
</body>

</html>