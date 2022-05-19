import React from "react";
import {Link, useSearchParams} from "react-router-dom";
import cs01 from './img/course/cs-1.jpg'
import './css/Course.css'
import {faCaretRight, faEnvelope, faHeart} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function Course() {

    const [searchParams] = useSearchParams();


    let CourseCode = searchParams.get("CourseCode")
    let AcademicYear = searchParams.get("AcademicYear")

    return (
        <div className="container-enroll100">
            <div class="row">
                <div class="col-md-1"></div>

                <div class="col-md-10">
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
                                                <h3><a
                                                    href="file:///C:/Users/Mahela/Downloads/Compressed/geniuscoursehtml-10/geniuscoursehtml-10/genius-course-html-upload-package/Genius_course_placeholder/course-details.html#">Fully
                                                    Responsive <b>Web Design &amp; Development.</b></a>
                                                </h3>
                                            </div>
                                            <div className="course-details-content">
                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh
                                                    euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad
                                                    minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut
                                                    aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
                                                    vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla
                                                    facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent
                                                    luptatum zzril delenit augue duis dolore te feugait nulla facilisi.</p>
                                                <p>
                                                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh
                                                    euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad
                                                    minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut
                                                    aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
                                                    vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla
                                                    facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent
                                                    luptatum zzril delenit augue duis dolore te feugait nulla facilisi.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div className="col-md-3">
                                    <div className="side-bar">
                                        <div className="course-side-bar-widget">
                                            <div className="btn btn-danger text-center text-uppercase float-left bold-font box">
                                                Enroll THis course <FontAwesomeIcon icon={faCaretRight} />
                                            </div>
                                        </div>
                                        <div className="enrolled-student">
                                            <div className="student-number bold-font">
                                                250 Enrolled
                                            </div>
                                        </div>
                                        <div className="couse-feature ul-li-block">
                                            <ul>
                                                <li>Lectures <span>20 Lectures</span></li>
                                                <li>Language <span>English, France</span></li>
                                                <li>Video <span>8 Hours</span></li>
                                                <li>Duration <span>30 Days</span></li>
                                                <li>Includes <span>Breakfast</span></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
    )
}

export default Course;