import React, { Component } from 'react';
import {navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';


class HeaderComponents extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }
    render() {
        return (
            <div>
                <header>
                    
                    
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                
                    <div><a href="https://digibook.com" className="navbar-brand">digiBook App</a></div>
                </nav>
                <nav className="navbar-right">
                        <Link to={"/register"} className="nav-link">Register</Link>
                        <Link to={"/login"} className="nav-link">Login</Link>       
                </nav>
                   
                </header>
                
            </div>

            
        );
    }
}

export default HeaderComponents;