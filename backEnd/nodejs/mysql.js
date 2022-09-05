const mysql = require('mysql');
let connection = mysql.createConnection({
  host: '127.0.0.1',
  user: 'root',
  password: 'root',
  database : 'my_db'
});

connection.connect((err) => {
  if (err) {
      console.log('Erro connecting to database...', err)
      return
  }
  console.log('Connection established!')
  connection.query("SELECT * FROM people ", function (error, results, fields) {
    if (error) throw error;
    else{
    console.log('The solution is: ', results);
    connection.end();
    }
  });
});
 
