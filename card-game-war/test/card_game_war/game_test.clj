(ns card-game-war.game-test
  (:require [clojure.test :refer :all]
            [card-game-war.game :refer :all]))


;; fill in  tests for your game
(deftest test-play-round
  (testing "the highest rank wins the cards in the round"
    (is (= 1 1)))
  (testing "queens are higher rank than jacks"
    (is [:heart :queen] (play-round [:heart :queen] [:heart :jack]))
    (is [:spade :queen] (play-round [:spade :queen] [:heart :jack]))
    (is [:club :queen] (play-round [:heart :jack] [:club :queen]))
    (is [:diamond :queen] (play-round [:spade :jack] [:diamond :queen]))  
  )
  (testing "kings are higher rank than queens"
    (is [:heart :king] (play-round [:heart :queen] [:heart :king]))
    (is [:spade :king] (play-round [:spade :queen] [:spade :king]))
    (is [:club :king] (play-round [:heart :jack] [:club :king]))
    (is [:spade :king] (play-round [:spade :king] [:diamond :queen]))  
  )
  (testing "aces are higher rank than kings"
    (is [:heart :ace] (play-round [:heart :queen] [:heart :ace]))
    (is [:spade :ace] (play-round [:spade :ace] [:spade :king]))
    (is [:club :ace] (play-round [:heart :jack] [:club :ace]))
    (is [:spade :ace] (play-round [:spade :ace] [:diamond :queen]))  
  )
  (testing "if the ranks are equal, clubs beat spades"
    (is [:club :ace] (play-round [:club :ace] [:spade :ace]))
    (is [:club 2] (play-round [:club 2] [:spade 2]))
  )
  (testing "if the ranks are equal, diamonds beat clubs"
    (is [:diamond :ace] (play-round [:club :ace] [:diamond :ace]))
    (is [:diamond 2] (play-round [:diamond 2] [:club 2]))
  )
  (testing "if the ranks are equal, hearts beat diamonds"
    (is [:heart :ace] (play-round [:diamond :ace] [:heart :ace]))
    (is [:heart 2] (play-round [:heart 2] [:diamond 2]))
  )
)

(deftest test-play-game
  (testing "the player loses when they run out of cards"))

