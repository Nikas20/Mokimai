"use strict";

function compareBMI(kg1, m1, kg2, m2) {
  const bmi1 = kg1 / (m1 * m1);
  const bmi2 = kg2 / (m2 * m2);

  const itTrue = bmi1 > bmi2;
  return itTrue;
}
const marksIs = compareBMI(70, 1.85, 68, 1.87);

console.log(marksIs);
