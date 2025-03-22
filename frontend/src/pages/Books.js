import "./Books.css";
import React, { useState } from "react";
import Table from "../components/Table";
import Modal from "../components/Modal";
const Books = () => {
  
  const [books, setBooks] = useState([  ]);

  const editBook = (id) => {
    alert(`Edit book with ID: ${id}`);
  };

  const deleteBook = (id) => {
    setBooks(books.filter((book) => book.id !== id));
  };

  const columns = [
    { key: "title", label: "Títle" },
    { key: "author", label: "Author" },
    { key: "publisher", label: "Editorial" },
    { key: "pages", label: "Number of Pages" },
    { key: "category", label: "Category" },
  ];
  const [showModal, setShowModal] = useState (false);

  return (
    <div className="books-container">
      <h1>Books</h1>
      <Table columns={columns} data={books} actions={{ edit: editBook, delete: deleteBook }} />
      
      <button onClick= {() => setShowModal (true)} className="btn-create-book"> Add Book </button>
      {showModal &&  <Modal onClose ={() => setShowModal (false)}/> }
    </div> 
  );
  };
  
export default Books;