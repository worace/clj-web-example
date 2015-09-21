(ns clj-web-template.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.logger.timbre :as timbre-mw]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World PIZZA")
  (route/not-found "Not Found"))

(def app
  (timbre-mw/wrap-with-logger
   (wrap-defaults app-routes site-defaults)))


