(ns models.users.core
  (:require [re-frame.core :as re-frame]
            [re-graph.core :as re-graph]
            [clojure.string :as string]))


;(defn init[]
 ; (re-graph/init {:http {:url "https://3vsyt7kgfffilfb54esnzlhnuu.appsync-api.us-east-1.amazonaws.com/graphql"
  ;                     :http-parameters
   ;                    {:with-credentials? false
    ;                    :headers {"host" "3vsyt7kgfffilfb54esnzlhnuu.appsync-api.us-east-1.amazonaws.com"
     ;                             "x-api-key" "da2-nrwm45qlsjbtvlpuf5tpk27q3i"}}
      ;                   :ws   nil}}))

;(init)

;(defn consulta[]
 ; (re-graph/query "query {generateUser {userFullName userId eoriNumber}}"
  ;                {}
   ;               (callback)))

;(defn callback [db [_ {:keys [data errors] :as payload}]]
;                (println data))

                                        ;(consulta)

;(re-frame/reg-event-fx
; ::init
; (fn [{:keys [db]} [_ _]]
;   {:db db
;    :dispatch [::init-re-graph]}))


;(re-frame/reg-event-fx
; ::init-re-graph
; (fn [{:keys [db]} [_ _]]
;   {:db db
;    :dispatch }))


(re-frame/reg-event-fx
 ::generate-user
 (fn [{:keys [db]} [_ q]]
   {:db db
    :dispatch [::re-graph/query "{ generateUser { userFullName userId eoriNumber } }"
               {}
               [::user-generated]]}))

(re-frame/reg-event-db
 ::user-generated
 (fn [db [_ {:keys [data errors] :as payload}]]
   (if (seq errors)
     (println errors)
     (assoc db :user (data :generateUser)))))

(re-frame/reg-sub
 ::user
 (fn [db _]
   (db :user)))

