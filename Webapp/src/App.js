import {BrowserRouter as Router, Routes, Link, Route} from 'react-router-dom';
import './App.css';
import Login from './components/Login/Login'
import Register from './components/Register/Register'

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h3>Main Page</h3>

        <Router>   
            <Routes>

              <Route exact path="/Login" element={<Login/>} />
              <Route path="/Register"  element={<Register/>}/>

            </Routes> 
  
        </Router>

      </header>
    </div>
  );
}



export default App;
