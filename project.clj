(defproject clj-web-template "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :main clj-web-template.core
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [http-kit "2.1.18"]
                 [environ "1.0.1"]
                 [com.taoensso/timbre "4.1.1"]
                 [ring-logger-timbre "0.7.0"]
                 [ring "1.4.0"
                  :exclusions [ring/ring-jetty-adapter
                               ring/ring-servlet]]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[lein-ring "0.8.13"]
            [lein-environ "1.0.1"]]
  :ring {:handler clj-web-template.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
