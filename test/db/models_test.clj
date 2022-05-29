(ns db.models-test
  (:require [clojure.test :refer :all]
            [db.models :as m]))


(deftest category-test
    (testing "should create category"
      (let [
            id "EL"
            name "Electronics"
            description "Electronics"
            slug "/electronics"
            ]
        (is (= (m/category id name description slug)
               {:id id
                :name name
                :description description
                :slug slug})))))

