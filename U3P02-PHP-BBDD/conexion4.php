<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<?php
$servidor="localhost";
$usuario="alumno_rw";
$clave="dwes";

$conexion = new mysqli($servidor,$usuario,$clave,"animales");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$conexion->query("SET NAMES 'UTF8'");

$ruta="img";
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>Chip</th>
	<th>Nombre</th>
	<th>Especie</th>
	<th>Imagen</th>
</tr>
<?php
$resultado = $conexion -> query("SELECT * FROM animal ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
$fila=$resultado->fetch_assoc();
while($fila!=null) {
	echo "<tr style='background-color:lightgreen'>";
	echo "<td>$fila[chip]</td>";
	echo "<td>$fila[nombre]</td>";
	echo "<td>$fila[especie]</td>\n";
	echo "<td><img src='$ruta/$fila[imagen]'></td>\n";
	echo "</tr>";
	$fila=$resultado->fetch_assoc();
}

$conexion ->query("UPDATE animal SET especie='jabali' WHERE nombre='Babe'");
echo "<h3 style='color:red'>". $conexion->error ."</h3>";


$conexion ->query ("DROP TABLE animal");
echo "<h3 style='color:red'>". $conexion->error ."</h3>";
?>


</table>
</body>
</html>




