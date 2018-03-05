<html>
<head>
	<h1></h1><img src='img/logo.png'></h1>
	<title>Index Pablo Molina</title>
	<meta charset="UTF-8"/>
	
</head>
<body>
<?php if(isset($_GET['localidad'])){?>
	<h3><?php echo "<p> Clientes de ".$_GET['localidad']."</p>" ?></h3>
	<?php }?>
<?php
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";


$conexion = new mysqli($servidor,$usuario,$clave,"empresa");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";

}
$where='';
$resultado1 = $conexion -> query("SELECT DISTINCT LOCALIDAD FROM clientes");
if($resultado1->num_rows === 0) echo "<p>Error. No se encuentran localidades en sta base de datos</p>";
while ($city = $resultado1 -> fetch_assoc()){
    
    
    echo "<br><a href='index.php?localidad=".$city['LOCALIDAD']."'>".$city['LOCALIDAD']."</a>";
   
   
}
?>

<table>
<tr style='background-color:lightblue'>
<th>Código del cliente</th>
<th>Nombre</th>
<th>Localidad</th>
<th>Límite de crédito</th>
</tr>

<?php 
if (isset($_GET['localidad'])){
    $where="WHERE clientes.LOCALIDAD LIKE '".$_GET['localidad']."'";
}

$resultado2 = $conexion ->query("SELECT * FROM clientes ".$where);
if($resultado2->num_rows ===0) echo "<p>Error. No se encuentran clientes en esta localidad</p>";
while ($cli = $resultado2 -> fetch_assoc()){
    
    echo "<tr bgcolor='yellow'>";
    echo "<td>".$cli['COD_CLIENTE']."</td>";
    echo "<td><a href='pedidos.php?id=".$cli['COD_CLIENTE']."'>".$cli['NOMBRE']."</td>";
    echo "<td>".$cli['LOCALIDAD']."</td>";
    echo "<td>".$cli['LIMITE_CREDITO']."</td>";
    echo "</tr>";

}
?>
</table>
</body>
</html>
