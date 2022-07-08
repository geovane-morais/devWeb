let notas = new Array(10,8.5,4.5,6,7.6,8);

for(var x=0; x < notas.length; x=x+1){
    for(var y=0; y < (notas.length); y=y+1){
        if (notas[y] < notas[y+1]){
            //Trocar valor de variaveis sem usar uma temporaria
            [notas[y] , notas[y+1]] = [notas[y+1] , notas[y]];
        }
    }
}

for(var x=0; x < (notas.length); x++){
    console.log("Nota = " + notas[x]);
}

