import React, { useState } from "react";
import { Link } from "react-router-dom";
import logo from './head-logo.png'
import registerImg from './body-img.png'
import './Register.css'

function Register() {

    const [email, setEmail] = useState('');
    const [Fusername, setFname] = useState('');
    const [Lusername, setLname] = useState('');
    const [pwd, setPwd] = useState('');
    const [cpwd, setCpwd] = useState('');

    const handleSubmit = () => {
        //e.preventDefault();
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
                            <form onSubmit={handleSubmit}>
                                <div className="input-group">
                                    <input type="text" name="Fname" placeholder="First Name" value={Fusername} onChange={e => { setFname(e.target.value) }} id="fname" />
                                </div>
                                <div className="input-group">
                                    <input type="text" name="Lname" placeholder="Last Name"value={Lusername} onChange={e => { setLname(e.target.value) }} id="lname" />
                                </div>
                                <div className="input-group">
                                    <input type="Email" name="Email" placeholder="Email Address" value={email} onChange={e => { setEmail(e.target.value) }} id="email" />
                                </div>
                                <div className="input-group">
                                    <input type="password" name="Password" placeholder="Password" value={pwd} onChange={e => { setPwd(e.target.value) }} id="pwd" />
                                </div>
                                <div className="input-group">
                                    <input type="password" name="Confirm_password" placeholder="Confirm Password" value={cpwd} onChange={e => { setCpwd(e.target.value) }} id="c_pwd" />
                                </div>
                                <input type="submit" id="s_btn" value="Submit" />
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