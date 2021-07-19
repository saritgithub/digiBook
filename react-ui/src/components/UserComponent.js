
import React from "react";
import { Component } from "react";
import UserService from "../services/UserService";

class UserComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
                users: []
        }
    
    }

    componentDidMount(){
        UserService.getUsers().then((res) => {
            this.setState({ users: res.data});
        });

    }

    register() {
        this.props.history.push('/register');
    }
    login() {
        this.props.history.push('/login');
    }
    render (){
        return (
            <div>
                <h2 className = "text-center">Users List</h2>
                <div className = "row">
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> User Id</th>
                                <th> First Name</th>
                                <th> Last Name</th>
                                <th> Street</th>
                                <th> City</th>
                                <th> Country</th>
                                <th> Zipcode</th>
                                <th> Telephone</th>
                                <th> email</th>
                                <th> password</th>
                                <th> Joined Date</th>
                                <th> Actions</th>
                            </tr>

                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user =>
                                    <tr key = {user.id}>
                                        <td> { user.userId} </td>
                                        <td> { user.firstName} </td>
                                        <td> { user.lastName} </td>
                                        <td> { user.street} </td>
                                        <td> { user.city} </td>
                                        <td> { user.country} </td>
                                        <td> { user.zipcode} </td>
                                        <td> { user.telephone} </td>
                                        <td> { user.email} </td>
                                        <td> { user.userName} </td>
                                        <td> { user.password} </td>
                                        <td> { user.JoinedDate} </td>

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

export default UserComponent