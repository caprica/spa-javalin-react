# spa-javalin-react
A Basic Javalin web application configured for a ReactJS single page client application.

This project uses ReactJS, using AngularJS or any other client framework should be very similar.

Anyway, here it is, a skeleton project for a single page web application using Javalin for the middle tier.

Key features:

 * The web application is mapped to the root "/" context
 * All static resources are under the "/assets/" path
 * A request for "index.html" will redirect to "/" for a nicer URL in the address bar
 * All web-service API are under an "/api/" path
 * A request for an unknown API will have a catch-all that maps to a BAD_REQUEST response
 * Any other request, including deep-link requests, will map to the single page web application for client
   routing
 * Does NOT rely on ugly hashes '#' in URLs or the address bar

The names for the path prefixes used are arbitrary and can be changed to whatever you prefer.

There is no cache control for the static resources, you might like to consider that.

You can run this project from a shell/terminal, simply type:

```
mvn exec:java
```

Then open your browser at the following URLs to prove it's all configured properly:

```
http://localhost:8080
http://localhost:8080/index.html
http://localhost:8080/api/users
http://localhost:8080/api/users/boss
http://localhost:8080/api/users/emo
http://localhost:8080/api/users/emma
http://localhost:8080/api/version
http://localhost:8080/api/anything-else-does-not-exist
http://localhost:8080/assets/css/index.css
http://localhost:8080/assets/img/star.png
http://localhost:8080/assets/js/app.js
```

It can still be useful to route to static assets on the server - e.g. images or scripts that not part of the client
application itself.

This project also has client-side routing enabled. These are deep links that will be routed to the client index
page where the React router will take over:

```
http://localhost:8080/users
http://localhost:8080/users/boss
http://localhost:8080/users/emo
http://localhost:8080/users/emma
http://localhost:8080/a/not/found/page
```

Full refreshes will work and be routed correctly.

Everything else is just like any other ReactJS application.

If you want to disable source maps, look in the package.json for the scripts section and make the following
change:

```
  "scripts": {
    "start": "react-scripts start",
    "build": "GENERATE_SOURCEMAP=false react-scripts build",
    "test": "react-scripts test",
    "eject": "react-scripts eject"
  },
```

Proxying API requests also works just the same as before, add the following to your package.json (this has
already been applied in this project):

```
"proxy": "http://localhost:8080"
```

You may need to adjust the port number, in this case 8080 is the port number used by the Jetty container launched
by the aforementioned maven command.

And then as usual to run the development version of the application (use port 3000 by default rather than 8080):

```
cd src/main/app
yarn start
```

You're welcome.
