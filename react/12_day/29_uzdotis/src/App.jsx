import { BrowserRouter, Routes, Route} from "react-router";
import Home from "./components/Home"
import UserDetails from "./components/UserDetails";
function App() {
  return (<>
    <Routes>
        <Route
        path="/users"
        element={<Home/>}
        />
        <Route
        path="/users/:id"
        element={<UserDetails/>}
        />
      </Routes>
    </>
    
  )
}

export default App