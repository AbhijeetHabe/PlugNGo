import React from "react";
import "./App.css";
import "./Components/Register.css";
import Home from "./Components/Home";
import { Header } from "./Components/Header";
import { Login } from "./Components/Login";
import { Register } from "./Components/Register";
import { Route, Routes } from "react-router-dom";
import { Layout } from "./Components/Layout";
import { AdminPage } from "./Components/AdminPage";
import About from "./Components/About";
import Services from "./Components/Services";
import ContactUs from "./Components/ContactUs";


function App() {
  return (
    <div>
      <Header></Header>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/home" element={<Home />} />
          <Route path="/admin" element={<AdminPage />} />
          <Route path="/about" element={<About />} />
          <Route path="/services" element={<Services />} />
          <Route path="/contactus" element={<ContactUs />} />
          <Route path="/login" element={<Login />} />

          <Route path="/register" element={<Register />} />
          <Route path="/adminpage" element={<AdminPage />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
