(ns db.models)

(defn category
  [id name description slug]
  {:id          id
   :name        name
   :description description
   :slug        slug})
