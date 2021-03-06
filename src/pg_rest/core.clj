; Projeto realizado para a disciplina Linguagens Funcionais do 5° ano de Engenharia da Computação do IMT - Instituto Mauá de Tecnologia
; Aulas ministradas pelo Prof. Aparecido Freitas

; Alunos:
; Matheus Mandotti - 16.00177-0 
; Kevin Iiyama - 16.01391-3
; Gabriel Soares - 16.00151-6
; João Correa - 16.00410-8
; Henrique Poladian - 16.00026-9


(ns pg-rest.core
  (:require 
    [dotenv :refer [env app-env]]
    [compojure.core :refer :all]
    [compojure.route :as route]
    [org.httpkit.server :as server]
    [ring.middleware.json :as js]
    [ring.middleware.defaults :refer :all]
    [ring.middleware.reload :refer [wrap-reload]]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as json]
    [pg-rest.lib.routes :as routes])
  (:gen-class))

  (defroutes app-routes
    (GET "/" [] routes/echo-route)
    (GET "/teachers" [] routes/get-teachers-route)
    (POST "/teachers" [] routes/add-teachers-route))
  
  (defn -main
    "Production"
    [& args]
      (let [port (Integer/parseInt (env :PORT))]
      (server/run-server (js/wrap-json-params (js/wrap-json-response (wrap-defaults #'app-routes api-defaults))) {:port port})
      (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
  
  (defn -dev-main
    "Dev/Test (auto reload watch enabled)"
    [& args]
      (let [port (Integer/parseInt (env :PORT))]
      (server/run-server (wrap-reload (js/wrap-json-params (js/wrap-json-response (wrap-defaults #'app-routes api-defaults)))) {:port port})
      (println (str "Running webserver at http:/127.0.0.1:" port "/"))))