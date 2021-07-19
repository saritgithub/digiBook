
import React from "react";
import { Component } from "react";
import BookService from "../services/BookService";



class BookComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
                books: []
                
        }

        this.viewBorrow = this.viewBorrow.bind(this);
        this.borrowList = this.borrowList.bind(this);
        

    }
    

    viewBorrow(bookId){
    this.props.history.push({pathname:`/borrow-details/${bookId}`,state :{'bookId':bookId}});
        }

    borrowList(){
        this.props.history.push('/borrows');
        }

    componentDidMount(){
        BookService.getBooks().then((res) => {
            this.setState({ books: res.data});
        });
    
   

    }
    render (){
        return (
            <div>
                <h2 className = "text-center">Book List</h2>
                <div className = "row">
                <button className= "btn btn-primary" onClick= {this.borrowList}> My borrowed books</button>
                </div>
                <br></br>

                <div className = "row">
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> Book Id</th>
                                <th> Book Title</th>
                                <th> Book Description</th>
                                <th> Issuer</th>
                                <th> Date of Issue</th>
                                <th> Category</th>
                                <th> Actions</th>
                            </tr>

                        </thead>
                        <tbody>
                            {
                                this.state.books.map(
                                    book =>
                                    <tr key = {book.id}>
                                        <td> { book.bookId} </td>
                                        <td> { book.bookTitle} </td>
                                        <td> { book.bookDescription} </td>
                                        <td> { book.issuer} </td>
                                        <td> { book.dateOfIssue} </td>
                                        <td> { book.category} </td>
                                        
                                       
                                        
                                        <td>
                                       
                                        <button style={{marginLeft: "10px"}} onClick={ () => {this.viewBorrow(book.bookId)}} className="btn btn-info">Borrow Book </button>
                                        
                                        
                                        </td>
                                        

                                    </tr>
                                )
                            }

                        </tbody>
                    </table>
                </div>
                    
            </div>

        ) 

       }
    
    }

export default BookComponent