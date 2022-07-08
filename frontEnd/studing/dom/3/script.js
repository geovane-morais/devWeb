let tamanho = document.getElementById("idCars").children.item(1).width / screen.width * 100;

function tamanhoIMG(entrada){
    let estilo = `width: ${entrada}%; height: ${entrada}%;`;
    for(const x in document.getElementById("idCars").children){
        document.getElementById("idCars").children.item(x).style.cssText = estilo;
    }
}

document.getElementById("zoomIn").addEventListener('click', () =>{
    if (tamanho < 24){
        tamanho += 2;
        tamanhoIMG(tamanho);
    }else{
        alert("Atingiu o tamanho maximo");
    }
});
document.getElementById("zoomOut").addEventListener('click', () =>{
    if (tamanho > 10){
        tamanho -= 2;
        tamanhoIMG(tamanho);
    }else{
        alert("Atingiu o tamanho minimo");
    }
});
