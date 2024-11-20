import { useState } from "react";
export default function Card() {
  const [taskDone, setTaskDone] = useState(false);
  return (
    <div className="card">
      <div className="card-body">
        <h5 className="card-title">
          {taskDone ? "Task is done!" : "Task is not done!"}
        </h5>
        <p className="card-text">
          Some quick example text to build on the card title and make up the
          bulk of the card's content
        </p>
        <button
          onClick={() => setTaskDone(!taskDone)}
          className={taskDone ? "btn btn-success" : "btn btn-danger"}
        >
          {taskDone ? "Done" : "Mark as done"}
        </button>
      </div>
    </div>
  );
}