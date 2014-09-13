<html>
	<body>
		<h2>Hello!</h2>
		<h4>${message}</h4>
		<br />
		
		<form name="input" action="/assignment1_mariumau/send" method="get">
			Message content: <input type="text" name="content">
			<input type="submit" value="Submit">
		</form>

		<p><a href="/assignment1_mariumau/read">Get last message</a></p>
		
		<a href=http://localhost:8080/assignment1_mariumau/hello/person>(is it me you're looking for)</a>
		
	</body>
</html>
