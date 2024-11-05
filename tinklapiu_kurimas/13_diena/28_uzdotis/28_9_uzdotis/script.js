"use strict"

const  SausainiuIskepeTautvydas = +prompt('Kiek sausainių iškepė Tautvydas?') 
const keliDraugaiDarAtsinešePotiekPatSausainiu = +prompt('Keli draugai dar atsinešė po tiek pat sausainių?') 
const zmoniuIsVisoDalyvavoSventeje = +prompt('Kiek žmonių iš viso dalyvavo šventėje?') 


const sausainiuIsViso = SausainiuIskepeTautvydas + keliDraugaiDarAtsinešePotiekPatSausainiu * SausainiuIskepeTautvydas
const poKiekSauseiniuGavoKekvenas =  Math.trunc(sausainiuIsViso / zmoniuIsVisoDalyvavoSventeje)
const kiekPapildomaiAtliekoSausainiu = sausainiuIsViso - poKiekSauseiniuGavoKekvenas * zmoniuIsVisoDalyvavoSventeje

console.log(`Kiekvienas sventės dalyvis gavo po ${poKiekSauseiniuGavoKekvenas} sausainius`) 
console.log(`Tautvydui papildomai atiteko ${kiekPapildomaiAtliekoSausainiu} sausainiai`) 