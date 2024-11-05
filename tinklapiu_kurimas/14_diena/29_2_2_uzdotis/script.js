"use strict";

const pakamaiSvereKilogramo = 5;

const pakamaiSvereGramu = pakamaiSvereKilogramo * 1000;

const svorisVarles = +prompt("Kiek sveria varle?");
const stebiamosVarles = +prompt("Kiek varlių norima stebėti?");
if (pakamaiSvereGramu <= svorisVarles * stebiamosVarles) {
  console.log("Varliu stebėjimui pakanka");
} else {
  console.log("Varliu stebėjimui per mažai");
}
