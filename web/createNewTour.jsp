<%-- 
    Document   : createNewTour
    Created on : Jun 12, 2020, 4:39:17 PM
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
        <c:if test="${not empty sessionScope.ADMIN}">
            <h1>Create New Tour</h1>
            <form action="CreateNewTour" method="POST" name="myForm" onsubmit="return validateForm()">
                Name    <input type="text" name="txtTourName" value="" required="true"/></br></br>
                To Place    <input type="text" name="txtToPlace" value="" required="true"/></br></br>
                From Date    <input type="date" name="txtFromDate" value="" id="txtFromDate" readonly="true" required="true"/>
                To Date    <input type="date" name="txtToDate" value="" id="txtToDate" readonly="true" required="true"/></br></br>
                Image    <img id="output" width="300" height="210" style="display: none"/>
                <input type="file" accept="image/*" name="txtImage" id="file" required="true" onchange="loadFile(event)"/></br></br>

                Price    <input type="text" name="txtPrice" value="" required="true"/></p></br></br>
                Quota    <input type="text" name="txtQuota" value="" required="true"/></br></br>
                    <input type="submit" value="Create"/>
                    <input type="reset" value="Reset" style="margin-left: 20px;"/>
            </form>
        </c:if>
        <c:if test="${empty sessionScope.ADMIN}">
            <h2>You can not create!</h2>
        </c:if>
    </body>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
    type="text/javascript"></script>
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
          rel="Stylesheet"type="text/css"/>
    <script type="text/javascript">

                    $(function () {
                        $("#txtFromDate").datepicker({
                            numberOfMonths: 1,
                            onSelect: function (selected) {
                                var dt = new Date(selected);
                                dt.setDate(dt.getDate() + 1);
                                $("#txtToDate").datepicker("option", "minDate", dt);
                            }
                        });
                        $("#txtToDate").datepicker({
                            numberOfMonths: 2,
                            onSelect: function (selected) {
                                var dt = new Date(selected);
                                dt.setDate(dt.getDate() - 1);
                                $("#txtFromDate").datepicker("option", "maxDate", dt);
                            }
                        });
                    });
                    var loadFile = function (event) {
                        var image = document.getElementById('output');
                        image.style.display = "inline";
                        image.src = URL.createObjectURL(event.target.files[0]);

                    };

                    function validateForm() {
                        var x = document.forms["myForm"]["txtPrice"].value;
                        if (isNaN(x) || x < 1) {
                            alert("Price not valid");
                            return false;
                        }
                        var y = document.forms["myForm"]["txtQuota"].value;
                        if (isNaN(y) || y < 1) {
                            alert("Quota not valid");
                            return false;
                        }
                    }
                    ;

    </script>
</html>
