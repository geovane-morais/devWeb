const timer = require('node-schedule');

//ScheduleJob('Second minute hour day mouth day-specific');
//ScheduleJob('  *      *     *    *    *        *');

const tarefa = timer.scheduleJob('*/5 * * * *', () =>{
    console.log("***Tarefa realizada a cada 5S***");
});
const tarefa1 = timer.scheduleJob('*/1 * * * * *', () =>{
    console.log("Segundos:", new Date().getSeconds(),"s");
});

//tarefa.cancel(); //cancela a tarefa

//Executa a função depois de 20.s000 Ms
setTimeout(function(){},20000)

//Criando uma regra
const regra = new timer.RecurrenceRule();
regra.dayOfWeek= [new timer.Range(1.5)]; //Vai executar de segunda a sexta feira
regra.hour= 19;
regra.secund = 10;

const tarefa3 = timer.scheduleJob(regra, function(){
    console.log("Tarefa3");
});
