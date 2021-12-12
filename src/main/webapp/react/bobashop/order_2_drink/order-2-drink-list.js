import {MenuItem} from "@material-ui/core";

const {Link, useHistory,useParams} = window.ReactRouterDOM;
import orderToDrinkService, {deleteDrinkForOrderByO2dId} from "./order-2-drink-service"
import drinkService from "../drinks/drink-service"
import Menu from "@material-ui/core/Menu";
const { useState, useEffect,Component } = React;

const Order2DrinkList = () => {

    const [drinksForThisOrder, setDrinksForThisOrder] = useState([])
    const [newDrinkForThisOrder, setNewDrinkForThisOrder] = useState({})
    const [drinks, setDrinks]=useState([])
    // const [newDrink, setNewDrink]=useState([])
    const {orderId} = useParams()

    useEffect(() => {

        findDrinksForTheOrder()
        findAllDrinks()
    }, [])

    // const createDrinkForOrder = (drinkId,o2d) =>
    //     orderToDrinkService.createDrinkForOrder(orderId, drinkId, o2d)
    //         .then (drink => {
    //             setNewDrinkForThisOrder({name:''})
    //             setDrinksForThisOrder(drinksForThisOrder => ([...drinksForThisOrder, drink]))
    //         })

    const findDrinksForTheOrder = () =>
        orderToDrinkService.findDrinksForThisOrder(orderId)
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
        drinkService.findAllDrinks()
            .then(drinks => setDrinks(drinks))

    const deleteDrinkForOrder = (o2dId) =>
        orderToDrinkService.deleteDrinkForOrderByO2dId(o2dId)
            .then(() => window.location.reload(false))

    const createDrinkForOrder = (newDrink, drinkId)=>{

        setNewDrinkForThisOrder(newDrink => ({...newDrink, drink_id: drinkId}))
        setNewDrinkForThisOrder(newDrink => ({...newDrink, order_id: orderId}))
        orderToDrinkService.createDrinkForOrder(orderId,drinkId,newDrink).then (drinks => {
            setNewDrinkForThisOrder({name:''})
            setDrinksForThisOrder(drinksForThisOrder => ([...drinksForThisOrder, drinks]))
        })

    }

    return (

        <div>
            <h2>
                <Link onClick={() => history.back()}>
                    <i className="fas fa-arrow-left margin-right-10px"></i>
                </Link>
            </h2>

            <h2>Drinks for this order</h2>

            <div className="dropdown">
                <button className="btn btn-primary " type="button" data-toggle="dropdown">
                    Menu
                    <span className="caret"></span></button>
                <ul className="dropdown-menu">
                    {
                        drinks.map(drink =>
                            <li className = "list-group-item"
                                style={{ display: "flex" }}
                                key={drink.id}
                                //onChange={(e) => setNewDrinkForThisOrder(newDrink => ({...newDrink, drink_id: drink.drink.id}))}
                                onClick={()=>createDrinkForOrder(newDrinkForThisOrder,drink.id)}
                            >
                                {drink.id} {drink.name}
                            </li>)
                    }
                </ul>
            </div>




            <ul className="list-group">
                {
                    drinksForThisOrder.map(drink =>
                        <li className = "list-group-item" style={{ display: "flex" }} key={drink.id}>
                            <Link to={`/drinks/${drink.drink.id}`}>
                                ID: {drink.drink.id}
                            </Link>

                            {/*TODO: need to figure out how to parse the drinkType*/}
                            &emsp;Name: {drink.drink.name}
                            &emsp;Price: {drink.drink.price}


                            {/*TODO: need to connect to the rates table and compute the avg*/}
                            {/*  &emsp;Rating: {},*/}
                            {/*: name: {drink},*/}

                            <Link to={`/orders/${orderId}` }>
                                OrderID: {orderId}
                            </Link>

                            <button className="btn btn-danger" style={{ marginLeft: "auto" }}
                                    onClick={() => {if (window.confirm('Are you sure you wish to delete ' + drink.drink.id+' drink?'))
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