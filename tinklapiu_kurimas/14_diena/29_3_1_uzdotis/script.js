"use strict";

let a = +prompt("Itervalo Pradzia");
const b = +prompt("Intervalo pabaiga");
let c = 0;

for (let i = a; i < b + 1; i++) {
  let z = i % 6 === 0;
  if (z) {
    c++;
  }
}
console.log(`Reikalingu marskinėliu skaicius: ${c}`);
