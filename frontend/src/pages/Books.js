import "./Books.css";
import React, { useState } from "react";
import Table from "../components/Table";
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

  return (
    
    
    <div className="books-container">
      <h1>Books</h1>
      <Table columns={columns} data={books} actions={{ edit: editBook, delete: deleteBook }} />
    </div>
    
  );


  };
  
export default Books;