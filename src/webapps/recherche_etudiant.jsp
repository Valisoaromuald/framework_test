<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form action="${pageContext.request.contextPath}/etudiants_info" method="post">
        <div class="input-label">
            <label for="">Nom</label>
            <input type="text" name="nom" id="nom">
        </div>
        <div class="input-label">
            <label for="identifiant">id</label>
            <input type="text" name="identifiant" id="identifiant">
        </div>
        <button type="submit">Enregistrer</button>
    </form>
</body>

</html>