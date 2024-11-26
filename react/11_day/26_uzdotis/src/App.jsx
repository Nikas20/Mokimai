import Form from "./components/Form";
import { BrowserRouter, Routes, Route, Link } from "react-router";
import Success from "./components/Success";
function App() {
  return (
    <main className="container">
      <div className="row">
        <Routes>
          <Route path="/" element={<Form />} />
          <Route path="/success" element={<Success />} />
        </Routes>
      </div>
    </main>
  );
}

export default App;
