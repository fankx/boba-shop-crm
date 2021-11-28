// TODO: declare URL where server listens for HTTP requests
//const USERS_URL = "https://restuarant-crm.herokuapp.com/api/users"
// us-cdbr-east-04.cleardb.com/heroku_c6a34d11c0df5ab?reconnect=true?serverTimezone=UTC

 const USERS_URL = "http://localhost:8080/api/users"
// TODO: retrieve all users from the server
export const findAllUsers = () =>
    fetch(USERS_URL)
        .then(response => response.json())

// TODO: retrieve a single user by their ID
export const findUserById = (id) =>
    fetch(`${USERS_URL}/${id}`)
        .then(response => response.json())

// TODO: delete a user by their ID
export const deleteUser = (id) => // deleteUser function accepts user's ID
    fetch(`${USERS_URL}/${id}`, { // encode user's ID at the end of the URL
        method: "DELETE"
    })// send an HTTP DELETE request to the server


// TODO: create a new user
export const createUser = (user) =>
    fetch(USERS_URL, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())


// TODO: update a user by their ID
export const updateUser = (id, user) => // update a user whose ID is id and new values are in user
    fetch(`${USERS_URL}/${id}`, {// send request to server with ID embedded in URL
        method: 'PUT',// send an HTTP PUT request
        body: JSON.stringify(user),// embed user data in the BODY as JSON string
        headers: {'content-type': 'application/json'}// tell server to interpret object as JSON
    })
        .then(response => response.json())// parse response



// TODO: export all functions as the API to this service
export default {
    findAllUsers,
    findUserById,
    deleteUser,
    createUser,
    updateUser
}
