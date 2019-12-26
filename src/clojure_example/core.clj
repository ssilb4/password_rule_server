(ns clojure-example.core
  (:require 
    [dotenv :refer [env app-env]]
    [compojure.core :refer :all]
    [compojure.route :as route]
    [org.httpkit.server :as server]
    [ring.middleware.json :as js]
    [ring.middleware.defaults :refer :all]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as json]
    [clojure-example.lib.routes :as routes])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] routes/echo-route)
  (GET "/password-rules" [] routes/get-password-rule-route)
  (POST "/password-rules" [] routes/add-password-rule-route)
  (GET "/password-rules/:id" [id] (fn [req] (routes/get-password-rule-route req id))))

(defn -main
  "Production"
  [& args]
    (let [port (Integer/parseInt (env :PORT))]
    (server/run-server (js/wrap-json-params (js/wrap-json-response (wrap-defaults #'app-routes api-defaults))) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))