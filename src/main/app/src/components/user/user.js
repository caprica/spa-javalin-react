import React        from 'react'

import { Link }     from 'react-router-dom'

import Page         from '../Page'

import useFetchData from '../../hooks/useFetchData'

const User = (props) => {

    // eslint-disable-next-line no-unused-vars
    const [state, dispatch] = useFetchData({
        url: `/api/users/${props.match.params.username}`
    });

    return (
        <Page header={`User ${props.match.params.username}`}>
            <table>
                <thead>
                    <tr>
                        <th>username</th>
                        <th>name</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{state.data.username}</td>
                        <td>{state.data.name}</td>
                    </tr>
                </tbody>
            </table>
            {state.loading && <p>Fetching user {props.match.params.username}...</p>}
            {state.error && <p>Error fetching user {props.match.params.username}: {state.error.message}</p>}
            <br/>
            <span><Link className="App-link" to="/">Home</Link> | <Link className="App-link" to="/users">Users</Link></span>
        </Page>
    )

}

export default User
