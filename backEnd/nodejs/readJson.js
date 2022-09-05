const file = require('fs');

const caminho = __dirname + "/teste.json"

//sincrono
console.log("\n\nSincrono");
const conteudo = file.readFileSync(caminho, "utf-8"); //funciona
console.log(conteudo);
console.log(JSON.parse(conteudo));


//assincono
file.readFile(caminho, "utf-8", (error, valor) =>{ //funciona
    console.log("\n\nAssincrono");
    console.log(valor);
    console.log(JSON.parse(valor));
});


//sincrono
const conteudo3 = require(caminho); //funciona
console.log("\n\nSincrono2");
console.log(conteudo3);






