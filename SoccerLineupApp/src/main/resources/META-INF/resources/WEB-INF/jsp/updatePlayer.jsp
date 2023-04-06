<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title> Update Player Page </title>
	</head>
	
	<body>
		<!-- Reccomendation for bootstrap is to put everything in class container -->
		<div class="container">
			<h1>Update Player:</h1>
			<!--  use path variable to tie a form POST to a bean -->
			<form:form method = "POST" modelAttribute="player">
				<!--  required keyword is a front end validation, which is nice but can easily be overriden by hackers, so server side is necessary -->
				<fieldset class="mb-3">
					<form:label path = "description">Description:</form:label>
					<form:input type = "text" path = "description" required = "required"/>
					<form:errors path="description" cssClass="text-warning"/>
				</fieldset>
				
				<fieldset class="mb-3">
					<form:label path = "targetDate">Target Date:</form:label>
					<form:input type = "text" path = "targetDate" required = "required"/>
					<form:errors path="targetDate" cssClass="text-warning"/>
				</fieldset>
				
				<fieldset class="mb-3">
					<form:label path = "done">Completed:</form:label>
					<form:input type = "text" path = "done" required = "required"/>
					<form:errors path="done" cssClass="text-warning"/>
				</fieldset>
				
				<input type = "submit" class = "btn btn-success">
			</form:form>
		</div>
		<script src = "webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src = "webjars/jquery/3.6.0/jquery.min.js"></script>
		
	</body>
</html>