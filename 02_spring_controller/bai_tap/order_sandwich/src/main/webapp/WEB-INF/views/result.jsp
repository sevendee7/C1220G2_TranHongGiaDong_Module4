<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>You order a sandwich with condiments:</h1>
<h2>
        <c:out value="${lettuce}">","</c:out>

        <c:out value="${tomato}">","</c:out>

        <c:out value="${mustard}">","</c:out>

        <c:out value="${sprouts}">","</c:out>
</h2>
</body>
</html>
