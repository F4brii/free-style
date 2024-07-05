import React from "react";
import "../styles/Precios.css";

const Precios = () => {
    return (
    <div className="tabla-container">
        <table className="tabla-precio">
        <thead className="cabezapre">
            <tr>
                <th></th>
                <th>Horario</th>
                <th>Precio</th>
            </tr>
        </thead>
        <tbody>
            <tr className="azul">
                <td>Regular</td>
                <td>6:00 am - 10:00 am / 4:00 pm - 11:00 pm</td>
                <td>$80.000 (Precio grupal)</td>
            </tr>
            <tr className="amarillo">
                <td>No regular</td>
                <td>10:00 am - 4:00 am</td>
                <td>$5.000 (Precio individual)</td>
            </tr>
        </tbody>
    </table>
    </div>
    );
};

export default Precios;
