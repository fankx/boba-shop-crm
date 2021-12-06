const {Link, useHistory} = window.ReactRouterDOM;
import order2DrinkService from "./order-2-drink-service"
const { useState, useEffect } = React;

const Order2DrinkList = () => {
    const history = useHistory()
    const [drinksForThisOrder, setDrinksForThisOrder] = useState([])
    const [newDrinkForThisOrder, setDrinkForThisOrder] = useState({})
    const {orderId} = useParams()

    useEffect(() => {
        findDrinksForOrder(orderId)
    }, [])

    const createDrinkForOrder = (drink) =>
        order2DrinkService.createDrinkForOrder(orderId, drink)
            .then (drink => {
                setDrinkForThisOrder({name:''})
                setDrinksForThisOrder (drinks => ([...drinks, drink]))
            })

    const findDrinksForOrder = (orderId) =>
        order2DrinkService.findDrinksForOrder(orderId)
            .then(drinks => setDrinksForThisOrder(drinks))

    // const createDrink = (drink) =>
    //     order2DrinkService.createDrink(drink)
    //         .then(drink => {
    //             setNewDrink({title:''})
    //             setDrinks(drinks => ([...drinks, drink]))
    //         })

    const updateDrinkForOrderByDrinkId = (oid, did, drink) =>
        order2DrinkService.then(drink => setDrinks(drinks => (drinks.map(drink => drink.id === id ? newDrink : drink))))

    const findAllDrinks = () =>
        order2DrinkService.findAllDrinks()
            .then(drinks => setDrinks(drinks))

    const deleteDrinkForOrder = (drinkId) =>
        order2DrinkService.deleteDrink(drinkId)
            .then(() => window.location.reload(false))

    return (

        <div>
            <h2>
                <Link onClick={() => history.back()}>
                    <i className="fas fa-arrow-left margin-right-10px"></i>
                </Link>
            </h2>
            <h2>Drinks for this order</h2>
            <select value={optionsState}>
                <option value="A">Apple</option>
                <option value="B">Banana</option>
                <option value="C">Cranberry</option>
            </select>

            <ul className="list-group">
                {
                    drinks.map(drink =>
                        <li className = "list-group-item" style={{ display: "flex" }} key={drink.id}>
                            {/*<Link to={`/drinks/${drink.id}`}>*/}
                            {/*    ID: {drink.id}*/}
                            {/*</Link>*/}

                            {/*TODO: need to figure out how to parse the drinkType*/}
                            &emsp;Name: {drink.name}
                            &emsp;Price: {drink.price}
                            {/*TODO: need to connect to the rates table and compute the avg*/}
                            {/*  &emsp;Rating: {},*/}
                            {/*: name: {drink},*/}

                            <button className="btn btn-danger" style={{ marginLeft: "auto" }}
                                    onClick={() => {if (window.confirm('Are you sure you wish to delete this item?'))
                                        deleteDrink(drink.id)}}>
                                Delete
                            </button>
                        </li>)

                }

            </ul>
        </div>
    )
}

export default Order2DrinkList;