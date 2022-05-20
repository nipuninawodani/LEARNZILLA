import React, {useEffect, useState} from "react";
import {Link, useSearchParams} from "react-router-dom";
import cs01 from './img/cs-1.jpg'
import './css/Enroll.css'
import {faCaretRight, faEnvelope, faHeart} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import CourseService from "../../services/CourseService";

function Enroll() {

    const [searchParams] = useSearchParams();


    let CourseCode = searchParams.get("CourseCode")
    let AcademicYear = searchParams.get("AcademicYear")

    const [level, setLevel] = useState('');
    const [semester,setSemester] = useState('');
    const [teacher_id,setTeacher_id] = useState('');
    const [title,setTitle] = useState('');
    const [description,setDescription] = useState('');
    const [language,setLanguage] = useState('');

    useEffect(() => {
        CourseService.getCourseByCourseCodeAndAcademicYear(CourseCode,AcademicYear).then(response =>{
            setLevel(response.data.level)
            setSemester(response.data.semester)
            setTeacher_id(response.data.teacher_id)
            setLanguage(response.data.language)
            setTitle(response.data.title)
           setDescription(response.data.description)
        })
    }, []);

    console.log(level)



    return (
        <div className="container-enroll100">
            <div className="row">
                <div className="col-md-1"></div>

                <div className="col-md-10">
                    <div id="enroll-details" className="enroll-details-section">
                        <div className="container">
                            <div className="row">
                                <div className="col-md-9">
                                    <div className="enroll-details-item">
                                        <div className="enroll-single-pic mb30">
                                            <img src="https://learnzillaftp.000webhostapp.com/cs-1.jpg" alt="" />
                                        </div>
                                        <div className="enroll-single-text">
                                            <div className="enroll-title mt10 headline relative-position">
                                                <h3>
                                                    <b>{title}</b>
                                                </h3>
                                            </div>
                                            <div className="enroll-details-content">
                                                <p>{description}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div className="col-md-3">
                                    <div className="side-bar">
                                        <div className="enroll-side-bar-widget">
                                            <div className="btn btn-danger text-center text-uppercase float-left bold-font box">
                                                Enroll In This Course <FontAwesomeIcon icon={faCaretRight} />
                                            </div>
                                        </div>
                                        <div className="enrolled-student">
                                            <div className="student-number bold-font">
                                                250 Enrolled
                                            </div>
                                        </div>
                                        <div className="couse-feature ul-li-block">
                                            <ul>
                                                <li>Level <span>{level}</span></li>
                                                <li>Semester <span>{semester}</span></li>
                                                <li>Lectures <span>20 Lectures</span></li>
                                                <li>Language <span>{language}</span></li>
                                                <li>Teacher <span>Mr. A Adikari</span></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="col-md-1"></div>
            </div>
        </div>
    )
}

export default Enroll;