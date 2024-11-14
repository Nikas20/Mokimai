const books = [
  { title: "Knyga #1", price: 10.25 },
  { title: "Knyga #2", price: 5.15 },
  { title: "Knyga #3", price: 7.32 },
  { title: "Knyga #4", price: 54.01 },
  { title: "Knyga #5", price: 77.17 },
];

function bookName(){
    books.map((book) => console.log(book.title)) 
};

function calculateBook(){
    console.log(books.length)
};
function addBook(){
    books.push({title: "Knyga #6", price: 2.75})
}
function bookName6(){
 console.log(books[5])
};
function bookPriceAll() {
    cart.reduce((accumulator, product) => accumulator += items[product].price, 0)
};








bookName()
calculateBook()
addBook()
bookName6()