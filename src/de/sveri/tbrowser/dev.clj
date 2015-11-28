(ns de.sveri.tbrowser.dev
  (:require [fx-clj.core :as fx]
            [clojure.core.async :refer [chan go <! >!]])
  (:import (javafx.scene.layout AnchorPane)
           (javafx.scene.control ScrollPane)
           (java.awt SplashScreen)
           (javafx.stage Modality)))



;(defn create-view []
;  (let [click-ch (chan)
;        ;(fx/)
;        btn (fx/button :#my-btn {:on-action click-ch ;; You can bind a core.async channel directly to an event
;                                 :text "Next"})
;
;        txt (fx/text "Initial text")
;        view (fx/v-box txt btn)]
;    (go
;      (<! click-ch)
;      (fx/run<! (fx/pset! txt "Next text"))
;      (<! click-ch)
;      (fx/run<!
;        (fx/pset! txt "Last text")
;

;AnchorPane.bottomAnchor="0.0" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0" AnchorPane.topAnchor="0.0"
;(def fit-anchor-to-parent {:AnchorPanetopAnchor 0.0})
;(def fit-anchor-to-parent {:AnchorPane.bottomAnchor 0.0 :AnchorPane.leftAnchor 0.0 :AnchorPane.rightAnchor 0.0 :AnchorPane.topAnchor 0.0})

(defn fill-anchor-pane
  "Make node can fill-in AnchiPnae."
  [x]
  (AnchorPane/setTopAnchor x 0.0)
  (AnchorPane/setBottomAnchor x 0.0)
  (AnchorPane/setLeftAnchor x 0.0)
  (AnchorPane/setRightAnchor x 0.0)
  x)

(defn open-uri [webengine urifield e]
  (.load webengine (.getText urifield)))

(defn main-window
  "airen"
  []
  (let [
        urifield (fx/text-field :#urifield {:prefWidth 700 :text "http://"})
        webview (fill-anchor-pane (fx/web-view :#webview))
        webengine (.getEngine webview)
        _ (.setJavaScriptEnabled webengine false)
        _ (.load webengine "http://heise.de")

        go-btn (fx/button :#go-btn {:text "Go" :on-action (partial open-uri webengine urifield)})
        uri-h-box (fx/h-box :#uri-h-box {:prefHeight 21} urifield go-btn)


        webview-anchor-pane (fill-anchor-pane (fx/anchor-pane :#webview-ap {} webview))
        ;webview-anchor-pane (fill-anchor-pane (AnchorPane.))
        ;_ (.add (.getChildren webview-anchor-pane) webview)
        ;_ (fill-anchor-pane webview-anchor-pane)

        ;webview-srcoll-pane (ScrollPane. webview-anchor-pane)
        ;_ (fill-anchor-pane webview-srcoll-pane)
        ;_ (.add (.getChildren webview-srcoll-pane) webview-anchor-pane)
        webview-srcoll-pane (fill-anchor-pane (fx/scroll-pane :#webview-sp {:prefWidth 1100} webview-anchor-pane))

        v-box-main (fill-anchor-pane (fx/v-box :#main-v-box {} uri-h-box webview-srcoll-pane))
        ;v-box-main (fx/v-box :#main-v-box {:prefHeight 575 :prefWidth 640} uri-h-box webview-srcoll-pane)

        anchor-pane-main (fill-anchor-pane (AnchorPane.))
        _ (.add (.getChildren anchor-pane-main) v-box-main)
        ;anchor-pane-main (fx/anchor-pane :#main-anchor-pane {} v-box-main)
        ;anchor-pane-main (fx/anchor-pane :#main-anchor-pane fit-anchor-to-parent v-box-main)
        view (fill-anchor-pane (fx/v-box :#top-v-box {} anchor-pane-main))


        ]
    view))

(defn ->webengine [webview]
  (let [webengine (.getEngine webview)]
      (.setJavaScriptEnabled webengine false)
      (.load webengine "http://heise.de")
      webengine))

(defn anchor-test []
  (let [urifield (fx/text-field :#urifield {:prefWidth 700 :prefHeight 180 :text "http://"})

        webview (fill-anchor-pane (fx/web-view :#webview))
        webengine (->webengine webview)

        go-btn (fx/button :#go-btn {:text "Go" :on-action (partial open-uri webengine urifield)})
        uri-h-box (fx/h-box :#uri-h-box {:prefHeight 21} urifield go-btn)





        view (fx/border-pane :border-pane {:center webview :top uri-h-box})]
    (->webengine webview)
    view))

(fx/sandbox #'anchor-test)
;(fx/sandbox #'main-window)






;{:max-height 1.7976931348623157E308 :max-width 1.7976931348623157E308}


;working
;(defn anchor-test []
;  (let [
;        webview (fill-anchor-pane (fx/web-view :#webview))
;        webengine (->webengine webview)
;
;
;        webview-anchor-pane (fill-anchor-pane (fx/anchor-pane :#ap {} webview))
;
;        view (fx/anchor-pane :#main {} webview-anchor-pane)]
;    ;view (fx/v-box :#main-v-box {} webview-anchor-pane)]
;    (->webengine webview)
;    view))