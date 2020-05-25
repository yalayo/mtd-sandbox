(ns views.users.show-user
  (:require [re-frame.core :as re-frame]
            [models.users.core :as model]))

(defn show-user-component []
  (let [user @(re-frame/subscribe [::model/user])]
    [:div "User"
     [:p (get user :userFullName)]
     [:p (get user :emailAddress)]
     [:p (get user :vatRegistrationDate)]
     [:button {:onClick (fn [e]
                          (.preventDefault e)
                          (re-frame/dispatch [::model/generate-user]))} "Generate"]]))
