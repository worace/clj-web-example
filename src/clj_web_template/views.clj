(ns clj-web-template.views
  (:require [hiccup.core :refer [html]]
            [hiccup.form :as hf]
            [ring.util.anti-forgery refer [:anti-forgery-field]]))

(defn layout
  [content]
  (html [:html
         [:head
          [:meta {:http-equiv "Content-Type" :content "text/html" :charset "iso-8859-1"}]
          [:title "Clojure Web App Example"]]
         [:body
          content]]))

(defn form []
  (hf/form-to
   [:post "/examples"]
   (anti-forgery-field)
   [:div
    (hf/label "email" "Email")
    (hf/email-field {:placeholder "Email"} "example.email")]
   [:div
    (hf/label "pass" "Password")
    (hf/password-field {:placeholder "Password"} "example.pass")]
   [:div
    (hf/label "name" "Name")
    (hf/text-field {:placeholder "Name"} "example.name")]
   [:div
    (hf/label "admin" "Admin?")
    (hf/check-box "example.admin")]
   (hf/submit-button "Submit")
   ))

(defn home
  [items]
  (layout
   [:ul
    (for [i items]
      [:li (str i)])
    (form)
    ]))

;; {:pass "pizza", :last_login nil, :admin false, :name "horace", :id 1}

