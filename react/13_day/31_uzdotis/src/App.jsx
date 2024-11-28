import "./App.css";
import { BrowserRouter, Routes, Route, NavLink } from "react-router";
import Form from "./components/Form";
import Home from "./components/Home";
import AllTasks from "./components/AllTasks";
import EditTask from "./components/EditTask";

function App() {
  return (
    <div>
      <header className="conteiner">
        <nav>
          <ul className="row">
            <li className="col list-group-item">
              <NavLink to={"/"}>Home</NavLink>
            </li>
            <li className="col list-group-item">
              <NavLink to={"/register"}>Register nev task</NavLink>
            </li>
            <li className="col list-group-item">
              <NavLink to={"/tasks"}>View task</NavLink>
            </li>
          </ul>
        </nav>
      </header>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Form />} />
        <Route path="/tasks" element={<AllTasks />} />
        <Route path="/tasks/:id" element={<EditTask />} />
      </Routes>
    </div>
  );
}

export default App;
