import {MenuItem} from "@material-ui/core";

const {Link, useHistory,useParams} = window.ReactRouterDOM;
<<<<<<< HEAD
import orderToDrinkService, {deleteDrinkForOrderByDrinkId, findDrinksForThisOrder} from "./order-2-drink-service"
=======
import orderToDrinkService, {deleteDrinkForOrderByDrinkId} from "./order-2-drink-service"
>>>>>>> upstream/develop
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
        // 這裡有問題連1的飲料都拿不到
<<<<<<< HEAD
        // findDrinksForTheOrder(1)
        findDrinksForTheOrder(orderId)
=======
        findDrinksForTheOrder(orderId)
        findAllDrinks()
>>>>>>> upstream/develop
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
        drinkService.findAllDrinks()
            .then(drinks => setDrinks(drinks))

    const deleteDrinkForOrder = (drinkId) =>
        orderToDrinkService.deleteDrinkForOrderByDrinkId(orderId,drinkId)
            .then(() => window.location.reload(false))

    return (

        <div>
            <h2>
                <Link onClick={() => history.back()}>
                    <i className="fas fa-arrow-left margin-right-10px"></i>
                </Link>
            </h2>

            <h2>Drinks for this order</h2>

            <div className="dropdown">
<<<<<<< HEAD
                <button className="btn btn-primary" type="button" data-toggle="dropdown">
=======
                <button className="btn btn-primary " type="button" data-toggle="dropdown">
>>>>>>> upstream/develop
                    Menu
                      <span className="caret"></span></button>
                <ul className="dropdown-menu">
                    {
                        drinks.map(
                            drink =>
                            <li className = "list-group-item"
                                style={{ display: "flex" }}
                                key={drink.id}
<<<<<<< HEAD
                                onClick={() => createDrinkForOrder(newDrinkForThisOrder)}
                            >
                                {drink.name} ${drink.price}
=======
                            >
                                {drink.name}
>>>>>>> upstream/develop
                            </li>)
                    }
                </ul>
            </div>




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