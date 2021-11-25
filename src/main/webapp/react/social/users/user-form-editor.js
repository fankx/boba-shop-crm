import userService from "./user-service"; // import user-service so we can fetch a single user
const {useState, useEffect} = React; // import React's hooks
const {useParams, useHistory} = window.ReactRouterDOM; // import userParams to parse parameters from URL import useHistory


const UserFormEditor = () => {
        const {id} = useParams()// parse "id" from URL
        const [user, setUser] = useState({})
        useEffect(() => { // on load
                if(id !== "new") {
                        findUserById(id)
                }
                // find the user by their ID encoded from path
        }, []);
        const createUser = (user) =>
            userService.createUser(user)
                .then(() => history.goBack())

        const findUserById = (id) =>// fetch a single user using their ID
            userService.findUserById(id)// use user service's new findUserById
                .then(user => setUser(user)) //// store user from server to local user state variable
        const deleteUser = (id) =>
            userService.deleteUser(id)
                .then(() => history.goBack())
        const updateUser = (id, newUser) =>
            userService.updateUser(id, newUser)
                .then(() => history.goBack())


        return (
        <div>
                <h2>User Editor</h2>
                <label>ID</label>
                <input value={user.id}/><br/>
                <label>First Name</label>
                <input
                    onChange={(e) =>
                        setUser(user =>
                            ({...user, firstName: e.target.value}))}
                    value={user.firstName}/>

                <label>Last Name</label>
                <input
                    onChange={(e) =>
                    setUser(user=>
                        ( {...user,lastName: e.target.value}))}
                    value={user.lastName}/><br/>
                <label>Username</label>
                <input
                    onChange={(e) =>
                        setUser(user =>
                            ({...user, username: e.target.value}))}
                    value={user.username}/>
                <br/>
                <label>Password</label>
                <input
                    onChange={(e) =>
                        setUser(user =>
                            ({...user, password: e.target.value}))}
                    value={user.password}/>
                <br/>
                <button // add a button
                    onClick={() => { // when you click,use history to go back
                            history.back()}}>
                        Cancel
                </button>

                <button
                    onClick={() => deleteUser(user.id)}>
                        Delete
                </button>

                <button
                    onClick={() => createUser(user)}>
                        Create
                </button>

                <button
                    onClick={() => updateUser(user.id, user)}>
                        Save
                </button>

        </div>

        )
}

export default UserFormEditor