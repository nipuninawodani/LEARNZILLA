import axios from 'axios'

const COURSE_BASE_REST_API_URL='http://localhost:8080/course'

class CourseService{

    createCourse(course){
        return axios.post(COURSE_BASE_REST_API_URL,course)
    }

    getCourseById(id){
        return axios.post(COURSE_BASE_REST_API_URL+"/"+id)
    }

    getCourseByCourseCodeAndAcademicYear(coursecode,academicyear){
        console.log(COURSE_BASE_REST_API_URL+"/get/"+coursecode+"&"+academicyear)
        return axios.get(COURSE_BASE_REST_API_URL+"/get/"+coursecode+"&"+academicyear)
    }
}

export default new CourseService();