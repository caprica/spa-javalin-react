import React             from 'react'

import { Switch, Route, Redirect } from 'react-router-dom'

import Home              from './components/home'
import NotFound          from './components/not-found'
import User              from './components/user'
import Users             from './components/users'

import './App.css'

const App = () => (
    <Switch>
        <Route exact path='/index.html'>
            <Redirect to="/"/>
        </Route>

        <Route exact path='/'                component={Home}    />
        <Route exact path='/users'           component={Users}   />
        <Route       path='/users/:username' component={User}    />
        <Route                               component={NotFound}/>
    </Switch>
)

export default App
