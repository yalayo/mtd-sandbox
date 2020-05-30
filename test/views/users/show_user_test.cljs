(ns views.users.show-user-test
  (:require [views.users.show-user :refer [show-user-component]]
            [devcards.core :refer-macros [defcard defcard-rg]]))

(defn- show-component [user]
  [show-user-component user])

(def user {:userId "459365552472" :userFullName "Gabi Edwards" :eoriNumber "GB8375544331" :emailAddress "gabi.edwards@example.com" :mtdItId "XTIT00363444181" :nino "KE107507B" :vatRegistrationDate "2019-05-30" :vrn "665428512" :saUtr"4912714855"})

(defcard-rg show-user
  [:div
   [:h1 [:i "Show user component"]]
   [show-component user]])
