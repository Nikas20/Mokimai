"use strict"

const  SausainiuIskepeTautvydas = +prompt('Kiek sausainiu iskepe Tautvydas?') 
const keliDraugaiDarAtsinešePotiekPatSausainiu = +prompt('Keli draugai dar atsinese po tiek pat sausainiu?') 
const zmoniuIsVisoDalyvavoSventeje = +prompt('Kiek žmoniu iš viso dalyvavo sventeje?') 


const sausainiuIsViso = SausainiuIskepeTautvydas + keliDraugaiDarAtsinešePotiekPatSausainiu * SausainiuIskepeTautvydas
const poKiekSauseiniuGavoKekvenas =  Math.trunc(sausainiuIsViso / zmoniuIsVisoDalyvavoSventeje)
const kiekPapildomaiAtliekoSausainiu = sausainiuIsViso - poKiekSauseiniuGavoKekvenas * zmoniuIsVisoDalyvavoSventeje

console.log(`Kiekvienas sventes dalyvis gavo po ${poKiekSauseiniuGavoKekvenas} sausainius`) 
console.log(`Tautvydui papildomai atiteko ${kiekPapildomaiAtliekoSausainiu} sausainiai`)