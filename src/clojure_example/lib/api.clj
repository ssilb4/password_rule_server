(ns clojure-example.lib.api
  (:require 
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as cjson]
    [clojure-example.lib.db :as db])
  (:gen-class))

(defn get-password-rule 
  "Retrieve a list of records from friends"
  []
  (db/select :passwordrule [:name :number :lower :upper :special :count :min :max :etc]))

(defn add-password-rule
  "Add a record to friends"
  [{ name :name number :number lower :lower upper :upper special :special count :count min :min max :max etc :etc :as record }]
  (db/insert :passwordrule record))