"use strict"


const monetasPo5ct = +prompt("Kiek yra monetu po 5 ct?")
const monetasPo20ct = +prompt("Kiek yra monetu po 20 ct?")
const monteasPo2lt = +prompt("Kiek yra monetu po 2 Lt?")

const monetasPo5ctSuma = monetasPo5ct * 5 / 100
const monetasPo20ctSuma = monetasPo20ct * 20 / 100
const monteasPo2LtSuma = monteasPo2lt * 2

const taupiklijePinigu = `Taupklije yra ${monetasPo5ctSuma + monetasPo20ctSuma + monteasPo2LtSuma} Lt.`


console.log(taupiklijePinigu)