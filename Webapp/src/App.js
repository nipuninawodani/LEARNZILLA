import {BrowserRouter as Router, Routes, Link, Route} from 'react-router-dom';
import './App.css';
import Login from "./Components/Login/Login";
import Register from "./Components/Register/Register";
import Course from "./Components/Course/Course";
import Results from "./Components/Results/Results";
import Update_dialog from "./Components/Results/Update_dialog_component/Update_dialog";
import Edit_dialog from "./Components/Results/Edit_dialog_component/Edit_dialog";
import Delete_dialog from "./Components/Results/Delete_dialog_component/Delete_dialog";


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
              <Route path="/Update_dialog"  element={<Update_dialog/>}/>
              <Route path="/Edit_dialog"  element={<Edit_dialog/>}/>
              <Route path="/Delete_dialog"  element={<Delete_dialog/>}/>


            </Routes> 
  
        </Router>

      </header>
    </div>
  );
}



export default App;
