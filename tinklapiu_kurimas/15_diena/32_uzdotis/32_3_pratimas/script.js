"use strict";
const numbers = [1, -3, 3, -3, 0];
const j = 0;
function positives(numbers) {
  const n = numbers.length;
  for (let i = 0; i < n; i++) {
    if (numbers[i] > 0) {
      positiveNumbers[j] = numbers[i];
      j++;
    }
  }

  return positiveNumbers;
}
const answer = positives(numbers);
console.log(answer);
