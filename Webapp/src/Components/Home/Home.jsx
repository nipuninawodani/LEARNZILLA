import React from "react";
import { Link } from "react-router-dom";
import "./Home.css"
import userProfile from "./images/userProfile.jpg"
import courses from "./images/courses.jpg"
import grades from "./images/grades.jpg"
import announcements from "./images/announcements.jpg"


function Home() {

    return (
        <div className="container-home">
            <div className="wrap-home">
                <div className="container">
                <div class="jumbotron">
                    <h4 className="text-center">Welcome Again!</h4>
                    <br />
                    <p class = "text-center" >Hi there! Let's learn something exciting today! Good Luck!</p>
                    <br />
                    <div class="row" >
                        <div class="col">
                            <div class="card" >
                                <div class="card-body text-center">
                                    <img src={userProfile} class="card-img-top" alt="..." />
                                    <p ></p>
                                    <a href="#" class="btn btn-outline-danger btn-sm ">My Profile</a>
                                </div>

                            </div>
                            <br />
                        </div>
                        <div class="col">
                            <div class="card" >
                                <div class="card-body text-center">
                                    <img src={courses} class="card-img-top" alt="..." />
                                    <p ></p>
                                    <a href="#" class="btn btn-outline-danger btn-sm">My Courses</a>
                                </div>

                            </div>
                            <br />
                        </div>
                        <div class="col">
                            <div class="card" >
                                <div class="card-body text-center">
                                    <img src={announcements} class="card-img-top" alt="..." />
                                    <p ></p>
                                    <a href="#" class="btn btn-outline-danger btn-sm">My Announcements</a>
                                </div>

                            </div>
                            <br />
                        </div>
                        <div class="col">
                            <div class="card" >
                                <div class="card-body text-center">
                                    <img src={grades} class="card-img-top" alt="..." />
                                    <p ></p>
                                    <a href="#" class="btn btn-outline-danger btn-sm">My Grades</a>
                                </div>

                            </div>
                            <br />
                        </div>
                    

                    </div>
                    <hr class="my-4" />
                    <p  className="text-center">Hope to see you soon again! Untill then keep studying!</p>
                    <p class="lead text-center">
                        <a class="btn btn-outline-dark btn-sm" href="#" role="button">Log Out</a>
                    </p>
                </div>
            </div>
            </div>
        </div>
    )
}

export default Home;