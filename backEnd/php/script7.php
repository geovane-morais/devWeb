<!DOCTYPE	html>
<html lang="pt-br">
	<head>
		<title>teste PHP</title>
	</head>

	<body>
		<?php

			$ListaAlimento = array("arroz","feijao","carne","macarão","etc");
			$cont=0;


			foreach($ListaAlimento as $vetor){
			switch ($cont) {
				case 0:
					$vetor = "feijão";
				break;

				case 1:
					$vetor = "arroz";
				break;
				default:

			}
			echo "Alimento[" . $cont . "]:" . $vetor . '<br/>';
			$cont++;
			}



		?>
	</body> 
</html>
