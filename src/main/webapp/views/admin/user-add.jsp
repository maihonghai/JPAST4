<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath}/admin/user/insert" method="post" enctype="multipart/form-data">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username"><br>
    
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email"><br>
    
    <label for="fullname">Full Name:</label><br>
    <input type="text" id="fullname" name="fullname"><br>
    
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br>
    
    <label for="phone">Phone:</label><br>
    <input type="text" id="phone" name="phone"><br>
    
    <label for="images">Images:</label><br>
    <img height="150" width="200" src="" id="imagess" style="display:none;"/><br>
    <input type="file" onchange="choosefile(this)" id="image" name="image"><br>

    <label for="roleid">Role ID:</label><br>
    <input type="text" id="roleid" name="roleid"><br>
    
    <input type="submit" value="Insert">
</form>

<script>
    function choosefile(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                document.getElementById('imagess').src = e.target.result;
                document.getElementById('imagess').style.display = 'block'; // Hiện ảnh khi đã chọn
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
