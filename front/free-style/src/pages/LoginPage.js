import React from "react";
import "../styles/LoginPage.css";
import { login } from "../services/authService";
import LoginForm from "../components/LoginForm";

const LoginPage = () => {
  const handleLogin = async (email, password) => {
    try {
      return await login(email, password);
    } catch (error) {
      return {
        success: false
      };
    }
  };

  return (
    <div className="login-page">
      <div className="login-container">
        <LoginForm onLogin={handleLogin} />
        <div className="vertical-divider"></div>
        <div className="login-image">
          <img src="./logo-freestyle.jpeg" alt="Login" className="login-img" />
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
