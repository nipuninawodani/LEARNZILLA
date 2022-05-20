import { faCaretDown } from "@fortawesome/free-solid-svg-icons";
import React from "react";
import { Link } from "react-router-dom";
import './Course_Teacher.css'


function Course_add() {

    return (
        <div className="container-course_teacher">
            <div className="wrap-course_teacher">
                <h2 className="text-center">Add Course</h2>

                <form>
                    <div className="mb-3">
                        <label htmlFor="courseTitle" className="form-label">Course Title</label>
                        <input type="email" className="form-control" id="courseTitle"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseDescription" className="form-label">Course Description</label>
                        <textarea className="form-control" id="courseDescription"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseCode" className="form-label">Course Code</label>
                        <input type="text" className="form-control" id="courseCode"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseAcademicYear" className="form-label">Course Academic Year</label>
                        <input type="text" className="form-control" id="courseAcademicYear"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseLanguage" className="form-label">Course Language</label>
                        <input type="text" className="form-control" id="courseLanguage"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseLevel" className="form-label">Course Level</label>
                        <input type="text" className="form-control" id="courseLevel"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseSemester" className="form-label">Course Semester</label>
                        <input type="text" className="form-control" id="courseSemester"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseFile" className="form-label">Preview Image</label>
                        <input className="form-control" type="file" id="courseFile" />
                    </div>

                    <div className="mb-3">
                        <input className="form-control btn btn-danger" type="button" id="courseButton" value="Submit"/>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default Course_add;