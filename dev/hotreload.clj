(ns hotreload
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]
            [clj-rest-api.core :refer [handler]])
  (:gen-class))
(def dev-handler
  (wrap-reload #'handler))
(defn -main [& args]
  (run-jetty dev-handler {:port 13000}))
