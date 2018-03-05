<html>
<head>
	<h3><a href='index.php'>Índice</a><br><a href='administracion.php'>Administración</a><br><img src='img/nba-logo.png' width="50px" height="50px"></h3>
	<title>NBA Pablo Molina</title>
	<meta charset="UTF-8"/>
</head>
<body>
<?php
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";


$conexion = new mysqli($servidor,$usuario,$clave,"nba");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
$order='';
$where='';
if (isset($_POST['vequipo'])) {
    if (!empty($_POST['vequipo'])){
        $palabra=explode(" ",$_POST['vequipo']);
        $cont=0;
        $where =" WHERE ";
        while((sizeof($palabra))>$cont){
            
            if ((sizeof($palabra)-1)==$cont){
                $where=$where."Nombre LIKE '%".$palabra[$cont]."%'";
            }else{
                $where=$where."Nombre LIKE '%".$palabra[$cont]."%' OR ";
            }
            $cont+=1;
        }
        
    }else{
        echo "<p>El campo no puede estar vacío </p>";
    }
}

?>
<form action="index.php" method="post">
<h3>Introduce el nombre del equipo:</h3> 
<input type="text" name="vequipo">
<input type="submit" name="enviar">
</form>

<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>Nombre<a href='index.php?order=1'>&#9650;</a><a href='index.php?order=2'> &#9660;</a></th>
	<th>Imagen </th>
</tr>
<?php
if (isset($_GET['order'])){
    if ($_GET['order']==1){
        $order=" ORDER BY nombre ASC"; //Definimos la variable $order para luego utilizarla en el select $resultado
    }elseif ($_GET['order']==2){
        $order=" ORDER BY nombre DESC";
    }
}
$resultado = $conexion -> query("SELECT * FROM equipos ".$where."".$order); // si no hacemos click en un tipo ni en un orden, nos muestra todo
if($resultado->num_rows === 0) echo "<p>No hay equipos que coincidan con la búsqueda</p>";
while ($eq = $resultado->fetch_assoc()) {
    echo "<tr bgcolor='yellow'>";
    echo "<td>".$eq['Nombre']."</td>\n";
    echo "<td><a href='equipo.php?Nombre=".$eq['Nombre']."'><img src='img/equipos/".$eq['Nombre'].".gif'></a></td>\n"; //Link a equipo.php
    echo "</tr>";
}
?>
</table>

</body>
</html>
