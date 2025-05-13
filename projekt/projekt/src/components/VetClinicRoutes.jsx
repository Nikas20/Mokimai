import { BrowserRouter, Navigate, Route, Routes } from "react-router";
import { MainLayout } from "../layouts/MainLayout.jsx";
import { Login } from "../pages/auth/Login.jsx";
import { Register } from "../pages/auth/Register.jsx";
const VetClinicRoutes = () => {
  return (
    <BrowserRouter>
    
      
          <Routes>
            <Route path={"/login"} element={<Login />} />
            <Route path={"/register"} element={<Register />} />
            <Route path={"/"} element={<MainLayout />}/>
          </Routes>
    </BrowserRouter>
  );
};

export default VetClinicRoutes;
