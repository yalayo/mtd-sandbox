(ns views.users.pick-user
  (:require [views.users.show-user :refer [show-user-component]]))

(defn pick-user-component [{:keys [user1 user2 user3] :as data}]
  [:div.container
   [:div.columns
    [:div.column
     [:div.box
      [show-user-component user1]]]
    [:div.column
     [:div.box
      [show-user-component user2]]]
    [:div.column
     [:div.box
      [show-user-component user3]]]]])
