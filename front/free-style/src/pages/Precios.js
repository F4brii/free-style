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
        <div className="tabla-container">
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
            <tr key={index}>
                <td>{pre.tipo}</td>
                <td>{pre.horario}</td>
                <td>{pre.precio}</td>
                </tr>
            ))}
            </tbody>
        </table>
        </div>
    );
    };

export default Precios;
