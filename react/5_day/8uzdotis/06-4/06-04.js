//Write a JavaScript function to get the month name from a particular date.
function month_name(data) {
  return data.toLocaleString("default", { month: "long" });
}

//Test Data :
console.log(month_name(new Date("10/11/2009")));
console.log(month_name(new Date("11/13/2014")));
//Output :
//"October"
//"November"
