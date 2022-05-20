import { faCaretDown } from "@fortawesome/free-solid-svg-icons";
import React from "react";
import { Link } from "react-router-dom";
import "./Course_view.css"
import card from "./card.jpg"


function Course_view() {

    return (
        <div className="container-course_view">
            <div className="wrap-course_view">

                <div className="container">
                    <div class="jumbotron">
                        <h4 >My Courses</h4>
                        <p >You can see the courses that you have enrolled in here!</p>

                        <div class="row" >
                            <div class="col-sm-4">
                                <div class="card" >
                                    <div class="card-body">
                                        <img src={card} class="card-img-top" alt="..." />
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                                    </div>

                                </div>
                                <br />
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-body">
                                        <img src={card} class="card-img-top" alt="..." />
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                                    </div>

                                </div>
                                <br />
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-body">
                                        <img src={card} class="card-img-top" alt="..." />
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. </p>
                                    </div>

                                </div>
                                <br />
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-body">
                                        <img src={card} class="card-img-top" alt="..." />
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. </p>
                                    </div>

                                </div>
                                <br />
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-body">
                                        <img src={card} class="card-img-top" alt="..." />
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                                    </div>

                                </div>
                                <br />
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-body">
                                        <img src={card} class="card-img-top" alt="..." />
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                                    </div>

                                </div>
                                <br />
                            </div>

                        </div>

                        <hr class="my-4" />
                        <h4>Enroll in a course here!</h4>
                        <nav class="navbar navbar-light ">
                            <form class="form-inline">
                                <input class=" mr-sm-2"  type="search" placeholder="Enter course name" aria-label="Search" />
                                <button class="btn btn-danger my-2 my-sm-0" type="submit">Search</button>
                            </form>
                        </nav>
                        <br />
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Course name 01</li>
                            <li class="list-group-item">Course name 02</li>
                            <li class="list-group-item">Course name 03</li>
                            <li class="list-group-item">Course name 04</li>
                            <li class="list-group-item">Course name 05</li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    )
}

export default Course_view;