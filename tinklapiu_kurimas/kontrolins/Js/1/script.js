

const sum = () =>{
  const n = 20;
  let i = 0;
  let suma = 0;
while(i < n){
  i = +prompt("skaicius")
  if(i === n){
    break
  }
  else if(i >n){
    break
  } else{ suma += i }
}return suma
}

const gavom = sum()
console.log(gavom);