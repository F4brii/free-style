import React, { useRef, useState } from "react";
import registroService from '../services/registroService'; // Import the mock service
import '../styles/Signin.css';

const Signin = () => {
    const [nombre, setNombre] = useState('');
    const [correo, setCorreo] = useState('');
    const [contrasena, setContrasena] = useState('');
    const [mensaje, setMensaje] = useState('');
    const passwordFieldRef = useRef(null);

    const togglePassword = () => {
        const passwordField = passwordFieldRef.current;
        if (passwordField.type === "password") {
            passwordField.type = "text";
        } else {
            passwordField.type = "password";
        }
    };

    const handleRegistro = async (event) => {
        event.preventDefault();
        const usuario = { nombre, correo, contrasena };

        try {
            const response = await registroService.registrarUsuario(usuario);
            setMensaje(response.message);
        } catch (error) {
            setMensaje('Error');
        }
    };

    return (
        <div className="signin-container">
            <h1 className="tituloregistro">Registro de usuario</h1>
            <div className="container">
                <div className="form-container">
                    <form onSubmit={handleRegistro}>
                        <div className="mandatory-note">* Campo obligatorio</div>

                        <div className="form-group">
                            <label className="labelregistro" htmlFor="nombre">Nombres y Apellidos <span className="required">*</span></label>
                            <input
                                id="nombre"
                                value={nombre}
                                onChange={(e) => setNombre(e.target.value)}
                                required
                            />
                        </div>

                        <div className="form-group">
                            <label className="labelregistro" htmlFor="correo">Correo electrónico <span className="required">*</span></label>
                            <input
                                id="correo"
                                type="email"
                                value={correo}
                                onChange={(e) => setCorreo(e.target.value)}
                                required
                            />
                        </div>

                        <div className="form-group">
                            <label className="labelregistro" htmlFor="contrasena">Contraseña <span className="required">*</span></label>
                            <div className="password-container">
                                <input
                                    type="password"
                                    id="contrasena"
                                    value={contrasena}
                                    onChange={(e) => setContrasena(e.target.value)}
                                    required
                                    ref={passwordFieldRef}
                                />
                                <span className="eye-icon" onClick={togglePassword}>👁️</span>
                            </div>
                        </div>

                        <div className="password-note">La contraseña debe contener entre 8 y 10 caracteres, incluyendo al menos una letra mayúscula, un número y un carácter especial.</div>

                        <button className="botonregistro" type="submit">Registrar</button>
                    </form>
                    {mensaje && <p>{mensaje}</p>}
                </div>
                <div className="side-image">
                    <img src="cancha.png" alt="Freestyle Logo" />
                </div>
            </div>
        </div>
    );
};

export default Signin;
