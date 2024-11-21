import Child from "./Child";
export default function Parent() {
  const items = ["React", "JavaScript", "CSS"];
  const list = [...items];
  return (
    <div>
      <h1> Items List</h1>
     <Child text ={list} />;
    </div>
  );
}
