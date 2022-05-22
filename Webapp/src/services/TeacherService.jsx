import axios from 'axios'

const TEACHER_BASE_REST_API_URL='http://localhost:8080/'

class TeacherService{

    createTeacher(teacher){
        return axios.post(TEACHER_BASE_REST_API_URL,teacher)
    }

    getTeacherById(id){
        return axios.get(TEACHER_BASE_REST_API_URL+"learnzilla/teacher/id/"+id)
    }

}

export default new TeacherService();