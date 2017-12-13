
<?php
include 'Obra.php';
$servidor="localhost";
$usuario="alumno_rw";
$clave="dwes";

session_name('idsesion22');
session_start();

$conexion = new mysqli($servidor,$usuario,$clave,"catalogo22");

$conexion->query("SET NAMES 'UTF8'");

$order="";
$where="";


if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}

if (isset($_GET["cerrarSesion"])) {
    session_unset();
    if (ini_get("session.use_cookies")) {
        $params = session_get_cookie_params();
        setcookie(session_name(), '', time() - 42000,
            $params["path"], $params["domain"],
            $params["secure"], $params["httponly"]
            );
    }
    session_destroy();
}

if( isset($_REQUEST['id']) && $_REQUEST['id']=='ASC') {
    
    $order="ORDER BY titulo ".$_REQUEST['id'];
}
else if ( isset($_REQUEST['id']) && $_REQUEST['id']=='DESC' ){
    
    $order="ORDER BY titulo ".$_REQUEST['id'];
}
if (isset($_REQUEST['idAutor'])){
    $where=" WHERE idAutor=".$_REQUEST['idAutor'];
    $_SESSION['cod']=$_REQUEST['idAutor'];
}else{
    $where="";
}
?>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<?php
if(!isset($_SESSION['cod'])){
    

?>
<form action="mostrarCatalogo.php" method="post">
        Buscar obra:<input type="text" name="busqueda">
        <input type="submit" name="Buscar">
</form>
<table style='border:0'>
<tr style='background-color:lightblue'>
	<th>Titulo<a href="mostrarcatalogo.php?id=ASC">&#9650</a> <a href="mostrarcatalogo.php?id=DESC">&#9660</a></th>
	<th>IdAutor</th>
	<th>Nombre Autor</th>
	

</tr>
<?php 
}elseif (isset($_SESSION['cod'])){
    ?>
    <table style='border:0'>
    <tr style='background-color:lightblue'>
    <th>Discos</th>
    <th>IdAutor</th>
    <th>Nombre Autor</th>
    <th>Nacionalidad</th>
    <th>Género</th>
    </tr>
    
    
<?php 
}

$resultado=$conexion ->query("SELECT * FROM obra ".$where." ".$order);
if($resultado->num_rows==0)echo "<p>No hay discos en la base de datos</p>";

while ($obra = $resultado->fetch_object('Obra')) {
    
    $resultado2=$conexion ->query("SELECT nombre, nacionalidad, genero FROM autor WHERE id=".$obra->getIdAutor());
    $autor=$resultado2->fetch_assoc();
    
    if(isset($_SESSION['cod'])){
    
    echo "<tr bgcolor='lightgreen'>";
    echo "<td><a href='mostrarObra.php?idObra=".$obra ->getIdObra()."'>".$obra->getTitulo()."</td>\n";
    echo "<td>".$obra->getIdAutor()."</td>\n";
    echo "<td><a href='mostrarcatalogo.php?idAutor=".$obra->getIdAutor()."'>".$autor['nombre']."</td>\n";
    echo "<td>".$autor['nacionalidad']."</td>\n";
    echo "<td>".$autor['genero']."</td>\n";
    echo "</tr>";
    mysqli_free_result($resultado2);
}else {
    echo "<tr bgcolor='lightgreen'>";
    echo "<td><a href='mostrarObra.php?idObra=".$obra ->getIdObra()."'>".$obra->getTitulo()."</td>\n";
    echo "<td>".$obra->getIdAutor()."</td>\n";
    echo "<td><a href='mostrarcatalogo.php?idAutor=".$obra->getIdAutor()."'>".$autor['nombre']."</td>\n";
  
    mysqli_free_result($resultado2);
}
}
?>
</table>
<br>
<a href="mostrarcatalogo.php?cerrarSesion=true">Eliminar filtros</a>
</body>
</html>
