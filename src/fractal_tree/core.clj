(ns fractal-tree.core
  (:gen-class)
  (:require [clojure-turtle.core :as turtle]))

(defn draw-tree [n & {:keys [angle]
                      :or {angle 20}}]
  (when-not (zero? n)
    (let [len (* 10 n)]
      (turtle/left angle)
      (turtle/forward len)
      (draw-tree (dec n) :angle angle)
      (turtle/back len)
      (turtle/right (* 2 angle))
      (turtle/forward len)
      (draw-tree (dec n) :angle angle)
      (turtle/back len)
      (turtle/left angle))))

(defn -main [& args]
  (turtle/new-window {:size [1000 1200]})
  (if-let [[angle] args]
    (draw-tree 10 :angle (Integer/parseInt angle))
    (draw-tree 10)))
