import React, { Component } from 'react';
import UserService from '../services/UserService';

class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {userName: '',
                     password: '',
            
    }
    this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
    this.changePasswordHandler = this.changePasswordHandler.bind(this);
    this.resetLoginForm = this.resetLoginForm.bind(this);
}

resetLoginForm = (e) => {
    e.preventDefault();
    let user = {userName: this.state.userName, password: this.state.password};
    console.log('user => ' + JSON.stringify(user));

    UserService.createUsers(user).then(res=>{
        this.props.history.push('/user');
        
    });
}   

changeUsernameHandler= (event) => {
    this.setState({userName:event.target.value});
}

changePasswordHandler= (event) => {
    this.setState({password:event.target.value});
}
    
    render() {
        return (
            <div>
            <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        <h3 className = "text-center"> Login</h3>
                         <div className = "card-body">

                            <form>
                                <div className = "form-group">
                                    <label> Username</label>
                                    <input placeholder="Enter Username" name="userName" className="form-control" 
                                            value={this.state.userName} onChange={this.changeUsernameHandler}/>
                                </div>
                                <div className = "form-group">
                                        <label> Password: </label>
                                        <input placeholder="Enter Password" name="password" className="form-control" 
                                            value={this.state.password} onChange={this.changePasswordHandler}/>
                                    </div>

                                    <button className="btn btn-success" onClick={this.resetLoginForm}>Login</button>

                            </form>

                        </div>



                    </div>

                </div>

            </div>
            
        </div>
    );
  }
}

 
export default Login;