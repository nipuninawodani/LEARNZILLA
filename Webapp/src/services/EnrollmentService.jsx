import axios from 'axios'

const config = {
    headers: {
        Authorization: "Bearer " + localStorage.getItem("Token")
    }
}

const COURSE_BASE_REST_API_URL='http://localhost:8080/enrollment/learnzilla'

class EnrollmentService {

    createEnrollment(enrollment) {
        return axios.post(COURSE_BASE_REST_API_URL, enrollment,config)

    }

    getEnrollmentByStudent(studentId) {
        return axios.get(COURSE_BASE_REST_API_URL +"/get/student_id="+ studentId,config)

    }

    getGrade(course_code,academic_year,student_id){
        return axios.get("/enrollment/check/course_code="+course_code+"&academic_year="+academic_year+"&student_id="+student_id,config)
    }
}

export default new EnrollmentService();


