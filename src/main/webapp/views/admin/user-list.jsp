<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<a href="<c:url value='/admin/user/add'></c:url>">Add User</a>
<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Images</th>
        <th>Username</th>
        <th>Email</th>
        <th>Full Name</th>
        <th>Phone</th>
        <th>RoleId</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="STT">
        <tr>
            <td>${STT.index + 1}</td>
            <td>
                <c:if test="${user.image != null && user.image != ''}">
                    <img height="150" width="200" src="${user.image}"/>
                </c:if>
            </td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.fullname}</td>
            <td>${user.phone}</td>
            <td>
                <c:if test="${user.roleId == 1}">
                    <span>User</span>
                </c:if>
                <c:if test="${user.roleId == 3}">
                    <span>Manager</span>
                </c:if>
                <c:if test="${user.roleId == 4}">
                    <span>Seller</span>
                </c:if>
                <c:if test="${user.roleId == 5}">
                    <span>Shipper</span>
                </c:if>
            </td>
            <td>
                <a href="<c:url value='/admin/user/edit?id=${user.userId}'/>">Sửa</a>
                | <a href="<c:url value='/admin/user/delete?id=${user.userId}'/>">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
