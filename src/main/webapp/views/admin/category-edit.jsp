<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath }/admin/category/update"
	method="post" enctype="multipart/form-data">
	<input type="text" id="cateid" name="cateid" value="${cate.categoryId }" hidden="hidden"><br>
	<label for="catename">Category name:</label><br> 
	<input type="text" id="catename" name="catename" value="${cate.categoryname }"><br>
	<label for="images">Images:</label><br>
	<c:if test="${cate.images.substring(0,5) != 'https'}">
		<c:url value="/image?fname=${cate.images }" var="imgUrl"></c:url>
	</c:if>
	<c:if test="${cate.images.substring(0,5) == 'https'}">
		<c:url value="${cate.images }" var="imgUrl"></c:url>
	</c:if>
	<img id = "imagess" height="150" width="200" src="${imgUrl }"/>
	 <input type="file" onchange="choosefile(this)" id="images" name="images" ><br> 
	
	<p>Status:</p>
	<input type="radio" id="ston" name="status" value="1"${cate.status==1?'checked':''}>
	<label for="html">Đang hoạt động</label><br>
	<input type="radio" id="stoff" name="status" value="0"${cate.status!=1?'checked':''}>
	<label for="css">Khóa</label><br>
	
	
	<br> <input type="submit" value="Update">
</form>
<!-- Đặt hàm JavaScript ở đây, trước thẻ đóng body -->
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
