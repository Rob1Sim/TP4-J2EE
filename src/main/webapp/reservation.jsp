<%--
  Created by IntelliJ IDEA.
  User: robis
  Date: 15/11/2024
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>s
<html>
<head>
    <title>Réservation</title>
</head>
<body>
<h2>Réservation Appartement</h2>

<!-- Affichage du message d'erreur en rouge si présent -->
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form action="CreateReservation" method="post">
    <label>
        <select name="typeAppartement">
            <option value="0" label="petit">petit</option>
            <option value="1" label="moyenne">moyenne</option>
            <option value="2" label="grand">grand</option>
        </select>
    </label>
<br>
    Prix: <label>
    <input type="text" name="prix">
</label><br>
    <label>Options:</label><br>
    <label>
        <input type="checkbox" name="options" value="jardin">
    </label> Jardin<br>
    <label>
        <input type="checkbox" name="options" value="piscine">
    </label> Piscine<br>
    <label>
        <input type="checkbox" name="options" value="proche de la mer">
    </label> Proche de la mer<br>

    <input type="submit" value="Réserver">
<br>

    <input type="submit" value="Réserver">
</form>
</body>
</html>
