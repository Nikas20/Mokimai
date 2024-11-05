"use strict";

const g = 9.8;

const aukstis = +prompt("Iš kokio aukscio soka parasiutininkas?");
const laikasPerKuriIssiliaidziaParasutas = +prompt(
  "Per kiek sekundžiu issiskleidzia jo parasiutas?"
);
const kritimoLaikas = Math.sqrt((2 * aukstis) / g);
if (laikasPerKuriIssiliaidziaParasutas < kritimoLaikas) {
  console.log("Parasiutas issiskleis");
} else {
  console.log("Parasiutas neissiskleis");
}
