<?php 
class Animal{
    private $chip;
    private $nombre;
    private $especie;
    private $imagen;
   
    function getChip(){
        return $this -> chip;
    }
    function getNombre(){
        return $this -> nombre;
    }
    function getEspecie(){
        return $this -> especie;
    }
    function getImagen(){
        return $this -> imagen;
    }
    function __toString(){
        return $this -> Animal;
    }
}
?>

<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<?php 

?>
</body>
</html>
