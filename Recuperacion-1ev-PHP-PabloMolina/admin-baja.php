<?php
$mensajeError='';
session_name("login");
session_start();
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";
$conexion = new mysqli($servidor,$usuario,$clave,"nba");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$borrar='';
if(isset($_POST['enviar'])){
    $borrar=$_POST['elegir'];
    $resultado2 = $conexion->query('DELETE FROM jugadores WHERE id='.$borrar);
    if ($conexion->connect_error) {
        $mensajeError = "Ha surgido un problema con la base de datos";
    } else {
        echo "<p>El jugador ha sido borrado con exito</p>";
        header('Location:admin-baja.php');
    }
}
?>


<html>
<head>
	<h3><a href='index.php'>Índice</a><br><img src='img/nba-logo.png' width="50px" height="50px"></h3>
	<title>NBA Pablo Molina</title>
</head>
<h2>Pincha en un jugador para borrarlo</h2>
<body>
<form action="admin-baja.php" method="post">
<p>Seleccione un jugador para eliminar</p>
    <p>Jugador:
    <select name="elegir">
    <option value="0">Selección:</option>

<?php
$resultado = $conexion -> query("SELECT * FROM jugadores ORDER BY Nombre ASC");
if($resultado->num_rows === 0) echo "<p>No hay jugadores en la base de datos</p>";
while ($id = $resultado->fetch_assoc()) {
    
    echo '<option value="'.$id['codigo'].'">'.$id['Nombre'].'</option>';
    
}
?>
<input type="submit" name="enviar">
</select>
</p>
</form>
</body>
</html>
