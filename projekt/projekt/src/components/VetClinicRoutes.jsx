import { BrowserRouter, Navigate, Route, Routes } from "react-router";
import { MainLayout } from "../layouts/MainLayout.jsx";
import { AuthGuard } from "../components/AuthGuard.jsx";
import { AuthProvider } from "../context/AuthContext.jsx";
import { PaginationProvider } from "../context/PaginationContext.jsx";
import { Login } from "../pages/auth/Login.jsx";
import { Register } from "../pages/auth/Register.jsx";
import { TourAdd } from "../pages/tour/TourAdd.jsx";
import {TourList} from "../pages/tour/TourList.jsx";
import {TourCard} from "../pages/tour/TourCard.jsx";
const VetClinicRoutes = () => {
  return (
    <BrowserRouter>
    <AuthProvider>
          <Routes>
            
            <Route path={"/login"} element={<Login />} />
            <Route path={"/register"} element={<Register />} />
            <Route path={"/"} element={<MainLayout />}/>
            
            <Route path={"/tour"} element={
              <AuthGuard>
              <PaginationProvider>
              <TourList />
              </PaginationProvider>
              </AuthGuard>
              }/>


            <Route path={"/tour/add"} element={<TourAdd />}/>
            <Route path={"/tour/:id"} element={<TourCard />}/>
          </Routes>
    </AuthProvider>      
    </BrowserRouter>
  );
};

export default VetClinicRoutes;
