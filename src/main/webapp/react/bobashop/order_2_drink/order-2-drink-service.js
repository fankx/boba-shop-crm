import {retrieveUser} from "../orders/order-service";

const DRINKS_URL = "http://localhost:8080/api/drinks"
const ORDERS_URL = "http://localhost:8080/api/orders"

export const createDrinkForOrder = (orderId, drink) =>
    fetch(`o2d/${orderId}/drinks`, {
        method: 'POST',
        body: JSON.stringify(drink),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const deleteDrinkForOrderByDrinkId = (oid) =>
    fetch(`${ORDERS_URL}/${oid}/drinks/`, {
        method: "DELETE"
    })

export const findDrinksForThisOrder = (oid) =>
    fetch(`${ORDERS_URL}/${oid}/drinks`)
        .then(response => response.json())

export const updateDrinkForOrderByDrinkId = (oid, did, drink) =>
    fetch(`${ORDERS_URL}/${oid}/drinks/${did}`, {
        method: 'PUT',
        body: JSON.stringify(drink),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())


export default {
    deleteDrinkForOrderByDrinkId,
    createDrinkForOrder,
    findDrinksForThisOrder,
    updateDrinkForOrderByDrinkId
}