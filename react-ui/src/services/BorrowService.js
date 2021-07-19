import axios from "axios";

const BORROW_REST_API_URL = "http://localhost:8080/api/v1/borrows";

class BorrowService {

      getBorrows() {
      return axios.get(BORROW_REST_API_URL);
      
      }

      deleteBorrow(borrowId){
            return axios.delete(BORROW_REST_API_URL + '/' + borrowId);
    
        }

      getBorrowById(borrowId){
            return axios.get(BORROW_REST_API_URL + '/' + borrowId);
         }
}

export default new BorrowService()