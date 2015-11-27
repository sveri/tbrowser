(defproject tbrowser "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/core.async "0.2.374"]
                 [fx-clj "0.2.0-alpha1"]]
  :main ^:skip-aot tbrowser.core
  :target-path "target/%s"
  :profiles {:dev     {:repl-options {:init-ns          de.sveri.tbrowser.dev}}

             :uberjar {:aot :all}})
