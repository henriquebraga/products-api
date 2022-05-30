(ns db.memory-db)


(defonce db (atom {:category {}}))

(defn flush-db! []
  (swap! db dissoc :category)
  (swap! db assoc :category {}))




