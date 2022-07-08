
<?php
	function ola(){
		$argumentos = func_get_args();
		$quantidade = func_num_args();

		for ($foo=0;$foo<$quantidade; $foo++){
			echo "Ola " . $argumentos[$foo] . PHP_EOL;
		}
		echo func_num_args() . PHP_EOL;
	}
	ola("João", "maria", "juliana");
?>
