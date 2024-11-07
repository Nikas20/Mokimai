const calkulator = (event) =>{
    event.preventDefault();

    const skaiciusPirm = Number(document.querySelector("[name='firstNumber']").value);
    const skaiciusAntr = Number(document.querySelector("[name='secondNumber']").value);
   const spanSum = document.querySelector("#sum")
     spanSum.textContent = skaiciusPirm + skaiciusAntr
    
}
    
document.addEventListener("submit", calkulator);