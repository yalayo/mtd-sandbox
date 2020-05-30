(ns views.users.pick-user
  (:require [re-frame.core :as re-frame]
            [views.users.show-user :refer [show-user-component]]
            [models.users.core :as model]))

(defn pick-user-component [{:keys [user1 user2 user3] :as data}]
  (let [user1 @(re-frame/subscribe [::model/user1])
        user2 @(re-frame/subscribe [::model/user2])
        user3 @(re-frame/subscribe [::model/user3])
        data {:user1 user1 :user2 user2 :user3 user3}]
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
      [show-user-component user3]]]]]))
