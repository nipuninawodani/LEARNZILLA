import axios from 'axios'

const config = {
    headers: {
        Authorization: "Bearer " + localStorage.getItem("Token")
    }
}

const TEACHER_BASE_REST_API_URL='http://localhost:8080/'

class TeacherService{

    createTeacher(teacher){
        return axios.post(TEACHER_BASE_REST_API_URL,teacher,config)
    }

    getTeacherById(id){
        return axios.get(TEACHER_BASE_REST_API_URL+"learnzilla/teacher/id/"+id,config)
    }

}

export default new TeacherService();