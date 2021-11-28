import userService from "./user-service"; // import user-service so we can fetch a single user
const {useState, useEffect} = React; // import React's hooks
const {useParams, useHistory} = window.ReactRouterDOM; // import userParams to parse parameters from URL import useHistory
import { MessageBox } from 'element-react';

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
        const deleteUser = (id) =>{
                alert("trythis");
            userService.deleteUser(id)
                .then(() => history.goBack() )}
        const deleteUserTry = (id) =>{
                MessageBox.prompt('请输入邮箱', '提示', {
                        inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
                        inputErrorMessage: '邮箱格式不正确'
                }).then(({ value }) => {
                        Message({
                                type: 'success',
                                message: '你的邮箱是: ' + value
                        });
                }).catch(() => {
                        Message({
                                type: 'info',
                                message: '取消输入'
                        });
                });
                userService.deleteUser(id)
                    .then(() => history.goBack() )}
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

                <label>Birthday</label>
                <input
                    onChange={(e) =>
                        setUser(user =>
                            ({...user, dateOfBirth: e.target.value}))}
                    value={user.dateOfBirth}/>

                <br/>

                <label>email</label>
                <input
                    onChange={(e) =>
                        setUser(user =>
                            ({...user, email: e.target.value}))}
                    value={user.email}/>

                <br/>

                <label>Customer value</label>
                <input
                    onChange={(e) =>
                        setUser(user =>
                            ({...user, customerValue: e.target.value}))}
                    value={user.customerValue}/>

                <br/>



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







                <button className="btn btn-warning"// add a button
                    onClick={() => { // when you click,use history to go back
                            history.back()}}>
                        Cancel
                </button>

                <button className="btn btn-danger"

                    onClick={() => deleteUser(user.id)}>
                        DeleteOld
                </button>

                <button className="btn btn-danger"

                        onClick={this.deleteUserTry.bind(this)}>
                        Deletetry
                </button>

                {/*<button*/}

                {/*    onClick={() => { MessageBox.confirm('此操作将永久删除该文件, 是否继续?', '提示', {*/}
                {/*            type: 'warning'*/}
                {/*    }).then(() => {*/}
                {/*            Message({*/}
                {/*                    type: 'success',*/}
                {/*                    message: '删除成功!'*/}
                {/*            });*/}
                {/*    }).catch(() => {*/}
                {/*            Message({*/}
                {/*                    type: 'info',*/}
                {/*                    message: '已取消删除'*/}
                {/*            });*/}
                {/*    });*/}
                {/*            deleteUser(user.id)}}>*/}
                {/*        DeleteAlert*/}
                {/*</button>*/}

                <button className="btn btn-success"
                    onClick={() => createUser(user)}>
                        Create
                </button>

                <button className="btn btn-primary"
                    onClick={() => updateUser(user.id, user)}>
                        Save
                </button>

        </div>

        )
}

export default UserFormEditor