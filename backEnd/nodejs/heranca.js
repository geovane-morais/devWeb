const produto = {
    nome: "Macarrao",
    valor: 170,
    ICMS: 0.01
}

const venda = {
    __proto__: produto, //pode setar a relação de prototipo assim ou
    quantidade: 5,
    IdCliente: 21
}
Object.setPrototypeOf(venda, produto) // ou assim

class Produto {
    constructor(nome,valor,ICMS){
        [this.nome,this.valor,this.ICMS] = [nome,valor,ICMS];
    }
    getNome(){
        return this.nome;
    }
}
class Venda extends Produto{
    constructor(nome,valor,ICMS,quantidade,IdCLiente){
        super(nome,valor,ICMS);  //PEGA O CONSTRUCTOR DA CLASSE PAI
        [this.quantidade,this.IdCliente] = [quantidade,IdCLiente];
    }
}

const VENDA = new Venda("Macarrao",170,0.01,5,21);

console.log(VENDA.getNome());
console.log(venda.nome);


let nomee = {nome: "geovane"};
const nomeee = nomee;
nomeee.nome= "julia";
nomeee.nome= "Fabiana";

console.log(nomee);
console.log(nomeee);