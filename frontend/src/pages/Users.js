import React, { useState } from "react";
import './Users.css';

const Users = () => {
  const [users, setUsers] = useState([
    {
      id: 1,
      username: "Jair",
      lastName: "Velazquez",
      phone: "477-345-67-80",
      email: "jair.98@gmail.com",
    },
    {
      id: 2,
      username: "Eduardo",
      lastName: "Alvarado",
      phone: "477-245-09-56",
      email: "edalva@gmail.com",
    },
    {
      id: 3,
      username: "Lizbeth",
      lastName: "Torres",
      phone: "477-789-1230",
      email: "liztorres@gmail.com",
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

    const sortedUsers = [...users].sort((a, b) => {
      if (a[key] < b[key]) return direction === "asc" ? -1 : 1;
      if (a[key] > b[key]) return direction === "asc" ? 1 : -1;
      return 0;
    });

    setSortConfig({ key, direction });
    setUsers(sortedUsers);
  };

 
  const filteredUsers = users.filter((user) => {
    if (!searchText) return true; 

    const lowerText = searchText.toLowerCase();

    switch (searchFilter) {
      case "username":
        return user.username.toLowerCase().includes(lowerText);
      case "lastName":
        return user.lastName.toLowerCase().includes(lowerText);
      case "phone":
        return user.phone.includes(lowerText);
      case "email":
        return user.email.toLowerCase().includes(lowerText);
      default: // "All"
        return (
          user.username.toLowerCase().includes(lowerText) ||
          user.lastName.toLowerCase().includes(lowerText) ||
          user.phone.includes(lowerText) ||
          user.email.toLowerCase().includes(lowerText)
        );
    }
  });

  
  const editUser = (id) => {
    alert(`Editar usuario con ID: ${id}`);
  };

  const deleteUser = (id) => {
    alert(`Eliminar usuario con ID: ${id}`);
    setUsers(users.filter((user) => user.id !== id)); 
  };

  return (
    <div className="user-container">
      <h2>Lista de Usuarios</h2>

      
      <div className="search-container-table">
        <input
          type="text"
          placeholder="Search..."
          value={searchText}
          onChange={(e) => setSearchText(e.target.value)}
        />
        <select value={searchFilter} onChange={(e) => setSearchFilter(e.target.value)}>
          <option value="All">Todos</option>
          <option value="username">Nombre de Usuario</option>
          <option value="lastName">Apellidos</option>
          <option value="phone">Teléfono</option>
          <option value="email">Correo</option>
        </select>
      </div>

  
      <table>
        <thead>
          <tr>
            <th className= "id-column" onClick={() => sortTable("id")}>ID</th>
            <th onClick={() => sortTable("username")}>Name</th>
            <th onClick={() => sortTable("lastName")}>Lastname</th>
            <th onClick={() => sortTable("phone")}>Phone</th>
            <th onClick={() => sortTable("email")}>Mail</th>
            <th>Acciones</th> 
          </tr>
        </thead>
        <tbody>
          {filteredUsers.length > 0 ? (
            filteredUsers.map((user) => (
                <tr key={user.id}>
                <td className="id-column">{user.id}</td> 
                <td>{user.username}</td>
                <td>{user.lastName}</td>
                <td>{user.phone}</td>
                <td>{user.email}</td>
                <td>
                  
                  <button className="edit" onClick={() => editUser(user.id)}>
                    <i className="fas fa-edit"></i> 
                  </button>
                  <button className="delete" onClick={() => deleteUser(user.id)}>
                    <i className="fas fa-trash"></i>
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5">No hay usuarios disponibles</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
    );
  };
  
export default Users;