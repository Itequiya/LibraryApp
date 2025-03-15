import { Link } from 'react-router-dom';
import Logo from './Logo';
import "./Header.css";


const Header = () => {
  return (
    <header className="Header">
      <Logo />
      <nav className="nav">
        <ul className="nav-list">
          <li><Link to="/books">Books</Link></li>
          <li><Link to="/loans">Loans</Link></li>
          <li><Link to="/user">User</Link></li>
          <li><Link to="/libraries">Libraries</Link></li>
        </ul>
        {/* Barra de búsqueda añadida */}
        <div className="search-container">
        <input
          type="search"
          placeholder="Search..."
          className="search-input"
        />
      </div>
      </nav>
    </header>
  );
};

export default Header;