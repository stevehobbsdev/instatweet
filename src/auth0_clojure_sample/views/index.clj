(ns auth0-clojure-sample.views.index
  (:require
   [auth0-clojure-sample.views.components :as components]
   [hiccup.element :refer [link-to]]))

(def index-hero
  "Defines the markup for the hero panel"
  [:div {:class "text-center hero my-5"}
   [:img {:class "mb-3 app-logo" :src "/logo.png" :alt "Clojure logo"}]
   [:h1 {:class "mb-4"} "Clojure Sample Project"]
   [:p.lead "This is a sample application demonstrating the authentication flow, using Clojure"]])

(def content-panel-data
  "Defines the data for the content panels. Returns an array of maps containing `title`, `url` and `content`."
  [{:title "Configure other identity providers"
    :url "https://auth0.com/docs/connections"
    :content "Auth0 supports social providers as Facebook, Twitter, Instagram and 100+, Enterprise providers as Microsoft Office 365, Google Apps, Azure, and more. You can also use any OAuth2 Authorization Server."}
   {:title "Configure other identity providers"
    :url "https://auth0.com/docs/connections"
    :content "Auth0 supports social providers as Facebook, Twitter, Instagram and 100+, Enterprise providers as Microsoft Office 365, Google Apps, Azure, and more. You can also use any OAuth2 Authorization Server."}
   {:title "Configure other identity providers"
    :url "https://auth0.com/docs/connections"
    :content "Auth0 supports social providers as Facebook, Twitter, Instagram and 100+, Enterprise providers as Microsoft Office 365, Google Apps, Azure, and more. You can also use any OAuth2 Authorization Server."}
   {:title "Configure other identity providers"
    :url "https://auth0.com/docs/connections"
    :content "Auth0 supports social providers as Facebook, Twitter, Instagram and 100+, Enterprise providers as Microsoft Office 365, Google Apps, Azure, and more. You can also use any OAuth2 Authorization Server."}])

(defn- content-panel
  "Builds the markup for an individual pane on the content panel, given a map with `url`, `title` and `content`.
  `content` should just be a single paragraph of text."
  [{url :url
    title :title
    content :content}]
  [:div.content-panel
   [:h5 {:class "mb-3"}
    (link-to url components/link-icon title)]
   [:p content]])

(def index-content
  "Builds the markup for the content panel on the index page"
  [:div {:class "d-flex justify-content-between flex-wrap"}
   (map content-panel content-panel-data)])

(defn html
  "Builds the markup for the index page"
  []
  [:div index-hero
   [:div {:class "next-steps"}
    [:h2 {:class "mt-5 text-center"} "What can I do?"]
    index-content]])
