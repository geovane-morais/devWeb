<!DOCTYPE	html>
<html lang="pt-br">
	<head>
		<title>teste PHP</title>
	</head>

	<body>
		<?php
			$vai_chover = TRUE;
			$esta_frio  = TRUE; 		

			if ($esta_frio and $vai_chover):
				echo 'Vou ficar em casa pois ira chover';
			endif;
		?>
	</body> 
</html>
