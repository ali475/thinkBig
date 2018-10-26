<%-- 
    Document   : Desscussions
    Created on : Oct 26, 2018, 3:55:29 PM
    Author     : Ali Mohamed
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          int Datacount = (int)request.getAttribute("datacount");
          int []IDs= new int[Datacount];
          String []Text =new String[Datacount];
          for (int i = 0; i <Datacount; i++) {
                  IDs[i]=(int)request.getAttribute("ID"+i);;
                  Text[i]=(String)request.getAttribute("Text"+i);
                  out.print("<a href=\"OpinionViewer?pram1="+IDs[i]+"\">"+Text[i]+"</a><br>");
              }
          
        %>
        <form action="OpinionViewer" method="get">
            <a href="OpinionViewer?pram1=Ali">this is data test</a>
        </form>
       
    </body>
</html>
