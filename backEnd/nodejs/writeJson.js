const file = require('fs');

const caminho = __dirname + "/teste2.json";

const produto = {
    "nome": "Camiseta",
    "tamanho": "M",
    "cor": "Vermalha",
    "valor": 39.99
}

file.writeFile(caminho, JSON.stringify(produto), err => {
    console.log( err || "Arquivo salvo!!!");
});






