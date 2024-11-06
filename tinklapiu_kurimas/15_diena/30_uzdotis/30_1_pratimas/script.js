"use strict";

function celsiusToFahrenheit(temp) {
  const fahrenheitTemp = temp * 1.8 + 32;
  return fahrenheitTemp;
}
const gradus = +prompt("Temperatura Celsius");
const tempFahrenheit = celsiusToFahrenheit(gradus);
console.log(tempFahrenheit);
