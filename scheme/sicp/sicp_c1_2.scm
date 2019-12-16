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
(newline)

(display "1.16 - Design a procedure that evolves an iterative exponentiation process that uses successive squaring and uses a logarithmic number of steps.")
(newline)(display "-----------------------------")(newline)(newline)

; this function uses three parameters a, r, and p, an accumulator that starts at 1, the root, ant the power.  When applied to ar^p, their evaluation remains 
; constant from one iteration to the next, and returns a at the final iteration.  Instead of a linear function that multiplies a number by itself n time, for
; O(n) time complexity, this uses successive squaring toproduce the result in O(log n).  Instead of using a recursive process for O(n) space complexity, it
; uses an iterative one (via a recursive procedure) for O(1).

(define (fast-exp root power)
  (exp-itr 1 root power))
(define (exp-itr accumulator root power)
  (cond ((= power 0)
         accumulator)
        ((= (remainder power 2) 0)
         (exp-itr accumulator (* root root) (/ power 2)))
        (else (exp-itr (* accumulator root) root (- power 1)))))

(display "value for 5^5, should equal 3125")(newline)
(fast-exp 5 5)

(display "Write an implement a function that performs integer multiplication without using the * operator, ")
(Display "but do it in O(log n) time with the use of \"double\" and \"halve\" functions")
(newline)(display "-----------------------------")(newline)(newline)

(define (double x) (+ x x))
(define (halve-even x)
  (/ x 2))

(define (mult x y)
  (cond ((= (remainder y 2) 0) (mult (double x) (halve-even y)))
        ((= y 1) x)
        (else (+ x(mult x (- y 1))))))
(newline)(display "")(newline)