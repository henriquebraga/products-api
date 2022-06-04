(ns commons.interceptors
  (:require [clojure.data.json :as json]
            [io.pedestal.http.content-negotiation :as c-negotiation]))

(def supported-types ["text/json"])

(def coerce-json-interceptor
  {:name ::coerce-body
   :leave
   (fn [context]
     (let [response (get context :response)
           body (get response :body)
           coerced-body (json/write-str body)
           updated-response (assoc response
                              :headers {"Content-Type" "text/json"}
                              :body coerced-body)]
       (assoc context :response updated-response)))})

(def content-negotiation-interceptor (c-negotiation/negotiate-content supported-types))