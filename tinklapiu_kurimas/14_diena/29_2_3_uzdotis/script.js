"use strict";
const n = 3;

const pazimis1 = +prompt("Koks pazimis");
const pazimis2 = +prompt("Koks pazimis");
const pazimis3 = +prompt("Koks pazimis");
const pazimis4 = +prompt("Koks pazimis");
const pazimis5 = +prompt("Koks pazimis");
const vidurkis = (pazimis1 + pazimis2 + pazimis3 + pazimis4 + pazimis5) / 5;

if (vidurkis > 9) {
  console.log("Petriukas gaus tris saldainius");
} else if (7 <= vidurkis) {
  console.log("Petriukas gaus du saldainius");
} else {
  console.log("Petriukas gaus vieną saldainį");
}
console.log(vidurkis);
