export default function TaskList({ tasks, toggleComplete, deleteTask }) {
    return (
      <>
        <h2 className="text-secondary">{tasks.length == 0 && "No tasks yet!"}</h2>
        <ul>
          {tasks.map((task, index) => (
            <li key={index}>
              <span
                style={{
                  textDecoration: task.completed ? "line-through" : "none",
                }}
              >
                {task.text}
              </span>
              <button
                className="btn btn-primary m-1"
                onClick={() => toggleComplete(index)}
              >
                Toggle
              </button>
              <button
                className="btn btn-danger m-1"
                onClick={() => deleteTask(index)}
              >
                Delete
              </button>
            </li>
          ))}
        </ul>
      </>
    );
  }