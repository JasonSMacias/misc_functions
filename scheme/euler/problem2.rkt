#lang racket

(define (fib-evens-sum val-1 val-2 stop-point count)
  (let*
      ([next (+ val-1 val-2)]
       [new-count (if (= (remainder next 2) 0) (+ count next) count)])
    (if (>= next stop-point) count (fib-evens-sum val-2 next stop-point new-count))))

(fib-evens-sum 1 2 4000000 2) ;should equal 4613732

; additional runs to test more values, should equal 44 and 60696 respectively
; (fib-evens-sum 1 2 60 2)
; (fib-evens-sum 1 2 100000 2)
