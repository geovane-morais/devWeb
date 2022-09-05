//funcao convencional
function calcRaio(raio){
    const PI = Math.PI;
    return (PI * raio * raio);
}
//Armazenadno uma funcao arrow em uma variavel
const CalcRaio = (raio) => {
    const PI = Math.PI;
    return (PI * raio * raio);
} 
//Arrow com apenas uma linha
const calcraio = (raio) => (Math.PI * raio * raio);


console.log(calcRaio(10) + " M2");
console.log(CalcRaio(3.5) + " M2");
console.log(calcraio(3.1) + " M2");


let aleatorio = (min=0,max=1000) => {
    if (min > max) [min,max] = [max,min];
    return Math.floor(Math.random() * (max-min) + min);
}

console.log("\n",
    aleatorio(0,10),
    aleatorio(0,10),
    aleatorio(0,10),
    aleatorio(0,10),
    aleatorio(0,10)
);