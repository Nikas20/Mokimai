"use strict"

const zuviuPirminisKiekis = +prompt("Kiek zuvu gyvena akvariume?")
const zuviuPerDiena = +prompt("Kiek zuvu i akvariuma idedama kiekvena diena?")
const PraeitosDienos = +prompt("Kiek dien prejo?")

const zuviuSuma = `Po ${PraeitosDienos} dienu akvariume gyvens ${ zuviuPirminisKiekis + zuviuPerDiena * PraeitosDienos} zuvu.`


console.log(zuviuSuma)