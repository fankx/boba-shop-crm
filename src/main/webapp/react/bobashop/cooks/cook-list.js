const {Link, useHistory} = window.ReactRouterDOM;
import cookService from "./cook-service"
const { useState, useEffect } = React;


const CookList = () => {
    const history = useHistory()
    const [cooks, setCooks] = useState([])
    useEffect(() => {
        findAllCooks()
    }, [])
    const findAllCooks = () =>
        cookService.findAllCooks()
            .then(cooks => setCooks(cooks))
    const deleteCookTry = (id) =>{
        cookService.deleteCook(id)
            .then(() => window.location.reload(false) )}
    return(

        <div>
            <h2>Cook List</h2>
            <button className="btn btn-success"
                onClick={() => history.push("/cooks/new")}>
                Add Cook
            </button>
            <ul className="list-group">
                {
                    cooks.map(cook =>
                        <li className = "list-group-item" style={{ display: "flex" }} key={cook.id}>
                            <Link to={`/cooks/${cook.id}`}>
                            ID: {cook.id}

                            </Link>
                            : first name: {cook.firstName},
                            last name: {cook.lastName},
                            username: {cook.username},
                            password: {cook.password},
                            email: {cook.email},
                            birthday: {cook.dateOfBirth},

                            <div className="col-1 " style={{ marginLeft: "auto" }}>
                                <Link to={`/cooks/${cook.id}/drinks`}>
                                    drinks
                                </Link>
                            </div>
                            <button className="btn btn-danger" style={{ marginLeft: "auto" }}
                                    onClick={() => {if (window.confirm('Are you sure you wish to delete this item?'))
                                        deleteCookTry(cook.id)}}>
                                Delete
                            </button>

                        </li>)


                }

            </ul>
        </div>
    )
}

export default CookList;