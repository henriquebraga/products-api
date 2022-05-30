(ns db.memory-db-test
  (:require [clojure.test :refer :all])
  (:require [db.memory-db :as db]))

(deftest flush-test
  (testing "should flush and delete all elements from db"
    (swap! db/db assoc-in [:category] {:id "EL" :name "Electronics" :slug "/electronics"}))
    (db/flush-db!)
    (is (= @db/db {:category {}}))
  )


