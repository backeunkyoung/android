// 서버 실행은 해당 경로 터미널에서 node server.js 입력

const express = require('express');
const app = express();
const port = 3333;
const db = require('./DB/access_db');

app.use(express.json());
app.use(express.urlencoded({extended : true}));

app.listen(port, () => {  // server check massage
    console.log(`express is running on ${port}`);
});

// meal?spicy=not&temp=hot
app.get('/meal', (req, res) => {   // meal Table load
    // var query = bodyparser(req);
    // query["spicy"]
    // query['temp']

    for (output in req) {
        console.log("req : " + JSON.stringify(output));
    }

    var query = "SELECT * FROM food_add_db.meal;"

    db.query(query, (err, data) => {
        if (!err) {
            res.send({'foodname' : "음식 이름"})
            // res.send({'products' : data});
            console.log("meal success");
            // console.log(data)
        }
        else {
            res.send(err);
            console.log(err)
        }
    })
});

app.get('/dessertDrink', (req, res) => {   // dessertDrink Table load
    var query = "SELECT * FROM food_add_db.dessert_drink;"

    db.query(query, (err, data) => {
        if (!err) {
            res.send({'products' : data});
            console.log("drink success");
            // console.log(data)
        }
        else {
            res.send(err);
            console.log(err)
        }
    })
});

app.get('/dessertFood', (req, res) => {   // dessertFood Table load
    var query = "SELECT * FROM food_add_db.dessert_food;"

    db.query(query, (err, data) => {
        if (!err) {
            res.send({'products' : data});
            console.log("food success");
            // console.log(data)
        }
        else {
            res.send(err);
            console.log(err)
        }
    })
});