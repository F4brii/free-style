import React from "react";
import '../styles/LoginPage.css';
import { login } from "../services/authService";
import LoginForm from "../components/LoginForm";

const LoginPage = () => {
  const handleLogin = async (email, password) => {
    try {
      const response = await login(email, password);
      console.log("Login successful:", response);
      // Aquí puedes redirigir al usuario o guardar el token en el estado global o en localStorage
    } catch (error) {
      console.error("Login failed:", error.message);
      alert("Login failed: " + error.message);
    }
  };

  return (
    <div className="login-page">
      <div className="login-container">
        <LoginForm onLogin={handleLogin} />
        <div className="vertical-divider"></div>
        <div className="login-image">
          <img src="your-image-url.jpg" alt="Login" />
        </div>
      </div>
    </div>
  );
};

export default LoginPage;

