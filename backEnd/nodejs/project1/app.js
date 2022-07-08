const url = 'http://files.cod3r.com.br/curso-js/funcionarios.json';
const axios = require("axios");

async function start(){
  const resposta =  await axios.get(url);
  const funcionario = resposta.data
                        .filter((e) => (e.pais == "Japan"))
                        .filter((e) => (e.genero == "F"))
                        .reduce((atual,prox) => atual.salario < prox.salario ? atual : prox); 
  /*Menor salario de uma funcionaria japonesa*/
  console.log(funcionario);
}
start();