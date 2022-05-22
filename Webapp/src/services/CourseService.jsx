import axios from 'axios'

const COURSE_BASE_REST_API_URL='http://localhost:8080/course'

const config = {
    headers: {
        Authorization: "Bearer " + localStorage.getItem("Token")
    }
}


class CourseService{

    createCourse(course){
       return axios.post(COURSE_BASE_REST_API_URL,course,config)

    }

    uploadPreviewImg(data,course_id){

        data.append("course_id",course_id)

        axios.post(COURSE_BASE_REST_API_URL + "/file", data,config)
        .then(res => { // then print response status
            console.log(res.statusText)
        })

    }

    getCourseById(id){
        return axios.get(COURSE_BASE_REST_API_URL+"/"+id,config)
    }

    getCourseByCourseCodeAndAcademicYear(coursecode,academicyear){
        return axios.get(COURSE_BASE_REST_API_URL+"/get/"+coursecode+"&"+academicyear,config)
    }

    getCourseByName(name){
        return axios.get(COURSE_BASE_REST_API_URL+"/name="+name ,config)
    }
}

export default new CourseService();