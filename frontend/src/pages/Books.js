import "./Books.css";
import React, { useState } from "react";

const Books = () => {
  const [books, setBooks] = useState([
    {
      id: 1,
      title: "El Alquimista",
      author: "Paulo Coelho",
      publisher: "HarperCollins",
      pages: 208,
      category: "Ficción",
    },
    {
      id: 2,
      title: "Cien Años de Soledad",
      author: "Gabriel García Márquez",
      publisher: "Editorial Sudamericana",
      pages: 417,
      category: "Realismo Mágico",
    },
    {
      id: 3,
      title: "La Sombra del Viento",
      author: "Carlos Ruiz Zafón",
      publisher: "Planeta",
      pages: 575,
      category: "Misterio",
    },
  ]); 
  const [sortConfig, setSortConfig] = useState({ key: null, direction: "asc" });

  const [searchText, setSearchText] = useState(""); 
  const [searchFilter, setSearchFilter] = useState("All"); 

  const sortTable = (key) => {
    let direction = "asc";
    if (sortConfig.key === key && sortConfig.direction === "asc") {
      direction = "desc";
    }

    const sortedBooks = [...books].sort((a, b) => {
      if (a[key] < b[key]) return direction === "asc" ? -1 : 1;
      if (a[key] > b[key]) return direction === "asc" ? 1 : -1;
      return 0;
    });

    setSortConfig({ key, direction });
    setBooks(sortedBooks);
  };

 
  const filteredBooks = books.filter((book) => {
    if (!searchText) return true; 

    const lowerText = searchText.toLowerCase();

    switch (searchFilter) {
      case "title":
        return book.title.toLowerCase().includes(lowerText);
      case "author":
        return book.author.toLowerCase().includes(lowerText);
      case "publisher":
        return book.publisher.toLowerCase().includes(lowerText);
      case "category":
        return book.category.toLowerCase().includes(lowerText);
      default: // "All"
        return (
          book.title.toLowerCase().includes(lowerText) ||
          book.author.toLowerCase().includes(lowerText) ||
          book.publisher.toLowerCase().includes(lowerText) ||
          book.category.toLowerCase().includes(lowerText)
        );
    }
  });

  
  const editBook = (id) => {
    alert(`Editar libro con ID: ${id}`);
  };

  const deleteBook = (id) => {
    alert(`Eliminar libro con ID: ${id}`);
    setBooks(books.filter((book) => book.id !== id)); 
  };

  return (
    <div className="book-container">
      <h2>Lista de Libros</h2>

      
      <div className="search-container-table">
        <input
          type="text"
          placeholder="Buscar..."
          value={searchText}
          onChange={(e) => setSearchText(e.target.value)}
        />
        <select value={searchFilter} onChange={(e) => setSearchFilter(e.target.value)}>
          <option value="All">Todos</option>
          <option value="title">Título</option>
          <option value="author">Autor</option>
          <option value="publisher">Editorial</option>
          <option value="category">Categoría</option>
        </select>
      </div>

     
      <table>
        <thead>
          <tr>
            <th onClick={() => sortTable("title")}>Título</th>
            <th onClick={() => sortTable("author")}>Autor</th>
            <th onClick={() => sortTable("publisher")}>Editorial</th>
            <th onClick={() => sortTable("pages")}>Número de Páginas</th>
            <th onClick={() => sortTable("category")}>Categoría</th>
            <th>Acciones</th> 
          </tr>
        </thead>
        <tbody>
          {filteredBooks.length > 0 ? (
            filteredBooks.map((book) => (
              <tr key={book.id}>
                <td>{book.title}</td>
                <td>{book.author}</td>
                <td>{book.publisher}</td>
                <td>{book.pages}</td>
                <td>{book.category}</td>
                <td>
                  
                  <button id="editBookBtn"  onClick={() => editBook(book.id)}>
                    <i className="fas fa-edit"></i> 
                  </button>
                  <button id= "deleteBookBtn"onClick={() => deleteBook(book.id)}>
                    <i className="fas fa-trash"></i> 
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="6">No hay libros disponibles</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
  };
  
export default Books;