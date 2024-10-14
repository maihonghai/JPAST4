<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath}/admin/user/update" method="post" enctype="multipart/form-data">
    <input type="hidden" id="userId" name="userId" value="${user.userId}">
    
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" value="${user.username}"><br>
    
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" value="${user.email}"><br>
    
    <label for="fullname">Full Name:</label><br>
    <input type="text" id="fullname" name="fullname" value="${user.fullname}"><br>
    
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" value="${user.password}"><br>
    
    <label for="phone">Phone:</label><br>
    <input type="text" id="phone" name="phone" value="${user.phone}"><br>
    
    <label for="images">Images:</label><br>
    <c:if test="${user.image != null && user.image != ''}">
        <img height="150" width="200" src="${user.image}" id="imagess"/><br>
    </c:if>
    <input type="file" onchange="choosefile(this)" id="image" name="image"><br>

    <p>RoleId:</p>
    <input type="radio" id="ston" name="status" value="1" ${user.roleId == 1 ? 'checked' : ''}>
    <label for="ston">User</label><br>
    <input type="radio" id="stoff" name="status" value="0" ${user.roleId == 3 ? 'checked' : ''}>
    <label for="stoff">Manager</label><br>
    
    <input type="submit" value="Update">
</form>

<script>
    function choosefile(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                document.getElementById('imagess').src = e.target.result;
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
