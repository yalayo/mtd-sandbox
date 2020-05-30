(ns ^:figwheel-hooks webapp.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [re-graph.core :as re-graph]
   [views.users.pick-user :refer [pick-user-component]]
   [models.users.core :as model]))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:user nil}))

(defn init-re-graph []
  (re-frame/dispatch-sync [::re-graph/init {:ws nil
                                            :http {:url "https://3vsyt7kgfffilfb54esnzlhnuu.appsync-api.us-east-1.amazonaws.com/graphql"
                                                   :impl {:with-credentials? false :headers {"x-api-key" "da2-oihdtbkwffbbrb6rrgnzmawowy" }}}}])

  (re-frame/dispatch-sync [::model/generate-user1])
  (re-frame/dispatch-sync [::model/generate-user2])
  (re-frame/dispatch-sync [::model/generate-user3]))

(init-re-graph)

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (rdom/render [pick-user-component] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
