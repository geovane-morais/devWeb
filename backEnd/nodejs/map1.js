//DIFERENÇAS DE MAP para forEach é que o MAP devolve o valor
//podemos usar numeros.map().map() e ir modificando o valor do array

const numeros = [1,2,3,4,5];

let dobro = numeros.map( function(receber) {
    return receber * 2;
})

dobro.forEach((saida) => console.log(saida));


/*====================DESAFIO==================*/
/*  IMPRIMIR APENAS O PREÇO DA STRING A BAIXO  */
const carrinho = [
    '{ "nome": "Borracha", "preco": 3.45 }',
    '{ "nome": "Caderno", "preco": 13.95 }',
    '{ "nome": "Kit de Lapis", "preco": 41.22 }',
    '{ "nome": "Caneta", "preco": 7.50 }'
]

let valor = carrinho.map(function(e){
    return JSON.parse(e);
}); 

valor = valor.map( function(e){
    return {
        nome: e.nome,
        preco :`R$ ${e.preco}`.replace(".",",")
    }
});

valor.forEach( (retorno) => console.log(retorno.preco) );
