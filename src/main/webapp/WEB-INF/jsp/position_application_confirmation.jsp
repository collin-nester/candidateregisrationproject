<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Application Confirmation</title>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<mytags:navbar/>

${application_info.candidate.name} has applied for ${application_info.position.positionName}. <br>
Education: ${application_info.education} <br>
Experience: ${application_info.experience} <br>
<a href="position_application"><button>Go Back</button></a>
</body>
</html>