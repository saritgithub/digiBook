import React, { Component } from 'react';
import UserService from '../services/UserService';

class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {email: '',
                     password: '',
            
    }
    this.changeEmailHandler = this.changeEmailHandler.bind(this);
    this.changePasswordHandler = this.changePasswordHandler.bind(this);
    this.resetLoginForm = this.resetLoginForm.bind(this);
}

resetLoginForm = (e) => {
    e.preventDefault();
    let user = {email: this.state.email, password: this.state.password};
    //console.log('user => ' + JSON.stringify(user));

    UserService.loginUser(user).then(res=>{
        console.log(res);
        localStorage.setItem('userId',res.data.userId);
        this.props.history.push('/books');
        
    });
}   

changeEmailHandler= (event) => {
    this.setState({email:event.target.value});
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
                                    <label> Email</label>
                                    <input placeholder="Enter Email" name="email" className="form-control" 
                                            value={this.state.email} onChange={this.changeEmailHandler}/>
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