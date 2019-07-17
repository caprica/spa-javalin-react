import React from 'react'

import logo from './logo.svg'

const Page = ({header, children}) =>
    <div className="App">
        <header className="App-header">
            <img src={logo} className="App-logo" alt="logo"/>
            {header && <h1>{header}</h1>}
            {children}
        </header>
    </div>

export default Page
