<%@page import = "models.*"%>
<%
    Personne [] personne = (Personne []) request.getAttribute("personne"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire</title>
</head>
<body>
    <form action="insert">
        <select name="idpersonne" id="">
            <%
                for(int i = 0 ; i < personne.length ; i++){ %>
                    <option value="<%=personne[i].getId_personne()%>"><%=personne[i].getName_Personne()%></option>
                <%}
            %>
        </select>
      <p><input type="text" name="idteeth" placeholder="teeht" required></p>  
      <p><input type="text" name="etat" placeholder="etat" required></p>  
      <p><input type="submit" value="go"></p>  
    </form>
</body>
</html>