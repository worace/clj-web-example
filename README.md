## Clojure Web App Template

Simple example app attempting to put together a straightforward
clojure web stack, including:

* [X] Log configuration
* [X] DB access using Postgres
* [X] DB queries using Yesql
* [X] DB migrations using Migratus
* [ ] Clojurescript support including Figwheel
* [ ] Reagent frontend
* [X] HTTP-Kit webserver
* [ ] simple websocket hook on HTTP-kit
* [X] code reloading (ring reload middleware)
* [X] Procfile for heroku

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

## DB Setup

The db will need to be created in the appropriate postgres
server.

__Locally__

```
createdb clj_web_template_development
```

__Heroku__

```
heroku addons:create heroku-postgresql:hobby-dev
```

## License

Copyright © 2015 FIXME
