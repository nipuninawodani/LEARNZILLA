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
                            <th>Student Name</th>
                            <th>Grade</th>
                        </tr>
                        <tr>
                            <td>Alfreds Futterkiste</td>
                            <td>Maria Anders</td>
                            <td>A+</td>
                        </tr>
                        <tr>
                            <td>Berglunds snabbköp</td>
                            <td>Christina Berglund</td>
                            <td>C-</td>
                        </tr>
                        <tr>
                            <td>Centro comercial Moctezuma</td>
                            <td>Francisco Chang</td>
                            <td>A</td>
                        </tr>
                        <tr>
                            <td>Ernst Handel</td>
                            <td>Roland Mendel</td>
                            <td>A+</td>
                        </tr>
                        <tr>
                            <td>Island Trading</td>
                            <td>Helen Bennett</td>
                            <td>B+</td>
                        </tr>
                        <tr>
                            <td>Königlich Essen</td>
                            <td>Philip Cramer</td>
                            <td>A</td>
                        </tr>
                        <tr>
                            <td>Laughing Bacchus Winecellars</td>
                            <td>Yoshi Tannamuri</td>
                            <td>C</td>
                        </tr>
                        <tr>
                            <td>Magazzini Alimentari Riuniti</td>
                            <td>Giovanni Rovelli</td>
                            <td>C-</td>
                        </tr>
                        <tr>
                            <td>North/South</td>
                            <td>Simon Crowther</td>
                            <td>D</td>
                        </tr>
                        <tr>
                            <td>Paris spécialités</td>
                            <td>Marie Bertrand</td>
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