import axios from "axios";

const BOOK_REST_API_URL = "http://localhost:8080/api/v1/books";

class BookService {

      getBooks() {
        const userId=localStorage.getItem('userId');
      return axios.get(BOOK_REST_API_URL);//+'/user/'+userId);
      
    }

      getBookById(bookId){
      return axios.get(BOOK_REST_API_URL + '/' + bookId);
   }

      
}

export default new BookService()