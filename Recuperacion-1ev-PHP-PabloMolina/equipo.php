<html>
<head>
	<h3><a href='index.php'>Índice</a><br><a href='administracion.php'>Administración</a><br><img src='img/nba-logo.png' width="50px" height="50px"></h3>
	<title>NBA Pablo Molina</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php if(isset($_GET['Nombre'])){?>
	<h1><?php echo $_GET['Nombre'] ?><center><img src='img/equipos/<?php echo $_GET['Nombre'] ?>.gif'></center></h1>
	<?php }?>
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

if (isset($_GET['Nombre'])){
    $where=" WHERE Nombre LIKE '".$_GET['Nombre']."'"; //Guardamos esta parte de la consulta en la variable $where, para utilizarla luego
    $team=$_GET['Nombre'];
}else{
    $mensaje='Error, no se le ha pasado el nombre del equipo.';
}
?>
<table style='border:0'>
<tr style='background-color:gray'>
	<th>Nombre</th>
	<th>Ciudad</th>
	<th>Conferencia</th>
	<th>Division</th>
	</tr>
<?php
$resultado = $conexion -> query("SELECT * FROM equipos ".$where);
if($resultado->num_rows === 0) echo "<p>No hay equipos en la base de datos</p>";
while ($tm=$resultado-> fetch_assoc()) {
    
    echo "<tr bgcolor='red'>";
    echo "<td>".$tm['Nombre']."</td>\n";
    echo "<td>".$tm['Ciudad']."</td>\n";
    echo "<td>".$tm['Conferencia']."</td>\n";
    echo "<td>".$tm['Division']."</td>\n";
    echo "</tr>"; 
    
}
    
?>
</table>

<?php 
$resultado2 = $conexion -> query("SELECT jugadores.Nombre, jugadores.codigo FROM equipos, 
jugadores WHERE equipos.Nombre=jugadores.Nombre_equipo AND jugadores.Nombre_equipo LIKE '".$team."' ORDER BY Nombre ASC"); 
if($resultado2->num_rows === 0) echo "<p>No hay equipos en la base de datos</p>";
while ($jug=$resultado2-> fetch_assoc()) {
    echo "<ul>";
    echo "<li><a href='jugador.php?id=".$jug['codigo']."'>".$jug['Nombre']."</li>";
    echo "</ul>";    
}
?>
<table style='border:0'>
<tr style='background-color:green'> 
	<th>Equipo Local</th>
	<th>Equipo Visitante</th>
	<th>Puntos Local</th>
	<th>Puntos Visitante</th>
</tr>
<?php
$resultado3 = $conexion -> query("SELECT DISTINCT partidos.equipo_local, partidos.equipo_visitante, partidos.puntos_local, partidos.puntos_visitante 
FROM partidos, equipos WHERE partidos.equipo_local LIKE '".$team."' OR partidos.equipo_visitante LIKE '".$team."'");
if($resultado3->num_rows === 0) echo "<p>No hay equipos en la base de datos</p>";
while ($part=$resultado3-> fetch_assoc()) {
    
    echo "<tr bgcolor='orange'>";
    echo "<td>".$part['equipo_local']."</td>\n";
    echo "<td>".$part['equipo_visitante']."</td>\n";
    echo "<td>".$part['puntos_local']."</td>\n";
    echo "<td>".$part['puntos_visitante']."</td>\n";
    echo "</tr>"; 
    
}
    
?>
</table>

<?php If($mensaje!='') echo $mensaje;?>
</body>
</html>
