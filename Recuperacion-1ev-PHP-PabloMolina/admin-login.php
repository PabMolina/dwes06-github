<?php
session_name("login");
session_start();
$pass='';
$login=0;
if(isset($_SESSION['login'])){
    $login=$_SESSION['login'];
    if($login==1) header('Location:administracion.php');
}
$mensajeError='';
if(isset($_POST['enviar'])){
    if(isset($_POST['pass'])){
        $pass=$_POST['pass'];
    }
    if($pass=='admin'){
         $_SESSION['password'] = $pass;
         $_SESSION['login'] = 1;
            header('Location:administracion.php');
    }else{
            $mensajeError = "La contraseña es erronea, intentelo de nuevo";
        }
    }

?>

<html>
<head>
	<h3><a href='index.php'>Índice</a><br><img src='img/nba-logo.png' width="50px" height="50px"></h3>
	<title>NBA Pablo Molina</title>
	<meta charset="UTF-8"/>
</head>
<body>
<div >
<form action="admin-login.php" method="POST">
    <h1>Login</h1>
    <p>Contraseña:</p><input type="password" name="pass">
    <input type="submit" name="enviar" value="Entrar">
</form>
<p><?php if($mensajeError!='')echo $mensajeError;?></p>
</div>
</body>
</html>