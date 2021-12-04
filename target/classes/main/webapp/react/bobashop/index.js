import UserList from "./users/user-list";
import UserFormEditor from "./users/user-form-editor";

import OrderList from "./orders/order-list";
import OrderFormEditor from "./orders/order-form-editor";

import DrinkList from "./drinks/drink-list";
import DrinkFormEditor from "./drinks/drink-form-editor";

const {HashRouter, Route} = window.ReactRouterDOM;
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/users", "/"]} exact={true}>
                    <UserList/>
                </Route>
                <Route path="/users/:id" exact={true}>
                    <UserFormEditor/>
                </Route>
                <Route path="/orders/:id" exact={true}>
                    <OrderFormEditor/>
                </Route>
                <Route path={["/orders", "/"]} exact={true}>
                    <OrderList/>
                </Route>
                <Route path={["/drinks", "/"]} exact={true}>
                    <DrinkList/>
                </Route>
                <Route path="/drinks/:id" exact={true}>
                    <DrinkFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
