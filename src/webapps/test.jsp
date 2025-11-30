<%@ page import="java.util.List"%>
<%@ page import="modele.Etudiant"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Lokoy ny lanitra tsy hiova</h1>
    <%
        List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("listeEtudiant");
        String nom = (String) request.getAttribute("nomPersonne");
    %>
    <h1><%= nom %></h1>
        <ul>
            <% for(Etudiant etu: etudiants) { %>
            <li><%= etu.getNom()+" "+etu.getPrenoms() %></li>
            <% } %>
        </ul>
    
</body>
</html>