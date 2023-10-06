<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Tools</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>

<h2>Admin Tools</h2>
<mytags:navbar/>


<ul>
    <li><a href="create_position">Create Position</a></li>
    <li><a href="list_applicants">List Applicants</a></li>
    <li><a href="applied_positions_lookup">Applied Positions Lookup</a></li>
    <li><a href="my_postings">My Postings</a></li>
</ul>

</body>
</html>