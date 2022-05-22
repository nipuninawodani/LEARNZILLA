import React from "react";
import { Link } from "react-router-dom";
import "./User_Profile.css"
import user from "./user.jpg"

function User_Profile() {

    return (
        <div className="container-user">
            <div className="wrap-user">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <img src={user} class="card-img-top" alt="..." />
                        </div>
                        <div class="col" >
                            <form className="top-margin">
                                <div class="form-group">
                                    <label >First Name</label>
                                    <input type="text" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label >Last Name</label>
                                    <input type="text" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label >Email</label>
                                    <input type="email" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label >Role</label>
                                    <input type="text" class="form-control"/>
                                </div>
                                <p></p>
                                <button type="submit" class="btn btn-danger">Edit Credentials</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default User_Profile;