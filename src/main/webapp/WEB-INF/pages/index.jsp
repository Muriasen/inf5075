<html>
	<body>
		<h2>Hello!</h2>
		<h4>${message}</h4>
		<br />
		<a href=http://localhost:8080/assignment1_mariumau/hello/person>Hello (is it me you're looking for)</a>
		
		<form name="input" action="/assignment1/send" method="get">
			Message content: <input type="text" name="content">
			<input type="submit" value="Submit">
		</form>

		<p><a href="/assignment1/read">Get last message</a></p>
		
		
	</body>
</html>
