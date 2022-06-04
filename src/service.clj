(ns service
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [controllers.healthcheck :as c.h]
            [commons.interceptors :as i])
  )


(def routes
  (route/expand-routes
    #{["/healthcheck" :get [i/coerce-json-interceptor i/content-negotiation-interceptor c.h/healthcheck] :route-name :healthcheck]}))

(def service {
              :env          :prod
              ::http/routes routes
              ::http/type   :jetty
              ::http/port   8085})


