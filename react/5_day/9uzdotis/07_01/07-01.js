//Write a JavaScript function to check whether an `input` is a string or not.
function is_string(input) {

  if ( typeof input === "string") {
    return true;
  } else {
    return false;
  }
}
//Test Data :
console.log(is_string("w3resource"));
//true
console.log(is_string([1, 2, 4, 0]));
//false
