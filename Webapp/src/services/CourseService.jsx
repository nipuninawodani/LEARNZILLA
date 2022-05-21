import axios from 'axios'

const COURSE_BASE_REST_API_URL='http://localhost:8080/course'

class CourseService{

    createCourse(course){
       return axios.post(COURSE_BASE_REST_API_URL,course)

    }

    uploadPreviewImg(data,course_id){

        data.append("course_id",course_id)

        axios.post(COURSE_BASE_REST_API_URL + "/file", data, {
        })
        .then(res => { // then print response status
            console.log(res.statusText)
        })

    }

    getCourseById(id){
        return axios.post(COURSE_BASE_REST_API_URL+"/"+id)
    }

    getCourseByCourseCodeAndAcademicYear(coursecode,academicyear){
        return axios.get(COURSE_BASE_REST_API_URL+"/get/"+coursecode+"&"+academicyear)
    }

    getCourseByName(name){
        return axios.get(COURSE_BASE_REST_API_URL+"/name="+name)
    }
}

export default new CourseService();