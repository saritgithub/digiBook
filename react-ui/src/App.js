import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch,Link} from 'react-router-dom'
import UserComponent from './components/UserComponent';
import HeaderComponents from './components/HeaderComponents';
import FooterComponent from './components/FooterComponent';
import BookComponent from './components/BookComponent';
import ViewBookComponent from './components/ViewBookComponent';
import BorrowComponent from './components/BorrowComponent';
import BorrowDetailsComponent from './components/BorrowDetailsComponent';
import Register from './components/Register'; 
import Login from './components/Login';

function App() {
  return (
    <div>
        <Router>
              <HeaderComponents />
                <div className="container">
                     <Switch> 
                         <Route path = "/" exact component = {UserComponent}></Route>
                         <Route path = "/users" component = {UserComponent}></Route>
                         <Route path = "/register" component = {Register}></Route>
                         <Route path = "/login" component = {Login}></Route>
                         <Route path = "/" exact component = {BookComponent}></Route>
                         <Route path = "/books" component = {BookComponent}></Route>
                         <Route path = "/view-book/:id" component = {ViewBookComponent}></Route>
                         <Route path = "/" exact component = {BorrowComponent}></Route>
                         <Route path = "/borrows" component = {BorrowComponent}></Route>
                         <Route path = "/borrow-details/:id" component = {BorrowDetailsComponent}></Route>
    
                     </Switch>
                </div>
              <FooterComponent />
        </Router>
    </div>
  );
}

export default App;
