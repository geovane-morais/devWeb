
<?php
	function incremento (&$a,$b){
		$a += $b;
	}
	$a = 10;
	incremento($a,20);
	print  $a.PHP_EOL;
?>

