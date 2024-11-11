const numbers = [1, -3, 5, -3, 0];

function allPositive(numbers) {
  const n = numbers.length;
  let p =[];
  let j = 0;
  for (let i = 0; i < n; i++) {
    if (numbers[i] > 0) {
      p[j] = numbers[i]
      j++
    }
  }
  const positive = p
  return p;
}
const answer = allPositive(numbers);
console.log(answer);