const express = require('express');
const app = express();
const port = 8080;

app.get('/produtos', (request, respose, next) => {
    respose.send({nome:'feijao', preco: 7.99, desc: 'feito com carinho'});
    //next(); Precisa dessa função para ir 
});

app.listen(port, ()=>{
    console.log(`Servidor Funcionando na porta ${port}`);
})