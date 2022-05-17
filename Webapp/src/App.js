import {BrowserRouter as Router, Routes, Link, Route} from 'react-router-dom';
import './App.css';
import Login from "./Components/Login/Login";
import Register from "./Components/Register/Register";
import Course from "./Components/Course/Course";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h3>Main Page</h3>

        <Router>   
            <Routes>

              <Route exact path="/Login" element={<Login/>} />
              <Route path="/Register"  element={<Register/>}/>
              <Route path="/Course"  element={<Course/>}/>

            </Routes> 
  
        </Router>

      </header>
    </div>
  );
}



export default App;
