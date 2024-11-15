<%--
  Created by IntelliJ IDEA.
  User: robis
  Date: 15/11/2024
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<h1>
    Inscription
</h1>
    <form method="POST" action="inscription">
        <label>
            Prénom :
            <input type="text" name="firstName">
        </label>
        <label>
            Nom :
            <input type="text" name="lastName">
        </label>
        <label>
            Email :
            <input type="email" name="email">
        </label>
        <label>
            N°de téléphone :
            <input type="text" name="phone">
        </label>
        <span style="color: red">${isError ? 'Vous devez replir tous les champs' : ''}</span>

        <input type="submit">
    </form>
</body>
</html>
