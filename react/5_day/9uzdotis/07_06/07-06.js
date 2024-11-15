//Write a JavaScript function to hide email addresses to protect from unauthorized user.
function protect_email(url) {
  return `${url.slice(0, 5)} ... ${url.slice(11, 23)}`
}
//Test Data :
console.log(protect_email("robin_singh@example.com"));
//"robin...@example.com"
