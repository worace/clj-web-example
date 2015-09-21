(ns clj-web-template.db
  (:require [yesql.core :as sql]
            [environ.core :refer [env]]))

(def config (env :database-url))

(sql/defqueries "db/queries/examples.sql")
