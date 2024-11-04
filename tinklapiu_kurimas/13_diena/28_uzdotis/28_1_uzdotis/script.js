"use strict"

const pirmadenis = +prompt("Kiek pamoku yra pirmadieni?")
const antradenis = +prompt("Kiek pamoku yra antradeni?")
const treciadenis = +prompt("Kiek pamoku yra treciadeni?")
const ketvertadenis = +prompt("Kiek pamoku yra ketvertadeni?")
const penktadenis = +prompt("Kiek pamoku yra penktadeni?")

const sumPamoku = pirmadenis + antradenis  + treciadenis  +ketvertadenis + penktadenis
const minuciuSuma = sumPamoku * 45

const pamokuSuma = `Pamoku skaicius : ${sumPamoku}`
const visoMinuciu = `Tai sudaro minuciu: ${minuciuSuma}`
console.log(pamokuSuma)
console.log(visoMinuciu)