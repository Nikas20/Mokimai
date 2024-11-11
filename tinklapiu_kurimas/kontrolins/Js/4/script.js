const friends = ["Rika", "Jacob", "Alex", "Oliver", "Marika"];
function filterBestFriends(masyvas, uzsklousa) {
  return masyvas.filter((el) => el.toLowerCase().includes(uzsklousa.toLowerCase()));

}

let i =(filterBestFriends(friends, "e"));
i= i.map((x) => '*'+ x)
console.log(i) ;



