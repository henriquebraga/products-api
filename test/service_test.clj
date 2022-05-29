(ns service-test
  (:require [clojure.test :refer :all]
            [io.pedestal.test :refer :all]
            [io.pedestal.http :as http]
            [service :as service]))

(def service
  (::http/service-fn (http/create-servlet service/service)))

(deftest healthcheck-test
  (is (=
        (:body (response-for service :get "/healthcheck"))
        "Service OK")
      )

  (is (=
        (:status (response-for service :get "/healthcheck"))
        200)))