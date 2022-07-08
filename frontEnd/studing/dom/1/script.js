

document.getElementById("b1").onclick = () =>{
    
}

document.getElementById("b1").onclick = function(){

}

document.getElementById("b1").onclick = () =>{
    let inserirLI = document.createElement("li");
    inserirLI.appendChild(document.createTextNode("ITEM"));
    document.getElementById("Lista1").appendChild(inserirLI);
}
document.getElementById("b2").onclick = () =>{
    let inserirLI = document.createElement("li");
    inserirLI.appendChild(document.createTextNode("ITEM"));
    document.getElementById("Lista2").appendChild(inserirLI);
}
document.getElementById("b3").onclick = () =>{
    document.body.getElementsByTagName("h1").item(0).innerText = "Titulo Corrigido";
    document.body.getElementsByTagName("h2").item(0).innerText = "Subtitulo Corrigido";
}



