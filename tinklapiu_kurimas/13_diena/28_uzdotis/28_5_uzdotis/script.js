"use strict"

const sienosIlgisMetrais = 4
const sienosAukstisMetrais = 3
const plytosKianaLitais = 0.5
const plytostIlgismetrais = 0.2
const plytosAukstisMetrais = 0.1

const plytosDidis = Math.round((plytostIlgismetrais * plytosAukstisMetrais)*100)/100
const sienosDidis = 4 * 3

const plytuKiekisAntSienos = sienosDidis / plytosDidis
const plytosKianos = plytuKiekisAntSienos * plytosKianaLitais

console.log(`Plytu kiekis ${plytuKiekisAntSienos}`)
console.log(`Plytos kainos ${plytosKianos} Lt`)