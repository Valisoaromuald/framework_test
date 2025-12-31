<%@page import="java.lang.String"%>
<%@page import="java.util.List"%>
<%@page import="modele.Piece"%>
<%@page import="modele.Maison"%>
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
    List<Piece> pieces = (List<Piece>)request.getAttribute("pieces");
    List<Maison[]> maisons = (List<Maison[]>) request.getAttribute("maisons");
        if(localisation!=null){%>
        <h2>Localisation: <%= localisation%>
        </h2>
        <% } %>

            <% if(adresse!=null){%>
                <h2>Adresse: <%= adresse%>
                </h2>
                <% } %>
                <% if(pieces!=null){%>
            <% for(Piece pi:pieces){ %>
                <h1><%= pi.getDesignation()%></h1>
                <h1><%= pi.getMeubles()%></h1>
            <% } %>
            <% } %>

            <% if(maisons!= null){%>
            <% for(Maison[] houses:maisons){ %>
            <% for(Maison m:houses){ %>
                <p><%=m.getLocalisation()%></p>
            <% } %>
            <% } %>
            <% } %>

</body>

</html>