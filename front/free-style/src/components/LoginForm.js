import React, { useState } from "react";
import "../styles/LoginForm.css";

const LoginForm = ({ onLogin }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    onLogin(email, password);
  };

  return (
    <div>
      <h2 className="login-title">Iniciar sesión</h2>
      <div className="login-form">
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
        ¿No tienes cuenta?, <a href="#">regístrate</a>.
      </div>
    </div>
  );
};

export default LoginForm;
