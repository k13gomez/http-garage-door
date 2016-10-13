(ns http-garage-door.core
  (:require [clojure.java.shell :refer [sh]]))

(defn initialize
  []
  (sh "gpio" "write" "7" "1")
  (sh "gpio" "mode" "7" "out")
  (sh "gpio" "mode" "24" "up"))

(defn get-status
  []
  (let [status (:out (sh "gpio" "read" "24"))]
    (if (= status "1\n")
      "open" "closed")))

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
