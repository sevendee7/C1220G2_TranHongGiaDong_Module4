<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">--%>
<%--<link rel="stylesheet" href="../../lib/bootstrap-4.6.0-dist/js/bootstrap.min.js">--%>
<%--<link rel="stylesheet" href="../../lib/bootstrap-4.6.0-dist/css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" href="../../lib/bootstrap413/css/bootstrap.min.css"/>--%>
<%--<link rel="stylesheet" href="../../lib/datatables/css/dataTables.bootstrap4.min.css"/>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>List Student</title>--%>
<%--</head>--%>
<%--<style>--%>
<%--    th {--%>
<%--        background-color: #b9bbbe;--%>
<%--        text-align: center;--%>
<%--    }--%>

<%--    td {--%>
<%--        text-align: center;--%>
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
<%--        <h2 style="text-align: center">Student Management</h2>--%>
<%--        <h6>--%>
<%--            <a href="/students?actionClient=create"><i class="fas fa-user-plus" style="font-size: 1.5rem;color: black"> Add New--%>
<%--                Student</i></a>--%>
<%--        </h6>--%>
<%--        <form class="form-inline my-2 my-lg-0">--%>
<%--            <input type="hidden" name="actionClient" value="search"/>--%>
<%--            <input class="form-control mr-sm-2" name="keywordName" value="${keywordName}" type="search"--%>
<%--                   placeholder="Search by name" aria-label="Search">--%>
<%--            <input class="form-control mr-sm-2" name="keywordId" value="${keywordId}" type="search"--%>
<%--                   placeholder="Search by id"--%>
<%--                   aria-label="Search">--%>
<%--            <input class="form-control mr-sm-2" name="keywordEmail" value="${keywordEmail}" type="search"--%>
<%--                   placeholder="Search by email" aria-label="Search">--%>
<%--            <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>--%>
<%--        </form>--%>
<%--        <br>--%>
<%--        <table id="StudentTable" class="table table-striped table-bordered bg-light text-black">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>No</th>--%>
<%--                <th>Id</th>--%>
<%--                <th>Name</th>--%>
<%--                <th>Gender</th>--%>
<%--                <th>Date of birth</th>--%>
<%--                <th>ID Card</th>--%>
<%--                <th>Email</th>--%>
<%--                <th>Address</th>--%>
<%--                <th>Phone</th>--%>
<%--                <th>Class</th>--%>
<%--                <th>Edit</th>--%>
<%--                <th>Delete</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <c:forEach var="student" items="${studentListServlet}" varStatus="loop">--%>

<%--                <tr>--%>
<%--                    <td>${loop.index + 1}</td>--%>
<%--                    <td>${student.id}</td>--%>
<%--                    <td>${student.name}</td>--%>
<%--                    <td>--%>
<%--                        <c:if test="${student.gender == true}">--%>
<%--                            Male--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${student.gender == false}">--%>
<%--                            Female--%>
<%--                        </c:if>--%>
<%--                    </td>--%>
<%--                    <td>${student.dateOfBirth}</td>--%>
<%--                    <td>${student.idNumber}</td>--%>
<%--                    <td>${student.email}</td>--%>
<%--                    <td>${student.address}</td>--%>
<%--                    <td>${student.phone}</td>--%>
<%--                    <c:forEach var="className" items="${classListServlet}">--%>
<%--                        <c:if test="${className.classCode == student.classCode}">--%>
<%--                            <td>${className.className}</td>--%>
<%--                        </c:if>--%>
<%--                    </c:forEach>--%>
<%--                        &lt;%&ndash;                <td>${student.className}</td>&ndash;%&gt;--%>
<%--                    <td><a href="/students?actionClient=update&id=${student.id}">--%>
<%--                        <i class="far fa-edit" style="font-size: 1.5rem"></i>--%>
<%--                    </a></td>--%>
<%--                    <td>--%>
<%--                        <button type="button" class="btn btn-danger"--%>
<%--                                onclick="sendIdToForm('${student.id}','${student.name}')">--%>
<%--                            <i class="far fa-trash-alt"></i>--%>
<%--                        </button>--%>
<%--                    </td>--%>
<%--                </tr>--%>

<%--            </c:forEach>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>
<%--    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1"--%>
<%--         aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--        <div class="modal-dialog">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="staticBackdropLabel">Delete Confirmation</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">Do you want to delete <span id="nameDelete"></span>?--%>
<%--                    <form action="/students">--%>
<%--                        <input type="hidden" name="actionClient" value="delete">--%>
<%--                        <input type="hidden" name="id" value="idDelete" id="idDelete">--%>
<%--                        <div class="modal-footer">--%>
<%--                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>--%>
<%--                            <button type="submit" class="btn btn-primary">Confirm</button>--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script src="../../lib/jquery-3.6.0.min.js"></script>--%>
<%--<script src="../../lib/bootstrap-4.6.0-dist/js/bootstrap.min.js"></script>--%>
<%--<script src="../../lib/datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="../../lib/datatables/js/dataTables.bootstrap4.min.js"></script>--%>
<%--<script src="../../lib/bootstrap413/js/bootstrap.min.js"></script>--%>
<%--<script>--%>
<%--    function sendIdToForm(employeeId, employeeName) {--%>

<%--        $('#staticBackdrop').modal('show');--%>
<%--        document.getElementById("idDelete").value = employeeId;--%>
<%--        document.getElementById("nameDelete").innerText = employeeName;--%>
<%--    }--%>

<%--    $(document).ready(function () {--%>
<%--        $('#StudentTable').dataTable({--%>
<%--            "dom": 'lrtip',--%>
<%--            "lengthChange": false,--%>
<%--            "pageLength": 5--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
