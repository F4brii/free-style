import React, { useState } from "react";
import { Link } from "react-router-dom";
import Note from "../components/Note";
import DetailModal from "../components/DetailModal";
import "../styles/ReservationPage.css";

const ReservationPage = () => {
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedReservation, setSelectedReservation] = useState(null);
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage] = useState(4); // Número de elementos por página

  const data = [
    {
      id: 1,
      tipo: "Regular",
      horario: "6:00 a.m - 7:00 a.m",
      cancha: 1,
      estado: "Ocupado",
      participantes: 0,
    },
    {
      id: 2,
      tipo: "Regular",
      horario: "6:00 a.m - 7:00 a.m",
      cancha: 2,
      estado: "Ocupado",
      participantes: 0,
    },
    {
      id: 3,
      tipo: "Regular",
      horario: "6:00 a.m - 7:00 a.m",
      cancha: 6,
      estado: "Disponible",
      participantes: 0,
    },
    {
      id: 9,
      tipo: "Regular",
      horario: "6:00 a.m - 7:00 a.m",
      cancha: 6,
      estado: "Disponible",
      participantes: 0,
    },
    {
      id: 6,
      tipo: "Regular",
      horario: "6:00 a.m - 7:00 a.m",
      cancha: 6,
      estado: "Disponible",
      participantes: 0,
    },
    {
      id: 4,
      tipo: "No regular",
      horario: "8:00 a.m - 9:00 a.m",
      cancha: 2,
      estado: "Parcialmente ocupado",
      participantes: 4,
    },
    {
      id: 5,
      tipo: "No regular",
      horario: "10:00 a.m - 11:00 a.m",
      cancha: 3,
      estado: "Parcialmente ocupado",
      participantes: 4,
    },
    {
      id: 7,
      tipo: "No regular",
      horario: "10:00 a.m - 11:00 a.m",
      cancha: 3,
      estado: "Parcialmente ocupado",
      participantes: 4,
    },
    {
      id: 8,
      tipo: "No regular",
      horario: "10:00 a.m - 11:00 a.m",
      cancha: 3,
      estado: "Parcialmente ocupado",
      participantes: 4,
    },
  ];

  const reservationNoteMessage =
    "Las reservas en las franjas horarias de tipo no regular, requieren reserva individual hasta 10 jugadores.";

  const handleReservationClick = (id) => {
    const reservation = data.find((item) => item.id === id);
    setSelectedReservation(reservation);
    setModalOpen(true);
  };

  const closeModal = () => {
    setModalOpen(false);
  };

  // Calcular índices para la paginación
  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItems = data.slice(indexOfFirstItem, indexOfLastItem);

  // Cambiar de página
  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  return (
    <div className="reservation-page">
      <h1>Reservas de Canchas</h1>
      <Note message={reservationNoteMessage} />
      <Note
        message={
          <p>
            Las franjas de tipo no regular tienen una tarifa especial, puede
            validar en el siguiente <Link to="/precios">enlace</Link>.
          </p>
        }
      />
      <table>
        <thead>
          <tr>
            <th>Horarios</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {currentItems.map((row) => (
            <tr
              key={row.id}
              className={row.tipo === "Regular" ? "regular-row" : "no-regular-row"}
            >
              <td>{row.horario}</td>
              <td>Cancha #{row.cancha}</td>
              <td>Estado: {row.estado}</td>
              <td>
                {row.tipo !== "Regular" && (
                  <>
                    {row.participantes} / 10
                  </>
                )}
              </td>
              <td>
                <button onClick={() => handleReservationClick(row.id)}>
                  Reservar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      {/* Paginación */}
      <div className="pagination">
        <button
          onClick={() => paginate(1)}
          disabled={currentPage === 1}
        >
          Primera
        </button>
        <button
          onClick={() => paginate(currentPage - 1)}
          disabled={currentPage === 1}
        >
          Anterior
        </button>
        <button
          onClick={() => paginate(currentPage + 1)}
          disabled={currentPage === Math.ceil(data.length / itemsPerPage)}
        >
          Siguiente
        </button>
        <button
          onClick={() => paginate(Math.ceil(data.length / itemsPerPage))}
          disabled={currentPage === Math.ceil(data.length / itemsPerPage)}
        >
          Última
        </button>
      </div>
      <DetailModal isOpen={modalOpen} onClose={closeModal}>
        {selectedReservation && (
          <> 
            <h2>Detalles de la reserva</h2>
            <p>Horario: {selectedReservation.horario}</p>
            <p>Cancha: {selectedReservation.cancha}</p>
            <p>Estado: {selectedReservation.estado}</p>
          </>
        )}
      </DetailModal>
    </div>
  );
};

export default ReservationPage;
