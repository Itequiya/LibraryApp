import "./Footer.css";
import facebook from '../Images/facebook.png'; 
import twitter from '../Images/twitter.png';
import instagram from '../Images/instagram.png';


const Footer = () => {
    return (

      <footer className="footer">
      <div className="footer-content">
        <p>© 2025 Itequiya. Todos los derechos reservados.</p>
        <p>Contáctanos</p>
        <a href="mailto:itequiyalibrary@gmail.com">itequiyalibrary@gmail.com</a>
        
        <p>Síguenos</p>
        <div className="footer-links">
          <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer">Facebook</a>
          <a href="https://www.twitter.com"target="_blank" rel="noopener noreferrer" >X</a>
          <a href="https://www.instagram.com"target="_blank" rel="noopener noreferrer" >Instagram</a>
        </div>

        
         <div className="social-links">
          <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer">
            <img src={facebook} alt="Facebook" className="social-icon" />
          </a>
          <a href="https://www.twitter.com" target="_blank" rel="noopener noreferrer">
            <img src={twitter} alt="Twitter" className="social-icon" />
          </a>
          <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer">
            <img src={instagram} alt="Instagram" className="social-icon" />
          </a>
        
        </div>

      </div>
    </footer>
    );
  };
  
  export default Footer;