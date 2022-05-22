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
        let request = axios.get("http://localhost:8080/learnzilla/student/"+login.email , config)

        if (request != null){
            request.then(response =>{
                console.log(response.data)
                localStorage.setItem("UserID",response.data.id)
                localStorage.setItem("Type","Student")
                console.log(localStorage.getItem("UserID"))
            })
        }

        else{
            let request2 = axios.get("http://localhost:8080/learnzilla/teacher/"+login.email , config)!=null

            request2.then(response =>{
                localStorage.setItem("UserID",response.data.id)
                localStorage.setItem("Type","Teacher")
            })

        }
    }



}

export default new RegisterService();