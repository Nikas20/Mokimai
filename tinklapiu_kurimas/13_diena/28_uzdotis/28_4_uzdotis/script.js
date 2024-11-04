"use strict"

const automobilioGreitisKilemetruPerValanda = +prompt("Koks automobilio greitis?")
const kialisMetrais = 264

const automobilioGreitisMetraisPerSikunde = automobilioGreitisKilemetruPerValanda / 3600 * 1000

const LaikasPerKuriuPravazios = `LaikasPerKuriuPravazios ${Math.round(( kialisMetrais / automobilioGreitisMetraisPerSikunde)*100) /100} s`


console.log(LaikasPerKuriuPravazios)