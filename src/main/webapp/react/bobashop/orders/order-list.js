import sectionService from "../../university/sections/section-service";

const {Link, useParams,useHistory} = window.ReactRouterDOM;
import orderService from "./order-service"
const { useState, useEffect } = React;
// const {Link, useParams, useHistory} = window.ReactRouterDOM;

const OrderList = () => {

    const [orders, setOrders] = useState([])
    const [newOrders, setNewOrders] = useState({})
    const {userId} = useParams()

    useEffect(() => {
        findOrdersForUser(userId)
    }, [])
    const findOrdersForUser = (userId) =>
        orderService.findOrdersForUser(userId)
            .then(orders => setOrders(orders))
    const findAllOrders = () =>
        orderService.findAllOrders()
            .then(orders => setOrders(orders))
    const deleteOrderTry = (id) =>{
        orderService.deleteOrder(id)
            .then(() => window.location.reload(false) )}

    return(

        <div>
            <h2>
                <Link onClick={() => history.back()}>
                    <i className="fas fa-arrow-left margin-right-10px"></i>
                </Link>

            </h2>
            <h2>Order List</h2>
            <button className="btn btn-success"
                onClick={() => history.push("/orders/new")}>
                Add Order
            </button>
            <ul className="list-group">
                {
                    orders.map(order =>
                        <li className = "list-group-item" style={{ display: "flex" }} key={order.id}>
                            <Link to={`/orders/${order.id}`}>
                            OrderID: {order.id}

                            </Link>
                            : Amount: {order.amount},
                            Discount: {order.discount},
                            Tips: {order.tip},
                            <Link to={`/users/${userId}`}>
                                UserID: {userId}
                            </Link>


                            {/*<button className="btn btn-success" onClick = {()=>{test(order)}}>test</button>*/}
                            <button className="btn btn-danger" style={{ marginLeft: "auto" }}
                                    onClick={() => {if (window.confirm('Are you sure you wish to delete this item?'))
                                        deleteOrderTry(order.id)}}>
                                Delete
                            </button>
                        </li>)


                }

            </ul>
        </div>
    )
}

export default OrderList;