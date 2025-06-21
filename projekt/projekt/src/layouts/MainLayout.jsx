import {Outlet} from "react-router";
import { Navbar } from "../components/NavBar.jsx";

export const MainLayout = () => {


    return (
        <div className="grid grid-rows-[5rem_1fr_5rem] h-screen">
             <header className="pb-1 relative">
                <Navbar/>
            </header>
            <main>
                <Outlet />
            </main>
        </div>
    )
}