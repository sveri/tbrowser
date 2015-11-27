(ns de.sveri.tbrowser.scenes
  (:require
    [fx-clj.core :as fx]
    [clojure.java.io :as io])
  (:import (javafx.fxml FXMLLoader)
           (javafx.scene.web WebView WebEngine)))

;(defn add-webview []
;  (let [wv (new WebView)]
;    ))

(defn open-uri [e]
  (println "cl"))

(defn test-view []
  ;(let [view (FXMLLoader/load
  ;             (io/resource "scenes/exampleenlive.xml"))]
  ;  (fx/at! view
  ;          "#my-btn"
  ;          {:on-action
  ;           (fn [e] (println "Got clicked!"))})
  ;  view)
  (let [view (FXMLLoader/load
               (io/resource "scenes/mainwindow.fxml"))
        we (new WebEngine)
        (fx/at!)]
    (fx/at! view
            "#browsetouri"
            {:on-action
             open-uri
             ;(fn [_] (println "Got clicked!"))
             })
    view)
  )

(fx/sandbox #'test-view)