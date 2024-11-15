
//Write a JavaScript function to check whether a string is blank or not. 
function is_Blank(str){
    if(typeof str === "string" && str.length === 0){
        return true
    } else {return false}
}
//Test Data :
console.log(is_Blank(''));
console.log(is_Blank('abc'));
//true
//false
//Click me to see the solution


