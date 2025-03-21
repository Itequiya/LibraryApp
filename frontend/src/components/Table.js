import React, { useState } from "react";
import "./Table.css";

const Table = ({ columns, data, actions }) => {
    const [sortConfig, setSortConfig] = useState({ key: null, direction: "asc" });
    const [searchText, setSearchText] = useState("");
    const [searchFilter, setSearchFilter] = useState("All");
  
    const sortTable = (key) => {
      let direction = "asc";
      if (sortConfig.key === key && sortConfig.direction === "asc") {
        direction = "desc";
      }
  
      const sortedData = [...data].sort((a, b) => {
        if (a[key] < b[key]) return direction === "asc" ? -1 : 1;
        if (a[key] > b[key]) return direction === "asc" ? 1 : -1;
        return 0;
      });
  
      setSortConfig({ key, direction });
    };

    const filteredData = data.filter((item) => {
        if (!searchText) return true;
        const lowerText = searchText.toLowerCase();
    
        if (searchFilter === "All") {
          return columns.some((col) => item[col.key]?.toString().toLowerCase().includes(lowerText));
        } else {
          return item[searchFilter]?.toString().toLowerCase().includes(lowerText);
        }
      });

      return (
        <div className="table-container-table">
          <div className="search-container-table">
            <input
              type="text"
              placeholder="Search..."
              value={searchText}
              onChange={(e) => setSearchText(e.target.value)}
            />
            <select value={searchFilter} onChange={(e) => setSearchFilter(e.target.value)}>
              <option value="All">Todos</option>
              {columns.map((col) => (
                <option key={col.key} value={col.key}>
                  {col.label}
                </option>
              ))}
            </select>
          </div>
    
          
            <table className="table-wrapper">
              <thead>
                <tr>
                  {columns.map((col) => (
                    <th key={col.key} onClick={() => sortTable(col.key)}>
                      {col.label} {sortConfig.key === col.key ? (sortConfig.direction === "asc" ? "▲" : "▼") : ""}
                    </th>
                  ))}
                  {actions && <th>Acciones</th>}
                </tr>
              </thead>
              <tbody>
                {filteredData.length > 0 ? (
                  filteredData.map((item) => (
                    <tr key={item.id}>
                      {columns.map((col) => (
                        <td key={col.key}>{item[col.key]}</td>
                      ))}
                      {actions && (
  <td>
    {actions.edit && (
      <button className="edit-btn" onClick={() => actions.edit(item.id)}>
        <i className="fas fa-edit"></i>
      </button>
    )}
    {actions.delete && (
      <button className="delete-btn" onClick={() => actions.delete(item.id)}>
        <i className="fas fa-trash"></i>
      </button>
    )}
  </td>
)}
</tr>
              ))
            ) : (
              <tr>
                <td colSpan={columns.length + (actions ? 1 : 0)}>No hay datos disponibles</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
   
  );
};

export default Table;