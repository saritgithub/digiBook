
import React, { Component } from 'react';
import BookService from "../services/BookService";

class ViewBookComponent extends Component {
    constructor(props) {
        console.log('111');
        super(props)
        this.state = {
            bookId: this.props.location.state.bookId,
            books: {}
        }

        this.borrowBook = this.borrowBook.bind(this);
    
    }

    componentDidMount(){
        BookService.getBookById(this.state.bookId).then(res => {
            this.setState({ books: res.data});
        })

    }

    borrowBook(bookId){
        this.props.history.push({pathname:`/borrow-details/${bookId}`,state :{'bookId':bookId}});
    }
    render() {
        return (
            <div>
                <br></br>

                <div className = "card col-md-6 offset-md-3">
                <h3 className = "text-center"> Book Details</h3>
                <div className = "card-body">
                    <div className = "row">
                        <label> Book Title: </label>
                            <div> { this.state.books.bookTitle }</div>
                        </div>
                        <div className = "row">
                            <label> Book Description: </label>
                            <div> { this.state.books.bookDescription }</div>
                        </div>
                        <div className = "row">
                            <label> Issuer: </label>
                            <div> { this.state.books.issuer }</div>
                        </div>
                        <div className = "row">
                    <button className="btn btn-primary" onClick={this.borrowBook(this.state.books.bookId)}> Borrow Book</button>
                       </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewBookComponent;

