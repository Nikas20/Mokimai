//import { useState } from 'react'
import './App.css'
import {BrowserRouter, Route, Routes} from "react-router";
//import {Navigate} from "react-router";
import {MainLayout} from "./layouts/MainLayout.jsx";
import {AuthGuard} from "./components/AuthGuard.jsx";
import {Login} from "./pages/auth/Login.jsx";
import {Register} from "./pages/auth/Register.jsx";
import {AuthProvider} from "./context/AuthContext.jsx";
import { TourAdd } from "../src/pages/tour/TourAdd.jsx"
import {TourList} from "../src/pages/tour/TourList.jsx";



const App = () => {
  return (
      <BrowserRouter>
          <Routes>
              <Route path={"/login"} element={
                  <AuthProvider>
                      <Login/>
                  </AuthProvider>
              }/>
              <Route path={"/register"} element={
                  <AuthProvider>
                      <Register/>
                  </AuthProvider>
              }/>
              <Route path={"/"} element={
                  <AuthGuard>
                      <AuthProvider>
                          <MainLayout/>
                      </AuthProvider>
                  </AuthGuard>
              }>
              </Route>
              <Route path={"/tour"} element={
                  <AuthGuard>
                      <AuthProvider>
                          <TourList/>
                      </AuthProvider>
                  </AuthGuard>
              }>
              </Route>
              <Route path={"/tour/add"} element={
                  <AuthGuard>
                      <AuthProvider>
                          <TourAdd/>
                      </AuthProvider>
                  </AuthGuard>
              }>
              </Route>
          </Routes>
      </BrowserRouter>
  )
}

export default App
