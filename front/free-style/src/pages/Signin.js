import React, { useRef } from "react";
import '../styles/Signin.css';



const Signin = () => {

const passwordFieldRef = useRef(null);

const togglePassword = () => {
    const passwordField = passwordFieldRef.current;
    if (passwordField.type === "password") {
        passwordField.type = "text";
    } else {
        passwordField.type = "password";
    }
    };

    return (
    <div className="signin-container">
            <h1 className="tituloregistro">Registro de usuario</h1>
    <div class="container">
        <div class="form-container">
            <form action="">
                <div class="mandatory-note">* Campo obligatorio</div>
                
                <div class="form-group">
                    <label  className="labelregistro" for="nombre">Nombres y Apellidos <span class="required">*</span></label>
                    <input id="nombre" placeholder="" required/>
                </div>
                <div class="form-group">
                    <label className="labelregistro" for="correo">Correo electrónico <span class="required">*</span></label>
                    <input id="correo" type="email" placeholder="" required/>
                </div>

                <div class="form-group">
                    <label className="labelregistro" for="contrasena">Contraseña <span class="required">*</span></label>
                    <div class="password-container">
                        <input type="password" id="contrasena" placeholder="" required ref={passwordFieldRef} />
                        <span className="eye-icon" onClick={togglePassword}>👁️</span>
                    </div>
                </div>
                
                <div class="password-note">La contraseña debe contener entre 8 y 10 caracteres, incluyendo al menos una letra mayúscula, un número y un carácter especial.</div>

                <button className="botonregistro" type="submit">Registrar</button>
            </form>
        </div>
        <div class="side-image">
            <img src="cancha.png" alt="Freestyle Logo"/>
        </div>
    </div>

    </div>

    
    );
};

export default Signin;
