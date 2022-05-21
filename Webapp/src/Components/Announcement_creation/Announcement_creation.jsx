import React from "react";
import { Link } from "react-router-dom";
import "./Announcement_creation.css"


function Announcement_creation() {

    return (
        <div className="container-course_creation">
            <div className="wrap-course_creation">
                <h4>Create An Announcement</h4>

                <div>
                    <form>
                        <div class="form-group">
                            <label for="announcemnet-title">Announcement title</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" />
                        </div>
                        <br />
                        <div class="form-group">
                            <label for="announcemnet-body">Announcement body</label>
                            <textarea class="form-control" rows="5"></textarea>
                        </div>
                        <br />
                        <div class="form-group">
                            <label for="Announcement_files"> Select a file </label>
                            <input type="file" class="form-control-file" />
                        </div>
                        <br />
                        <button type="submit" class="btn btn-danger">Send Announcement</button>
                    </form>
                </div>

            </div>

        </div>
    )
}

export default Announcement_creation;