"use strict";

let snaigiuPerPirmaSekunde = +prompt(
  "Kiek snaigiu nukrito per pirmąja sekunde?"
);
const kiekSelundziuSnigo = +prompt("Kiek sekundziu snigo?");
let snaigiuPerKitasSekunde = snaigiuPerPirmaSekunde;
for (let i = 1; i < kiekSelundziuSnigo; i++) {
  snaigiuPerKitasSekunde = snaigiuPerKitasSekunde * 2;
  snaigiuPerPirmaSekunde = snaigiuPerPirmaSekunde + snaigiuPerKitasSekunde;
}
console.log(snaigiuPerPirmaSekunde);
