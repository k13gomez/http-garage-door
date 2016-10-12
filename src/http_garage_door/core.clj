(ns http-garage-door.core
  (:require [clojure.java.shell :refer [sh]]))

(defn get-status
  []
  (let [status (:out (sh "gpio" "read" "23"))]
    (if (= status "1\n")
      "closed" "open")))

(defn predict-status
  []
  (let [current (get-status)]
    (if (= current "open")
      "closed" "open")))

(defn toggle-status
  []
  (sh "gpio" "write" "7" "0")
  (Thread/sleep 1000)
  (sh "gpio" "write" "7" "1")
  (predict-status))
