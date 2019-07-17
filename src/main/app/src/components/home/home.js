import React    from 'react'

import { Link } from 'react-router-dom'

import Page     from '../Page'

const Home = () =>
    <Page header="Home">
        <p>
            ReactJS Client Routing and Javalin Server Routing.
        </p>
        <span><Link className="App-link" to="/users">Users</Link> | <Link className="App-link" to="/no/such/route">No Such Route</Link></span>
    </Page>

export default Home
