import React, { Component } from 'react';
import BookService from '../services/BookService';
import BorrowService from "../services/BorrowService";


class BorrowDetailsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            bookId: this.props.location.state.bookId,
            books: {}

        }
        this.createBorrow = this.createBorrow.bind(this);
        this.cancel = this.cancel.bind(this);
    
    }
    createBorrow(takenDate,bookId){
        let borrow = {takenDate: takenDate, bookId: bookId, userId:localStorage.getItem('userId')};
        console.log(borrow);
        BorrowService.createBorrow(borrow).then( res => {
            this.setState({borrows: this.state.borrows});
            this.props.history.push('/borrows');
        });
    }

    componentDidMount(){
        BookService.getBookById(this.state.bookId).then(res => {
            this.setState({ books: res.data});
        })

    }
    cancel(){
        this.props.history.push('/books');
    }

        
    render() {
        return (
            <div>
                <br></br>

                <div className = "card col-md-6 offset-md-3">
                <h3 className = "text-center"> Borrow This Book</h3>
                <div className = "card-body">
                        <div className = "row">
                        <label><strong> Book Title:&nbsp;&nbsp;</strong></label>
                            <div> { this.state.books.bookTitle }</div>
                        </div>
                        <div className = "row">
                        <label><strong> Book Description:&nbsp;&nbsp;</strong> </label>
                            <div> { this.state.books.bookDescription }</div>
                        </div>
                        <div className = "row">
                        <label><strong> Issuer: &nbsp;&nbsp;</strong></label>
                            <div> { this.state.books.issuer }</div>
                        </div>
                        <div className = "row">
                        <label><strong> Date of Issue:&nbsp;&nbsp; </strong></label>
                            <div> { this.state.books.dateOfIssue }</div>
                        </div>
                        <div className = "row">
                        <label> <strong>Category: &nbsp;&nbsp;</strong></label>
                            <div> { this.state.books.category }</div>
                        </div>

                        <div className= "text-center"><br></br>
                        <button className="btn btn-success"  onClick={()=>{this.createBorrow(new Date(),this.state.books.bookId)}}>Borrow</button>
                        <button className="btn btn-danger" onClick={this.cancel} style={{marginLeft: "10px"}}>Cancel</button>
                        </div>
                        
                    </div>

                </div>
            </div>
        )
    }
}

export default BorrowDetailsComponent;