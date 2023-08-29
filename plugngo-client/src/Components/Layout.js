import { Outlet } from "react-router-dom";
import React from "react";
//import { Header } from "./Header";

export const Layout = () => {
  return (
    <main>
      <Outlet></Outlet>
    </main>
  );
};
