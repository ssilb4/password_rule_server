(ns clojure-example.lib.routes
	(:require
		[compojure.core :refer :all]
		[compojure.route :as route]
		[clojure.pprint :as pp]
		[clojure.string :as str]
		[clojure.data.json :as json]
		[clojure-example.lib.api :as api])
	(:gen-class))

(defn echo-route 
	"Echo back the request"
  [req]
	{:status 200
   :headers {"Content-Type" "text/html"}
   :body (-> (str "GET '/' " req))})

(defn get-password-rule-route 
	"Echo back a name"
  [req]
	{:status 200
	 :headers {"Content-Type" "application/json"}
	 :body (do (-> (api/get-password-rule)))})

(defn add-password-rule-route 
	"Endpoint for adding a password Rule"
  [req]
	{:status 200
	 :headers {"Content-Type" "application/json"}
	 :body (-> (api/add-password-rule (req :params)))})