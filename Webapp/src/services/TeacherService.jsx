import axios from 'axios'

const COURSE_BASE_REST_API_URL='http://localhost:8080/'

class TeacherService{

    createTeacher(teacher){
        return axios.post(COURSE_BASE_REST_API_URL,teacher)
    }

    getTeacherById(id){
        return axios.get(COURSE_BASE_REST_API_URL+"teacher/id/"+id)
    }

}

export default new TeacherService();