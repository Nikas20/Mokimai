import { useParams } from "react-router";
import { Link } from "react-router";
export default function ProductDetails() {
  const products = [
    { id: 1, name: "Product A" },
    { id: 2, name: "Product B" },
    { id: 3, name: "Product C" },
  ];

  const { id } = useParams();
  const productname = products.find((product) => {
    return Number(product.id) === Number(id);
  });
  return (
    <div>
      <h1>{productname.name}</h1>
      <Link to="/products">Back to Product List</Link>
    </div>
  );
}
