function calculate(num1, num2, operation){
    try{
        if(operation === "+"){
            const result = num1 + num2
        return result;
        }
        else if(operation === "-"){
            const result = num1 - num2
        return result;   
        }
        else if(operation === "*"){
            const result = num1 * num2
        return result;    
        }
        else if(operation === "/" && num1 !== 0 && num2 !==0){
            const result = num1 / num2
        return result;    
        }
        else if(operation === "/" && num1 === 0 || num2 ===0){
            throw new Error("Cannot divide by zero")
        }
        else if(operation !== "+" && operation !== "-" && operation !== "*" && operation !== "/"){
            throw new Error("Invalid operation")
        }
    } 
    catch(error){console.error(error);}
}
console.log(calculate(10, 2, "+"));
console.log(calculate(10, 2, "/"));
//console.log(calculate(10, 0, "/"));
//console.log(calculate(10, 2, "&"));