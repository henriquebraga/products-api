(ns controllers.healthcheck)

(defn healthcheck
  [request]
  {:status 200 :body {:status "Service OK"}})

