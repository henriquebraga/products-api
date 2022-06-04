(ns service-test
  (:require [clojure.data.json :as json]
            [clojure.test :refer :all]
            [io.pedestal.test :refer :all]
            [io.pedestal.http :as http]
            [service :as service]))

(def service
  (::http/service-fn (http/create-servlet service/service)))

(deftest healthcheck-test
  (let [response (response-for service :get "/healthcheck")]
    (is (= (json/read-str (:body response))
           {"status" "Service OK"}))
    (is (= (:status response)
           200))))