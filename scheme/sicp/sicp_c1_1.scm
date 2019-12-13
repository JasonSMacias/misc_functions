#lang planet neil/sicp
; Exercises from sicp chapter 1.1
(display "1.2") (newline)
(display "-----------------------------") (newline)


(+ 5 4 (- 2(- 3 (+ 6 (/ 4 5)))))
(newline)

(display "1.3 - Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers") (newline)
(display "-----------------------------") (newline)
(define (largestSquares x y z)
  (cond ((and (> x z) (> y z)) (+ (* x x)(* y y)))
        ((and (> y x) (> z x))(+ (* y y) (* z z)))
        (else (+ (* x x) (* z z)))))
(display "Should equal 34:") (newline)
(largestSquares 5 2 3)
(newline)

(display "1.7 - design a square root method with a better test for when the result is close enough than the one given in the book example, that will work better for very small and very large numbers")(newline)
(display"-----------------------------") (newline)

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
  (< (abs (- (square guess) x)) (* 0.0001 guess)))

(define (sqrt x)
  (sqrt-iter 1.0 x))

(display "output of sqrt of 9") (newline)
(sqrt 9)
(newline)

(display "1.8 - Use Newton's method for cube roots to create a procedure to approximate the cube root of a number") (newline)
(display "-----------------------------") (newline)

; (define (square x) (* x x))

(define (cube x) (* x x x))

(define (croot-iter guess x)
  (if (good-enough-c? guess x)
  guess
  (croot-iter (improve-c guess x) x)))

(define (improve-c guess x) 
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(define (good-enough-c? guess x)
  (< (abs (- (cube guess) x)) (* 0.0001 guess)))

(define (croot x)
  (croot-iter 1.0 x))

(display "output of cube root of 8") (newline)
(croot 8)
(display "output of cube root of 27") (newline)
(croot 27)
(newline)
