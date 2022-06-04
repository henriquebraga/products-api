(defproject products-api "0.1.0-SNAPSHOT"
  :description "Products API"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :resource-paths ["config", "resources"]
  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "http-server/run-dev"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.5.5"]]}}
  :plugins [[lein-cloverage "1.2.2"]]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [io.pedestal/pedestal.service       "0.5.10"]
                 [io.pedestal/pedestal.jetty         "0.5.10"]
                 [org.clojure/data.json "2.4.0"]]
  :repl-options {:init-ns products-api.core}
  :main http-server
  )
