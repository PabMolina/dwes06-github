<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<?php
$servidor="localhost";
$usuario="alumno";
$clave="alumno";

$conexion = new mysqli($servidor,$usuario,$clave,"animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$conexion->query("SET NAMES 'UTF8'");
include('animal.php');
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
while ($animal = $resultado->fetch_object('Animal')) {
    // echo $animal."<br/>"; // primer intento más sencillo
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$animal->getChip()."</td>\n";
    echo "<td>".$animal->getNombre()."</td>\n";
    echo "<td>".$animal->getEspecie()."</td>\n";
    echo "<td><img src='img/".$animal->getImagen()."'</img></td>\n";
    echo "</tr>";
}
?>

</table>
</body>
</html>