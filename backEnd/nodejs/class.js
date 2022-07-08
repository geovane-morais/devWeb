class produto{
    constructor(nome,idade,sexo){
        this.nome = nome;
        this.idade=idade;
        this.sexo = sexo; 
    }

    getNome(){
        return this.nome;
    }
}

Produto = new produto ("Geovane",19,"M");

console.log(Produto.getNome());
console.log("produto: " + typeof(produto))

