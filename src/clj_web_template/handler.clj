(ns clj-web-template.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-web-template.views :as views]
            [clj-web-template.db :as db]
            [ring.logger.timbre :as timbre-mw]
            [ring.middleware.reload :as reload-mw]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn home []
  "Hello World")

(defroutes app-routes
  (GET "/" [] (views/home (db/all-examples db/config)))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
       (wrap-defaults site-defaults)
       (timbre-mw/wrap-with-logger)
       (reload-mw/wrap-reload)))


