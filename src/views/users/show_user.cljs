(ns views.users.show-user
  (:require [re-frame.core :as re-frame]
            [models.users.core :as model]))

(defn show-user-component [user]
    [:div
     [:p (get user :userFullName)]
     [:p (get user :emailAddress)]
     [:p (get user :eoriNumber)]
     [:p (get user :mtdItId)]
     [:p (get user :nino)]
     [:p (get user :saUtr)]
     [:p (get user :vrn)]
     [:button {:onClick (fn [e]
                          (.preventDefault e)
                          (re-frame/dispatch [::model/generate-user]))} "Select"]])
