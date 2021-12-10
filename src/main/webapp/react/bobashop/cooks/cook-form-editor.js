import cookService from "./cook-service";

const {useState, useEffect} = React; // import React's hooks
const {useParams, useHistory, Link} = window.ReactRouterDOM; // import cookParams to parse parameters from URL import useHistory

import 'react-confirm-alert/src/react-confirm-alert.css';

const CookFormEditor = () => {
        const {id} = useParams()// parse "id" from URL
        const [cook, setCook] = useState({})
        useEffect(() => { // on load
                if(id !== "new") {
                        findCookById(id)
                }
                // find the cook by their ID encoded from path
        }, []);
        const createCook = (cook) =>
            cookService.createCook(cook)
                .then(() => {
        alert("cook is created");
                })

        const findCookById = (id) =>// fetch a single cook using their ID
            cookService.findCookById(id)// use cook service's new findCookById
                .then(cook => setCook(cook)) //// store cook from server to local cook state variable

        const updateCook = (id, newCook) =>
            cookService.updateCook(id, newCook)
                .then(() => history.back())


        return (
        <div>
                <h2>Cook Editor</h2>
                <label>First Name</label>
                <br/>
                <input
                    onChange={(e) =>
                        setCook(cook =>
                            ({...cook, firstName: e.target.value}))}
                    value={cook.firstName}/>
                <br/>
                <label>Last Name</label>
                <br/>
                <input
                    onChange={(e) =>
                    setCook(cook=>
                        ( {...cook,lastName: e.target.value}))}
                    value={cook.lastName}/>

                <br/>

                <label>Birthday</label>
                <br/>
                <input placeholder={"yyyy-mm-dd"}
                    onChange={(e) =>
                        setCook(cook =>
                            ({...cook, dateOfBirth: e.target.value}))}
                    value={cook.dateOfBirth}/>

                <br/>

                <label>email</label>
                <br/>
                <input
                    onChange={(e) =>
                        setCook(cook =>
                            ({...cook, email: e.target.value}))}
                    value={cook.email}/>

                <br/>

                <label>Manager</label>
                <br/>
                <input
                    onChange={(e) =>
                        setCook(cook =>
                            ({...cook, manager: e.target.value}))}
                    value={cook.manager.id}/>

                <br/>



                <label>Username</label>
                <br/>
                <input
                    onChange={(e) =>
                        setCook(cook =>
                            ({...cook, username: e.target.value}))}
                    value={cook.username}/>
                <br/>
                <label>Password</label>
                <br/>
                <input
                    onChange={(e) =>
                        setCook(cook =>
                            ({...cook, password: e.target.value}))}
                    value={cook.password}/>
                <br/><br/>

                <Link to={`/cooks/${cook.id}/drinks`}>
                        drinks that the cook is responsible for
                </Link>
                <br/>
                <br/><br/><br/>

                <button className="btn btn-warning"// add a button
                    onClick={() => { // when you click,use history to go back
                            history.back()}}>
                        Back
                </button>


                <button className="btn btn-success"
                    onClick={() => createCook(cook)}>
                        Create Cook
                </button>

                <button className="btn btn-primary"
                    onClick={() => updateCook(cook.id, cook)}>
                        Save Updated
                </button>

        </div>

        )
}

export default CookFormEditor