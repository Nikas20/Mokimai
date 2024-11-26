import { Link } from "react-router";
import ProductDetails from "./ProductDetails";
export default function ProductList() {
  const products = [
    { id: 1, name: "Product A" },
    { id: 2, name: "Product B" },
    { id: 3, name: "Product C" },
  ];
  return (
    <div>
      <h1>Product List</h1>
      <ul>
        {products.map((product, index) => (
          <li key={index}>
            {product.name}{" "}
            {<Link to={"/products/" + product.id}>View Details</Link>}
          </li>
        ))}
      </ul>
    </div>
  );
}
