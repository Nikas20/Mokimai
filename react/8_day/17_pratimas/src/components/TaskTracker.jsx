import { useState } from "react";

export default function TaskTracker(props) {
  const [tasks, setTasks] = useState([]);

  const addTask = (newTask) => {
    setTasks([...tasks, { text: newTask, completed: false }]);
  };

  const toggleComplete = (index) => {
    const updatedTasks = [...tasks];

    updatedTasks[index].completed = !updatedTasks[index].completed;

    setTasks(updatedTasks);
  };
  console.log(tasks);

  return (
    
    <ul>
        <h1 >Task Tracker</h1>
      <button onClick={() => addTask(prompt(props.question))}>Add Task</button>  
      {tasks.map((task, index) => (
        <li key={index}>
          <span
            style={{ textDecoration: task.completed ? "line-through" : "none" }}
          >
            {task.text}
          </span>
          <button onClick={() => toggleComplete(index)}>{task.completed ? "Undo" : "Done"}</button>
        </li>
      ))}
    </ul>

//<div className="row">{postsList.length ? postsList : "Empty"}</div>;
  );
}
