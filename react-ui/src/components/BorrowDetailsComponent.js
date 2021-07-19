import React, { Component } from 'react';
import BorrowService from "../services/BorrowService";

class BorrowDetailsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            borrows: {}

        }
    
    }

    componentDidMount(){
        BorrowService.getBorrowById(this.state.borrowId).then(res => {
            this.setState({ borrows: res.data});
        })

    }

        
    render() {
        return (
            <div>
                <br></br>

                <div className = "card col-md-6 offset-md-3">
                <h3 className = "text-center"> Borrow Details</h3>
                <div className = "card-body">
                    
    
                    </div>

                </div>
            </div>
        )
    }
}

export default BorrowDetailsComponent;