(ns card-game-war.game)

;; feel free to use these cards or use your own data structure
(def suits [:spade :club :diamond :heart])
(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
(def cards
  (for [suit suits
        rank ranks]
    [suit rank]))

(def ranks-ordering (zipmap ranks [2 3 4 5 6 7 8 9 10 11 12 13 14]))
(def suits-ordering (zipmap suits [1 2 3 4]))

(defn shuffle-cards [deck]
  (shuffle deck)
)

(defn play-round [player1-card player2-card]
  (let [c1r (ranks-ordering (second player1-card))
        c2r (ranks-ordering (second player2-card))
        c1s (suits-ordering (first player1-card))
        c2s (suits-ordering (first player2-card))]
    (if (= c1r c2r)
      (if (> c1s c2s)
        player1-card
        player2-card
      )
      (if (> c1r c2r)
        player1-card
        player2-card
      )
    )
  )
)

(defn play-game [player1-cards player2-cards])
