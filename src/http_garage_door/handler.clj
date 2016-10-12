(ns http-garage-door.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [http-garage-door.core :refer :all]))

(initialize)

(def app
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "http-garage-door"
                    :description "HTTP Garage Door API"}
             :tags [{:name "api", :description "control the garage door over http"}]}}}

    (context "/api" []
      :tags ["api"]

      (GET "/status" []
        :return String
        :summary "returns the status of the garage door"
        (ok (get-status)))

      (POST "/toggle" []
        :return String
        :summary "toggle the garage door open/closed"
        (ok (toggle-status))))))
