(ns auth0-clojure-sample.components.footer)

(def html
  [:footer {:class "bg-light p-3 text-center"}
   [:div.logo]
   [:p "Sample project provided by "
    [:a {:href "https://auth0.com"} "Auth0"]]])