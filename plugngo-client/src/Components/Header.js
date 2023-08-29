//import Container from 'react-bootstrap/Container';

//import Nav from "react-bootstrap/Nav";
//import Navbar from "react-bootstrap/Navbar";
//import { Login } from "./Components/Login";
import "./Header.css";
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink,
} from "./NavBarElements";

const Header = () => {
  return (
    <>
      <Nav>
        <Bars />

        <NavMenu>
          <h1>
            <NavLink to="/home">PLUGNGo</NavLink>
          </h1>

          <NavLink to="/about">About</NavLink>
          <NavLink to="/services">Services</NavLink>
          <NavLink to="/contactus">Contact</NavLink>
        </NavMenu>
        <NavBtn>
          <NavBtnLink to="/login">Sign In</NavBtnLink>
          <NavBtnLink to="/register">Sign Up</NavBtnLink>
        </NavBtn>
      </Nav>
    </>
  );
};

export { Header };
