<jsp:useBean id="formData" scope="session" type="org.example.exo1.model.Formulaire"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
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
        .message {
            text-align: center;
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Informations soumises</h1>
<p class="message">Vos identifiants ont été bien enregistrés</p>

<table>
    <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Sexe</th>
        <th>Code Postal</th>
        <th>Transports</th>
    </tr>
    <tr>
        <td>${formData.nom}</td>
        <td>${formData.prenom}</td>
        <td>${formData.genre}</td>
        <td>${formData.codePostal}</td>
        <td>
            ${formattedTransports}
        </td>
    </tr>
</table>
</body>
</html>
