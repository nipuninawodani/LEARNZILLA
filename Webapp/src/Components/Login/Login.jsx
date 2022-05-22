import React, {useEffect, useState} from "react";
import { Link } from "react-router-dom";
import './css/login.css'
import './css/util.css'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faEnvelope, faLock, faLongArrowRight} from "@fortawesome/free-solid-svg-icons";
import img01 from './images/img-01.png'
import RegisterService from "../../services/RegisterService";
import LoginService from "../../services/LoginService";

function Login() {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();

        const login = {password, email}

        LoginService.Login (login).then((response) => {

            localStorage.setItem("Token" , response.data.token)
            LoginService.GetUser(login)

            if (localStorage.getItem("Type") == "Student"){

            }
            else{

            }

        }).catch(error =>{
            console.log(error)
        })
    }

    return (
        <div className="limiter">
                <div className="container-login100">
                    <div className="wrap-login100">
                        <div className="login100-pic js-tilt" data-tilt>
                            <img src={img01} alt="IMG" />
                        </div>

                        <form className="login100-form validate-form">
					<span className="login100-form-title">
						Member Login
					</span>

                            <div className="wrap-input100 validate-input"
                                 data-validate="Valid email is required: ex@abc.xyz">
                                <input className="input100" type="text" name="email" placeholder="Email" value={email} onChange={e => { setEmail(e.target.value) }}/>
                                    <span className="focus-input100"></span>
                                    <span className="symbol-input100">
							<FontAwesomeIcon icon={faEnvelope} /></span>
                             </div>

                            <div className="wrap-input100 validate-input" data-validate="Password is required">
                                <input className="input100" type="password" name="pass" placeholder="Password" value={password} onChange={e => { setPassword(e.target.value) }}/>
                                    <span className="focus-input100"></span>
                                    <span className="symbol-input100">
							<FontAwesomeIcon icon={faLock} />
						</span>
                            </div>

                            <div className="container-login100-form-btn">
                                <button className="login100-form-btn" onClick={(e) => handleSubmit(e)}>
                                    Login
                                </button>
                            </div>

                            <div className="text-center p-t-12">
						<span className="txt1"> Forgot </span>
                                <a className="txt2" href="./register">
                                    Username / Password?
                                </a>
                            </div>

                            <div className="text-center p-t-136">
                                <Link to='/Register'>
                                    <span> Create your Account </span>
                                    <FontAwesomeIcon icon={faLongArrowRight} />
                                </Link>
                            </div>
                        </form>
                    </div>
                </div>
        </div>
    )
}

export default Login;