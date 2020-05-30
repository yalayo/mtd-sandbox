(ns models.users.core
  (:require [re-frame.core :as re-frame]
            [re-graph.core :as re-graph]
            [clojure.string :as string]))



(re-frame/reg-event-fx
 ::generate-users
 (fn [{:keys [db]} [_ q]]
   {:db db
    :dispatch [::generate-user1]
    }
   {:db db
    :dispatch [::generate-user2]
    }
   {:db db
    :dispatch [::generate-user3]
    }))

(re-frame/reg-event-fx
 ::generate-user1
 (fn [{:keys [db]} [_ q]]
   {:db db
    :dispatch [::re-graph/query "{ generateUser { userId userFullName userId eoriNumber emailAddress mtdItId nino vatRegistrationDate vrn saUtr } }"
               {}
               [::user1-generated]]}))

(re-frame/reg-event-db
 ::user1-generated
 (fn [db [_ {:keys [data errors] :as payload}]]
   (if (seq errors)
     (println errors)
     (assoc db :user1 (data :generateUser)))))

(re-frame/reg-sub
 ::user1
 (fn [db _]
   (db :user1)))

;; Remove asap (refactor)

(re-frame/reg-event-fx
 ::generate-user2
 (fn [{:keys [db]} [_ q]]
   {:db db
    :dispatch [::re-graph/query "{ generateUser { userId userFullName userId eoriNumber emailAddress mtdItId nino vatRegistrationDate vrn saUtr } }"
               {}
               [::user2-generated]]}))

(re-frame/reg-event-db
 ::user2-generated
 (fn [db [_ {:keys [data errors] :as payload}]]
   (if (seq errors)
     (println errors)
     (assoc db :user2 (data :generateUser)))))

(re-frame/reg-sub
 ::user2
 (fn [db _]
   (db :user2)))

(re-frame/reg-event-fx
 ::generate-user3
 (fn [{:keys [db]} [_ q]]
   {:db db
    :dispatch [::re-graph/query "{ generateUser { userId userFullName userId eoriNumber emailAddress mtdItId nino vatRegistrationDate vrn saUtr } }"
               {}
               [::user3-generated]]}))

(re-frame/reg-event-db
 ::user3-generated
 (fn [db [_ {:keys [data errors] :as payload}]]
   (if (seq errors)
     (println errors)
     (assoc db :user3 (data :generateUser)))))

(re-frame/reg-sub
 ::user3
 (fn [db _]
   (db :user3)))

