const {Link, useHistory} = window.ReactRouterDOM;
import drinkService from "./drink-service"
const { useState, useEffect } = React;


const DrinkList = () => {
    const history = useHistory()
    const [drinks, setDrinks] = useState([])
    const [newDrink, setNewDrink] = useState({})
    useEffect(() => {
        findAllDrinks()
    }, [])
    const createDrink = (drink) =>
        drinkService.createDrink(drink)
            .then(drink => {
                setNewDrink({title:''})
                setDrinks(drinks => ([...drinks, drink]))
            })
    const updateDrink = (id, newDrink) =>
        drinkService.updateDrink(id, newDrink)
            .then(drink => setDrinks(drinks => (drinks.map(drink => drink.id === id ? newDrink : drink))))

    const findAllDrinks = () =>
        drinkService.findAllDrinks()
            .then(drinks => setDrinks(drinks))

    const deleteDrink = (id) =>
        drinkService.deleteDrink(id)
            .then(drinks => setDrinks(drinks => drinks.filter(drink => drink.id !== id)))
    return (

        <div>
            <h2>Drink List</h2>
            <button className="btn btn-success"
                    onClick={() => history.push("/drinks/new")}>
                Add Drink
            </button>

            <ul className="list-group">
                {
                    drinks.map(drink =>
                        <li className = "list-group-item" style={{ display: "flex" }} key={drink.id}>
                            <Link to={`/drinks/${drink.id}`}>
                                ID: {drink.id}
                            </Link>

                            {/*TODO: need to figure out how to parse the drinkType*/}
                            &emsp;Name: {drink.drinkType}
                            {/*TODO: need to connect to the rates table and compute the avg*/}
                              &emsp;Rating: {},
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

export default DrinkList;