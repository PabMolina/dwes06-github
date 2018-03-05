<html>
<head>
	<h3><a href='index.php'>Índice</a><br><a href='administracion.php'>Administración</a><br><img src='img/nba-logo.png' width="50px" height="50px"></h3>
	<title>NBA Pablo Molina</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php

$servidor="localhost";
$usuario="alumno_rw";
$clave="dwes";
$mensaje='';

$conexion = new mysqli($servidor,$usuario,$clave,"nba");
$conexion->query("SET NAMES 'UTF8'");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$where='';

if (isset($_GET['id'])){
    $where=" WHERE codigo = ".$_GET['id']."";
    $player=$_GET['id']; //Esto me sobra, porque no lo utilizo para nada, aunque no pasa nada por guardarla por si acaso.
}else{
    $mensaje='Error, no se ha seleccionado un jugador.';
}
?>
<table style='border:0'>
<tr style='background-color:yellow'>
	<th>Codigo</th>
	<th>Nombre</th>
	<th>Procedencia</th>
	<th>Altura</th>
	<th>Peso</th>
	<th>Posicion</th>
	<th>Nombre Equipo</th>
	</tr>
<?php
$resultado = $conexion -> query("SELECT * FROM jugadores ".$where);
if($resultado->num_rows === 0) echo "<p>No hay jugadores en la base de datos</p>";
while ($stats=$resultado-> fetch_assoc()) {
    
    echo "<tr bgcolor='green'>";
    echo "<td>".$stats['codigo']."</td>\n";
    echo "<td>".$stats['Nombre']."</td>\n";
    echo "<td>".$stats['Procedencia']."</td>\n";
    echo "<td>".$stats['Altura']."</td>\n";
    echo "<td>".$stats['Peso']."</td>\n";
    echo "<td>".$stats['Posicion']."</td>\n";
    echo "<td>".$stats['Nombre_equipo']."</td>\n";
    echo "</tr>"; 
    
}
    
?>
</table>
<?php If($mensaje!='') echo $mensaje;?>
</body>
</html>