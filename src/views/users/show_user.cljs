(ns views.users.show-user
  (:require [re-frame.core :as re-frame]
            [models.users.core :as model]))

(defn show-user-component [user]
  [:div
   [:div.columns.is-mobile.is-multiline
    [:div.column.is-two-fifths.is-narrow
     [:p.title.is-4 "Name"]
     [:p.subtitle.is-6 (get user :userFullName)]]
    [:div.column
     [:p.title.is-4 "Email"]
     [:p.subtitle.is-6 (get user :emailAddress)]]]
   [:div.columns
    [:div.column
     [:p.title.is-4 "National insurance number"]
     [:p.subtitle.is-6 (get user :nino)]]]
   [:div.columns
    [:div.column
     [:p.title.is-4 "MTD id"]
     [:p.subtitle.is-6 (get user :mtdItId)]]]
   [:div.columns.is-vcentered
    [:div.column
     [:p.title.is-4 "Sa UTR"]
     [:p.subtitle.is-6 (get user :saUtr)]]
    [:div.column.is-one-quarter
     [:button.button.is-success.is-medium "Select"]]]])
