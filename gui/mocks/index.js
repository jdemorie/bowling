import express from "express";
import cors from "cors";
import {server as mockServer} from "./server.js";

mockServer.listen();

const app = express();

app.use(cors());

app.get('/server/score', (req, res) => {
    res.json([
        {
            name: 'Player 1',
            turns: [{value: "00"}, {value: "00"}, {value: "00"}, {value: "00"}, {value: "00"}, {value: "00"}, {value: "00"}, {value: "00"}, {value: "00"}, {value: "00"}],
            score: 0
        },
    ]);
});

app.post('/server/start', (req, res) => {
    res.json({message: 'Start from server'});
});

app.post('/server/play', (req, res) => {
    setTimeout(() => {
        res.json({pinsDown: 2});
    }, 3000);
});

app.listen(8080, () => {
    console.log(process.env.NODE_ENV);
    console.log("server started");
});