<%@ include file="common/header.jspf" %>		
<%@ include file="common/navigation.jspf" %>

<!-- Reccomendation for bootstrap is to put everything in class container -->
<div class="container">
	<h1>Add Player:</h1>
	<!--  use path variable to tie a form POST to a bean -->
	<form:form method = "POST" modelAttribute="player">
		<!--  required keyword is a front end validation, which is nice but can easily be overriden by hackers, so server side is necessary -->
		
		<fieldset class="mb-3">
			<form:label path = "name">Name</form:label>
			<form:input type = "text" path = "name" required = "required"/>
			<form:errors path="name" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">
			<form:label path = "position">Position</form:label>
			<form:input type = "text" path = "position" required = "required"/>
			<form:errors path="position" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">
			<form:label path = "number">Number</form:label>
			<form:input type = "text" path = "number" required = "required"/>
			<form:errors path="number" cssClass="text-warning"/>
		</fieldset>
		
		
		<form:input type = "hidden" path = "id"/>
		<form:input type = "hidden" path = "team"/>
		<input type = "submit" class = "btn btn-success">
	</form:form>
</div>

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>
		
		
		
		



