<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:if test="${!isConnected}">
    <p style="color:red;">Vous devez être connecté pour réservé</p>
    <a href="inscription">Inscription</a>
</c:if>
<form action="createReservation" method="post">
        <label>
            <select name="typeAppartement">
                <option value="0" label="petit">petit</option>
                <option value="1" label="moyenne">moyenne</option>
                <option value="2" label="grand">grand</option>
            </select>
        </label>
    <label>
        Prix:
        <input type="text" name="prix">
    </label>
        <label>Options:</label><br>
        <label>
            <input type="checkbox" name="options" value="jardin">
        </label> Jardin<br>
        <label>
            <input type="checkbox" name="options" value="piscine">
        </label> Piscine<br>
        <label>
            <input type="checkbox" name="options" value="mer">
        </label> Proche de la mer<br>
        <c:if test="${isConnected}">
            <input type="submit" value="Réserver">
        </c:if>

</form>
</body>
</html>
