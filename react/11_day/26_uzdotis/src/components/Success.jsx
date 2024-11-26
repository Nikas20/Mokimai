import { Link } from "react-router";
export default function Success() {
  return (
    <div>
      <h1>You have registered successfully</h1>
      {<Link to={"/"}>Back</Link>}
    </div>
  );
}
