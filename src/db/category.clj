(ns db.category)


(defn upsert-category
  [db category]
  (let [id (:id category)
        categories (:category db)]
    (if (contains? categories id)
      (do
        (update-in db [:category] dissoc id)
        (update-in db [:category] assoc id category))
      (update-in db [:category] assoc id category))))

(defn delete-category
  [db category-id]
  (print "db" db)
  (if-let [id-exists-in-db? (-> db
                              :category
                              (get ,,, category-id))]


    (update-in db [:category] dissoc category-id))
  )