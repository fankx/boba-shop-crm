import sectionService from "../../university/sections/section-service";

const {Link, useParams,useHistory} = window.ReactRouterDOM;
import orderService, {createOrderForUser} from "./order-service"
import SectionEditorInline from "../../university/sections/section-editor-inline";
const { useState, useEffect } = React;
// const {Link, useParams, useHistory} = window.ReactRouterDOM;

const OrderList = () => {

    const [orders, setOrders] = useState([])
    const [newOrder, setNewOrder] = useState({})
    const {userId} = useParams()

    useEffect(() => {
        findOrdersForUser(userId)
    }, [])
    const createOrderForUser = (order) =>
        orderService.createOrderForUser(userId, order)
            .then(order => {
                setNewOrder({name:''})
                setOrders(orders => ([...orders, order]))
            })

    const findOrdersForUser = (userId) =>
        orderService.findOrdersForUser(userId)
            .then(orders => setOrders(orders))
    const findAllOrders = () =>
        orderService.findAllOrders()
            .then(orders => setOrders(orders))
    const deleteOrderTry = (id) =>{
        orderService.deleteOrder(id)
            .then(() => window.location.reload(false) )}
    //discount for all the user
    const discountRate = 0.1;
    return(

        <div>
            <h2>
                <Link onClick={() => history.back()}>
                    <i className="fas fa-arrow-left margin-right-10px"></i>
                </Link>

            </h2>
            <h2>Order List</h2>
            {/*<button className="btn btn-success"*/}
            {/*    onClick={() => history.push("/orders/new")}>*/}
            {/*    Add Order*/}
            {/*</button>*/}
            <div>
                <h2>
                    <Link onClick={() => history.back()}>
                        <i className="fas fa-arrow-left margin-right-10px"></i>
                    </Link>
                    Sections
                </h2>
                <ul className="list-group">
                    <li className="list-group-item">
                        <div className="row">
                            <div className="col">
                                <input placeholder="tip Amount"
                                       title="Please enter a XXX"
                                       className="form-control"
                                       onChange={(e) => {
                                           setNewOrder(newOrder => ({...newOrder, tip: e.target.value}))
                                           console.log(e.target.value);
                                           console.log(newOrder);
                                         }
                                       }
                                       value={newOrder.tip}
                                       />
                                <input readOnly
                                       title="Please enter a name for the section"
                                       className="form-control"
                                       value = {discountRate}
                                       onChange={(e) => setNewOrder(newOrder => ({...newOrder, discount: e.target.value}))}
                                       // value={newOrder.discount}
                                />
                            </div>
                            <div className="col-2">
                                <i className="fas float-right fa-plus fa-2x" onClick={() => createOrderForUser(newOrder)}></i>
                            </div>
                        </div>
                    </li>
                    {/*{*/}
                    {/*    sections.map(section =>*/}
                    {/*        <li key={section.id} className="list-group-item">*/}
                    {/*            <SectionEditorInline key={section._id}*/}
                    {/*                                 updateSection={updateSection}*/}
                    {/*                                 deleteSection={deleteSection}*/}
                    {/*                                 section={section}/>*/}
                    {/*        </li>)*/}
                    {/*}*/}
                </ul>
            </div>







            {/*following are old versions?*/}
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