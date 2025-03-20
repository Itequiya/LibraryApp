
import React, { useState } from 'react';
import './Home.css';
import jovenenbiblioteca from '../Images/jovenenbiblioteca.jpg';
import jovenbiblioteca2 from '../Images/jovenbiblioteca2.jpg';
import libreriajoven from '../Images/libreriajoven.jpg';

const Home = () => {

  const images = [
    jovenbiblioteca2,
    jovenenbiblioteca,
    libreriajoven
  ];

  const [currentIndex, setCurrentIndex] = useState(0);
  
  const nextSlide = () => {
    setCurrentIndex((prevIndex) => (prevIndex + 1) % images.length);
  };

  const prevSlide = () => {
    setCurrentIndex((prevIndex) => (prevIndex - 1 + images.length) % images.length);
  };

    return (
      <><div className="slider-container">
        <div className="slider">
          <img src={images[currentIndex]} alt="slider" className="slider-image" />
        </div>
        <button id="slider-btn-left" className="prev-button" onClick={prevSlide}>❮</button>
        <button id="slider-btn-right" className="next-button" onClick={nextSlide}>❯</button>
      </div>

      <div className="separator">
        <span>Ubicación</span>
      </div>

      <div className="map-container">
          <iframe title="mapa" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3721.8946370276108!2d-101.66332342415696!3d21.116766384748793!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x842bbfaacac36c87%3A0x6b00823680bc60!2sBiblioteca%20Central%20Estatal%20Wigberto%20Jim%C3%A9nez%20Moreno!5e0!3m2!1ses-419!2smx!4v1742349309842!5m2!1ses-419!2smx" 
          allowFullScreen
          loading="lazy">
          </iframe>
        </div></>

    );
  };
  
export default Home;