const {Link, useHistory} = window.ReactRouterDOM;
import userService from "./user-service"
const { useState, useEffect } = React;


const UserList = () => {
    const history = useHistory()
    const [users, setUsers] = useState([])
    useEffect(() => {
        findAllUsers()
    }, [])
    const findAllUsers = () =>
        userService.findAllUsers()
            .then(users => setUsers(users))

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
                        <li className = "list-group-item" key={user.id}>
                            <Link to={`/users/${user.id}`}>
                            userID: {user.id},
                            first name: {user.firstName},
                            last name: {user.lastName},
                            username: {user.username},
                                password: {user.password},
                                email: {user.email},
                                birthday: {user.dateOfBirth}
                            </Link>
                        </li>)


                }

            </ul>
        </div>
    )
}

export default UserList;