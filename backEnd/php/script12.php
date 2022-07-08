
<?php
    function remove_acento1 ($str){
    $a = array('á','é','í','ó','ú');
    $b = array('a','e','i','o','u');
    return str_replace($a,$b,$str);
    }

	$remove_acento =  function($str){
        $a = array('á','é','í','ó','ú');
        $b = array('a','e','i','o','u');
        return str_replace($a,$b,$str);
    };
    print $remove_acento('José vai á praia') . PHP_EOL;

    print str_replace("%body%", "black", "<body text='%body%'>") . PHP_EOL;

    $palavras = array();
    $palavras[] = 'á mínha máe';
    $palavras[] = 'ó meu pái';
    $palavras[] = 'vó túdo bém';
 
    //função so pega com '' ou ""
    $r = array_map('remove_acento1',$palavras); 
    print_r($r);


    //Meus teste
    $troca_numero = function($equacao){
        $a = array('1','2','3','4','5','6','7','8','9','0');
        return str_replace($a, "N", $equacao);
    };
    print $troca_numero("12+5+69-22*2") . PHP_EOL;
?>
