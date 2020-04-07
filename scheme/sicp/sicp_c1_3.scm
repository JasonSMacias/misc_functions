#lang planet neil/sicp
; Exercises from SICP chapter 1.3
; generalized sum function from book
; takes in begin value "a", end value "b", term operation function "term", increment operation function "next", recursive
(define (sum term a next b)
  (if (> a b)
      0
      (+ (term a)
         (sum term (next a) next b))))


; procedure copied from book to define the integral of a function between the limits a and b for small values of dx,
; for reference in later exercises
(define (integral f a b dx)
  (define (add-dx x) (+ x dx))
  (* (sum f (+ a (/ dx 2.0)) add-dx b) dx))

(define (cube x) (* x x x))

  (newline)(newline)
(display "1.29 - Use Simpson's Rule to approximate the integral of a function between a and b with more accuracy than above procedure")
(display "\n-----------------------------\n\n")

;  n assumed to be even (if not, a function would be needed to change odd values to next higher even
(define (integral-new f a b n)
  (define h (/ (- b a) n))
  (define (increment val) (+ val 1))
  (define (simpson-term k)
    (define y (f (+ a (* k h))))
    (* (cond [(or (= k 0) (= k 1)) 1]
             [(odd? k) 4]
             [else 2])
       y))
  (* (/ h 3) (sum simpson-term 0 increment n)))
(display "n of 100: ")(exact->inexact (integral-new cube 0 1 100))
(display "n of 1000: ")(integral-new cube 0 1 1000.0)
(display "dx of .01: ")(integral cube 0 1 0.01)
(display "dx of .001: ")(integral cube 0 1 0.001)