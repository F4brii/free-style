import React from "react";
import Note from "../components/Note";
import "../styles/ReservationPage.css";

const ReservationPage = () => {
  const data = [
    {
      id: 1,
      column1: "Data 1",
      column2: "Data 2",
      column3: "Data 3",
      column4: "Data 4",
      column5: "Data 5",
    },
    {
      id: 2,
      column1: "Data 6",
      column2: "Data 7",
      column3: "Data 8",
      column4: "Data 9",
      column5: "Data 10",
    },
    {
      id: 3,
      column1: "Data 11",
      column2: "Data 12",
      column3: "Data 13",
      column4: "Data 14",
      column5: "Data 15",
    },
  ];

  const reservationNoteMessage = "Las reservas en las franjas horarias de tipo no regular, requieren reserva individual hasta 10 jugadores.";
  const rateNoteMessage = "Las franjas de tipo no regular tienen una tarifa especial, puede validar en el siguiente ";

  return (
    <div className="reservation-page">
      <Note message={reservationNoteMessage} />
      <Note message={rateNoteMessage }  /> <a href="/Precios">enlace</a>
      <table>
        <thead>
          <tr>
            <th>Horarios</th>
            <th>Numero de cancha</th>
            <th>Estado</th>
            <th> </th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {data.map(row => (
            <tr key={row.id}>
              <td>{row.column1}</td>
              <td>{row.column2}</td>
              <td>{row.column3}</td>
              <td>{row.column4}</td>
              <td>{row.column5}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ReservationPage;
