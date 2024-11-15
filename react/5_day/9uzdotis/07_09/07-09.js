//Write a JavaScript function to capitalize the first letter of each word in a string.
function capitalize_Words(str) {
   const words = str.split(" ").map(word => word.charAt(0).toUpperCase() + word.slice(1));
   return words
}
  //
//Test Data :
console.log(capitalize_Words("js string exercises"));
//"Js String Exercises"
