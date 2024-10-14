<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath }/admin/category/insert" method="post" enctype="multipart/form-data">
	<label for="catename">Category name:</label><br> 
	<input type="text" id="catename" name="catename" ><br> 
	<label for="images">Images:</label><br> 
	
	<img height="150" width="200" src="" id="imagess"/>
	
<!-- 	NHẬP LINK:<INPUT TYPE="TEXT" ID="ICON1"><BR> -->

	<input type="file" onchange="choosefile(this)" id="images" name="images" ><br>
	<label for="status">Status:</label><br> 
	<input id="ston" type="radio" name="status" value="1" checked>
	<label for="ston">Hoạt Động</label>
	<input id="stoff" type="radio" name="status" value="0">
	<label for="stoff">Khóa</label><br>
	
	<br> <input type="submit" value="insert">
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
