(ns views.users.pick-user-test
  (:require [views.users.pick-user :refer [pick-user-component]]
            [devcards.core :refer-macros [defcard defcard-rg]]))

(def user {:userId "459365552472" :userFullName "Gabi Edwards" :eoriNumber "GB8375544331" :emailAddress "gabi.edwards@example.com" :mtdItId "XTIT00363444181" :nino "KE107507B" :vatRegistrationDate "2019-05-30" :vrn "665428512" :saUtr"4912714855"})

(defn- show-component [data]
  [pick-user-component data])

(defcard-rg pick-user
  [:div
   [:h1 [:i "Pick user component"]]
   [show-component {:user1 user :user2 user :user3 user}]])


