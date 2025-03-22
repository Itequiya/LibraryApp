import React, { useState, useRef } from "react";
import "./Modal.css";
import { CircleX } from 'lucide-react';


function Modal ({onClose}) {
    const modalRef = useRef ();
    const closeModal = (e) => {
        if(modalRef.current === e.target){
          onClose();  
        }
    }

return (
    <div ref={modalRef} onClick={closeModal} className="modal">
    <div className="modal-content">
        <button onClick = {onClose} className="close-modal-btn" ><CircleX size={32}/></button>
        <h2> Add a new Book</h2>
        <form>
            <input type='text' placeholder="Title" required />
            <input type='text' placeholder="Author" required />
            <input type='text' placeholder="Editorial" required />
            <input type='text' placeholder="Pages" required />
            <input type='text' placeholder="Category"/> 
            <button className="create-button" type="submit">Create Book</button>
        </form>
    </div>
</div>
)
}
export default Modal