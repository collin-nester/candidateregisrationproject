<!DOCTYPE html>
<html>
<head>
<title>Position Creation Confirmation</title>
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
${new_position.positionName} has been created with ID ${new_position.id} <br>
Description: ${new_position.positionDescription} <br>
<a href="create_position"><button>Go Back</button></a>
</body>
</html>