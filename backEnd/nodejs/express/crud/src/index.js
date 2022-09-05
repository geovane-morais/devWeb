const database = require('./database.js');
const express = require('express');
const application = express();
const port = 3333;
const bodyParser = require('body-parser');

application.use(bodyParser.urlencoded({ extended: true }));

application.get('/produtos', (req, res, next) =>{
    res.send(database.getProdutos());
});

/*application.get('/produtos/:id',(req,res,next) =>{});
 *para usar esse get precisa fazer IP/produtos/1 
 *para pegar esse id precisa usar como requisicão: req.params.id = 1
 */
application.get('/produtos/:id', (req,res,next) =>{
    res.send(database.getProduto(req.params.id));
    console.log(req.params.id);
    next();
});

/*
 * Para pegar os paramentos de um formulario é usado
 * req.body.variable
 */
application.post('/produtos', (req, res, next) =>{
    const produto = database.salvarProduto({
        nome: req.body.nome,
        preco:req.body.preco
    });
    res.send(produto);
    console.log(produto);
});

application.listen(port, ()=>{
     console.log(`App rodando na porta ${port}`);
});


/* Por convensão é usado POST para adição, PUT para update, DELETE para deletar
 * E o GET para pegar algum ponto.
 * application.put('/produtos', (req, res, next) =>{{})
 * application.delete('/produtos', (req, res, next) =>{{})
 */