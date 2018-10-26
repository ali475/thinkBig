<%-- 
    Document   : opinion
    Created on : Oct 26, 2018, 6:07:26 PM
    Author     : Ali Mohamed
--%>

<%@page import="Entities.opinion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
          int []Ids= new int[5];
          String[]Texts = new String[5];
          String []Types= new String[5];
            for (int i = 0; i < 5; i++) {
                    Ids[i]= (int)request.getAttribute("id"+i);
                    Texts[i]= (String)request.getAttribute("text"+i);
                    Types[i]= (String)request.getAttribute("type"+i);
                }
        %>
        <form action="SaveHashTags" method="POST">
            <%
                for (int i = 0; i < 5; i++) {
                     out.print("<input type=\"hidden\" name =\"ID"+i+"\" value=\""+Ids[i]+"\">");
                     out.print("<p>"+Texts[i]+"</p>");
                        for (int j = 0; j < 5; j++) {
                                out.print("<input type=\"text\" name=\"HashTag"+i+j+"\" value=\"\" size=\"20\" />");
                            }
                    }
               
            %>
          
            <input type="submit" name="submit" value="Save">
        </form>
    </body>
</html>
