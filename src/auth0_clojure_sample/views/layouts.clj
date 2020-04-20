(ns auth0-clojure-sample.views.layouts
  (:require [hiccup.page :refer [html5 include-css include-js]]
            [auth0-clojure-sample.components.navbar :as navbar]
            [auth0-clojure-sample.components.footer :as footer]))

(def assets
  {:css ["/bootstrap.css"
         "https://cdn.auth0.com/js/auth0-samples-theme/1.0/css/auth0-theme.min.css"
         "https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
         "//cdn.jsdelivr.net/gh/highlightjs/cdn-release@9.17.1/build/styles/default.min.css"
         "/main.css"]
   :js ["https://code.jquery.com/jquery-3.2.1.slim.min.js"
        "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        "//cdn.jsdelivr.net/gh/highlightjs/cdn-release@9.17.1/build/highlight.min.js"
        "/app.js"]})

(defn default
  [title profile & body]
  (html5 {:class "h-100"}
         [:head
          [:meta {:charset "utf-8"}]
          [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
          [:title title]
          [:base {:href "/"}]
          (map include-css (assets :css))]
         [:body {:class "h-100"}
          (navbar/html profile)
          [:div {:class "d-flex flex-column h-100"}
           [:div {:class "flex-grow-1 flex-shrink-1 container"}
            body]
           footer/html
           (map include-js (assets :js))]]))
