<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Registration Confirmation</title>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<mytags:navbar/>

${candidate.name} has been registered with username ${candidate.username} and email ${candidate.email}
<a href="home"><button>Home</button></a>
</body>
</html>