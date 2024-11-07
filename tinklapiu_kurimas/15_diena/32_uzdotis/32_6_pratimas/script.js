"use strict";
const numbers = [1, 2, 3, 4, 5];

function allPositive(numbers) {
  const n = numbers.length;
  let p = 0;
  for (let i = 0; i < n; i++) {
    if (numbers[i] > 0) {
      p++;
    }
  }
  const trueOrFalse = p === n;
  return trueOrFalse;
}
const answer = allPositive(numbers);
console.log(answer);
