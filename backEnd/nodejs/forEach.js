//DIFERENÇAS DE MAP para forEach é que o MAP devolve o valor
//podemos usar numeros.map().map() e ir modificando o valor do array

Array.prototype.forEach2 = function (callback) {
    for(let x=0; x < this.length; x++){
       callback(this[x], x, this);
    }
} 

const array1 = new Array("CARRO","MOTO","CAMINHÃO","AVIÃO","BARCO");

const array2 = ["MAÇA","GOIABA","MORANGO","BROCOLIS","PIPINU"];

array1.forEach2((nome) => console.log(nome));
console.log("");
array2.forEach2((nome,indice) => console.log(`${indice}: ${nome}`));

const carrinho = [
    '{ "nome": "Borracha", "preco": 3.45 }',
    '{ "nome": "Caderno", "preco": 13.95 }',
    '{ "nome": "Kit de Lapis", "preco": 41.22 }',
    '{ "nome": "Caneta", "preco": 7.50 }'
]

let preco = carrinho.map(function(e){

});