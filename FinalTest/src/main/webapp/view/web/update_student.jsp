<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<link rel="stylesheet" href="../../lib/bootstrap-4.6.0-dist/js/bootstrap.min.js">--%>
<%--<link rel="stylesheet" href="../../lib/bootstrap-4.6.0-dist/css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" href="../../lib/bootstrap413/css/bootstrap.min.css"/>--%>
<%--<link rel="stylesheet" href="../../lib/datatables/css/dataTables.bootstrap4.min.css"/>--%>
<%--<link rel="stylesheet" href="../css/style_of_me.css">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Update Student</title>--%>
<%--    <style>--%>
<%--        th {--%>
<%--            background-color: #b9bbbe;--%>
<%--            text-align: left;--%>
<%--        }--%>

<%--        td {--%>
<%--            text-align: left;--%>
<%--            background-color: #95999c;--%>
<%--        }--%>

<%--        #header-background {--%>
<%--            width: 100%;--%>
<%--            height: 100%;--%>
<%--            background-image: url("../../view/img/header-background.jpg");--%>
<%--        }--%>

<%--        #body-background {--%>
<%--            width: 100%;--%>
<%--            height: 100%;--%>
<%--            background-image: url("../../view/img/336-3369684_home-web-design-education-website-background.png");--%>
<%--        }--%>

<%--        #input-table {--%>
<%--            background-color: #002752;--%>
<%--        }--%>

<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container-fluid">--%>
<%--    <div class="h-auto" id="header-background">--%>
<%--        <div class="row head" style="height: 150px">--%>
<%--            <div class="col-3">--%>
<%--                <img src="../../view/img/logo.jpg" alt="Logo" height="100%" width="40%">--%>
<%--            </div>--%>
<%--            <div class="col-6"></div>--%>
<%--            <div class="col-3 text-center" style="line-height: 150px; font-size: 20px">--%>
<%--                <b>Tran Hong Gia Dong - C1220G2</b>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div id="body-background">--%>
<%--        <div class="row">--%>
<%--            <div class="col-4" id="left-ads"><img src="../../view/img/1.gif" width="500px" height="800px"></div>--%>
<%--            <div class="col-4" id="input-table">--%>
<%--                <h2 style="text-align: center;color: white">Update Student</h2>--%>
<%--                <c:if test="${msg.equals('Update successfully!')}">--%>
<%--                    <p style="color: blue">${msg}</p>--%>
<%--                </c:if>--%>
<%--                <c:if test="${msg.equals('Update failed!')}">--%>
<%--                    <p style="color: red">${msg}</p>--%>
<%--                </c:if>--%>
<%--                <br>--%>
<%--                <form action="/students" method="post">--%>
<%--                    <table class="table table-striped" style="width: 30%; margin: auto;border: 1px solid black">--%>
<%--                        <tr>--%>
<%--                            <input type="hidden" name="id" value="${studentObj.id}"/>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Name:</td>--%>
<%--                            <td><input type="text" name="name" value="${studentObj.name}"/></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                <label for="gender">Gender:</label>--%>
<%--                            </td>--%>
<%--                            <td>--%>
<%--                                <select name="gender" id="gender">--%>
<%--                                    <c:if test="${studentObj.gender}">--%>
<%--                                        <option selected value="true">Male</option>--%>
<%--                                        <option value="false">Female</option>--%>
<%--                                    </c:if>--%>
<%--                                    <c:if test="${!studentObj.gender}">--%>
<%--                                        <option value="true">Male</option>--%>
<%--                                        <option selected value="false">Female</option>--%>
<%--                                    </c:if>--%>
<%--                                </select>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Date of Birth:</td>--%>
<%--                            <td><input type="text" name="dateOfBirth" value="${studentObj.dateOfBirth}"/></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>ID Card:</td>--%>
<%--                            <td><input type="text" name="idCard" value="${studentObj.idNumber}"/></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Email:</td>--%>
<%--                            <td><input type="text" name="email" value="${studentObj.email}"/></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Address:</td>--%>
<%--                            <td><input type="text" name="address" value="${studentObj.address}"/></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>Phone:</td>--%>
<%--                            <td><input type="text" name="phone" value="${studentObj.phone}"/></td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                Class:--%>
<%--                            </td>--%>
<%--                            <td>--%>
<%--                                <input type="text" name="classCode" value="${studentObj.classCode}"/>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        <input type="hidden" name="actionClient" value="update">--%>
<%--                        <input type="hidden" name="id" value="${studentObj.id}">--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                <input type="submit" class="btn btn-lg btn-primary" value="Update Customer"--%>
<%--                                       style="font-size: 1rem"/>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <div class="col-4"><img src="../../view/img/2.gif" width="500px" height="800px"></div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script src="../../lib/jquery-3.6.0.min.js"></script>--%>
<%--<script src="../../lib/bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
