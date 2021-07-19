import React, { Component } from 'react';
import BorrowService from "../services/BorrowService";



class BorrowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            borrows: [] 
              
        }

        this.deleteBorrow = this.deleteBorrow.bind(this);
    
    }

    deleteBorrow(borrowId){
        BorrowService.deleteBorrow(borrowId).then( res => {
            this.setState({borrows: this.state.borrows.filter(borrow => borrow.borrowId !== borrowId)});
        });
    }



    componentDidMount(){
        BorrowService.getBorrows().then((res) => {
            this.setState({ borrows: res.data});
        });

    }
    render() {
        return (
            <div>
            <h2 className = "text-center">List of Borrow Books</h2>
            <div className = "row">
                <table className = "table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th> Borrow Id</th>
                            <th> Taken Date</th>
                            <th> Book Title</th>
                            <th> Actions</th>
                            
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.borrows.map(
                                borrow =>
                                
                                <tr key = {borrow.id}>
                                    <td> { borrow.borrowId} </td>
                                    <td> { borrow.takenDate} </td>
                                    <td> { borrow.bookTitle} </td>
                                    
                                    <td>
                                    <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBorrow(borrow.borrowId)} className="btn btn-danger">Return Book </button>
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

export default BorrowComponent;