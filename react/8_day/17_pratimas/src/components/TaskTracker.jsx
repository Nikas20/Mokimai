import TaskList from "./TaslList";
import { useState } from "react";


export default function TaskTracker() {
  const [tasks, setTasks] = useState([]);

  const addTask = () => {
    const editTask = prompt("Enter a task:");
    setTasks([...tasks, { text: editTask, completed: false }]);
  };

  const toggleComplete = (index) => {
    const updatedTasks = [...tasks];

    updatedTasks[index].completed = !updatedTasks[index].completed;

    setTasks(updatedTasks);
  };

  const deleteTask = (index) => {
    const areYouSure = confirm("Are you sure?");
    if (areYouSure) {
      const updatedTasks = tasks.filter((task, i) => i !== index);

      setTasks(updatedTasks);
    }
  };

  return (
    <div className= "position-absolute top-0 start-0">
      <h1>Task Tracker</h1>
      <button className="btn btn-success m-1" onClick={addTask}>
        Add a task
      </button>
      <TaskList
        tasks={tasks}
        toggleComplete={toggleComplete}
        deleteTask={deleteTask}
      />
    </div>
  );
}