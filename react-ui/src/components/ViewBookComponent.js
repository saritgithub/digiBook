
import React, { Component } from 'react';
import BookService from "../services/BookService";

class ViewBookComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            books: {}
        }
    
    }

    componentDidMount(){
        BookService.getBookById(this.state.bookId).then(res => {
            this.setState({ books: res.data});
        })

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
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewBookComponent;

