import axios from "axios";

const USER_REST_API_URL = "http://localhost:8080/api/v1/users";

class UserService {

    getUsers() {
      return axios.get(USER_REST_API_URL);
    }

    async createUsers(user){
        return axios.post(USER_REST_API_URL,user);
      
    }
    async loginUser(user){
      return axios.post(USER_REST_API_URL,user);
    }

}

export default new UserService()