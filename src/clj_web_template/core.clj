(ns clj-web-template.core
  (:require [org.httpkit.server :as http-kit]
            [clj-web-template.config.utils :as utils]
            [clj-web-template.handler :as handler])
  (:gen-class))

(defonce http-server (atom nil))

(defn start-http-server [port]
  (http-kit/run-server handler/app {:port port}))

(defn stop! []
  (when @http-server
    (@http-server :timeout 100)
    (reset! http-server nil))
  (shutdown-agents))

(defn start! [port]
  (reset! http-server (start-http-server port))
  (.addShutdownHook (Runtime/getRuntime) (Thread. stop!)))

(defn -main [& args]
  (start! (utils/http-port (first args))))
