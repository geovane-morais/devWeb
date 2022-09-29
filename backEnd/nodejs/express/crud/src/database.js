const sequence = {
    _id: 1,
    getId: function(){
        return this._id++;
    }
}

const produtos = {}

function salvarProduto(produto){
    if (!produto.id) produto.id=sequence.getId();
    produtos[produto.id] = produto;
    return produto;
}

function getProduto(id) {
    return produtos[id] || {}
}

function getProdutos(){
    return Object.values(produtos);
}

module.exports = {salvarProduto,getProduto,getProdutos};