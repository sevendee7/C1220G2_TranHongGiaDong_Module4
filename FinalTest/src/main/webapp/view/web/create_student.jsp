<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">--%>
<%--<link rel="stylesheet" href="../../lib/bootstrap-4.6.0-dist/js/bootstrap.min.js">--%>
<%--<link rel="stylesheet" href="../../lib/bootstrap-4.6.0-dist/css/bootstrap.min.css">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Student Management Application</title>--%>
<%--</head>--%>
<%--<style>--%>
<%--    th {--%>
<%--        background-color: #b9bbbe;--%>
<%--        text-align: left;--%>
<%--    }--%>

<%--    td {--%>
<%--        text-align: left;--%>
<%--    }--%>

<%--    #header-background {--%>
<%--        width: 100%;--%>
<%--        height: 100%;--%>
<%--        background-image: url("../../view/img/header-background.jpg");--%>
<%--    }--%>

<%--    #body-background {--%>
<%--        width: 100%;--%>
<%--        height: 100%;--%>
<%--        background-image: url("../../view/img/336-3369684_home-web-design-education-website-background.png");--%>
<%--    }--%>

<%--    #input-table {--%>
<%--        background-color: #002752;--%>
<%--    }--%>
<%--</style>--%>
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
<%--                <h1 style="text-align: center; color: white">Add New Student</h1>--%>
<%--                <h2 style="text-align: center">--%>
<%--                    <a href="/students?actionClient=" style="color: blue"><i class="fas fa-long-arrow-alt-left"></i> Go--%>
<%--                        back</a>--%>
<%--                </h2>--%>
<%--                <br>--%>
<%--                <div>--%>
<%--                    <h2 style="text-align:center; color: darkblue">${result}</h2>--%>
<%--                    <h2 style="text-align:center; color: red">--%>
<%--                        <c:if test="${mapError.get('error') != null}"/>--%>
<%--                        <c:out value="${mapError.get('error')}"/>--%>
<%--                    </h2>--%>
<%--                    <form method="post">--%>
<%--                        <table border="1" cellpadding="5" style="border: 5px solid grey; margin: auto">--%>
<%--                            <tr>--%>
<%--                                <th>Student ID:</th>--%>
<%--                                <td>--%>
<%--                                    <input type="text" name="id" id="id" size="45"/>--%>
<%--                                    <p style="color: red"><c:if test="${mapError.get('id') != null}"/>--%>
<%--                                        <c:out value="${mapError.get('id')}"/>--%>
<%--                                    </p>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <th>Name:</th>--%>
<%--                                <td>--%>
<%--                                    <input type="text" name="name" id="name" size="45"/>--%>
<%--                                    <p style="color: red"><c:if test="${mapError.get('name') != null}"/>--%>
<%--                                        <c:out value="${mapError.get('name')}"/>--%>
<%--                                    </p>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <th>--%>
<%--                                    <label for="gender">Gender:</label>--%>
<%--                                <td>--%>
<%--                                    <select name="gender" id="gender">--%>
<%--                                        <option value="true">Male</option>--%>
<%--                                        <option value="false">Female</option>--%>
<%--                                    </select>--%>
<%--                                </td>--%>
<%--                                </th>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <th>Date of Birth:</th>--%>
<%--                                <td>--%>
<%--                                    <input type="date" name="dateOfBirth" id="dateOfBirth" size="45"/>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <th>Id Card:</th>--%>
<%--                                <td>--%>
<%--                                    <input type="text" name="idNumber" id="idNumber" size="15"/>--%>
<%--                                    <p style="color: red"><c:if test="${mapError.get('idNumber') != null}"/>--%>
<%--                                        <c:out value="${mapError.get('idNumber')}"/>--%>
<%--                                    </p>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <th>Email:</th>--%>
<%--                                <td>--%>
<%--                                    <input type="text" name="email" id="email" size="15"/>--%>
<%--                                    <p style="color: red"><c:if test="${mapError.get('email') != null}"/>--%>
<%--                                        <c:out value="${mapError.get('email')}"/>--%>
<%--                                    </p>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <th>Address:</th>--%>
<%--                                <td>--%>
<%--                                    <input type="text" name="address" id="address" size="45"/>--%>
<%--                                    <p style="color: red"><c:if test="${mapError.get('address') != null}"/>--%>
<%--                                        <c:out value="${mapError.get('address')}"/>--%>
<%--                                    </p>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <th>Phone:</th>--%>
<%--                                <td>--%>
<%--                                    <input type="text" name="phone" id="phone" size="45"/>--%>
<%--                                    <p style="color: red"><c:if test="${mapError.get('phone') != null}"/>--%>
<%--                                        <c:out value="${mapError.get('phone')}"/>--%>
<%--                                    </p>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <th>Class:</th>--%>
<%--                                <td>--%>
<%--                                    <input type="text" name="classCode" id="classCode" size="45"/>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td colspan="2" align="center" style="text-align: center">--%>
<%--                                    <input type="submit" class="btn btn-lg btn-primary" value="Save"/>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                        </table>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-4"><img src="../../view/img/2.gif" width="500px" height="800px"></div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script src="../../lib/jquery-3.6.0.min.js"></script>--%>
<%--<script src="../../lib/bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
