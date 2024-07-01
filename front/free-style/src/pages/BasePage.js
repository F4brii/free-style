import React from "react";
import Menu from "../components/Menu";
import { Outlet } from "react-router-dom";
import "../styles/BasePage.css";

const BasePage = () => {
  return (
    <div>
      <Menu />
      <div className="base-page">
        <Outlet />
      </div>
    </div>
  );
};

export default BasePage;
