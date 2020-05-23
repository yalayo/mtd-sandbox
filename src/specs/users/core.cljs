(ns specs.users.core
  (:require [clojure.spec.alpha :as s]))

(s/def ::userId string?)
(s/def ::userFullName string?)
(s/def ::emailAddress string?)
(s/def ::eoriNumber string?)
(s/def ::mtdItId string?)
(s/def ::nino string?)
(s/def ::vatRegistrationDate string?)
(s/def ::vrn string?)
(s/def ::groupIdentifier string?)
(s/def ::saUtr string?)

(s/def ::user (s/keys :req-un [::userId ::userFullName ::emailAddress ::eoriNumber ::mtdItId ::nino ::vatRegistrationDate ::vrn ::groupIdentifier ::saUtr]))


