import { useState } from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router";
import ProductList from "./components/ProductList";
import ProductDetails from "./components/ProductDetails";
function App() {
  return (
    <>
    
    <Routes>
        <Route
        path="/products"
        element={<ProductList/>}
        />
        <Route 
        path="/products/:id" 
        element={<ProductDetails />} 
        />
      </Routes>

    </>
  );
}

export default App;
