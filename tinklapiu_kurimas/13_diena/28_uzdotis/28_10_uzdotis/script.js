"use strict"

const gautiSaldainai = +prompt("Kiek saldainiu gauna Marius?")
const poKiekSaldainiuSuvlgo = +prompt("Po kiek saldainiu suvalgo?")
const dienosLikoIkiKaledu = +prompt("Kelios dienos liko iki Kaledu?")
const poKiekSladeniuRinkinija = +prompt("Kiek saldeniu Marius pades i rinkini") //4

const gautiSaldainaiBeSuvalgitu = gautiSaldainai - poKiekSaldainiuSuvlgo
const visoGautuSaldainiuBeSuvalgitu = dienosLikoIkiKaledu * gautiSaldainaiBeSuvalgitu
const kiekRinkinuPadareMarius =  Math.trunc(visoGautuSaldainiuBeSuvalgitu / poKiekSladeniuRinkinija)
const likuseSaldainiai = visoGautuSaldainiuBeSuvalgitu - kiekRinkinuPadareMarius * poKiekSladeniuRinkinija

console.log(`Marius dovanas paruos  ${kiekRinkinuPadareMarius} draugu.`) 
console.log(`Supakavus dovanas liks ${likuseSaldainiai} saldainiai `) 