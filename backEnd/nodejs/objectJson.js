const infoSistem = {   
    name: "Ubuntu",
    cpu: "Xeon-e5",
    memory: "24gb",
    storage: "10TB",
    NewSistem: () => {
        return new infoSistem;
    }
}
  
console.log(JSON.stringify(infoSistem));
console.log(JSON.parse('{"name": "Debian","cpu": "I7"}'));

