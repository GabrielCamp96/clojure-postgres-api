(ns pg-rest.lib.api
    (:require 
      [compojure.core :refer :all]
      [compojure.route :as route]
      [clojure.pprint :as pp]
      [clojure.string :as str]
      [clojure.data.json :as cjson]
      [pg-rest.lib.db :as db])
    (:gen-class))
  
  (defn get-teachers 
    "Retrieve a list of records from teachers"
    []
    (db/select :teachers [:id :name :class ]))
  
  (defn add-teachers 
    "Add a record to teachers"
    [{ name :name class :class :as record }]
    (db/insert :teachers record))