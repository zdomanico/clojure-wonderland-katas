(ns alphabet-cipher.coder)


(defn tochar [x] 
  (if (> x (int \Z)) 
    (char (+ (int \A) (- (dec x) (int \Z)))) 
    (char x)
  )
)

(defn a-z []
  (map tochar (range (int \A) (inc (int \Z))))
)

(defn row [start]
  (map tochar (range (int start) (+ (int start) 26)))
)


(defn buildgrid []
  (let [l (a-z)
        r (for [x (a-z)] (zipmap (a-z) (row x)))]
    (zipmap l r)  
  )
)

(defn encode-letter [c1 c2]
  (let [grid (buildgrid)]
    ((grid c1) c2)
  )
)


(defn encode [keyword message]
  (let [full_key (take (count message) (cycle keyword))]
    (loop [[k & key] (clojure.string/upper-case (apply str full_key)) 
           [m & mes] (clojure.string/upper-case message)
           secret []]
      (if (nil? k) 
        (clojure.string/lower-case (apply str secret))
        (recur key mes (conj secret (encode-letter k m)))
      )
    )
  )  
)

(defn decode [keyword message]
  
)

(defn decipher [cipher message]
  "decypherme")

