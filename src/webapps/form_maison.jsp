<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link type="text/css"rel="stylesheet" href="style.css">
</head>
<body>
    <form action=" ${pageContext.request.contextPath}/maisons" method="post">
                                    <div class="input-label">
                                        <label for="localisation">localisation</label>
                                        <input type="text" name="m.localisation" id="localisation" value="nanisana">
                                    </div>
                                    <div class="input-label">
                                        <label for="adresse">Adresse</label>
                                        <input type="text" name="m.adresse" id="adresser" value="Lot IIH 2D Bis FAA Nanisana">
                                    </div>
                                    <div class="input-label">
                                        <label for="pieces[0]">Pieces 1</label>
                                        <input type="text" name="m.pieces[0].designation" id="pieces[0]" value="living room">
                                    </div>
                                    <div class="input-label">
                                        <label for="pieces[1]">Pieces 2</label>
                                        <input type="text" name="m.pieces[1].designation" id="pieces[1]" value="kitchen">
                                    </div>
                                    <button type="submit">Afficher</button>
                                    </form>
</body>
</html>