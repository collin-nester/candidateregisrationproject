<!DOCTYPE html>
<html>
<head>
<title>Application Confirmation</title>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="admin_tools"> <li>Admin Tools</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
${application_info.candidate.name} has applied for ${application_info.position.positionName}. <br>
Education: ${application_info.education} <br>
Experience: ${application_info.experience} <br>
<a href="position_application"><button>Go Back</button></a>
</body>
</html>