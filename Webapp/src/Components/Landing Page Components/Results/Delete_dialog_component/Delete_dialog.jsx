import React from "react";
import { Link } from "react-router-dom";
import './Delete_dialog.css'


function Delete_dialog() {

    return (
        <div className="container-delete">
            <div className="wrap-delete">
                <div id="title-question">
                    <p>Are you sure you want to delete?</p>
                </div>
                <div id="btn-group">
                    <span id="btn-edit"><button type="button" class="btn btn-success">Yes</button></span>
                    <span id="btn-cancel"><button type="button" class="btn btn-danger">No</button></span>
                </div>
            </div>
        </div>
    )
}

export default Delete_dialog;