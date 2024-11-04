"use strict"

const pirmadenis = +prompt("Kiek pamoku yra pirmadieni?")
const antradenis = +prompt("Kiek pamoku yra antradeni?")
const treciadenis = +prompt("Kiek pamoku yra treciadeni?")
const ketvertadenis = +prompt("Kiek pamoku yra ketvertadeni?")
const penktadenis = +prompt("Kiek pamoku yra penktadeni?")
let sum_pamoku = (pirmadenis + antradenis  +treciadenis +ketvertadenis +penktadenis)
const minut = (sum_pamoku * 45)
const reslt1 = `Pamoku skaicius : ${sum_pamoku}`
const reslt2 = `Tai sudaro minuciu: ${minut}`
console.log(reslt1)
console.log(reslt2)