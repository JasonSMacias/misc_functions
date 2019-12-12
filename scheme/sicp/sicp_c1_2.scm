#lang planet neil/sicp
; Exercises from sicp chapter 1.2
"1.11 - create a function f(n) where:"
"  n if n<3"
"  f(n-1) + 2f(n-2) + 3f(n-3) if n>=3"
"-----------------------------"
""
"a: write with recursive process"
(define (get-num x)
  (cond 
    ((< x 3) x)
    ((or (= x 3)(> x 3))
      (+ (get-num (- x 1))
         (* 2 (get-num (- x 2)))
         (* 3 (get-num (- x 3)))))))
""
"Output of 3"
(get-num 3)
"Output of 8"
(get-num 8)

""
"b: write with iterative process"
(define (get-num-i x)
  
  (define (get-itr curr min1 min2 count)
    (define new-curr (+ curr (* 2 min1) (* 3 min2)))
           (if (= count x)
               new-curr
               (get-itr new-curr curr min1 (+ count 1))))
  
  (cond ((< x 3) x)
        ((or (= x 3) (> x 3))
         (get-itr 2 1 0 3))))
""
"Output of 3"
(get-num-i 3)
"Output of 8"
(get-num-i 8)
""