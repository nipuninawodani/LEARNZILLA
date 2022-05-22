import React, {useCallback} from "react";
import {Link, useSearchParams} from "react-router-dom";
import cs01 from './img/cs-1.jpg'
import './css/Course.css'
import {faCaretRight, faEnvelope, faHeart} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {useEffect, useState} from "react";
import CourseService from "../../services/CourseService";
import TeacherService from "../../services/TeacherService";
import LectureService from "../../services/LectureService";
import RegisterService from "../../services/RegisterService";
import EnrollmentService from "../../services/EnrollmentService";

function Course() {

    const [searchParams] = useSearchParams();


    let CourseCode = searchParams.get("CourseCode")
    let AcademicYear = searchParams.get("AcademicYear")

    const [level, setLevel] = useState('');
    const [semester,setSemester] = useState('');
    const [title,setTitle] = useState('');
    const [description,setDescription] = useState('');
    const [language,setLanguage] = useState('');
    const [previewImg, setPreviewImg] = useState('');
    const [lectures, setLectures] = useState([]);
    const [accordian, setAccordian] = useState([]);

    const [teachername, setTeachername] = useState('');

    useEffect(() => {
        CourseService.getCourseByCourseCodeAndAcademicYear(CourseCode,AcademicYear).then(response =>{
            setLevel(response.data.level)
            setSemester(response.data.semester)
            setLanguage(response.data.language)
            setTitle(response.data.title)
            setDescription(response.data.description)
            setPreviewImg(response.data.previewImg)

            TeacherService.getTeacherById(response.data.teacher_id).then(response =>{
                setTeachername(response.data.firstName +" "+response.data.lastName)
            })

            EnrollmentService.getGrade(CourseCode,AcademicYear,localStorage.getItem("UserID"))

            LectureService.getLectureByCourse(CourseCode,AcademicYear).then(response =>{

                response.data.map(({description:Ldescription, title: Ltitle,lectureid}) =>
                    LectureService.getLectureResource(lectureid).then((responseL) => {

                        setAccordian(response.data.map(({description:Ldescription, title: Ltitle,lectureid}) =>

                            <div className="accordion-item">
                                <h2 className="accordion-header" id={'heading'+ lectureid}>
                                    <button className="accordion-button collapsed" type="button"
                                            data-bs-toggle="collapse" data-bs-target={'#collapse' +lectureid}
                                            aria-expanded="false" aria-controls={'collapse' +lectureid}>
                                        {Ltitle}
                                    </button>
                                </h2>
                                <div id={'collapse' +lectureid} className="accordion-collapse collapse"
                                     aria-labelledby={'heading'+ lectureid} data-bs-parent="#accordionExample">
                                    <div className="accordion-body">
                                        {Ldescription}<br/>
                                        <div>
                                            Resources:
                                            <ul>
                                                {responseL.data.map(({resource,filename}) =>
                                                    <li><a href={resource}>{filename}</a></li>
                                                )
                                                }
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))

                    }).catch(error =>{
                        console.log(error)
                    })
                )
            })
        })
    }, []);

    return (
        <div className="container-course100">
            <div className="row">
                <div className="col-md-1"></div>

                <div className="col-md-10">
                    <div id="course-details" className="course-details-section">
                        <div className="container">
                            <div className="row">
                                <div className="col-md-9">
                                    <div className="course-details-item">
                                        <div className="course-single-pic mb30">
                                            <img src={previewImg} alt="" width="870px" height="400px"/>
                                        </div>
                                        <div className="course-single-text">
                                            <div className="course-title mt10 headline relative-position">
                                                <h3>
                                                    <b>{title}</b>
                                                </h3>
                                            </div>
                                            <div className="course-details-content">
                                                <p>{description}</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div className="accordion" id="CourseAccordion">
                                        <div className="accordion-item">
                                            <h2 className="accordion-header" id="headingOne">
                                                <button className="accordion-button" type="button"
                                                        data-bs-toggle="collapse" data-bs-target="#collapseOne"
                                                        aria-expanded="true" aria-controls="collapseOne">
                                                    Announcements
                                                </button>
                                            </h2>
                                            <div id="collapseOne" className="accordion-collapse collapse show"
                                                 aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                                <div className="accordion-body">
                                                    Announcements
                                                </div>
                                            </div>
                                        </div>
                                        {accordian}
                                    </div>

                                </div>

                                <div className="col-md-3">
                                    <div className="side-bar">
                                        <div className="couse-feature ul-li-block">
                                            <ul>
                                                <li>Level <span>{level}</span></li>
                                                <li>Semester <span>{semester}</span></li>
                                                <li>Lectures <span>20 Lectures</span></li>
                                                <li>Language <span>{language}</span></li>
                                                <li>Teacher <span>Mr. {teachername}</span></li>
                                                <li>Status <span>On Going</span></li>
                                                <li>Grade <span>N/A</span></li>
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

export default Course;