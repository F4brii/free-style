// src/components/Menu.js

import React from "react";
import { Link } from "react-router-dom";
import "../styles/Menu.css";

const Menu = () => {
  const handleLogout = () => {
    // Lógica para cerrar sesión
  };

  return (
    <nav className="menu">
      <Link to="/" className="menu-item">Inicio</Link>
      <Link to="/reservation" className="menu-item">Reservar</Link>
      <Link to="/precios" className="menu-item">Horarios y trafias</Link>
      <div className="menu-item logout">
        <button onClick={handleLogout}>Cerrar sesión</button>
      </div>
    </nav>
  );
};

export default Menu;
