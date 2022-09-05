function getPreco(imposto = 0, moeda = 'R$'){
    return `${moeda} ${this.preco * (1-this.desc) * (1+imposto)}`;
}

let produto = {
    nome: 'Notebook',
    preco: 6999,
    desc: 0.20,
    getPreco
}

console.log(getPreco());
console.log(produto.getPreco());

let produto1 = {preco: 20000, desc:0.30}

/* call e aplly executam a função e os valores do objeto são       *
 * considerados como valor global a unica observação é que o aplly *
 * tem que usar o arry [] e call apenas as ",,"                    */
console.log(getPreco.call(produto1, 0.17 , '$'));
console.log(getPreco.apply(produto1, [0.17 , '$']));
