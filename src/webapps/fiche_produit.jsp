<%@ page import="modele.Produit"%>
<%@ page import="java.lang.String"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/produit" method="post">
        <label for="produit">Produit</label>
        <input type="text" name="nom">
        <label for="cat1">categorie1</label>
        <input type="checkbox" name="categories" id="categorie" value="categorie1" id="cat1">
        <label for="cat1">categorie 2</label>
        <input type="checkbox" name="categories" id="categorie" value="categorie2" id="cat2">
        <label for="cat1">categorie 3</label>
        <input type="checkbox" name="categories" id="categorie" value="categorie3" id="cat3">
        <button type="submit">Valider</button>
    </form>
    <%
    String nom =(String)request.getAttribute("nom");
    List<String> categories =  (List<String>)request.getAttribute("categories");
        if(nom!= null ){ %>
            <h2>Nom du produit: <%=nom %></h2>
        <% } 
        if(categories != null){ %>
            <h2>Categories: </h2>
            <ul>
            <% for(String categorie: categories ){ %>
            <li><%= categorie%></li>
            <% } %>
            </ul>
        <% } %>
</body>
</html>