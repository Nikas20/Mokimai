"use strict";
const numbers = [1, 2, 3, 4, 5];

function anyPositive(numbers) {
  const n = numbers.length;
  let p = 0;
  for (let i = 0; i < n; i++) {
    if (numbers[i] > 0) {
      p++;
    }
  }
  const trueOrFalse = p > 0;
  return trueOrFalse;
}
const answer = anyPositive(numbers);
console.log(answer);
