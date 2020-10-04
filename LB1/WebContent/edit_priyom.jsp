
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit priyom</title>
</head>
<body>
<h3>Edit priyom</h3>
<form method="post">
<input type="hidden" value="${priyom.id}" name="id" />
<label>Skarga</label><br>
<input name="skarga" value="${priyom.skarga}" /><br><br>
<label>Diagnos</label><br>
<input name="diagnos" value="${priyom.diagnos}" /><br><br>
<label>Datapr</label><br>
<input name="datapr" value="${priyom.datapr}" /><br><br>
<input type="submit" value="Send" />
</form>
</body>
</html>