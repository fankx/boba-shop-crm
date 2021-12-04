import orderService from "./order-service"; // import order-service so we can fetch a single order
import 'react-confirm-alert/src/react-confirm-alert.css';

const {useState, useEffect} = React; // import React's hooks
const {Link,useParams, useHistory} = window.ReactRouterDOM; // import orderParams to parse parameters from URL import useHistory

const OrderFormEditor = () => {
    const {id} = useParams()// parse "id" from URL
    const [order, setOrder] = useState({})
    useEffect(() => { // on load
        if (id !== "new") {
            findOrderById(id)
        }
        // find the order by their ID encoded from path
    }, []);
    const createOrder = (order) =>
        orderService.createOrder(order)
            .then(() => {
                alert("order is created");
            })

    const findOrderById = (id) =>// fetch a single order using their ID
        orderService.findOrderById(id)// use order service's new findOrderById
            .then(order => setOrder(order)) //// store order from server to local order state variable

    const updateOrder = (id, newOrder) =>
        orderService.updateOrder(id, newOrder)
            .then(() => history.back())
    // const userId = order.user.id

    return (
        <div>
            <h2>Order Editor</h2>
            <label>Amount </label>
            <br/>
            <input
                onChange={(e) =>
                    setOrder(order =>
                        ({...order, amount: e.target.value}))}
                value={order.amount}/>
            <br/>
            <label>Discount</label>
            <br/>
            <input
                onChange={(e) =>
                    setOrder(order =>
                        ({...order, discount: e.target.value}))}
                value={order.discount}/>

            <br/>

            <label>Tips</label>
            <br/>
            <input
                   onChange={(e) =>
                       setOrder(order =>
                           ({...order, tip: e.target.value}))}
                   value={order.tip}/>

            <br/>

            <label>UserID</label>
            <br/>

            {/*<Link to={`/users/${order.user.id}`}>*/}
            {/*ID: {order.user.id}*/}

            {/*</Link>*/}
            <br/><br/><br/>


            <button className="btn btn-warning"// add a button
                    onClick={() => { // when you click,use history to go back
                        history.back()
                    }}>
                Back
            </button>


            <button className="btn btn-success"
                    onClick={() => createOrder(order)}>
                Create Order
            </button>

            <button className="btn btn-primary"
                    onClick={() => updateOrder(order.id, order)}>
                Save Updated
            </button>

        </div>

    )
}

export default OrderFormEditor