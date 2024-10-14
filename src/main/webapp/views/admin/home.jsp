<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

</head>
<body>
    <div class="container">
        <h1>Welcome, Admin</h1>
        <p>Manage users, view reports, and configure settings.</p>
        <a href="/ltweb/views/logout.jsp">Logout</a>
        <a href="${pageContext.request.contextPath }/admin/categories">Categories</a>
    </div>
</body>
</html>
