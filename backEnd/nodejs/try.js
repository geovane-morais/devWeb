function tratamentoDeErro(erro) {
    /*throw new Error ("SEU BURRO");
    throw "SEU BURRO";*/
    throw {
        id:001,
        descricao: 'aconteceu isso',
        data: new Date
    }
}
  
function imprimirNomeUpCase(obj){
    try{
        console.log(obj.nome.toUpperCase());
    } catch (e){
        tratamentoDeErro(e);
    }
}

let obj = {name: 'geovane'};
let OBJ = {nome: 'geovane'};
imprimirNomeUpCase(obj);

imprimirNomeUpCase(OBJ);

