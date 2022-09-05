const estruturaLista = document.getElementById("Lista");
let lista = estruturaLista.children;
let ItemAremover = document.getElementById('removeItem');

document.getElementById("insert").onclick = () =>{
    let newItem = document.getElementById("itemInsert").value;
    if(newItem){
        newItem = document.createTextNode(newItem);

        let newLi = document.createElement("li");
        newLi.appendChild(newItem);

        estruturaLista.appendChild(newLi);

        ItemAremover.max = lista.length;
    }else{
        console.log("Valor inserido invalido")
        alert("Valor inserido invalido");
    }
}

document.getElementById("remove").onclick = () => {
    let itemSelecionado = ItemAremover.value-1;

    try {
        estruturaLista.removeChild(lista.item(itemSelecionado));  
        ItemAremover.max = lista.length;
    } catch (error){
        console.log("Item selecionado é invalido para exclusão");
        alert("Item Invalido para exclusão");
        ItemAremover.value = null;
    }

    if(itemSelecionado == lista.length)
        ItemAremover.value = lista.length;
}

document.getElementById("ordered").onclick = () => {
    for(let y=0; y<(lista.length-1) ;y++){
        for(let x=0; x<(lista.length-1) ;x++){
            if(lista[x].innerText > lista[x+1].innerText){
                lista.item(x).parentElement.insertBefore(lista.item(x+1),lista.item(x));
            }
        }
    }
}