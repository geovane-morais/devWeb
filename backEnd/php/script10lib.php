<?php
	function fatorial($numero){
		if ($numero  == 1) : return 1;
		else : return ($numero * fatorial($numero - 1));
		endif;
		/* Função recurciva é uma função que chama ela mesma *
		 * dentro da função em si							 */
	}
	function quadrado($numero){
		return ($numero * $numero);
	}
?>

