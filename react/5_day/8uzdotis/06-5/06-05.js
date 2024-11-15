//Write a JavaScript function to compare dates (i.e. greater than, less than or equal to).
function compare_dates(data1, data2) {
  if (
    data1.getFullYear() === data2.getFullYear() &&
    data1.getMonth() === data2.getMonth() &&
    data1.getDate() === data2.getDate() &&
    data1.getHours() === data2.getHours() &&
    data1.getMinutes() === data2.getMinutes()
  ) {
    return "Data1 = Data2";
  } else if (data1 > data2) {
    return "Data1 > Data2";
  } else if (data1 < data2) {
    return "Data2 > Data1";
  }
}
//Test Data :
console.log(
  compare_dates(new Date("11/14/2013 00:00"), new Date("11/14/2013 00:00"))
);
console.log(
  compare_dates(new Date("11/14/2013 00:01"), new Date("11/14/2013 00:00"))
);
console.log(
  compare_dates(new Date("11/14/2013 00:00"), new Date("11/14/2013 00:01"))
);
//Output :
//"Date1 = Date2"
//"Date1 > Date2"
//"Date2 > Date1"
