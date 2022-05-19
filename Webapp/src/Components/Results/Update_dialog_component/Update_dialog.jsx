import React from "react";
import { Link } from "react-router-dom";
import './Update_dialog.css'


function Update_dialog() {

    return (
        <div className="container-update">
            <div className="wrap-update">
                <div id="title-question">
                    <p>Are you sure you want to update this result?</p>
                </div>
                <div id="btn-group">
                    <span id="btn-update"><button type="button" class="btn btn-success">Update</button></span>
                    <span id="btn-cancel"><button type="button" class="btn btn-danger">Cancel</button></span>
                </div>
            </div>
        </div>
    )
}

export default Update_dialog;