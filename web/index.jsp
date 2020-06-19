<%-- 
    Document   : index
    Created on : Jun 12, 2020, 2:19:06 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link href="loginform.css" rel="Stylesheet" type="text/css"/>-->
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="Login" method="POST">
            <input type="text" name="txtUsername" value="" /></br></br>
            <input type="password" name="txtPassword" value="" /></br></br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
