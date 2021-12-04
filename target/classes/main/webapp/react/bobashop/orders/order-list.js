const {Link, useHistory} = window.ReactRouterDOM;
import orderService from "./order-service"
const { useState, useEffect } = React;


const OrderList = () => {
    const history = useHistory()
    const [orders, setOrders] = useState([])
    useEffect(() => {
        findAllOrders()
    }, [])
    const findAllOrders = () =>
        orderService.findAllOrders()
            .then(orders => setOrders(orders))
    const deleteOrderTry = (id) =>{
        orderService.deleteOrder(id)
            .then(() => window.location.reload(false) )}
    const test = (order)=>{
        alert(order);
        console.log(order);
    }
    return(

        <div>

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
                            ID: {order.id}

                            </Link>
                            : Amount: {order.amount},
                            Discount: {order.discount},
                            Tips: {order.tip},

                            {/*userID: {order.user.id}*/}
                            <button className="btn btn-success" onClick = {()=>{test(order)}}>test</button>
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