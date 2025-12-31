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
                                    <div class="input-label">
                                        <label for="pieces[1]">Pieces 3</label>
                                        <input type="text" name="m.pieces[3].designation" id="pieces[1]" value="">
                                    </div>
                                    <div class="input-label">
                                        <label for="lieux[0]">Pieces 4</label>
                                        <input type="text" name="lieux[0]" id="lieux[0]" value="besarety">
                                    </div>
                                    <div class="input-label">
                                        <label for="lieux[1]">Pieces 5</label>
                                        <input type="text" name="lieux[1]" id="lieux[1]" value="ampasapito">
                                    </div>

                                    <div class="input-label">
                                        <label for="maisons[0]">beloha</label>
                                        <input type="text" name="maisons[0][0].localisation" id="maisons[0].localisation" value="reko">
                                    </div>
                                    <div class="input-label">
                                        <label for="maisons[1]">beloha</label>
                                        <input type="text" name="maisons[0][1].localisation" id="lieux[1]" value="band">
                                    </div>
                                    
                                    <button type="submit">Afficher</button>
                                    </form>
</body>
</html>