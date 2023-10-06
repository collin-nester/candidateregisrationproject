<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Position Creation Confirmation</title>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<mytags:navbar/>

${new_position.positionName} has been created with ID ${new_position.id} <br>
Description: ${new_position.positionDescription} <br>
<a href="create_position"><button>Go Back</button></a>
</body>
</html>