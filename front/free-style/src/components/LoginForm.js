import React, { useState, useContext } from "react";
import { useNavigate, Link } from "react-router-dom";

import "../styles/LoginForm.css";

import { AuthContext } from "../context/AuthContext";

const LoginForm = ({ onLogin }) => {
  const { login } = useContext(AuthContext);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null); // Estado para manejar el mensaje de error
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    const { success } = await onLogin(email, password);
    if (success) {
      login();
      navigate("/reservation");
    } else {
      setError("Error: Credenciales incorrectas"); // Establecer el mensaje de error
      setPassword(""); // Limpiar el campo de contraseña
    }
  };

  return (
    <div>
      <h2 className="login-title">Iniciar sesión</h2>
      <div className="login-form">
        {error && <div className="error-message">{error}</div>} {/* Mostrar el mensaje de error si existe */}
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="email">
              Correo electrónico:<span className="required">*</span>
            </label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div>
            <label htmlFor="password">
              Contraseña:<span className="required">*</span>
            </label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button type="submit">Acceder</button>
        </form>
      </div>
      <div className="register-link">
        ¿No tienes cuenta?, <Link to="/signin">regístrate</Link>.
      </div>
    </div>
  );
};

export default LoginForm;
