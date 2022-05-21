import { faCaretDown } from "@fortawesome/free-solid-svg-icons";
import React, {useState} from "react";
import { Link } from "react-router-dom";
import "./Course_view.css"
import img1 from "./card.jpg"
import {useEffect} from "react";
import CourseService from "../../services/CourseService";
import EnrollmentService from "../../services/EnrollmentService";


function Course_view() {

    //let StudentId = localStorage.getItem('UserId')
    let StudentId = "1";

    const [card, setCard] = useState('');

    const [search, setSearch] = useState('');

    const [searchval , setSearchval] = useState('')

    useEffect(() => {

        EnrollmentService.getEnrollmentByStudent(StudentId).then(response => {

            response.data.map(({course_code, academic_year}) =>
                CourseService.getCourseByCourseCodeAndAcademicYear(course_code, academic_year).then((responseC) => {

                    setCard(
                        <div className="col-sm-4">
                            <div className="card">
                                <a href={'http://localhost:3000/course?CourseCode='+course_code+'&AcademicYear='+academic_year}>
                                <div className="card-body">
                                    <img src={card} className="card-img-top" alt="..."/>
                                    <h5 className="card-title">{responseC.data.title}</h5>
                                    <p className="card-text">{responseC.data.course_code} {responseC.data.academic_year}</p>
                                </div></a>
                            </div>
                            <br/>
                        </div>
                    )
                })
            )
        })

    }, []);

    useEffect(() => {
        CourseService.getCourseByName(searchval).then(response => {

            setSearch(
                <div>
                    <ul className="list-group list-group-flush">
                        {response.data.map(({course_code, academic_year ,title}) =>
                            <li className="list-group-item"><a href={'http://localhost:3000/course?CourseCode='+course_code+'&AcademicYear='+academic_year}>{title}</a></li>
                        )}
                    </ul>
                </div>
            )

        })
    }, [searchval]);


    return (
        <div className="container-course_view">
            <div className="wrap-course_view">

                <div className="container">
                    <div className="jumbotron">
                        <h4 >My Courses</h4>
                        <p >You can see the courses that you have enrolled in here!</p>

                        <div className="row" >
                            {card}
                        </div>

                        <hr className="my-4" />
                        <h4>Enroll in a course here!</h4>
                        <nav className="navbar navbar-light ">
                            <form className="form-inline">
                                <input className=" mr-sm-2"  type="search" placeholder="Enter course name" aria-label="Search" value={searchval} onChange={e => { setSearchval(e.target.value) }}/>
                                <button className="btn btn-danger my-2 my-sm-0" type="submit">Search</button>
                            </form>
                        </nav>
                        <br />
                        {search}
                    </div>
                </div>

            </div>
        </div>
    )
}

export default Course_view;