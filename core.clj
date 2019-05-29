(ns assignment2.core
   (:require [clojure.string :as str])
)
(defn printSol[arr]
  (doseq [n arr]
    (doseq [x n]
      (print x))
    (println))
  
  
  )

(defn col[treasureMap]
  (def col (alength (aget treasureMap 0)))
  col
  )

(defn row[treasureMap]
 (def r (alength treasureMap))
  r
  )




(defn solvePathUtil
  [treasureMap x y sol row col]
  (if(and (>= x 0) (>= y 0) (< x row) (< y col))
	  (do
     (case (aget treasureMap x y)
	      "@" (println "found")
	      "-" (do             
             (if(not= (aget sol x y) "x")
               (do(aset sol x y "x")
                 
                 (solvePathUtil treasureMap x (inc y) sol row col)
                 (solvePathUtil treasureMap (inc x) y sol row col)
                 (solvePathUtil treasureMap (dec x) y sol row col)
                 (solvePathUtil treasureMap  x (dec y) sol row col)
                 
                   )
                 )
               )
             
             
        "#" (def ret 0)
	      )
     )
   
   )
  0
  )

(defn strlen-exceeds? [s n]
  (> (count s) n))


(defn find-path
  [treasureMap row col sol]
  (if(= (solvePathUtil treasureMap 0 0 sol row col) 0)
    (printSol sol)
    )
  )

(defn read-from-file []
  (use 'clojure.java.io)
   (with-open [rdr (clojure.java.io/reader "map.txt")]
   (reduce conj [] (line-seq rdr))
   ))


(defn -main
  [&args]
	  
	(def arr(read-from-file))
	(def data (mapv #(clojure.string/split % #"") arr))
	(def treasureMap (to-array-2d data))
  (def sol (to-array-2d data))
  (def row (alength treasureMap))
  (def col (alength (aget treasureMap 0)))
	(find-path treasureMap row col sol)


	nil
)

(-main[])
