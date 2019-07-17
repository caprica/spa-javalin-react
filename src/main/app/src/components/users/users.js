import React        from 'react'

import { Link }     from 'react-router-dom'

import Page         from '../Page'

import useFetchData from '../../hooks/useFetchData'

function Users() {

    // eslint-disable-next-line no-unused-vars
    const [state, dispatch] = useFetchData({
        url: '/api/users'
    });

    return (
        <Page header="Users">
            <table>
                <thead>
                    <tr>
                        <th>username</th>
                        <th>name</th>
                    </tr>
                </thead>
                <tbody>
                {
                    state.data.map((user, key) =>
                        <tr key={user.username}>
                            <td><Link className="App-link" to={`/users/${user.username}`}>{user.username}</Link></td>
                            <td>{user.name}</td>
                        </tr>
                    )
                }
                </tbody>
            </table>
            {state.loading && <p>Fetching users...</p>}
            {state.error && <p>Error fetching users: {state.error.message}</p>}
            <br/>
            <span><Link className="App-link" to="/">Home</Link></span>
        </Page>
    )

}

export default Users
