(defproject http-garage-door "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [metosin/compojure-api "1.1.8"]]
  :ring {:handler http-garage-door.handler/app}
  :uberjar-name "http-garage-door.jar"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[ikitommi/lein-ring "0.9.8-FIX"]]}})
