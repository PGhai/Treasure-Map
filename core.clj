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
  (def true-flag 0)
  (def false-flag 1)
  
  (if(and (>= x 0) (>= y 0) (< x row) (< y col))
	  (do
     (case (aget treasureMap x y)
	      "@" (do(println "found")
             (def ret true-flag))
	      "-" (do             
             (if(not= (aget sol x y) "x")
               (do(aset sol x y "x")
                 
                 (if(=(solvePathUtil treasureMap x (inc y) sol row col) true-flag)
                   (def ret true-flag)
                   (if(= (solvePathUtil treasureMap (inc x) y sol row col) true-flag)
                     (def ret true-flag)
                     (if(= (solvePathUtil treasureMap (dec x) y sol row col) true-flag)
                        (def ret true-flag)
                        (if(=(solvePathUtil treasureMap  x (dec y) sol row col) true-flag)
                            (def ret true-flag)
                            (do(aset sol x y "!")
                              (def ret false-flag))
                            ) 
                     ) 
                   )
                 )
                  )
                 )
               )
             
             
        "#" (def ret false-flag)
	      )
     )
   
   )
  ret
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
