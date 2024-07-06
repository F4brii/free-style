import React from "react";
import "../styles/Precios.css";

const Precios = () => {
    const pre = [{
        "tipo": "regular",
        "horario": "6:00 am - 10:00 am / 4:00 pm - 11:00 pm",
        "precio" : "80000"
    },
    {
        "tipo": "no regular",
        "horario": "10:00 am - 4:00 am",
        "precio" : "5000"
    }];

    return (
        <div className="contenedor">
            <div className="mensaje-container">
            <p>
                A continuación, te presentamos nuestros horarios y precios. Contamos con dos tipos de horarios:
                <br />
                <br />
                <b>1. Horarios Regulares:</b> Jugarás con tu equipo y se aplicará un precio grupal.<br />
                <b>2. Horarios No Regulares:</b> Jugarás de manera individual y tanto el cobro como la inscripción serán individuales.<br />
            <br />
                ¡Reserva ahora y no te pierdas la experiencia de Freestyle!
            </p>
            </div>
            <div className="tabla-container2">
        <table className="tabla-precio">
            <thead className="cabezapre">
                    <tr>
                <th></th> 
                <th>Horario</th>
                <th>Precio</th>
            </tr>
            </thead>
            <tbody className="azul">
            {pre.map((pre, index) => (
            <tr key={index} className={index % 2 === 0 ? "azul" : "amarillo"}>
                <td>{pre.tipo}</td>
                <td>{pre.horario}</td>
                <td>{pre.precio}</td>
                </tr>
            ))}
            </tbody>
        </table>
        </div>
        </div>
    );
    };

export default Precios;
