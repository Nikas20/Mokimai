"use strict";

function remainderOf(x, y) {
  const devining = x % y;
  return devining;
}
const xNubers = +prompt("Write the number x");
const yNubers = +prompt("Write the number y");
const remaiderX = remainderOf(xNubers, yNubers);

console.log(remaiderX);
