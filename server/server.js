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

app.post('/meal', (req, res) => {   // meal Table load
    console.log("req : \n" + JSON.stringify(req.body))
    var params = req.body;
    var type = params.type;
    var spicy = params.spicy;
    var soup = params.soup;

    var query = " SELECT * FROM food_add_db.meal\n" + 
                " WHERE food_add_db.meal.type = '" + type + "'" + "\n" + 
                " AND food_add_db.meal.spicy = '" + spicy + "'" + "\n" + 
                " AND food_add_db.meal.soup = '" + soup + "'" + "\n" + 
                " ORDER BY RAND() LIMIT 4;"

    db.query(query, (err, data) => {
        if (!err) {
            res.send({'products' : data});

            for (var i = 0; i < 4; i++) {
                console.log(data[i].food_name);
            }
        }
        else {
            res.send(err);
            console.log(err)
        }
    })
});

app.post('/dessertDrink', (req, res) => {   // dessert_drink Table load
    console.log("req : \n" + JSON.stringify(req.body))
    var params = req.body;
    var is_caffeine = params.is_caffeine;

    var query = " SELECT * FROM food_add_db.dessert_drink\n" + 
                " WHERE food_add_db.dessert_drink.is_caffeine = '" + is_caffeine + "'" + "\n" + 
                " ORDER BY RAND() LIMIT 4;"

    db.query(query, (err, data) => {
        if (!err) {
            res.send({'products' : data});

            for (var i = 0; i < 4; i++) {
                console.log(data[i].food_name);
            }
        }
        else {
            res.send(err);
            console.log(err)
        }
    })
});

app.post('/dessertFood', (req, res) => {   // dessertFood Table load
    console.log("req : \n" + JSON.stringify(req.body))
    var params = req.body;
    var type = params.type;

    var query = " SELECT * FROM food_add_db.dessert_food\n" + 
                " WHERE food_add_db.dessert_food.type = '" + type + "'" + "\n" + 
                " ORDER BY RAND() LIMIT 4;"

    db.query(query, (err, data) => {
        if (!err) {
            res.send({'products' : data});

            for (var i = 0; i < 4; i++) {
                console.log(data[i].food_name);
            }
        }
        else {
            res.send(err);
            console.log(err)
        }
    })
});