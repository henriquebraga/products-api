(ns http-server
  (:gen-class)
  (:require [io.pedestal.http :as http]
            [service :as service]))


(defonce service (http/create-server service/service))

(defn run-dev
  [& args]
  (println "Starting  [DEV] server...")
  (-> service/service
      (merge {
              :env :dev
              ::http/join? false
              ::http/routes #(deref #'service/routes)
              ::http/allowed-origins {:creds true :allowed-origins (constantly true)}})
      http/default-interceptors
      http/dev-interceptors
      http/create-server
      http/start))

(defn -main
  "The entry-point for 'lein run'"
  [& args]
  (println "\nCreating your server...")
  (http/start service))
