import React, { useState } from "react";
import Table from "../components/Table";
import './Users.css';

const Users = () => {

  const [users, setUsers] = useState([  ]);

  const editUser = (id) => {
    alert(`Edit user with ID: ${id}`);
  };

  const deleteUser = (id) => {
    setUsers(users.filter((user) => user.id !== id));
  };

  const columns = [
    { key: "id", label: "ID" },
    { key: "name", label: "Name" },
    { key: "lastname", label: "Lastname" },
    { key: "phone", label: "Phone" },
    { key: "mail", label: "Mail" },
  ];

  return (
    
    <div className="user-container">
      <h1>Users</h1>
      <Table columns={columns} data={users} actions={{ edit: editUser, delete: deleteUser }} />
    </div>
    
  );



}
  
export default Users;