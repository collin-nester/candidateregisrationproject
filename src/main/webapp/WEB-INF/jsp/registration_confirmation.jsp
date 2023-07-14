<!DOCTYPE html>
<html>
<head>
<title>Registration Confirmation</title>
<link rel="stylesheet" href="../css/global_styles.css">
</head>
<body>
<ul class="menubar">
    <a href="home"> <li>Home</li> </a>
    <a href="register"> <li>Register</li> </a>
    <a href="position_application"> <li>Position Application</li> </a>
    <a href="applied_positions"> <li>Applied Positions</li> </a>
    <a href="create_position"> <li>Create Position</li> </a>
    <a href="list_applicants"> <li>List Applicants</li> </a>
    <a href="login"> <li>Login</li> </a>
    <a href="logout"> <li>Logout</li> </a>
</ul>
${candidate.name} has been registered with username ${candidate.username} and email ${candidate.email}
<button onclick="window.history.back()">Go Back</button>
</body>
</html>