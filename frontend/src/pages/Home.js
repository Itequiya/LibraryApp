
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
      <div className="slider-container">
      <div className="slider">
        <img src={images[currentIndex]} alt="slider" className="slider-image" />
      </div>
      <button className="prev-button" onClick={prevSlide}>❮</button>
      <button className="next-button" onClick={nextSlide}>❯</button>
    </div>
    );
  };
  
export default Home;