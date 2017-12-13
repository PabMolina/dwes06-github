<?php
session_name('idsesion22');
session_start ();
    $_SESSION['name']="";
    session_destroy();
    header('location:login.php');
    
    ?>



