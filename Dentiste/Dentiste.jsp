<%@
    page import = "models.*"
%>
<%@
    page import = "java.util.List"
%>
<%@
    page import = "java.util.Vector"
%>
<%
    Personne [] personne = (Personne []) request.getAttribute("personne");
    Personne_newTeeth [] big_data = (Personne_newTeeth [] ) request.getAttribute("all") ;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dentiste</title>
    <link rel="stylesheet" href="assets/scss/style.css">
    <script src="assets/js/Suggestion.js" defer></script>
</head>
<body>
        <div class="contain">
            <%
                for(int i = 0 ; i<big_data.length ; i++){ %>
                    <div class="about_me">
                        <div class="about">
                            <div>
                                <span>Nom : <%=personne[i].getName_Personne()%></span>
                          
                                <span>Argent : <%=personne[i].getArgent()%> ar </span>
                            </div>
                            <div class="priorisation">
                                <label for=""> </label>
                                <form class="form">
                                    <input type="hidden" name="idpersonne" value="<%=personne[i].getId_personne()%>">
                                    <select name="priorisation" id="">
                                        <option value="1">Sante</option>
                                        <option value="0">Beaute</option>
                                    </select>
                                </form>
                            </div>
                        </div>
                        <div class="teeth" >
                            <div>
                                <label for=""></label>
                                <table>
                                    <tr>
                                        <th>Numero dents</th>
                                        <th>Emplacement</th>
                                        <th>Etat nify</th>
                                      
                                    </tr>
                                    <%
                                        for(int u = 0 ; u <big_data[i].getTeeth_personne().size() ; u++){ %>
                                            <tr>
                                                <td><%=big_data[i].getTeeth_personne().get(u).getNumeroDent()%></td>
                                                <td><%=big_data[i].getTeeth_personne().get(u).getEmplacement()%></td>
                                                <td><%=big_data[i].getTeeth_personne().get(u).getEtat()%></td>
                                                  </tr>
                                        <%}
                                    %>
                                </table>
                            </div>
                            <div class="after">
                                <%
                                    Vector<Object> myteeth = big_data[i].getNew_teeth_person() ;
                                    List<New_teeth_person> new_teeth = (List<New_teeth_person>) myteeth.elementAt(0);
                                %>
                                <label for=""></label>
                                <table>
                                    <tr>
                                        <th>Numero dents</th>
                                        <th>Emplacement</th>
                                        <th>Etat nify apres</th>
                                    
                                    </tr>
                                    <%
                                        for(int u = 0 ; u <new_teeth.size() ; u++){%>
                                            <tr>
                                                <td><%=new_teeth.get(u).getNumeroDent()%></td>
                                                <td><%=new_teeth.get(u).getEmplacement()%></td>
                                                <td><%=new_teeth.get(u).getEtat()%></td>
                                              
                                            </tr>
                                        <%}
                                    %>
                                </table>
                            </div>
                          
                            <div class="reste">
                                <%
                                    double argent_reste = (double) myteeth.elementAt(1); 
                                %>
                                Reste argent : <%=argent_reste%> 
                            </div>
                           
                        </div>
                    </div>
                <%} 
            %>
        </div>
</body>
</html>