(ns views.users.show-user-test
  (:require [views.users.show-user :refer [show-user-component]]
            [devcards.core :refer-macros [defcard defcard-rg]]))

(defn- show-component []
  [show-user-component])

(defcard-rg show-user
  [:div
   [:h1 [:i "Show user"]]
   [show-user-component]])
