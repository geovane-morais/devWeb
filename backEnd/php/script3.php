<!DOCTYPE	html>
<html lang="pt-br">
	<head>
		<title>teste PHP</title>
	</head>

	<body>
		<?php
			$validar_if = true;
			if ($validar_if) :
				print "validar_if é verdadeiro com "."&#34;".":"."&#34;"."<br><br>";
			endif;
			
			if ($validar_if){
				echo "validar_if é verdadeiro com &#34;{}&#34;" , "<br><br>";
			}
			
			if ($validar_if)
				echo "validar_If é verdadeiro sem nd" , "<br><br>";
		?>
	</body> 
</html>
