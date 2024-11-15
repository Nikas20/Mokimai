//Write a JavaScript function to get the current date. 
function curday(simbol){
    const data = new Date()
    return `${data.getMonth()+1}${simbol}${data.getDate()}${simbol}${data.getFullYear()}`
}
//Note : Pass a separator as an argument.
//Test Data :


console.log(curday('/')); 
console.log(curday('-'));
//Output :
//"11/13/2014" 
//"11-13-2014"


