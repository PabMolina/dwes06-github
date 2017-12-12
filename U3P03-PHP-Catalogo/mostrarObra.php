<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<?php
include 'Obra.php';
$servidor="localhost";
$usuario="alumno";
$clave="alumno";

$conexion = new mysqli($servidor,$usuario,$clave,"catalogo22");


if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$conexion->query("SET NAMES 'UTF8'");
$ruta="img";
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>ID OBRA</th>
	<th>TITULO</th>
	<th>AÑO</th>
	<th>ID AUTOR</th>
	<th>IMAGEN</th>
	<th>NOMBRE AUTOR<th>
</tr>
<?php 


if(!isset($_REQUEST["idObra"])) die ("<h3>ERROR en la peticion,no existe identificador de obra");
$id=$_REQUEST["idObra"];
$resultado=$conexion ->query("SELECT * FROM obra WHERE idObra=".$id);
if($resultado->num_rows==0)echo "<p>No hay discos en la base de datos</p>";

while ($obra = $resultado->fetch_object('Obra')) {
    
    $resultado2=$conexion ->query("SELECT nombre FROM autor WHERE id=".$obra->getIdAutor());
    $autor=$resultado2->fetch_assoc();
    
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra->getIdObra()."</td>\n";
    echo "<td>".$obra->getTitulo()."</td>\n";
    echo "<td>".$obra->getAño()."</td>\n";
    echo "<td>".$obra->getIdAutor()."</td>\n";
    echo "<td><img src=img/".$obra->getImagen()."></td>\n";
    echo "<td>".$autor['nombre']."</td>\n";
    echo "</tr>";
    mysqli_free_result($resultado2);
}
?>
</table>
<a href="mostrarCatalogo.php"><button>Volver al catálogo</button></a>
</body>
</html>

