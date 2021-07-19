import axios from "axios";

const BORROW_REST_API_URL = "http://localhost:8080/api/v1/borrows";

class BorrowService {

      getBorrows(userId) {
            const url = BORROW_REST_API_URL + '/user'+'/' + userId
      return axios.get(url)//+'/user/'+userId);
      
      }

      deleteBorrow(borrowId){
            return axios.put(BORROW_REST_API_URL + '/' + borrowId +"/return");
    
        }

      getBorrowById(borrowId){
            return axios.get(BORROW_REST_API_URL + '/' + borrowId);
         }

      createBorrow(borrow){
            return axios.post(BORROW_REST_API_URL,borrow);
    
        }

}

export default new BorrowService()