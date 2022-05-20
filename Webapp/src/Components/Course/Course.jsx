import React from "react";
import {Link, useSearchParams} from "react-router-dom";
import cs01 from './img/cs-1.jpg'
import './css/Course.css'
import {faCaretRight, faEnvelope, faHeart} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function Course() {

    const [searchParams] = useSearchParams();


    let CourseCode = searchParams.get("CourseCode")
    let AcademicYear = searchParams.get("AcademicYear")
    let weeks = [1,2,3,4,5]


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
                                                    Responsive <b>Web Design &amp; COurse.</b></a>
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
                                                <li>Lectures <span>20 Lectures</span></li>
                                                <li>Language <span>English, France</span></li>
                                                <li>Teacher <span>Mr. A Adikari</span></li>
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
                <div class="col-md-1"></div>
            </div>
        </div>
    )
}

export default Course;