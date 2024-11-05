"use strict";

const zingniuKiekis = +prompt("Iveskite zingsniu kieki iki mokyklo");
let suplojimuSkaicius = 0;
let spragtelejimuSkaicius = 0;

for (let i = 1; i < zingniuKiekis; i++) {
  if (i % 10 === 0) {
    suplojimuSkaicius++;
  }
  if (i % 5 === 0 && i % 5 !== 2) {
    spragtelejimuSkaicius++;
  }
}
console.log(`Suploimu skaicius: ${suplojimuSkaicius}`);
console.log(`Spragtelejimu skaicius: ${spragtelejimuSkaicius}`);
