; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
; Find the sum of all the multiples of 3 or 5 below 1000.
(define (sum-multiples iteration running-count)
  (cond ((and (< iteration 1000) (or (= 0 (remainder iteration 5)) (= 0 (remainder iteration 3)))) (sum-multiples (+ iteration 1) (+ running-count iteration)))
        ((and (< iteration 1000) (not (or (= 0 (remainder iteration 5)) (= 0 (remainder iteration 3))))) (sum-multiples (+ iteration 1) running-count))
        (else running-count)))
(sum-multiples 3 0)