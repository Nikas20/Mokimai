//Write a JavaScript function to parameterize a string.
function string_parameterize(str){
   const littleLeteer = str.toLowerCase()
   return littleLeteer.replaceAll(" ","-")

}
//Test Data :
console.log(string_parameterize("Robin Singh from USA."));
//"robin-singh-from-usa"
