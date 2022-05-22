import axios from 'axios'

const config = {
    headers: {
        Authorization: "Bearer " + localStorage.getItem("Token")
    }
}

const LOGIN_BASE_REST_API_URL='http://localhost:8080/login/student'

class RegisterService{

    Login(login){
        return axios.post(LOGIN_BASE_REST_API_URL,login)
    }

    GetUser(login){
        let request = axios.get("http://localhost:8080/learnzilla/student/"+login.email , config)!=null

        if (request != null){
            localStorage.setItem("UserID",request.data.id)
            localStorage.setItem("Type","Student")
        }

        else{
            let request2 = axios.get("http://localhost:8080/learnzilla/teacher/"+login.email , config)!=null

            localStorage.setItem("UserID",request.data.id)
            localStorage.setItem("Type","Teacher")

        }
    }



}

export default new RegisterService();