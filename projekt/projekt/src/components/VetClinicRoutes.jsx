import { BrowserRouter, Navigate, Route, Routes } from "react-router";
import { MainLayout } from "../layouts/MainLayout.jsx";
import { AuthGuard } from "./AuthGuard.jsx";
import { AuthProvider } from "../context/AuthContext.jsx";
import { PaginationProvider } from "../context/PaginationContext.jsx";
import { Login } from "../pages/auth/Login.jsx";
import { Register } from "../pages/auth/Register.jsx";
import { TourAdd } from "../pages/tour/TourAdd.jsx";
import {TourList} from "../pages/tour/TourList.jsx";
import {TourEdit} from "../pages/tour/TourEdit.jsx";
import { TourDetails } from "../pages/tour/TourDetails.jsx";
import {MyBookings} from "../pages/booking/MyBookings.jsx"
import {AdminBookings} from "../pages/booking/AdminBookings.jsx"
import {AdminFeedbacks} from "../pages/booking/AdminFeedbacks.jsx"
const VetClinicRoutes = () => {
  return (
    <BrowserRouter>
    <AuthProvider>
          <Routes>
            
            <Route path={"/login"} element={<Login />} />
            <Route path={"/register"} element={<Register />} />
            <Route path={"/"} element={<MainLayout />}>
            <Route index element={<Navigate to="/tour" replace />} />
            <Route path={"/tour"} element={
              <AuthGuard>
              <PaginationProvider>
              <TourList />
              </PaginationProvider>
              </AuthGuard>
              }/>
            
            
            <Route path={"/tour/:id"} element={ <TourDetails />} />
            <Route path={"/tour/add"} element={<TourAdd />}/>
            <Route path={"/tour/edit/:id"} element={<TourEdit />}/>
            <Route path={"/booking"} element={<MyBookings />}/>
            <Route path={"/admin/bookings"} element={<AdminBookings />} />
            <Route path="/admin/feedbacks" element={<AdminFeedbacks />} />
</Route>

          </Routes>
    </AuthProvider>      
    </BrowserRouter>
  );
};

export default VetClinicRoutes;
