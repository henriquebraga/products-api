(ns controllers.healthcheck)


(defn healthcheck
  [request]
  {:status 200 :body (str "Service OK")})
