import axios from 'axios'

const COURSE_BASE_REST_API_URL='http://localhost:8080/enrollment'

class EnrollmentService {

    createEnrollment(enrollment) {
        return axios.post(COURSE_BASE_REST_API_URL, enrollment)

    }

    getEnrollmentByStudent(studentId) {
        return axios.get(COURSE_BASE_REST_API_URL +"/get/student_id="+ studentId)

    }
}

export default new EnrollmentService();


