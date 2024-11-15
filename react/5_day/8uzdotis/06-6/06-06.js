//Write a JavaScript function to add specified minutes to a Date object.
function add_minutes(data, number){
data.setTime(data.getTime() + (number * 60 *1000)) 
return data
}
//Test Data :
console.log(add_minutes(new Date(2014,10,2), 30).toString());
//Output :
//"Sun Nov 02 2014 00:30:00 GMT+0530 (India Standard Time)"