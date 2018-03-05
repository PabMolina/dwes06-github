<?php
$mensajeError='';
session_name("login");
session_start();
$user='';
$pass='';
if(isset($_SESSION['login'])){
    $login=$_SESSION['login'];
}else{
    $login=0;
}
if(isset($_SESSION['password'])){
    if($_SESSION['password']=='admin'){
        $pass=$_SESSION['password'];
    }
}

if($login!=1) header('Location:admin-login.php');

?>


<html>
<head>
	<h3><a href='index.php'>Índice</a><br><img src='img/nba-logo.png' width="50px" height="50px"></h3>
	<title>NBA Pablo Molina</title>
</head>
<body>


<?php 
       echo "<h1>Bienvenido </h1>\n";
?>

<a href="admin-baja.php">Borrar jugadores.</a><br>
<a href="admin-logout.php">Cerrar sesion.</a><br>

</body>
</html>