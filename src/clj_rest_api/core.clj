(ns clj-rest-api.core
  (:gen-class)
  (:require
   [integrant.core :as ig]
   [ring.adapter.jetty :as jetty]
   [ring.util.response :as response]))

;;; handlers

(defn hello-world [_request]
  (response/response "Hello, World!"))

(defmethod ig/init-key ::app [_ _]
  hello-world)

;;; API server

(defmethod ig/init-key ::server [_ {:keys [app options]}]
  (jetty/run-jetty app options))

(defmethod ig/halt-key! ::server [_ server]
  (.stop server))

(def config
  {::app {}
   ::server {:app (ig/ref ::app)
             :options {:port 3000
                       :join? false}}})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (ig/init config))
