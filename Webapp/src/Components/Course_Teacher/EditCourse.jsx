import { faCaretDown } from "@fortawesome/free-solid-svg-icons";
import React from "react";
import { Link } from "react-router-dom";
import './Course_Teacher.css'
import {useState} from "react";
import CourseService from "../../services/CourseService";


function Course_edit() {

    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [course_code, setCourse_code] = useState('');
    const [academic_year, setAcademic_year] = useState('');
    const [level, setLevel] = useState('');
    const [semester, setSemester] = useState('');
    const [language, setLanguage] = useState('');
    const [teacher_id, setTeacher_id] = useState('1');

    const handleSubmit = (e) => {
        e.preventDefault();

        const course = {title,description,course_code,academic_year,level,semester,language,teacher_id}

        CourseService.createCourse(course).then((response) => {

            console.log(response.data)

        }).catch(error =>{
            console.log(error)
        })
    }

    return (
        <div className="container-course_teacher">
            <div className="wrap-course_teacher">
                <h2 className="text-center">Edit Course ID: ID</h2>

                <form>
                    <div className="mb-3">
                        <label htmlFor="courseCode" className="form-label">Course Code</label>
                        <input type="text" className="form-control" id="courseCode" value="CourseCode" disabled/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseAcademicYear" className="form-label">Course Academic Year</label>
                        <input type="text" className="form-control" id="courseAcademicYear" value="AcademicYear" disabled/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseTitle" className="form-label">Course Title</label>
                        <input type="email" className="form-control" id="courseTitle" value={title} onChange={e => { setTitle(e.target.value) }}/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseDescription" className="form-label">Course Description</label>
                        <textarea className="form-control" id="courseDescription" value={description} onChange={e => { setDescription(e.target.value) }}/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseLanguage" className="form-label">Course Language</label>
                        <input type="text" className="form-control" id="courseLanguage" value={language} onChange={e => { setLanguage(e.target.value) }}/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseLevel" className="form-label">Course Level</label>
                        <input type="text" className="form-control" id="courseLevel" value={level} onChange={e => { setLevel(e.target.value) }}/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="courseSemester" className="form-label">Course Semester</label>
                        <input type="text" className="form-control" id="courseSemester" value={semester} onChange={e => { setSemester(e.target.value) }}/>
                    </div>

                    <div className="mb-3">
                        <input className="form-control btn btn-danger" type="button" id="courseButton" value="Submit" onClick={(e) => handleSubmit(e)}/>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default Course_edit;