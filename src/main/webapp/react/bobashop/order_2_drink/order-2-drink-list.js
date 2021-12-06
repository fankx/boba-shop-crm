const {Link, useHistory,useParams} = window.ReactRouterDOM;
import orderToDrinkService from "./order-2-drink-service"
const { useState, useEffect } = React;

const Order2DrinkList = () => {

    const [drinksForThisOrder, setDrinksForThisOrder] = useState([])
    const [newDrinkForThisOrder, setNewDrinkForThisOrder] = useState({})
    // const [drinks, setDrinks]=useState([])
    // const [newDrink, setNewDrink]=useState([])
    const {orderId} = useParams()

    useEffect(() => {
        // 這裡有問題連1的飲料都拿不到
        findDrinksForTheOrder(1)
    }, [])

    const createDrinkForOrder = (drink) =>
        orderToDrinkService.createDrinkForOrder(orderId, drink)
            .then (drink => {
                setNewDrinkForThisOrder({name:''})
                setDrinksForThisOrder(drinksForThisOrder => ([...drinksForThisOrder, drink]))
            })

    const findDrinksForTheOrder = (oId) =>
        orderToDrinkService.findDrinksForThisOrder(oId)
             .then((drinksForThisOrder) => setDrinksForThisOrder(drinksForThisOrder))

    // const createDrink = (drink) =>
    //     orderToDrinkService.createDrink(drink)
    //         .then(drink => {
    //             setNewDrink({title:''})
    //             setDrinks(drinks => ([...drinks, drink]))
    //         })

    const updateDrinkForOrderByDrinkId = (oid, did, drink) =>
        orderToDrinkService.then(drink => setDrinksForThisOrder(drinksForThisOrder => (drinksForThisOrder.map(drink => drink.id === id ? newDrinkForThisOrder : drink))))

    const findAllDrinks = () =>
        orderToDrinkService.findAllDrinks()
            .then(drinksForThisOrder => setDrinksForThisOrder(drinksForThisOrder))

    const deleteDrinkForOrder = (drinkId) =>
        orderToDrinkService.deleteDrink(orderId,drinkId)
            .then(() => window.location.reload(false))

    return (

        <div>
            <h2>
                <Link onClick={() => history.back()}>
                    <i className="fas fa-arrow-left margin-right-10px"></i>
                </Link>
            </h2>
            <h2>Drinks for this order</h2>
            <select >
                <option value="A">Apple</option>
                <option value="B">Banana</option>
                <option value="C">Cranberry</option>
            </select>

            <ul className="list-group">
                {
                    drinksForThisOrder.map(drink =>
                        <li className = "list-group-item" style={{ display: "flex" }} key={drink.id}>
                            <Link to={`/drinks/${drink.id}`}>
                                ID: {drink.id}
                            </Link>

                            {/*TODO: need to figure out how to parse the drinkType*/}
                            &emsp;Name: {drink.name}
                            &emsp;Price: {drink.price}
                            {/*TODO: need to connect to the rates table and compute the avg*/}
                            {/*  &emsp;Rating: {},*/}
                            {/*: name: {drink},*/}

                            <button className="btn btn-danger" style={{ marginLeft: "auto" }}
                                    onClick={() => {if (window.confirm('Are you sure you wish to delete this item?'))
                                        deleteDrinkForOrder(drink.id)}}>
                                Delete
                            </button>
                        </li>)

                }

            </ul>
        </div>
    )
}

export default Order2DrinkList;