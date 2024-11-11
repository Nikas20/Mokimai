//const amount = +prompt("Amount");
//const rateOfinterestInProcentPerAnnum = +prompt("Rate of Interest in procent per annum");
//const noOfYears = +prompt("No. of Years");
//const answear = (amount * rateOfinterestInProcentPerAnnum * noOfYears)/100
//console.log(answear);
const calkulator = (event) =>{
  event.preventDefault();
const skaiciusPirm = Number(document.querySelector("[name='firstNumber']").value);
const skaiciusAntr = Number(document.querySelector("[name='secondNumber']").value);
const skaiciusTrec = Number(document.querySelector("[name='treathNumber']").value);

const spanSum = document.querySelector("#sum")
spanSum.textContent = (skaiciusPirm * skaiciusAntr * skaiciusTrec)/100
}
    
document.addEventListener("submit", calkulator);