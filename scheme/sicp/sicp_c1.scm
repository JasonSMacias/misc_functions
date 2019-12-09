#lang planet neil/sicp
; Exercises from sicp chapter 1
"1.2"
"-----------------------------"
(+ 5 4 (- 2(- 3 (+ 6 (/ 4 5)))))

"1.3 - Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers"
"-----------------------------"
(define (largestSquares x y z)
  (cond ((and (> x z) (> y z)) (+ (* x x)(* y y)))
        ((and (> y x) (> z x))(+ (* y y) (* z z)))
        (else (+ (* x x) (* z z)))))
"Should equal 34:"
(largestSquares 5 2 3)


"1.7 - design a square root method with a better test for when the result is close enough than the one given in the book example, that will work better for very small and very large numbers""-----------------------------"

(define (square x) (* x x))

(define (sqrt-iter guess x)
  (if (good-enough? guess x)
  guess
  (sqrt-iter (improve guess x) x)))

(define (improve guess x)
  (average guess (/ x guess)))

(define (average x y)
  (/ (+ x y) 2))

(define (good-enough? guess x)
  (< (abs (- (square guess) x)) (* 0.0001 guess))

(define (sqrt x)
  (sqrt-iter 1.0 x))

"output of sqrt of 3"
(sqrt 9)
"!"