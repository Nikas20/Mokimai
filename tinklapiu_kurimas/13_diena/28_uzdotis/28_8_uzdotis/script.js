"use strict"

const  automobiluSkacius = 27
const iKeltaTelpaAtomobiliu = 10


const perkelsPerKartu = Math.trunc(automobiluSkacius / iKeltaTelpaAtomobiliu)
const liksNepaerkelta = automobiluSkacius - iKeltaTelpaAtomobiliu * perkelsPerKartu

console.log(`Perkels per kartu: ${perkelsPerKartu}`) 
console.log(`Liks nepaerkelta: ${liksNepaerkelta}`) 