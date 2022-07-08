let obj = {
    nome: "Geovane",
    idade: 19,
    rg: "XXXXXXXXX-X"
}
//OU
let OBJ = {}
OBJ.nome = "Julio";
OBJ.idade = 25;

console.log(obj);
console.log (OBJ);

console.log(Object.keys(obj)); //volta as variaveis do objeto
Object.defineProperty(obj, 'rg', {
    enumerable: true
})

obj = new Object(OBJ); //atribuir objeto novo
obj = OBJ //Pega o endereço de memoria (ambos linkados)
/* PADRÃO JSON obj.json
 *   {
 *      "nome": "Geovane",
 *      "idade" = 19,
 *      "rg" = "XXXXXXXXX-X"
 *   }
 */

