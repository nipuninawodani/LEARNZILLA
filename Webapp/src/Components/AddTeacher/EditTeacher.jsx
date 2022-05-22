import { faCaretDown } from "@fortawesome/free-solid-svg-icons";
import React from "react";
import { Link } from "react-router-dom";
import './Course_Teacher.css'


function Teacher_edit() {

    return (
        <div className="container-course_teacher">
            <div className="wrap-course_teacher">
                <h2 className="text-center">Edit Teacher</h2>

                <form>
                    <div className="mb-3">
                        <label htmlFor="courseCode" className="form-label">Teacher ID </label>
                        <input type="text" className="form-control" id="courseCode" value="TeacherID" disabled/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="firstName" className="form-label">Firstname</label>
                        <input type="text" className="form-control" id="firstName"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="lastName" className="form-label">Lastname</label>
                        <input type="text" className="form-control" id="lastName"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="email" className="form-label">Email</label>
                        <input type="email" className="form-control" id="email"/>
                    </div>

                    <div className="mb-3">
                        <input className="form-control btn btn-danger" type="button" id="courseButton" value="Submit"/>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default Teacher_edit;