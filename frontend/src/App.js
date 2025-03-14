import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import Loans from './pages/Loans';
import Books from './pages/Books';
import Users from './pages/Users';
import './App.css';

function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/loans" element={<Loans />} />
        <Route path="/books" element={<Books />} />
        <Route path="/users" element={<Users />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
