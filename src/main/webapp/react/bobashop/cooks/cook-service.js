
//const COOKS_URL = "https://restuarant-crm.herokuapp.com/api/cooks"
// us-cdbr-east-04.cleardb.com/heroku_c6a34d11c0df5ab?reconnect=true?serverTimezone=UTC

 const COOKS_URL = "http://localhost:8080/api/cooks"

export const findAllCooks = () =>
    fetch(COOKS_URL)
        .then(response => response.json())


export const findCookById = (id) =>
    fetch(`${COOKS_URL}/${id}`)
        .then(response => response.json())

export const findDrinksByCookId = (id) =>
    fetch(`${COOKS_URL}/${id}/drinks`)
        .then(response => response.json())

export const deleteCook = (id) => // deleteCook function accepts cook's ID
    fetch(`${COOKS_URL}/${id}`, { // encode cook's ID at the end of the URL
        method: "DELETE"
    })// send an HTTP DELETE request to the server



export const createCook = (cook) =>
    fetch(COOKS_URL, {
        method: 'POST',
        body: JSON.stringify(cook),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())



export const updateCook = (id, cook) => // update a cook whose ID is id and new values are in cook
    fetch(`${COOKS_URL}/${id}`, {// send request to server with ID embedded in URL
        method: 'PUT',// send an HTTP PUT request
        body: JSON.stringify(cook),// embed cook data in the BODY as JSON string
        headers: {'content-type': 'application/json'}// tell server to interpret object as JSON
    })
        .then(response => response.json())// parse response




export default {
    findAllCooks,
    findCookById,
    deleteCook,
    createCook,
    updateCook,
    findDrinksByCookId
}
