async function displayUserName(userId) {
  const divdata = document.querySelector("#user-info");
  try {
    const response = await fetch(
      `https://jsonplaceholder.typicode.com/users/${userId}`
    );

    if (response.status === 404) {
      divdata.textContent = "User not found";
      throw new Error("User not found");
    } else {
      const data = await response.json();

      divdata.textContent = data.name;
    }
  } catch (error) {
    console.error(error);
  }
}
displayUserName(11);
