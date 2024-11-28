import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { Link } from "react-router";

export default function AllTasks() {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [deleteTriger, setDeleteTriger] = useState(0);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:3001/tasks");
        const data = await response.json();

        setData(data);
        setLoading(false);
      } catch (error) {
        setError(error.mesage);
        setLoading(false);
      }
    };
    fetchData();
  }, [deleteTriger]);
  const deleteTask = async (id) => {
    try {
      const response = await fetch(`http://localhost:3001/tasks/${id}`, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error(`Respons status: ${response.status}`);
      }
      setDeleteTriger((deleteTriger) => deleteTriger + 1);
    } catch (error) {
      console.log(error);
    }
  };
  if (loading) {
    return <p>Loding ...</p>;
  }
  if (error){
    return <p>Error: {error}</p>
}
  return (
    <table className="table table-striped">
      <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Due date</th>
        </tr>
      </thead>

      <tbody>
        {data.map((task) => {
          return (
            <tr key={task.id}>
              <td>{task.id}</td>
              <td>{task.name}</td>
              <td>{task.date}</td>
              <td>
                <Link to={`/tasks/${task.id}`}>Edit</Link>
              </td>
              <td>
                <button onClick={() => deleteTask(task.id)}>Delete</button>
              </td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
}
