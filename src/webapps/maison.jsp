<%@page import="java.lang.String"%>
<%@page import="modele.Piece"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Information maison</h1>
    <% String localisation=(String)request.getAttribute("localisation"); String adresse=(String)request.getAttribute("adresse");
    Piece[] pieces = (Piece[])request.getAttribute("pieces");
        if(localisation!=null){%>
        <h2>Localisation: <%= localisation%>
        </h2>
        <% } %>

            <% if(adresse!=null){%>
                <h2>Adresse: <%= adresse%>
                </h2>
                <% } %>
                <% if(pieces!=null){%>
            <% for(Piece piece:pieces){ %>
                <h1><%= piece.getDesignation()%></h1>
                <h1><%= piece.getMeubles()%></h1>
                <% } %>
                <% } %>
</body>

</html>