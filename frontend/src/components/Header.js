import { Link } from 'react-router-dom';
import Logo from './Logo';
const Header = () => {
  return (
    <header>
    <Logo/>
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/loans">Préstamo de Libros</Link></li>
          <li><Link to="/books">Libros</Link></li>
          <li><Link to="/users">Usuarios</Link></li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;