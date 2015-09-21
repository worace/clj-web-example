## Clojure Web App Template

Simple example app attempting to put together a straightforward
clojure web stack, including:

* [X] Log configuration
* [ ] DB access using Postgres
* [X] DB migrations using Migratus
* [ ] Clojurescript support including Figwheel
* [ ] Reagent frontend
* [X] HTTP-Kit webserver
* [ ] simple websocket hook on HTTP-kit
* [X] code reloading (ring reload middleware)
* [ ] Procfile for heroku

## Running

To start a web server for the application, run:

    lein run

## DB Migrations

Migrations are managed using the [Migratus](https://github.com/yogthos/migratus)
library.

Migration files are stored in `resources/db/migrations`.

You can create a new migration file using:

```
lein migratus create create-examples-table
```

Once your migrations are prepared, you can run them with:

```
lein migratus migrate
```

or revert the last one with:

```
lein migratus rollback
```

## License

Copyright © 2015 FIXME
