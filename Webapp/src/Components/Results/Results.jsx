import React from "react";
import { Link } from "react-router-dom";
import './Results.css'


function Results() {

    return (
        <div className="container-results">
            <div className="wrap-results">
                <div className="course-title">
                    <span>Course Code - </span> <span>Course Name - </span> <span>Grade</span>
                </div>
                <div id="Result-table-wrapper" >
                    <table id="Result-table" >
                        <tr>
                            <th>Student ID</th>
                            <th>Grade</th>
                        </tr>
                        <tr>
                            <td>SE/2018/001</td>
                            <td>A+</td>
                        </tr>
                        <tr>
                            <td>SE/2018/002</td>
                            <td>C-</td>
                        </tr>
                        <tr>
                            <td>SE/2018/003</td>
                            <td>A</td>
                        </tr>
                        <tr>
                            <td>SE/2018/004</td>
                            <td>A+</td>
                        </tr>
                        <tr>
                            <td>SE/2018/005</td>
                            <td>B+</td>
                        </tr>
                        <tr>
                            <td>SE/2018/006</td>
                            <td>A</td>
                        </tr>
                        <tr>
                            <td>SE/2018/007</td>
                            <td>C</td>
                        </tr>
                        <tr>
                            <td>SE/2018/008</td>
                            <td>C-</td>
                        </tr>
                        <tr>
                            <td>SE/2018/009</td>
                            <td>D</td>
                        </tr>
                        <tr>
                            <td>SE/2018/010</td>
                            <td>AB</td>
                        </tr>
                    </table>

                </div>
                    
   
                <div id="btn-group">
                    <span id="btn-update"><button type="button" class="btn btn-success">Update</button></span>
                    <span id="btn-edit"><button type="button" class="btn btn-warning">Edit</button></span>
                    <span><button type="button" class="btn btn-danger">Cancel</button></span>
                </div>

            </div>
        </div>
    )
}

export default Results;