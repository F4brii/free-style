import React from "react";
import "../styles/Detalles.css";

const Detalles = () => {
const redirigir = () => {
        window.location.href = '/';
    };
return (

    <div className="body-detalles">

        <div class="detalles-container">
            <h2>Detalles de tu reserva</h2>
            <p><span>Franja de tiempo:</span> 6:00 a.m - 7:00 a.m</p>
            <p><span>Día:</span> 22 de Junio de 2024</p>
            <p><span>Cancha:</span> # 2</p>
            <p><span>Costo:</span> $80,000</p>
            <div class="buttons">
                <button class="cancel-btn"onClick={redirigir}>Cancelar</button>
                <button class="confirm-btn">Confirmar</button>
            </div>
        </div>

    </div>
);
};

export default Detalles;
