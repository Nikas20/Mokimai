"use strict";
const numbers = [2, 4, 6];
const initialValue = 1;
function product(numbers) {
  const sum = numbers.reduce(
    (accumulator, currentValue) => accumulator * currentValue,
    initialValue
  );

  return sum;
}

const sumaOfNumber = product(numbers);
console.log(sumaOfNumber);
