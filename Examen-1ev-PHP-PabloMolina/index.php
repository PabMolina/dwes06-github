<html>
<head>
	<img src='img/encabezado/encabezado.jpg'>
	<title>Pablo Molina</title>
	<meta charset="UTF-8"/>
	
</head>
<body>
<?php if(isset($_GET['type'])){?>
	<h1><?php echo $_GET['type'] ?></h1> <!--Título del tipo seleccionado-->
	<?php }?>
<?php
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";


$conexion = new mysqli($servidor,$usuario,$clave,"examen1718-1ev-sigurros");
$conexion->query("SET NAMES 'UTF8'");
if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}

$tipos = $conexion -> query("SELECT DISTINCT tipo FROM discos "); //Select para coger los diferentes tipos (album, dvd..)
if($tipos->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($disc = $tipos->fetch_assoc()) { 
    
    echo "<ul bgcolor='yellow'>";
    echo "<li><a href='index.php?type=".$disc['tipo']."'>".$disc['tipo']."</a></li>";
    echo "</ul>";
    
}
$where='';
$order='';
if (isset($_POST['vdisco'])) {
    if (!empty($_POST['vdisco'])){
        $palabra=explode(" ",$_POST['vdisco']);
        $cont=0;
        $where =" WHERE ";
        while((sizeof($palabra))>$cont){
            
            if ((sizeof($palabra)-1)==$cont){
                $where=$where."nombre LIKE '%".$palabra[$cont]."%'";
            }else{
                $where=$where."nombre LIKE '%".$palabra[$cont]."%' OR ";
            }
            $cont+=1;
        }
        
    }else{
        echo "<p>No puede estar vacio el campo </p>";
    }
}
?>
<form action="index.php" method="post">
<h3>Introduce el nombre del disco:</h3> 
<input type="text" name="vdisco">
<input type="submit" name="enviar">
</form>

<table style='border:0'>
<tr style='background-color:red'>
	<th>Título<a href='index.php?order=1'>&#9650;</a><a href='index.php?order=2'> &#9660;</a></th>
	<th>Discografía </th>
	<th>Año<a href='index.php?order=3'>&#9650;</a><a href='index.php?order=4'> &#9660;</a></th>
	<th>Formato</th>
	<th>Imagen portada</th>
</tr>
<?php
if (isset($_GET['order'])){
    if ($_GET['order']==1){
        $order=" ORDER BY nombre ASC"; //Definimos la variable $order para luego utilizarla en el select $resultado
    }elseif ($_GET['order']==2){
        $order=" ORDER BY nombre DESC";
        
    }elseif ($_GET['order']==3){
        $order=" ORDER BY year ASC";
        
    }elseif ($_GET['order']==4){
        $order=" ORDER BY year DESC";
        
    }
}
if(isset($_GET['type'])){
    $where="WHERE tipo='".$_GET['type']."'"; //definimos la variable $where para utilizarla en el select $resultado
}
$resultado = $conexion -> query("SELECT * FROM discos ".$where."".$order); // si no hacemos click en un tipo ni en un orden, nos muestra todo
if($resultado->num_rows === 0) echo "<p>No hay discos en la base de datos</p>";
while ($cd = $resultado->fetch_assoc()) {
    
    echo "<tr bgcolor='green'>";
    echo "<td>".$cd['nombre']."</td>\n";
    echo "<td>".$cd['discografica']."</td>\n";
    echo "<td>".$cd['year']."</td>\n";
    echo "<td>".$cd['soporte']."</td>\n";
    echo "<td><a href='disco.php?id=".$cd['id']."'><img src='img/discografia/".$cd['imagen'].".jpg'></a></td>\n"; //Link a disco.php
    echo "</tr>";
    
}

?>
</table>
<a href='index.php'>Ver todo</a><br>
<a href='admin-login.php'> Login</a>
</body>
</html>
