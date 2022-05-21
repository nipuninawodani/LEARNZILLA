import { faCaretDown } from "@fortawesome/free-solid-svg-icons";
import React, {Component} from "react";
import { Link } from "react-router-dom";
import './Lecture.css'
import LectureService from "../../services/LectureService";
import CourseService from "../../services/CourseService";
import {useState} from "react";


function Lecture_add(){

    const [lecturefile, setLecturefile] = useState(null)
    const [description, setDescription] = useState('');
    const [week, setWeek] = useState('');
    const [academic_year, setAcademic_year] = useState('2021');
    const [course_code, setCourse_code] = useState('GNCT23212');

    const handleSubmit = (e) => {
        e.preventDefault();

        const lecture = {course_code,academic_year,description,week}

        LectureService.createLecture(lecture).then((response) => {
            for(var x = 0; x<lecturefile.length; x++) {
                const data = new FormData()
                data.append('file', lecturefile[x])
                data.append('lecture_id' , response.data)
                LectureService.createLectureResource(data)
                for (var value of data.values()) {
                    console.log(value);
                }
                console.log("Hi")
            }

        }).catch(error =>{
            console.log(error)
        })

    }

    return (
        <div className="container-lecture">
            <div className="wrap-lecture">
                <h2 className="text-center">Add Lecture</h2>

                <form>

                    <div className="mb-3">
                        <label htmlFor="lectureWeek" className="form-label">Week</label>
                        <input type="text" className="form-control" id="lectureWeek" value={week} onChange={e => { setWeek(e.target.value) }}/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="lectureDescription" className="form-label">Lecture Description</label>
                        <textarea className="form-control" id="lectureDescription" value={description} onChange={e => { setDescription(e.target.value) }}/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="lectureFiles" className="form-label">Lecture Files</label>
                        <input className="form-control" type="file" id="lectureFiles" multiple onChange={e => { setLecturefile(e.target.files) }}/>
                    </div>

                    <div className="mb-3">
                        <input className="form-control btn btn-danger" type="button" id="courseButton" value="Submit" onClick={(e) => handleSubmit(e)}/>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default Lecture_add;