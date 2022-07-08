<!DOCTYPE	html>
<html lang="pt-br">
	<head>
		<title>teste PHP</title>
	</head>

	<body>
		<?php


			function DollForReal($doll, $value){
				return ($doll * $value);
			}

			echo "10 Dolares = " . DollForReal(10,5.67) . " Reais<br/>"; 
		?>
	</body> 
</html>
