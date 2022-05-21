import React, { useState } from "react";
import { Link } from "react-router-dom";
import logo from './head-logo.png'
import registerImg from './body-img.png'
import './Register.css'
import RegisterService from "../../services/RegisterService";

function Register() {

    const [email, setEmail] = useState('');
    const [first_name, setFirst_name] = useState('');
    const [last_name, setLast_name] = useState('');
    const [password, setPassword] = useState('');
    const [cpwd, setCpwd] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();

        const student = {firstName: first_name , lastName:last_name, password, email}

        RegisterService.createStudent(student).then((response) => {

            console.log(response.data)

        }).catch(error =>{
            console.log(error)
        })
    }



    return (
        <div className='main-Register'>

            <div className="wrap-registration">

                <div className="left-side">
                    <div className="header">
                        <img src={logo} id="logo-img" alt="" />
                    </div>

                    <div className="body">
                        <img src={registerImg} id="body-img" alt="" />
                    </div>

                    <p> Welcome to LearnZilla! </p>
                </div>

                <div className="right-side">

                    <div className="body-right">
                        <div className="container">
                            <h1>Create Account!</h1>
                            <form>
                                <div className="input-group">
                                    <input type="text" name="Fname" placeholder="First Name" value={first_name} onChange={e => { setFirst_name(e.target.value) }} id="fname" />
                                </div>
                                <div className="input-group">
                                    <input type="text" name="Lname" placeholder="Last Name" value={last_name} onChange={e => { setLast_name(e.target.value) }} id="lname" />
                                </div>
                                <div className="input-group">
                                    <input type="Email" name="Email" placeholder="Email Address" value={email} onChange={e => { setEmail(e.target.value) }} id="email" />
                                </div>
                                <div className="input-group">
                                    <input type="password" name="Password" placeholder="Password" value={password} onChange={e => { setPassword(e.target.value) }} id="pwd" />
                                </div>
                                <div className="input-group">
                                    <input type="password" name="Confirm_password" placeholder="Confirm Password" value={cpwd} onChange={e => { setCpwd(e.target.value) }} id="c_pwd" />
                                </div>
                                <input type="submit" id="s_btn" value="Submit" onClick={(e) => handleSubmit(e)}/>
                            </form>

                            <br/>

                            <div className="top-right">
                                    Already have an Account?
                                <Link id="link-signIn" to='/Login'>Sign In</Link>
                            </div>

                        </div>
                    </div>
                </div>

            </div>

        </div>
    )
}

export default Register;