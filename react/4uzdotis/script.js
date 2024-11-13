async function displayUserName(userId) {
  try {
    const response = await fetch(
      `https://jsonplaceholder.typicode.com/users/${userId}`
    );
    if (response.status === 404) {
        const divdata = document.querySelector("#user-info")
      divdata.textContent = "User not found"
      throw new Error("User not found");
    } else {
      const data = await response.json();
      const divdata = document.querySelector("#user-info")
      divdata.textContent = data.name
    }
  } catch (error) {
    console.error(error);
  }
}
displayUserName(1);