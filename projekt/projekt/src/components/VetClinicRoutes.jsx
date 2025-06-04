import { BrowserRouter, Navigate, Route, Routes } from "react-router";
import { MainLayout } from "../layouts/MainLayout.jsx";
import { Login } from "../pages/auth/Login.jsx";
import { Register } from "../pages/auth/Register.jsx";
import { TourAdd } from "../pages/tour/TourAdd.jsx";
import {TourList} from "../pages/tour/TourList.jsx";
const VetClinicRoutes = () => {
  return (
    <BrowserRouter>
    
      
          <Routes>
            <Route path={"/login"} element={<Login />} />
            <Route path={"/register"} element={<Register />} />
            <Route path={"/tour"} element={<MainLayout />}/>
            <Route path={"/tour"} element={<TourList />}/>
            <Route path={"/tour/add"} element={<TourAdd />}/>
          </Routes>
    </BrowserRouter>
  );
};

export default VetClinicRoutes;
