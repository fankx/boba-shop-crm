// TODO: declare URL where server listens for HTTP requests
//const ORDERS_URL = "https://restuarant-crm.herokuapp.com/api/orders"
// us-cdbr-east-04.cleardb.com/heroku_c6a34d11c0df5ab?reconnect=true?serverTimezone=UTC

 const ORDERS_URL = "http://localhost:8080/api/orders"
// TODO: retrieve all orders from the server
export const findAllOrders = () =>
    fetch(ORDERS_URL)
        .then(response => response.json())

// TODO: retrieve a single order by their ID
export const findOrderById = (id) =>
    fetch(`${ORDERS_URL}/${id}`)
        .then(response => response.json())

// TODO: delete a order by their ID
export const deleteOrder = (id) => // deleteOrder function accepts order's ID
    fetch(`${ORDERS_URL}/${id}`, { // encode order's ID at the end of the URL
        method: "DELETE"
    })// send an HTTP DELETE request to the server


// TODO: create a new order
export const createOrder = (order) =>
    fetch(ORDERS_URL, {
        method: 'POST',
        body: JSON.stringify(order),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())


// TODO: update a order by their ID
export const updateOrder = (id, order) => // update a order whose ID is id and new values are in order
    fetch(`${ORDERS_URL}/${id}`, {// send request to server with ID embedded in URL
        method: 'PUT',// send an HTTP PUT request
        body: JSON.stringify(order),// embed order data in the BODY as JSON string
        headers: {'content-type': 'application/json'}// tell server to interpret object as JSON
    })
        .then(response => response.json())// parse response



// TODO: export all functions as the API to this service
export default {
    findAllOrders,
    findOrderById,
    deleteOrder,
    createOrder,
    updateOrder
}
