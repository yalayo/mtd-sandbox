(ns models.users.core-test
  (:require [re-frame.core :as re-frame]
            [re-graph.core :as server]
            [day8.re-frame.test :refer [run-test-sync]]
            [cljs.test :refer [use-fixtures] :refer-macros [testing is]]
            [devcards.core :refer-macros [deftest]]
            [clojure.spec.alpha :as s]
            [specs.users.core :as spec]
            [models.users.core :as model]))

(defn- stub-server-response [response]
  (re-frame/reg-event-fx
   ::model/generate-user
   (fn [{:keys [db]} [_ q]]
     {:dispatch [::model/user-generated {:data response}]})))

(def user {:eoriNumber "GB7951164894" :emailAddress "tristen.russel@example.com" :mtdItId "XKIT00868578584" :nino "GW989636D" :vatRegistrationDate "2018-05-23" :userFullName "Tristen Russel" :userId "853180638820" :vrn "464194337" :groupIdentifier "197140739471" :saUtr "3777144085" :individualDetails { :firstName "Tristen" :lastName "Russel" :dateOfBirth "1959-02-22" :address { :line1 "20 Tower Hill" :line2 "Verwood" :postcode "TS16 1PA"}} :password "2ga5HOfgxEuW"})

(deftest generate-user-test
  (run-test-sync
   (stub-server-response user)
   (let [u (re-frame/subscribe [::model/user])]
     (testing "request to generate a new user"
       (re-frame/dispatch [::model/generate-user])

       (is (= user @u))
       (is (s/valid? ::spec/user @u))))))
