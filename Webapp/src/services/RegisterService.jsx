import axios from 'axios'

const config = {
    headers: {
        Authorization: "Bearer " + localStorage.getItem("Token")
    }
}

const REGISTER_BASE_REST_API_URL='http://localhost:8080/signup/student'

class RegisterService{

    createStudent(student){
        return axios.post(REGISTER_BASE_REST_API_URL,student)
    }
}

export default new RegisterService();