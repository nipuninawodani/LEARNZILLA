import { faCaretDown } from "@fortawesome/free-solid-svg-icons";
import React from "react";
import { Link } from "react-router-dom";
import './Lecture.css'


function Lecture_add() {

    return (
        <div className="container-lecture">
            <div className="wrap-lecture">
                <h2 className="text-center">Add Lecture</h2>

                <form>

                    <div className="mb-3">
                        <label htmlFor="lectureWeek" className="form-label">Week</label>
                        <input type="text" className="form-control" id="lectureWeek"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="lectureDescription" className="form-label">Lecture Description</label>
                        <textarea className="form-control" id="lectureDescription"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="lectureFiles" className="form-label">Lecture Files</label>
                        <input className="form-control" type="file" id="lectureFiles" multiple/>
                    </div>

                    <div className="mb-3">
                        <input className="form-control btn btn-danger" type="button" id="courseButton" value="Submit"/>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default Lecture_add;