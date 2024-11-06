"use strict";
const numbers = [1, 5, 10, 9, 4, 1];
function max(numbers) {
  const atskimas = Math.max(...numbers);
  return atskimas;
}
const number = max(numbers);
console.log(number);
