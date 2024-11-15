<%--@elvariable id="clientBean" type="org.example.exo2.model.Client"--%>
<%--
  Created by IntelliJ IDEA.
  User: robis
  Date: 15/11/2024
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info client</title>
</head>
<body>
    <h1>Bonjour ${clientBean.firstName} ${clientBean.lastName}</h1>
    <h2 style="color: green">Inscription avec succès</h2>
    <span>email: ${clientBean.email};N° de téléphone: ${clientBean.phone};</span>

</body>
</html>
