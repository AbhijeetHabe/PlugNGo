//import Container from 'react-bootstrap/Container';

//import Nav from "react-bootstrap/Nav";
//import Navbar from "react-bootstrap/Navbar";
//import { Login } from "./Components/Login";
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
          <NavLink to="/home">PLUGNGo</NavLink>
          <NavLink to="/about">About</NavLink>
          <NavLink to="/services">Services</NavLink>
          <NavLink to="/contactus">Contact</NavLink>
        </NavMenu>
        <NavBtn>
          <NavBtnLink to="/login">Sign In</NavBtnLink>
          <NavBtnLink to="/register">Sign Up</NavBtnLink>
          <NavBtnLink to="/adminpage">Admin</NavBtnLink>
        </NavBtn>
      </Nav>
    </>
  );
};

export { Header };
