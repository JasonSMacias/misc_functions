#lang planet neil/sicp

; Exercises from sicp chapter 1.2
(display "1.11 - create a function f(n) where:")(newline)
(display "  n if n<3")(newline)
(display "  f(n-1) + 2f(n-2) + 3f(n-3) if n>=3")(newline)
(display "-----------------------------")(newline)
(newline)

(display "a: write with recursive process")(newline)
(define (get-num x)
  (cond 
    ((< x 3) x)
    ((or (= x 3)(> x 3))
      (+ (get-num (- x 1))
         (* 2 (get-num (- x 2)))
         (* 3 (get-num (- x 3)))))))
(newline)
(display "Output of 3")(newline)
(get-num 3)
(display "Output of 8")(newline)
(get-num 8)

(newline)
(display "b: write with iterative process")(newline)
(define (get-num-i x)
  
  (define (get-itr curr min1 min2 count)
    (define new-curr (+ curr (* 2 min1) (* 3 min2)))
           (if (= count x)
               new-curr
               (get-itr new-curr curr min1 (+ count 1))))
  
  (cond ((< x 3) x)
        ((or (= x 3) (> x 3))
         (get-itr 2 1 0 3))))
(newline)
(display "Output of 3")(newline)
(get-num-i 3)
(display "Output of 8")(newline)
(get-num-i 8)
(newline)

(display "1.12 - compute the elements of Pascal's triangle with a recursive process")(newline)
(display "-----------------------------")(newline)(newline)

(define (triangle-value column row) 
  (if
    (or (= row 1) (= column 1) (= column row))
    1
    (+ (triangle-value (- column 1) (- row 1)) (triangle-value column (- row 1)))))

(display "value for column 3 row 5, should equal 6:")(newline)
(triangle-value 3 5)

; Function to display a pascal's triangle of n height
