// src/components/DetailModal.js
import React from "react";
import "../styles/DetailModal.css";

const DetailModal = ({ isOpen, onClose, onConfirm, children }) => {
  if (!isOpen) return null;

  const handleCancel = () => {
    onClose();
  };

  const handleConfirm = () => {
    alert("Confirmado!");
    onClose();
  };

  return (
    <div className="modal-overlay">
      <div className="modal">
        <div className="modal-content">{children}</div>
        <div className="modal-buttons">
          <button className="modal-button cancel-btn" onClick={handleCancel}>
            Cancelar
          </button>
          <button className="modal-button confirm-btn" onClick={handleConfirm}>
            Confirmar
          </button>
        </div>
      </div>
    </div>
  );
};

export default DetailModal;
