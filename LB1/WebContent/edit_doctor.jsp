
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit doctor</title>
</head>
<body>
<h3>Edit doctor</h3>
<form method="post">
<input type="hidden" value="${doctor.id}" name="id" />
<label>Name</label><br>
<input name="name" value="${doctor.name}" /><br><br>
<label>Special</label><br>
<input name="special" value="${doctor.special}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>