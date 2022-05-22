import React, {useEffect, useState} from "react";
import {Link, useSearchParams} from "react-router-dom";
import './css/Enroll.css'
import {faCaretRight, faEnvelope, faHeart} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import CourseService from "../../services/CourseService";
import TeacherService from "../../services/TeacherService";
import EnrollmentService from "../../services/EnrollmentService";
import { useNavigate } from "react-router-dom";

function Enroll() {

    const [searchParams] = useSearchParams();
    const navigate = useNavigate;


    let CourseCode = searchParams.get("CourseCode")
    let AcademicYear = searchParams.get("AcademicYear")
    //let StudentId = localStorage.getItem('UserId')
    let StudentId = "1";

    const [level, setLevel] = useState('');
    const [semester,setSemester] = useState('');
    const [title,setTitle] = useState('');
    const [description,setDescription] = useState('');
    const [language,setLanguage] = useState('');
    const [teachername, setTeachername] = useState('');

    useEffect(() => {
        CourseService.getCourseByCourseCodeAndAcademicYear(CourseCode,AcademicYear).then(response =>{
            setLevel(response.data.level)
            setSemester(response.data.semester)
            setLanguage(response.data.language)
            setTitle(response.data.title)
            setDescription(response.data.description)

            TeacherService.getTeacherById(response.data.teacher_id).then(response =>{
                setTeachername(response.data.firstName +" "+response.data.lastName)
            })

        })
    }, []);

    const handleenroll = (e) => {
        e.preventDefault();

        const enroll = {CourseCode,AcademicYear,StudentId}
        EnrollmentService.createEnrollment(enroll).then((response) => {
            navigate("/Student_Home")
        }).catch(error =>{
            console.log(error)
        })

    }



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
                                            <div className="btn btn-danger text-center text-uppercase float-left bold-font box" onClick={(e) => handleenroll(e)}>
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
                                                <li>Teacher <span>{teachername}</span></li>
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