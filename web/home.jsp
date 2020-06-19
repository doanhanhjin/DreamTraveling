<%-- 
    Document   : home
    Created on : Jun 12, 2020, 3:03:49 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="slideshow.html"%>
         <c:if test="${empty sessionScope.ADMIN and empty sessionScope.USER}">
            <a href="index.jsp">Login</a>
        </c:if>
            <c:if test="${not empty sessionScope.ADMIN}">
            <h2>Welcome ${sessionScope.ADMIN.fullName}</h2>
            <form action="Logout" method="POST" style="float: right;">
                <input type="submit" value="Logout"/>
            </form>
            <a href="createNewTour.jsp">Create New Tour</a>
        </c:if>
        <!--USER-->
        <c:if test="${not empty sessionScope.USER}">
            <h2>Welcome ${sessionScope.USER.fullName}</h2>
            <form action="Logout" method="POST" style="float: right;">
                <input type="submit" value="Logout"/>
            </form>
        </c:if>
        <form action="Search">
            SEARCH Tour </br></br>
            Place <input type="text" name="txtPlace" value="" placeholder="Search tour..." style="margin-right: 20px;"/>
            Date <input type="text" name="txtDate" id="txtDate" readonly="true" style="margin-right: 20px;"/>
            Price 
            <select name="dropDownPrice" style="margin-right: 20px;">
                <option value="1">1000 - 2000 USD</option>
                <option value="2">2000 - 3000 USD</option>
                <option value="3">3000 - 5000 USD</option>
                <option value="4">5000 - 10000 USD</option>
            </select>
            <input type="submit" value="SEARCH" />
        </form>
       
        <!--ADMIN-->
        
        <c:if test="${not empty requestScope.TOUR}">
            <c:forEach var="dto" items="${requestScope.TOUR}" varStatus="count">
                <table border="1" style="margin-top: 20px; border-collapse: collapse;">
                    <thead>
                        <tr style="text-align: left; padding: 8px; background-color: #4CAF50; color: white;">
                            <th>No</th>
                            <th style="width: 130px;">Tour Name</th>
                            <th style="width: 230px;">From Date</th>
                            <th style="width: 230px;">To Date</th>
                            <th style="width: 130px;">Price</th>
                            <th>Image</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr style="text-align: left; padding: 8px; background-color: #f2f2f2;">
                            <td>${count.count}</td>
                            <td>${dto.tourName}</td>
                            <td>${dto.fromDate}</td>
                            <td>${dto.toDate}</td>
                            <td>${dto.price} USD</td>
                            <td style="padding: 0px;">
                                <img src="${dto.image}" style="width: 100px; height: 60px;"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </c:forEach>
        </c:if>
        <c:if test="${not empty requestScope.NOTFOUND}">
            <c:out value="${requestScope.NOTFOUND}" />
        </c:if>
    </body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
    type="text/javascript"></script>
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
          rel="Stylesheet"type="text/css"/>
    <script type="text/javascript">

        var loadFile = function (event) {
            var image = document.getElementById('output');
            image.style.display = "inline";
            image.src = URL.createObjectURL(event.target.files[0]);

        };
        $(function () {
            $("#txtDate").datepicker({minDate: 0});
        });
    </script>
</html>
