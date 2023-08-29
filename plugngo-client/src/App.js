import React from "react";
//import logo from "./logo.svg";
import "./App.css";
import "./Components/Login.css";
import "./Components/Register.css";
import Home from "./Components/Home";
import { Header } from "./Components/Header";
import { Login } from "./Components/Login";
import { Register } from "./Components/Register";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Layout } from "./Components/Layout";
import { AdminPage } from "./Components/AdminPage";
import About from "./Components/About";
import Services from "./Components/Services";
import ContactUs from "./Components/ContactUs";

// // const [currentForm, setCurrentForm] = useState("login");

// // const toggleForm = (formName) => {
// //   setCurrentForm(formName);
// // };
function App() {
  return (
    <div>
      <Header></Header>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/home" element={<Home />} />
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
// //   );
// // }
//  function App() {
//    const [currentForm, setCurrentForm] = useState("App");

//    const toggleForm = (formName) => {
//      setCurrentForm(formName);
//    };

//   return <div className="App"></div>;
// }

export default App;
