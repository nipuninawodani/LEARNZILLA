import React from "react";
import {Link, useSearchParams} from "react-router-dom";
import cs01 from './img/cs-1.jpg'
import './css/Course.css'
import {faCaretRight, faEnvelope, faHeart} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {useEffect, useState} from "react";
import CourseService from "../../services/CourseService";
import TeacherService from "../../services/TeacherService";

function Course() {

    const [searchParams] = useSearchParams();


    let CourseCode = searchParams.get("CourseCode")
    let AcademicYear = searchParams.get("AcademicYear")
    let weeks = [1,2,3,4,5]

    const [level, setLevel] = useState('');
    const [semester,setSemester] = useState('');
    const [teacher_id,setTeacher_id] = useState('');
    const [title,setTitle] = useState('');
    const [description,setDescription] = useState('');
    const [language,setLanguage] = useState('');

    const [teachername, setTeachername] = useState('');

    useEffect(() => {
        CourseService.getCourseByCourseCodeAndAcademicYear(CourseCode,AcademicYear).then(response =>{
            setLevel(response.data.level)
            setSemester(response.data.semester)
            setTeacher_id(response.data.teacher_id)
            setLanguage(response.data.language)
            setTitle(response.data.title)
            setDescription(response.data.description)

            console.log(teacher_id)

            TeacherService.getTeacherById(teacher_id).then(response =>{
                setTeachername(response.data.firstName +" "+response.data.lastName)
            })
        })
    }, []);


    const accordian = weeks.map((week) =>
        <div className="accordion-item">
            <h2 className="accordion-header" id={'heading'+ week}>
                <button className="accordion-button collapsed" type="button"
                        data-bs-toggle="collapse" data-bs-target={'#collapse' +week}
                        aria-expanded="false" aria-controls={'collapse' +week}>
                    Week #{week}
                </button>
            </h2>
            <div id={'collapse' +week} className="accordion-collapse collapse"
                 aria-labelledby={'heading'+ week} data-bs-parent="#accordionExample">
                <div className="accordion-body">
                    <strong>This is the {week} item's accordion body.</strong> It is
                    hidden by default, until the collapse plugin adds the appropriate
                    classes that we use to style each element. These classes control the
                    overall appearance, as well as the showing and hiding via CSS
                    transitions. You can modify any of this with custom CSS or
                    overriding our default variables. It's also worth noting that just
                    about any HTML can go within the <code>.accordion-body</code>,
                    though the transition does limit overflow.
                </div>
            </div>
        </div>
    );

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
                                            <img src={cs01} alt="" />
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