function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}
let count = 0;

const formA = document.querySelector("#forma");
formA.addEventListener("submit", (event) => {
  event.preventDefault();
  
  const num = Number(formA.elements["number"].value);
  const gues = getRandomInt(100);
  count++
  if (num === gues) {
    document.getElementById("resultText").innerHTML = "You win";
    document.getElementById("resultCount").innerHTML = count + " guesses was done";
  } else if (num < gues) {
    document.getElementById("resultText").innerHTML = "The guessed number is bigger!";
    document.getElementById("resultCount").innerHTML = count + " guesses was done";
  } else if (num > gues) {
    document.getElementById("resultText").innerHTML = "The guessed number is smolest!";
    document.getElementById("resultCount").innerHTML = count + " guesses was done";
  }
  
  
});

