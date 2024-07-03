import React from 'react';
import '../styles/Note.css';

const Note = ({ message }) => {
  return (
    <div className="note">
      <p>{message}</p>
    </div>
  );
};

export default Note;
