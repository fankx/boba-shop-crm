import {retrieveUser} from "../orders/order-service";

const DRINKS_URL = "http://localhost:8080/api/drinks"
const ORDERS_URL = "http://localhost:8080/api/orders"
const O2D_URL = "http://localhost:8080/api/o2d"
export const createDrinkForOrder = (orderId, drinkId,o2d) =>
    fetch(`${O2D_URL}/${orderId}/drinks/${drinkId}`, {
        method: 'POST',
        body: JSON.stringify(o2d),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())



export const findDrinksForThisOrder = (orderId) =>
    fetch(`${ORDERS_URL}/${orderId}/drinks`)
        .then(response => response.json())

// export const updateDrinkForOrderByDrinkId = (oid, did, drink) =>
//     fetch(`${ORDERS_URL}/${oid}/drinks/${did}`, {
//         method: 'PUT',
//         body: JSON.stringify(drink),
//         headers: {'content-type': 'application/json'}
//     })
//         .then(response => response.json())


export const findO2dIdById = (o2dId)=>{
    fetch(`${O2D_URL}/${o2dId}/drinks`)
        .then(response => response.json())
}


export const deleteDrinkForOrderByO2dId = (order2drinkId) =>
    fetch(`${O2D_URL}/${order2drinkId}/drinks/`, {
        method: "DELETE"
    })
export default {
    findO2dIdById,
    deleteDrinkForOrderByO2dId,
    createDrinkForOrder,
    findDrinksForThisOrder,

}