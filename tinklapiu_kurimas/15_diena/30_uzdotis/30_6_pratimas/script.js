"use strict";
function hello() {
  const say = "Hello, world!";
  return say;
}

function callNTimes(time, fn) {
  for (let i = 0; i < time; i++) {
    console.log(fn);
  }
}
const timeCall = callNTimes(5, hello());
console.log(timeCall);
