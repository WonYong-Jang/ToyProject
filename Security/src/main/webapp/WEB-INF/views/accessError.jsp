<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Access Denied Page
</h1>

<h2><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></h2>

<h2><c:out value="${msg}"/></h2>
</body>
</html>
