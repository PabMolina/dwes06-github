<html>
<head>
	<h1></h1><img src='img/logo.png'></h1>
	<title>Pedidos Pablo Molina</title>
	<meta charset="UTF-8"/>
	
</head>
<body>
<?php 

?>
<?php
if(isset($_GET['id'])){?>
	<h3><?php echo "<p> Pedidos del cliente seleccionado</p>" ?></h3>
	<?php }

$servidor="localhost";
$usuario="alumno_rw";
$clave="dwes";

$conexion = new mysqli($servidor,$usuario,$clave,"empresa");
$conexion->query("SET NAMES 'UTF8'");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
if (isset($_GET['id'])){ 
    $id=$_GET['id'];
}else{
    echo "<p>Error</p>";
}

?>
<table>
<tr style='background-color:lightblue'>
<th>Código del cliente</th>
<th>Fecha del pedido</th>
<th>Código del producto</th>
<th>Unidades</th>
<th>Descripción</th>
<th>Precio Actual</th>
<th>Stock Disponible</th>
<th>Imagen</th>
<th>Coste total pedidos</th>
</tr>
<?php 

$resultado = $conexion ->query("SELECT pedidos.COD_CLIENTE, pedidos.FECHA_PEDIDO, pedidos.COD_PRODUCTO, 
pedidos.UNIDADES, productos.DESCRIPCION, productos.PRECIO_ACTUAL, 
productos.STOCK_DISPONIBLE, productos.IMAGEN 
FROM pedidos,productos
WHERE pedidos.COD_PRODUCTO=productos.COD_PRODUCTO AND pedidos.COD_CLIENTE='".$id."';");
if($resultado->num_rows ===0) echo "<p>Error.</p>";
$cont=0;
while ($ped = $resultado -> fetch_assoc()){
    $cont=$ped['UNIDADES'] * $ped['PRECIO_ACTUAL'];
    echo "<tr bgcolor='yellow'>";
    echo "<td>".$ped['COD_CLIENTE']."</td>";
    echo "<td>".$ped['FECHA_PEDIDO']."</td>";
    echo "<td>".$ped['COD_PRODUCTO']."</td>";
    echo "<td>".$ped['UNIDADES']."</td>";
    echo "<td>".$ped['DESCRIPCION']."</td>";
    echo "<td>".$ped['PRECIO_ACTUAL']."</td>";
    echo "<td>".$ped['STOCK_DISPONIBLE']."</td>";
    echo "<td><img src= 'img/".$ped['IMAGEN'].".png' width=150px></td>";
    echo "<td>".$cont."</td>";
    echo "</tr>";
    
}
?>
</table>
</body>
</html>
