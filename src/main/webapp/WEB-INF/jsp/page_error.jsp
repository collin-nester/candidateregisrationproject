<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<h2>Error</h2>
<mytags:navbar/>

You may have entered some information incorrectly.
<button onclick="window.history.back()">Try again</button>
</body>
</html>