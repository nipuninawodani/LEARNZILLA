import {BrowserRouter as Router, Routes, Link, Route} from 'react-router-dom';
import './App.css';
import Login from "./Components/Login/Login";
import Register from "./Components/Register/Register";
import Course from "./Components/Course/Course";
import Results from "./Components/Results/Results";

function App() {
  return (
    <div className="App">
      <header className="App-header">

        <Router>   
            <Routes>

              <Route exact path="/Login" element={<Login/>} />
              <Route path="/Register"  element={<Register/>}/>
              <Route path="/Course"  element={<Course/>}/>
              <Route path="/Results"  element={<Results/>}/>

            </Routes> 
  
        </Router>

      </header>
    </div>
  );
}



export default App;
