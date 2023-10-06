<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Notifications</title>
    <link rel="stylesheet" href="../css/global_styles.css">
    <style>tr * {max-width: 30%;} table {max-width: 60%;}</style>
</head>
<body>
<h2>Notifications</h2>
<mytags:navbar/>

<c:choose>
    <c:when test="${notifications.size() == 0}">
        You have no new notifications
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>Subject</th>
                <th>Message</th>
            </tr>
            <c:forEach var="notification_index" begin="0" end="${notifications.size() - 1}">
                <a name="${notifications.get(notification_index).head}">
                    <tr>
                        <th>${notifications.get(notification_index).head}</th>
                        <td>${notifications.get(notification_index).body}</th>
                    </tr>
                </a>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>