"use strict";

const myArray = [
  "sunday",
  "monday",
  "tuesday",
  "wednesday",
  "thursday",
  "friday",
  "saturday",
];

console.log(myArray[3]);

const n = myArray.length;
for (let i = 0; i < n; i++) {
  if (myArray[i] === "tuesday") {
    myArray.splice(i, 1, null);
    console.log(i);
  }
}
