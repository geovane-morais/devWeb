
<?php
	$texto = fopen('arquivo','r+');
    
    try{
        $teste = fopen('teste','r+') or die("Mensagem de erro");
        throw new Exception('Arquivo teste Inexistente');
    } catch(Exception $e){
        echo 'Excessão: ' . $e->getMessage() . PHP_EOL;
        echo 'Arquivo TESTE inexistente' . PHP_EOL;
    }

    while(!feof($texto))
        echo fgets($texto,20);

    echo PHP_EOL;
    fclose($texto);
?>
