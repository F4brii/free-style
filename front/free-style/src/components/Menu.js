// src/components/Menu.js

import React, { useContext } from "react";
import { Link } from "react-router-dom";

import { AuthContext } from "../context/AuthContext";
import "../styles/Menu.css";

const Menu = () => {
  const { logout } = useContext(AuthContext);

  const handleLogout = () => {
    logout();
  };

  return (
    <nav className="menu">
      <Link to="/" className="menu-item">
        Inicio
      </Link>
      <Link to="/reservation" className="menu-item">
        Reservar
      </Link>
      <Link to="/precios" className="menu-item">
        Horarios y trafias
      </Link>
      <div className="menu-item logout">
        <button onClick={handleLogout}>Cerrar sesión</button>
      </div>
    </nav>
  );
};

export default Menu;
