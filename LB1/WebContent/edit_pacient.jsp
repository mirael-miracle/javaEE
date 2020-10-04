
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit pacient</title>
</head>
<body>
<h3>Edit pacient</h3>
<form method="post">
<input type="hidden" value="${pacient.id}" name="id" />
<label>Name</label><br>
<input name="name" value="${pacient.name}" /><br><br>
<label>Skarga</label><br>
<input name="skarga" value="${pacient.skarga}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>