"use strict";

const saldainiai = +prompt("Kiek saldeniu gavo Petriukas"); //25;

let saldainiiuLiko;
let likoSaldainiiu = saldainiai;
let diena = 0;
while (saldainiai > 0) {
  const saldainiuSuvage = +prompt("Kiek saldeiniu suvalge per diena");
  likoSaldainiiu = likoSaldainiiu - saldainiuSuvage;
  if (likoSaldainiiu > 0) {
    saldainiiuLiko = likoSaldainiiu;
    diena++;
  } else if (likoSaldainiiu <= 0) {
    break;
  }
}
console.log(
  `Petriukas saidainiu uzteks ${diena} ir jam liks ${saldainiiuLiko} saldainiai.`
);
