var mysql = require('mysql');
const db = mysql.createPool({
    host : '3.16.216.122',
    port : 3306,
    user : 'user01',
    password : '1111',
    database : 'food_add_db'
});

module.exports = db;