(ns db.category-test
  (:require [clojure.test :refer :all]
            [db.category :as db.c]
            )
  )

(deftest upsert-category-test
  (testing "create category when does not exist"
    (let [db {:category {}}
          electronics {:id          "EL"
                       :name        "Electronics"
                       :description "Electronics"
                       :slug        "/electronics"
                       }
          ]
      (is (= {:category {"EL" electronics}}
             (db.c/upsert-category db electronics)
             ))))

  (testing "update values when category exists"
    (let [original-category {:id          "EL"
                             :name        "Electronics"
                             :description "Electronics"
                             :slug        "/electronics"}
          updated-category (assoc original-category :name "Electronics updated")
          db {:category {"EL" original-category}}]

      (is (= {:category {"EL" updated-category}}
             (db.c/upsert-category db updated-category))))))

(deftest delete-category-test
  (testing "return nil when deleting category does not exists"
    (let [db {:category {}}]
      (is (nil? (db.c/delete-category db "EL")))))

  (testing "return database without removed category"
    (let [
          sports {:id          "SP"
                  :name        "Sports"
                  :description "Sports"
                  :slug        "/sports"}
          electronics {:id          "EL"
                       :name        "Electronics"
                       :description "Electronics"
                       :slug        "/electronics"}
          db {:category {
                         "EL" electronics
                         "SP" sports}}]
      (is (= {:category {"SP" sports}}
             (db.c/delete-category db "EL"))))))

