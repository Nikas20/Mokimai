"use strict"

const  puodeliuKuriousReikiaSupakotSkaicius = 7
const vienaDezuteTelpa = 3


const pilnuDezutciuSkaicius = Math.round(puodeliuKuriousReikiaSupakotSkaicius / vienaDezuteTelpa)
const nesupakotuDezutciuSkaicius = puodeliuKuriousReikiaSupakotSkaicius - vienaDezuteTelpa * pilnuDezutciuSkaicius

console.log(`Pilnu dezutciu skaicius: ${pilnuDezutciuSkaicius}`) 
console.log(`Nesupakotu dezutciu skaicius: ${nesupakotuDezutciuSkaicius}`) 