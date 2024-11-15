const books = [
  { title: "Knyga #1", price: 10.25 },
  { title: "Knyga #2", price: 5.15 },
  { title: "Knyga #3", price: 7.32 },
  { title: "Knyga #4", price: 54.01 },
  { title: "Knyga #5", price: 77.17 },
];

function bookName() {
  books.map((book, index) => console.log(book.title, index));
}

function calculateBook() {
  console.log(books.length);
}
function addBook() {
  books.push({ title: "Knyga #6", price: 2.75 });
}
function bookName6() {
  console.log(books[5]);
}
function bookPriceAll() {
  console.log(
    Math.round(
      books.reduce((accumulator, product) => (accumulator += product.price), 0)
    )
  );
}
function nolaida() {
  const kaina = books.filter((book) => book.price > 10);
  kaina.map((book) =>
    console.log(
      `Knyga : ${book.title} Sena kaina: ${book.price} ${
        Math.round((book.price - book.price * 0.25) * 100) / 100
      } Pritaikyta nuolaida -25%`
    )
  );
}
function smolerToBiger() {
  const result = [...books];
  result.sort((a, b) => a.price - b.price);
  console.log(result);
}
function aToBandBtoA() {
  const aToB = [...books].sort((a, b) => a.title.localeCompare(b.title));
  const bToA = [...books].sort((a, b) => b.title.localeCompare(a.title));
  resultat = [aToB, bToA];
  console.log(resultat);
}
function brangesnisNei() {
  console.log(books.filter((book) => book.price > 7.5));
}
bookName();
calculateBook();
addBook();
bookName6();
bookPriceAll();
nolaida();
smolerToBiger();
aToBandBtoA();
brangesnisNei();
