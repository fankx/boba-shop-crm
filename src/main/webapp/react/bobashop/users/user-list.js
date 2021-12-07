const {Link, useHistory} = window.ReactRouterDOM;
import userService from "./user-service"
const { useState, useEffect } = React;


const UserList = () => {
    const history = useHistory()
    const [users, setUsers] = useState([])
    useEffect(() => {
        findAllUsers
    }, [])
    const findAllUsers = () =>
        userService.findAllUsers()
            .then(users => setUsers(users));
    const deleteUserTry = (id) =>{
        userService.deleteUser(id)
            .then(() => window.location.reload(false) )}
    return(

        <div>
            <h2>User List</h2>
            <button className="btn btn-success"
                onClick={() => history.push("/users/new")}>
                Add User
            </button>
            <ul className="list-group">
                {
                    users.map(user =>
                        <li className = "list-group-item" style={{ display: "flex" }} key={user.id}>
                            <Link to={`/users/${user.id}`}>
                            ID: {user.id}

                            </Link>
                            : first name: {user.firstName},
                            last name: {user.lastName},
                            username: {user.username},
                            password: {user.password},
                            email: {user.email},
                            birthday: {user.dateOfBirth},
                            customer value: {user.customerValue}
                            <div className="col-1 " style={{ marginLeft: "auto" }}>
                                <Link to={`/users/${user.id}/orders`}>
                                    Orders
                                </Link>
                            </div>
                            <button className="btn btn-danger" style={{ marginLeft: "auto" }}
                                    onClick={() => {if (window.confirm('Are you sure you wish to delete this item?'))
                                        deleteUserTry(user.id)}}>
                                Delete
                            </button>
                        </li>)


                }

            </ul>
        </div>
    )
}

export default UserList;