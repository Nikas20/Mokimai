"use strict";
const numbers = [1, 4, 8];
const initialValue = 0;
function sumNumbers(numbers) {
  const sum = numbers.reduce(
    (accumulator, currentValue) => accumulator + currentValue,
    initialValue
  );

  return sum;
}

const sumaOfNumber = sumNumbers(numbers);
console.log(sumaOfNumber);
