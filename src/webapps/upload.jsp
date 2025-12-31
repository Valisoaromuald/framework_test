<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action=" ${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">

    <label>Choisir des fichiers :</label>
    <input type="file" name="fichiers" multiple />

    <br><br>

    <button type="submit">Uploader</button>

</form>
</body>
</html>