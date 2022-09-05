let pessoa = {
    nome: "geovane",
    idade: 19,
    endereco: {
        rua: "Ricardo Ramos ",
        numero: 210,
        cep: "13842338"
    }
}

let { endereco: {rua, numero, cep}} = pessoa;
let { nome, idade } = pessoa;

console.log(nome, idade);
console.log(rua + numero);

let [n1, n2, n3 ,n4] = [1, 2, 3, 4];
console.log(n1,n2,n3,n4);