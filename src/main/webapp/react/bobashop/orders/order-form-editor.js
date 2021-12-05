import orderService, {findUserIdByOrderId} from "./order-service"; // import order-service so we can fetch a single order
import 'react-confirm-alert/src/react-confirm-alert.css';

const {useState, useEffect} = React; // import React's hooks
const {Link,useParams, useHistory} = window.ReactRouterDOM; // import orderParams to parse parameters from URL import useHistory
const ORDERS_URL = "http://localhost:8080/api/orders"
const OrderFormEditor = () => {
    const {id} = useParams()// parse "id" from URL
    const [order, setOrder] = useState({})
    const [drinks, setDrinks] = useState([])
    const [newDrink, setNewDrink] = useState({})
    useEffect(() => { // on load
        if (id !== "new") {
            findOrderById(id);
            // Get userID by the following can work
            // {
            // fetch(`${ORDERS_URL}/${id}/user`)
            //     .then(response =>response.json()
            //         .then(data => {
            //                 console.log(data.id);
            //             setOrder(order =>
            //                 ({...order, user_id: data.id}))
            //             }
            //         ))
            //     // fetch(`${ORDERS_URL}/${orderId}/user`)
            //     // .then(response => response.json())
            // }
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
    {

        // console.log(newOrder)
        // alert("dd")
        orderService.updateOrder(id, newOrder)
            .then(() => history.back())

    }

    const createDrinkForOrder=(drink)=>{
        orderService.createDrinkForOrder(id, drink)
            .then(drink => {
                setNewDrink({name:''})
                setDrinks(drinks => ([...drinks, drink]))
            })
    }
    // const userId = order.user.id

    // const showUser = async (id) => {
    //     // 调用接口请求异步获取数据
    //     orderService.findUserIdByOrderId(id);
    //     const userData = orderService.retrieveUser();
    //     // 更新状态
    //     // setOrder(order =>
    //     //     ({...order, user_id: user_id}))
    //     console.log(userData)
    // }

    // const showUser = (id) =>
    // {
    //     const user = orderService.findUserIdByOrderId(id);
    //
    //     console.log(orderService.findUserIdByOrderId(id));
    //     alert(orderService.findUserIdByOrderId(id));}
    const deleteDrink = (id) =>{
        orderService.deleteDrink(id)
            .then(() => window.location.reload(false) )}
    return (
        <div>
            <h2>
                <Link onClick={() => history.back()}>
                    <i className="fas fa-arrow-left margin-right-10px"></i>
                </Link>

            </h2>
            <h2>Order Editor</h2>
            {/*<button onClick={()=>{showUser(id)}}>update state</button>*/}
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
            {/*<ul className="list-group">*/}
            {/*    <li className="list-group-item">*/}
            {/*        <div className="row">*/}
            {/*            <div className="col">*/}
            {/*                Drink Selection: <input*/}
            {/*                                   className="form-control"*/}
            {/*                                   onChange={(e) => {*/}
            {/*                                       setNewDrink(newDrink => ({...newDrink, name: e.target.value}))*/}
            {/*                                   }*/}
            {/*                                   }*/}
            {/*                                   value={newDrink.name}*/}
            {/*            />*/}
            {/*            </div>*/}
            {/*            <div className="col-2">*/}
            {/*                <i className="fas float-right fa-plus fa-2x" onClick={() => createDrinkForOrder(newDrink)}></i>*/}
            {/*            </div>*/}
            {/*        </div>*/}
            {/*    </li>*/}
            {/*    {*/}
            {/*        drinks.map(drink =>*/}
            {/*            <li className = "list-group-item" style={{ display: "flex" }} key={drink.id}>*/}
            {/*                <Link to={`/drinks/${drink.id}`}>*/}
            {/*                    drinkID: {drink.id}*/}

            {/*                </Link>*/}

            {/*                /!*<button className="btn btn-success" onClick = {()=>{test(order)}}>test</button>*!/*/}
            {/*                <button className="btn btn-danger" style={{ marginLeft: "auto" }}*/}
            {/*                        onClick={() => {if (window.confirm('Are you sure you wish to delete this item?'))*/}
            {/*                            deleteDrink(drink.id)}}>*/}
            {/*                    Delete*/}
            {/*                </button>*/}
            {/*            </li>)*/}
            {/*    }*/}
            {/*</ul>*/}
            <label>Tips</label>
            <br/>
            <input
                   onChange={(e) =>
                       setOrder(order =>
                           ({...order, tip: e.target.value}))}
                   value={order.tip}/>

            <br/>
            <Link to={`/drinks`}>
                Drinks Order

            </Link>

            <br/>

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
                    onClick={() =>
                    {
                        // setOrder(order =>
                        //     ({...order, user_id: })

                        updateOrder(order.id, order)

                    }}>
                Save Updated
            </button>

        </div>

    )
}

export default OrderFormEditor