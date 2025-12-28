<%@ page import="java.util.List" %>
    <%@ page import="modele.Etudiant" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <link rel="stylesheet" href="style.css">
        </head>

        <body>
            <% List<Etudiant> listeEtudiants = (List<Etudiant>) request.getAttribute("listeEtudiant");
                    %>
                    <ul>
                        <% for(Etudiant etu: listeEtudiants){%>
                            <li>
                                <%="numero: "+etu.getId()+" nom: "+etu.getNom()+" prenoms: "+ etu.getPrenoms() %></li>
        <%}
        %>
    </ul>
    <form action=" ${pageContext.request.contextPath}/etudiants" method="post">
                                    <div class="input-label">
                                        <label for="">id</label>
                                        <input type="number" name="id" id="id">
                                    </div>
                                    <div class="input-label">
                                        <label for="">Nom</label>
                                        <input type="text" name="nom" id="nom">
                                    </div>
                                    <div class="input-label">
                                        <label for="">Prenoms</label>
                                        <input type="text" name="prenoms" id="prenoms">
                                    </div>
                                    <button type="submit">Enregistrer</button>
                                    </form>
        </body>

        </html>