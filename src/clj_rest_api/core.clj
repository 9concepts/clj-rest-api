(ns clj-rest-api.core
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))
(defn handler [request]
  {:status  200
   :headers {"Content-Type" "text/plain; charset=UTF-8"}
   :body    "hello world!\n"})
(defn -main [& args]
  (run-jetty handler {:port 3000}))
