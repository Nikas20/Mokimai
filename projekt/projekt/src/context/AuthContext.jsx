import PropTypes from 'prop-types';
import {createContext, useContext, useState} from "react";
import { useNavigate } from "react-router";
import api, { setAuth, clearAuth } from "../utils/api.js";


const AuthContext = createContext({
    user: {},
    login: () => {},
    logout: () => {},
    register: () => {},
});

export const AuthProvider = ({ children }) => {
    const navigate = useNavigate();
    const [user, setUser] = useState(() => {
        const maybeUser = localStorage.getItem("user");

        if (maybeUser) {
            return JSON.parse(maybeUser);
        }
    });

    const login = async (email, password) => {
        await api.post(
          "/login",
          new URLSearchParams({
            username: email,
            password: password,
          }),
          { withCredentials: true }
        );
      
        // After login success, fetch user info from /auth (no params, session cookie used)
        const response = await api.get("/auth", { withCredentials: true });
        const userData = response.data;
      
        const user = {
          email,
          roles: userData.roles,
        };
      
        localStorage.setItem("user", JSON.stringify(user));
        setUser(user);
        navigate("/");
      };

    const register = async (email, password) => {
        await api.post("/register", { email, password});
        navigate("/login");
    };

    const logout = () => {
        setUser(null);
        // Ištrinam email ir password iš axios
        clearAuth();
        localStorage.removeItem("user");
        navigate("/login");
    };

    return (
        // Paduodas sukurtas funkcijas, tam kad jas būtų galima naudoti betkur su useAuth
        <AuthContext.Provider value={{ user, login, logout, register }}>
            {children}
        </AuthContext.Provider>
    );
};

// Sukuriamas custom hookas, kuris leidžia naudoti AuthContext
export const useAuth = () => {
    return useContext(AuthContext);
};

//PropTypes validation
AuthProvider.propTypes = {
    children: PropTypes.node.isRequired,
};

