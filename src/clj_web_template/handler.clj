(ns clj-web-template.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clj-web-template.views :as views]
            [clj-web-template.db :as db]
            [ring.logger.timbre :as timbre-mw]
            [ring.util.response :refer [redirect]]
            [ring.middleware.reload :as reload-mw]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn home []
  "Hello World")

(defn admin-param [val]
  (if (= "true" val) true false))
(defn create-example [{:keys [name admin pass]}]
  (db/create-example! name (admin-param admin) pass))

(defroutes app-routes
  (GET "/" [] (views/home (db/all-examples db/config)))
  (POST "/examples"
        request
        (do
          (create-example (:params request))
          (redirect "/")))
  (route/not-found "Not Found"))

(def app
  (-> #'app-routes
      (wrap-defaults (assoc-in site-defaults
                               [:security :anti-forgery]
                               false))
       (timbre-mw/wrap-with-logger)
       (reload-mw/wrap-reload)))


