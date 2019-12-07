#lang planet neil/sicp
; Exercises from sicp chapter 1
"1.2"
(+ 5 4 (- 2(- 3 (+ 6 (/ 4 5)))))

"1.3 - Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers"
(define (largestSquares x y z)
  (cond ((and (> x z) (> y z)) (+ (* x x)(* y y)))
        ((and (> y x) (> z x))(+ (* y y) (* z z)))
        (else (+ (* x x) (* z z)))))
"Should equal 34:"
(largestSquares 5 2 3)

