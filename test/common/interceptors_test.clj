(ns common.interceptors-test
  (:require [clojure.test :refer :all]
            [commons.interceptors :as i]
            [io.pedestal.http.content-negotiation]
            )
  (:import (io.pedestal.interceptor Interceptor)))

(deftest negotiation-interceptors
  (testing "should return supported types for interceptor"
    (is (= ["text/json"] i/supported-types)))
  (testing "should return interceptor instance"
    (is (= (class i/content-negotiation-interceptor) Interceptor)))
  (testing "should return negotiate-content interceptor type"
    (is (= (:name i/content-negotiation-interceptor) :io.pedestal.http.content-negotiation/negotiate-content))))

(deftest coerce-json-interceptor
  (let [context {:response {:status 200 :body {:foo "bar"}}}]
    (testing "should have name ::coerce-body"
      (is (= (:name i/coerce-json-interceptor) :commons.interceptors/coerce-body)))
    (testing "should transform to string"
      (is (= ((:leave i/coerce-json-interceptor) context)
             {:response {:body    "{\"foo\":\"bar\"}"
                         :headers {"Content-Type" "text/json"}
                         :status  200}})))))