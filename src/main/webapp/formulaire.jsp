<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire</title>
</head>
<body>
<h1>Saisissez vos informations</h1>
<form method="POST" action="create-Formulaire" accept-charset="UTF-8">
    Nom: <input type="text" name="nom" /><br/>
    Prénom: <input type="text" name="prenom" /><br/>
    Genre:
    <select name="genre">
        <option value="">--Sélectionnez--</option>
        <option value="M">Homme</option>
        <option value="F">Femme</option>
        <option value="A">Autre</option>

    </select><br/>
    Code Postal: <input type="text" name="codePostal" /><br/>
    Transports :
    <input type="checkbox" name="transports" value="Voiture" /> Voiture
    <input type="checkbox" name="transports" value="Vélo" /> Vélo
    <input type="checkbox" name="transports" value="Train" /> Train<br/>
    <button type="submit">Soumettre</button>
</form>
<p style="color: red;">
    ${error != null ?error:''}
</p>
</body>
</html>
