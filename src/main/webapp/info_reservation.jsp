<%@ page import="org.example.exo2.model.OptionsType" %>

<%--

  Created by IntelliJ IDEA.
  User: robis
  Date: 15/11/2024
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info réservations</title>
</head>
<body>
    <p>${clientBean.firstName} ${clientBean.lastName} vous avez réserver un appartement de type : ${reservation.type} à un prix de  ${reservation.price} €.
        Avec ces options :</p>
    <span> ${formattedOptions}</span>
<p>Un mail de confirmation vous a été envoyé à : ${clientBean.email}.</p>
</body>
</html>
