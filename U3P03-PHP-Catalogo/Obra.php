<?php
class Obra{
    private $idObra;
    private $titulo;
    private $año;
    private $idAutor;
    private $imagen;
    
    function getIdObra(){
        return $this ->idObra;
    }
    function getTitulo(){
        return $this ->titulo;
    }
    function getAño(){
        return $this ->año;
    }
    function getIdAutor(){
        return $this->idAutor;
    }
    function getImagen(){
        return $this ->imagen;
    }
    function __toString(){
        return $this->Obra;
    }
}
?>
<html>
<head>
	<meta charset ="UTF-8">
</head>
<body>
</body>
</html>