const DRINKS_URL = "http://localhost:8080/api/drinks"

export const createDrink = (drink) =>
    fetch(DRINKS_URL, {
        method: 'POST',
        body: JSON.stringify(drink),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const findAllDrinks = () =>
    fetch(DRINKS_URL)
        .then(response => response.json())

export const findDrinkById = (id) =>
    fetch(`${DRINKS_URL}/${id}`)
        .then(response => response.json())

export const findOrdersByDrinkId = (drinkId) =>
    fetch(`${DRINKS_URL}/${drinkId}/orders`)
        .then(response => response.json())

export const deleteDrink = (id) =>
    fetch(`${DRINKS_URL}/${id}`, {
        method: "DELETE"
    })

export const updateDrink = (id, drink) =>
    fetch(`${DRINKS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(drink),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())


export default {
    findAllDrinks,
    findDrinkById,
    deleteDrink,
    createDrink,
    updateDrink,
    findOrdersByDrinkId,
}