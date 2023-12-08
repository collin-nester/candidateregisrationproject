<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menubar">
    <a href="home">Home</a>
    <a href="register">Register</a>
    <a href="position_application">Position Application</a>
    <a href="applied_positions">Applied Positions</a>
    <a href="#">Admin Tools</a>
    <span class="full_dropdown navbar_dropdown" id="admin_tools_dropdown">
        <a href="create_position">Create Position</a>
        <a href="list_applicants">List Applicants</a>
        <a href="applied_positions_lookup">Applied Positions Lookup</a>
        <a href="my_postings">My Postings</a>
    </span>
    <a href="login">Login</a>
    <a href="logout">Logout</a>
    <span class="full_dropdown">
        <a href="notifications">
            <c:if test="${notifications.size() > 0}">
                <svg id="bell_circle" height="8" width="8">
                    <circle cx="4" cy="4" r="4" fill="red"/>
                </svg>
            </c:if>
            <img src="../images/bell.png" height="20px" id="bell">
        </a>
        <c:if test="${notifications.size() > 0}">
            <span class="navbar_dropdown">
                <c:forEach var="notification_index" begin="0" end="${notifications.size() - 1}">
                    <a href="notifications#${notifications.get(notification_index).head}">
                        ${notifications.get(notification_index).head}
                    </a>
                </c:forEach>
            </span>
        </c:if>
    </span>
</div>