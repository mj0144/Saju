import './App.css';
import React from 'react';
import { BrowserRouter,  Routes, Route } from 'react-router-dom';
import  Main from 'pages/Main';
import  Info from 'pages/Info';
// import axios from 'axios';

function App() {

    return (
        <BrowserRouter basename="/">
                        <Routes>
                            <Route exact path="/" element={<Main />} /> {/* => 메인페이지 */}
                            <Route exact path="/info" element={<Info />} /> {/* => 정보입력 페이지 */}
                        </Routes>
        </BrowserRouter>
    );
}

export default App;