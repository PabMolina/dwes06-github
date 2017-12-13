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

$conexion->query("SET NAMES 'UTF8'");

$order="";
$where="";
$ruta="img";

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}

if( isset($_REQUEST['id']) && $_REQUEST['id']=='ASC') {
    
    $order="ORDER BY titulo ".$_REQUEST['id'];
}
else if ( isset($_REQUEST['id']) && $_REQUEST['id']=='DESC' ){
    
    $order="ORDER BY titulo ".$_REQUEST['id'];
}


?>
<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>Titulo<a href="mostrarcatalogo.php?id=ASC">&#9650</a> <a href="mostrarcatalogo.php?id=ASC">&#9660</a></th>
	<th>IdAutor</th>
	<th>Nombre Autor</th>
</tr>
<?php 
$resultado=$conexion ->query("SELECT * FROM obra ".$order);
if($resultado->num_rows==0)echo "<p>No hay discos en la base de datos</p>";

while ($obra = $resultado->fetch_object('Obra')) {
    
    $resultado2=$conexion ->query("SELECT nombre FROM autor WHERE id=".$obra->getIdAutor());
    $autor=$resultado2->fetch_assoc();
    
    echo "<tr bgcolor='lightgreen'>";
    echo "<td><a href='mostrarObra.php?idObra=".$obra ->getIdObra()."'>".$obra->getTitulo()."</td>\n";
    echo "<td>".$obra->getIdAutor()."</td>\n";
    echo "<td>".$autor['nombre']."</td>\n";
    echo "</tr>";
    mysqli_free_result($resultado2);
}

?>
</table>
</body>
</html>
