import { Link } from 'react-router-dom';
import Logo from './Logo';
import "./Header.css";


const Header = () => {
  return (
    <header className="Header">
      <Link to="/"><Logo></Logo></Link>
      <nav className="nav">
        <ul className="nav-list">
          <li><Link to="/books">Books</Link></li>
          <li><Link to="/loans">Loans</Link></li>
          <li><Link to="/users">User</Link></li>
          <li><Link to="/libraries">Libraries</Link></li>
        </ul>
       
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