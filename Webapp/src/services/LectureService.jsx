import axios from 'axios'

const LECTURE_BASE_REST_API_URL='http://localhost:8080/'

class LectureService{

    createLecture(lecture){
        return axios.post(LECTURE_BASE_REST_API_URL+"lecture",lecture)
    }

    createLectureResource(data,lecture_id){
        axios.post(LECTURE_BASE_REST_API_URL + "lectureResource", data, {
        })
            .then(res => { // then print response status
                console.log(res.statusText)
            })
    }

    getLectureByCourse(course_code,academic_year){
       return axios.get(LECTURE_BASE_REST_API_URL+"lecture/get/course_code="+course_code+"&academic_year="+academic_year)
    }

    getLectureResource(lectureid){
       return axios.get(LECTURE_BASE_REST_API_URL+"getLectureResource/lecture_id="+lectureid)
    }
}

export default new LectureService();