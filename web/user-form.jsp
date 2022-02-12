<%--
  Created by IntelliJ IDEA.
  User: TetaSun
  Date: 2/11/2022
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <c:if test="${user != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit User
                        </c:if>
                        <c:if test="${user == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                </c:if>
                <tr>
                    <th>First Name:</th>
                    <td>
                        <input type="text" name="firstName" size="45"
                               value="<c:out value='${user.firstName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Last Name:</th>
                    <td>
                        <input type="text" name="lastName" size="45"
                        <%--                               value="<c:out value='${user.email}' />"--%>
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Name:</th>
                    <td>
                        <input type="text" name="username" size="15"
                        <%--                               value="<c:out value='${user.country}' />"--%>
                        />
                    </td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td>
                        <input type="text" name="password" size="15"
                        <%--                               value="<c:out value='${user.country}' />"--%>
                        />
                    </td>
                </tr>
                <tr>
                    <th>Mobile Number:</th>
                    <td>
                        <input type="text" name="mobileNumber" size="15"
                        <%--                               value="<c:out value='${user.country}' />"--%>
                        />
                    </td>
                </tr>
                <tr>
                    <th>City:</th>
                    <td>
                        <input type="text" name="city" size="15"
                        <%--                               value="<c:out value='${user.country}' />"--%>
                        />
                    </td>
                </tr>
                <tr>
                    <th>street:</th>
                    <td>
                        <input type="text" name="street" size="15"
                        <%--                               value="<c:out value='${user.country}' />"--%>
                        />
                    </td>
                </tr>
                <tr>
                    <th>Postal Code:</th>
                    <td>
                        <input type="text" name="PostalCode" size="15"
                        <%--                               value="<c:out value='${user.country}' />"--%>
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="email" size="15"
                        <%--                               value="<c:out value='${user.country}' />"--%>
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>