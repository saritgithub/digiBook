import axios from "axios";

const BOOK_REST_API_URL = "http://localhost:8080/api/v1/books";

class BookService {

      getBooks() {
      return axios.get(BOOK_REST_API_URL);
      
    }

      getBookById(bookId){
      return axios.get(BOOK_REST_API_URL + '/' + bookId);
   }

      
}

export default new BookService()