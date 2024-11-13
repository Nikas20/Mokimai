async function fetchUserData(userId) {
  try {
    const response = await fetch(
      `https://jsonplaceholder.typicode.com/users/${userId}`
    );
    if(response.status === 404){
        throw new Error("User not found")}
      
    const data = await response.json()
    console.log(`User name: ${data.name}`);
  } catch (error) {
    console.error(error);
  }}
fetchUserData(1);
fetchUserData(999);