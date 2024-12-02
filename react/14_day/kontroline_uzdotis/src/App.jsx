import { useState } from 'react'
import Library from "./components/Library"
import Register from "./components/Register"

import { BrowserRouter, Routes, Route,NavLink } from "react-router";
import BookEdit from './components/BookEdit';
function App() {
  return (
  <div>
    <header className='bg-warning text-info-emphasis'>
      <nav>
        <ul className='row'>
          <li className="col list-group-item"><NavLink to={"/"}>Home</NavLink></li>
          <li className="col list-group-item"><NavLink to={"/register"}>Register</NavLink></li>
        </ul>
      </nav>
    </header>
    <main >
      <Routes>
        <Route path='/' element={<Library/>}/>
        <Route path='/register' element={<Register/>}/>
        <Route path='/books/:id' element={<BookEdit/>}/>
      </Routes>
    </main>
    <footer className='bg-warning'><p>Nikas</p></footer>
    </div>
  )
}

export default App
