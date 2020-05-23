(ns models.users.core
  (:require [re-frame.core :as re-frame]
            [re-graph.core :as re-graph]))

(re-frame/reg-event-fx
 ::generate-user
 (fn [{:keys [db]} [_ q]]
   {:dispatch [re-graph/query
               "{ things { id } }"
               {}
               [::user-generated]]}))

(re-frame/reg-event-db
 ::user-generated
 (fn [db [_ {:keys [data errors] :as payload}]]
   (assoc db :user data)))

(re-frame/reg-sub
 ::user
 (fn [db _]
   (db :user)))
