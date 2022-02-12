<%--
  Created by IntelliJ IDEA.
  User: TetaSun
  Date: 2/11/2022
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Users</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.firstName}" /></td>
                <td><c:out value="${user.lastName}" /></td>
                <td><c:out value="${user.username}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.mobileNumber}" /></td>
                <td><c:out value="${user.city}" /></td>
                <td><c:out value="${user.street}" /></td>
                <td><c:out value="${user.PostalCode}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>