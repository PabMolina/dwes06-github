<html>
<head>
	<img src='img/encabezado/encabezado.jpg'>
	<title>Disco Pablo Molina</title>
	<meta charset="UTF-8"/>
</head>
<body>

<?php

$servidor="localhost";
$usuario="alumno_rw";
$clave="dwes";
$mensaje='';

$conexion = new mysqli($servidor,$usuario,$clave,"examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$where='';

if (isset($_GET['id'])){
    $where=" WHERE id=".$_GET['id']; //Guardamos esta parte de la consulta en la variable $where, para utilizarla luego
    $disco=$_GET['id'];
}else{
    $mensaje='Error, no se le ha pasado el id del disco.';
}
?>
<table style='border:0'>
<tr style='background-color:blue'>
	<th>Título</th>
	<th>Discografía </th>
	<th>Año</th>
	<th>Formato</th> <!-- He eliminado el selector de idiomas porque me daba problemas -->
	<th>Imagen portada</th>
	<th>Comentarios</th>
	</tr>
<?php
$resultado = $conexion -> query("SELECT * FROM discos ".$where);
if($resultado->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($cd=$resultado-> fetch_assoc()) {
    
    echo "<tr bgcolor='green'>";
    echo "<td>".$cd['nombre']."</td>\n";
    echo "<td>".$cd['discografica']."</td>\n";
    echo "<td>".$cd['year']."</td>\n";
    echo "<td>".$cd['soporte']."</td>\n";
    echo "<td><img src='img/discografia/".$cd['imagen'].".jpg'></td>\n";
    echo "<td>".$cd['texto']."</td>\n";
    echo "</tr>"; 
    
}
    
?>
</table>
<table style='border:0'>
<tr style='background-color:ligthyellow'> <!-- Ahora vamos a sacar la tabla con los temas del disco seleccionado -->
	<th>Numero tema</th>
	<th>Título</th>
	<th>Duración</th>
</tr>
<?php 
$resultado2 = $conexion -> query("SELECT numero, nombre_i AS nombre, minutos, segundos FROM temas WHERE id_disco=".$disco); //Nueva consulta para sacar los temas
while ($tema=$resultado2-> fetch_assoc()) {
    echo "<tr bgcolor='ligthyellow'>";
    echo "<td bgcolor='ligthyellow'>".$tema['numero']."</th>";
    echo "<td bgcolor='ligthyellow'>".$tema['nombre']."</th>";
    echo "<td bgcolor='ligthyellow'>".$tema['minutos'].":".$tema['segundos']."</th>";
    echo "</tr>";    
}
?>
</table>
<a href='index.php'>Ver todo</a><br>
<?php If($mensaje!='') echo $mensaje;?>
</body>
</html>
