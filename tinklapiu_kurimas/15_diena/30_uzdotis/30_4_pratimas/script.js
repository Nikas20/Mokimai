"use strict";

function findType(nezinomasArgumentas) {
  const type = typeof nezinomasArgumentas;
  return type;
}
const tipeOfArgument = findType("Jurgis");

console.log(tipeOfArgument);
