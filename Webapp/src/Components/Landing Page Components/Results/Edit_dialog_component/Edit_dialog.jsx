import React from "react";
import { Link } from "react-router-dom";
import './Edit_dialog.css'


function Edit_dialog() {

    return (
        <div className="container-edit">
            <div className="wrap-edit">
                <div id="title-question">
                    <p>Are you sure you want to edit this result?</p>
                </div>
                <div id="btn-group">
                    <span id="btn-edit"><button type="button" class="btn btn-success">Edit</button></span>
                    <span id="btn-cancel"><button type="button" class="btn btn-danger">Cancel</button></span>
                </div>
            </div>
        </div>
    )
}

export default Edit_dialog;