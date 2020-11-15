(ns pg-rest.lib.routes
    (:require
      [compojure.core :refer :all]
      [compojure.route :as route]
      [clojure.pprint :as pp]
      [clojure.string :as str]
      [clojure.data.json :as json]
      [pg-rest.lib.api :as api])
    (:gen-class))
  
  (defn echo-route 
    "Echo back the request"
    [req]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (-> (str "GET '/' " req))})
  
  (defn get-teachers-route 
    "Echo back a name"
    [req]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (-> (api/get-teachers))})
  
  (defn add-teachers-route 
    "Endpoint for adding a teachers"
    [req]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (-> (api/add-teachers (req :params)))})