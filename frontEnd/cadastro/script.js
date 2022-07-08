
document.getElementById("btnCadastrar").addEventListener('click', () =>{
    let error = [null];
    let obrigatorios = [];

    const email = document.getElementById("txtEmail").value;
    const confirmEmail = document.getElementById("txtConfirmarEmail").value;
    
    const senha = document.getElementById("txtSenha").value;
    const confirmSenha = document.getElementById("txtConfirmarSenha").value;
    

    if(!(senha == confirmSenha)) {
        error.unshift("Senha não confere \n");
    }

    if(!(email == confirmEmail)) {
        error.unshift("Email não confere \n");
    }

    
    for (const x in document.getElementsByClassName("obrigatorio")){
        obrigatorios.push(document.getElementsByClassName("obrigatorio").item(x).value);
        const checkNumero = ! (x == 12 && document.getElementById("semNumero").checked == true);

        if (document.getElementsByClassName("obrigatorio").item(x).value == '' && checkNumero) 
        {
            document.getElementsByClassName("obrigatorio").item(x).style.cssText = 
            `
                display: inline-block;
                padding: 1px 2px;
                border-style: inset;
                border-radius: 5px;
                border-color: red;
            `;
            error = ["Falta item na lista"];
        }else{
            document.getElementsByClassName("obrigatorio").item(x).style.cssText = 
            `
                display: inline-block;
                padding: 1px 2px;
                border-style: inset;
                border-radius: 5px;
                border-color: -internal-light-dark(rgb(118, 118, 118), rgb(133, 133, 133));
            `;
        }
    }

    if(!(error[0] === null)){
        document.getElementById("confirmarDadosUsuario").innerText = "";
        alert(error);
    }else{
        document.getElementById("confirmarDadosUsuario").innerText = "";
        gerarValidacao("Nome", "txtNome","txtSobrenome");
        gerarValidacao("Sexo","comboSexo");
        gerarValidacao("CPF","txtCPF");
        gerarValidacao("Telefone","txtTelefone");
        gerarValidacao("Celular","txtCelular");
        gerarValidacao("Nascimento","txtDataNascimento");
        gerarValidacao("CEP","txtCEP");
        gerarValidacao("Logradouro","txtLogradouro");
        gerarValidacao("Número","txtNumero");
        gerarValidacao("Complemento","txtComplemento");
        gerarValidacao("Referência","txtReferencia");
        gerarValidacao("Bairro","txtBairro");
        gerarValidacao("Cidade","txtCidade");
        gerarValidacao("Estado","comboEstado");
        gerarValidacao("Email","txtEmail");
        
        let botao = document.createElement('button');
        botao.appendChild(document.createTextNode("Confirmar Cadastro"));
        botao.id = "confirmarCadastro";
        document.getElementById("confirmarDadosUsuario").appendChild(botao);

        document.getElementById("confirmarCadastro").addEventListener('click', () =>{
            alert("Cadastro Confirmado");
         });
    }

    console.log(error);
});

function gerarValidacao(nomeCampo, idCampo1, idCampo2 = ""){
    let newP = document.createElement('p');
    if (idCampo2 == ""){
        newP.appendChild( 
            document.createTextNode(
                `${nomeCampo}: 
                ${document.getElementById(idCampo1).value}`
            )
        )
    }else{
        newP.appendChild( 
            document.createTextNode(
                `${nomeCampo}: 
                ${document.getElementById(idCampo1).value} 
                ${document.getElementById(idCampo2).value}`
            )
        )
    }
    
    document.getElementById("confirmarDadosUsuario").appendChild(newP);
}