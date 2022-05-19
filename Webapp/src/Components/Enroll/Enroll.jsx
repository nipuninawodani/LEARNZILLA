import React from "react";
import {Link, useSearchParams} from "react-router-dom";
import cs01 from './img/cs-1.jpg'
import './css/Enroll.css'
import {faCaretRight, faEnvelope, faHeart} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function Enroll() {

    const [searchParams] = useSearchParams();


    let enrollCode = searchParams.get("enrollCode")
    let AcademicYear = searchParams.get("AcademicYear")

    return (
        <div className="container-enroll100">
            <div class="row">
                <div class="col-md-1"></div>

                <div class="col-md-10">
                    <div id="enroll-details" className="enroll-details-section">
                        <div className="container">
                            <div className="row">
                                <div className="col-md-9">
                                    <div className="enroll-details-item">
                                        <div className="enroll-single-pic mb30">
                                            <img src={cs01} alt="" />
                                        </div>
                                        <div className="enroll-single-text">
                                            <div className="enroll-title mt10 headline relative-position">
                                                <h3><a
                                                    href="file:///C:/Users/Mahela/Downloads/Compressed/geniusenrollhtml-10/geniusenrollhtml-10/genius-enroll-html-upload-package/Genius_enroll_placeholder/enroll-details.html#">Fully
                                                    Responsive <b>Web Design &amp; Development.</b></a>
                                                </h3>
                                            </div>
                                            <div className="enroll-details-content">
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
                                        <div className="enroll-side-bar-widget">
                                            <div className="btn btn-danger text-center text-uppercase float-left bold-font box">
                                                Enroll THis enroll <FontAwesomeIcon icon={faCaretRight} />
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
                                                <li>Teacher <span>Mr. A Adikari</span></li>
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

export default Enroll;