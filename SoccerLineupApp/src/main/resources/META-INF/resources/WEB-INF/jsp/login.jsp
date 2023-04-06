<html>
	<head>
	<title> Login page </title>
	</head>
	
	<!-- When loading the login page initially, this is a get request-->
	
	<body>
		<div class="container">
			<h1>Welcome to the login page for the soccer lineup application!</h1>
			<pre>${errorMessage}</pre>
			<!--  Using the form to send username and password not secure w/ default method. Bc sending via url over internet routers can see url. -->
			<!-- Instead use the post request method to submit things securely. post will send the information in something called form data in payload tab-->
			<form method="post"> 
				Name: <input type= "text" name="name">
				Password: <input type= "text" name="password">
				<input type="submit">
			</form>
		</div>
	<body>
</html>