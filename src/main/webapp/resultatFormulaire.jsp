<%@ page import="org.example.exo1.beans.Formulaire" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<jsp:useBean id="formDataList" scope="session" type="java.util.List<org.example.exo1.beans.Formulaire>" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultats</title>
    <style>
        table {
            width: 70%;
            border-collapse: collapse;
            margin: 20px auto;
            font-family: Arial, sans-serif;
        }
        th, td {
            border: 1px solid black;
            text-align: center;
            padding: 10px;
        }
        th {
            background-color: #f2f2f2;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Informations soumises</h1>

<%-- Vérification de la liste des formulaires --%>
<% if (formDataList != null && !formDataList.isEmpty()) { %>
<%
    // Iteration sur la liste de formulaires, chaque formulaire dans un tableau séparé
    for (Formulaire formData : formDataList) {
%>
<h2>Identifiant : <%= formData.getNom() %> <%= formData.getPrenom() %></h2>
<table>
    <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Sexe</th>
        <th>Code Postal</th>
        <th>Transports</th>
    </tr>
    <tr>
        <td><%= formData.getNom() %></td>
        <td><%= formData.getPrenom() %></td>
        <td><%= formData.getGenre() %></td>
        <td><%= formData.getCodePostal() %></td>
        <td>
            <%
                // Affichage des transports
                List<String> transports = formData.getTransports();
                for (int i = 0; i < transports.size(); i++) {
                    out.print(transports.get(i));
                    if (i < transports.size() - 1) {
                        out.print(", ");
                    }
                }
            %>
        </td>
    </tr>
</table>
<% } %>
<% } else { %>
<p>Aucun identifiant soumis.</p>
<% } %>

</body>
</html>
