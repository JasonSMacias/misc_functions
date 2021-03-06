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

(newline)
(display "\n1.17 - Write an implement a function that performs integer multiplication without using the * operator, ")
(Display "but do it in O(log n) time with the use of \"double\" and \"halve\" functions")
(display "\n-----------------------------\n\n")

(define (double x) (+ x x))
(define (halve-even x)
  (/ x 2))

(define (mult x y)
  (cond ((= (remainder y 2) 0) (mult (double x) (halve-even y)))
        ((= y 1) x)
        (else (+ x(mult x (- y 1))))))

(display "6 x 8:\n")
(mult 6 8)
(display "100 x 70:\n")
(mult 100 70)

(newline)(newline)
(display "1.18 - use 1.17 and 1.16 as a basis for multiply procedure that uses an iterative process for better space complexity,")
(display "using previously created \"double\" and \"halve\" procedures.")
(display "\n-----------------------------\n\n")
(define (mult-2 x y)
  (mult-itr 0 x y))
(define (mult-itr a x y)
  (cond ((= y 0) a)
        ((= (remainder y 2) 0) (mult-itr a (double x) (halve-even y)))
        (else (mult-itr (+ a x) x (- y 1)))))

(display "6 x 8:\n")
(mult-2 6 8)
(display "100 x 70:\n")
(mult-2 100 70)

(newline)(newline)
(display "1.19 - a procedure to calculate the Fibonacci numbers in a logarithmic number of steps.  Using book-provided
procedure, filling in the logic to compute \"p\" and \"q\" in cases where count is even")
(display "\n-----------------------------\n\n")

(define (fib n)
  (fib-iter 1 0 0 1 n))

(define (square x) (* x x)) 

(define (fib-iter a b p q count)
  (cond ((= count 0) 
         b)
        ((even? count)
         (fib-iter a
                   b
                   ;compute p'
                   (+ (square p) (square q))
                   ;compute q'
                   (+ (* 2 p q) (square q))
                   (/ count 2)))
        (else 
         (fib-iter (+ (* b q) 
                      (* a q) 
                      (* a p))
                   (+ (* b p) 
                      (* a q))
                   p
                   q
                   (- count 1)))))

; Iterative function to display the fibonacci sequence up to given parameter places
(define (get-sequence n)
  (get-s-iter 0 n))

(define (get-s-iter count n)
  (display (fib count))
  (display " ")
  (if (and (= (remainder count 5) 0) (not (= count 0))) (newline))
  (if (< count (- n 1))
      (get-s-iter (+ count 1) n)
      (display "\n")))

(display "Displaying fibonacci sequence up to 25:\n")
(get-sequence 25)

(newline)(newline)
(display "1.21 - use the 'smallest divisor' method given in the book to find the smallest divisor for the numbers 199, 1999, and 19999")
(display "\n-----------------------------\n\n")

(define (next-test-divisor num) (if (= num 2) 3 (+ num 2))) ; from 1.23

(define (smallest-divisor n)
  (find-divisor n 2))
(define (find-divisor n test-divisor)
  (cond ((> (square test-divisor) n) n)
        ((divides? test-divisor n) test-divisor)
        (else (find-divisor n (next-test-divisor test-divisor)))))
(define (divides? a b) (= (remainder b a) 0))

(display "199 smallest divisor: ")
(display (smallest-divisor 199))(newline)

(display "1999 smallest divisor: ")
(display (smallest-divisor 1999))(newline)

(display "19999 smallest divisor: ")
(display (smallest-divisor 19999))

(newline)(newline)
(display "1.22 - Using timed-prime-test to test for finding larger and larger primes")
(display "\n-----------------------------\n\n")

; prodecure provided by book using (runtime) primitive to compute whether a number is prime, and report how long the computation took
(define (timed-prime-test n)
  (newline)
  (display n)
  (start-prime-test n (runtime)))
(define (start-prime-test n start-time)
  (if (prime? n)
  (report-prime(- (runtime) start-time))))
(define (report-prime elapsed-time)
  (display " *** ")
  (display elapsed-time))

; checking for prime using smallest divisor test from 1.21
(define (prime? n)
  (= n (smallest-divisor n)))
(timed-prime-test 27644437)

; function to check consecutive odd numbers over a given number until the first three primes are found
(define(find-primes startNum)(if (odd? startNum) (fp-helper (+ startNum 1) 0) (fp-helper startNum 0)))
(define (fp-helper num primes) (if (= primes 3) (- num 2) (if (timed-prime-test num)(fp-helper (+ num 2) (+ primes 1))(fp-helper (+ num 2) primes))))
(define (odd? num) (= (remainder num 2) 0))

(newline)
(find-primes 1000)
(find-primes 10000)
(find-primes 100000)
(find-primes 1000000)

(newline)(newline)
(display "1.24 - using Fermat's probablilty based method of finding primes and timing it to see how it compares to other method")
(display "\n-----------------------------\n\n")

; procedure to compute the exponential of a number modulo another number, per book
(define (expmod base exp m)
  (cond [(= exp 0) 1]
        [(even? exp) 
          (remainder (square (expmod base (/ exp 2) m)) m)]
        [else (remainder (* base (expmod base (- exp 1)) m) m)]))

; Fermat prime test from book, tries expmod with random numbers
(define (fermat-test n)
  (define (try-it a)
    (= (expmod a n n) a))
    (try-it (+ 1 (random (- n 1)))))

; runs the test a given number of times, returns true if it succeeds every attempt
(define (fast-prime? n times)
  (cond [(= times 0) true]
        [(fermat-test n)
          (fast-prime? n (- times 1))]
        [else false]))

; timed prime again
(define (timed-prime-test2 n)
  (newline)
  (display n)
  (start-prime-test2 n (runtime)))
(define (start-prime-test2 n start-time)
  (if (prime2? n)
  (report-prime2 (- (runtime) start-time))))
(define (report-prime2 elapsed-time)
  (display " *** ")
  (display elapsed-time))

; checking for prime using fermat test
(define (prime2? n)
  (fast-prime? n 10))
(timed-prime-test 27644437)


(newline)(newline)
(display "1.27 - write a procedure that demonstrates that a Carmichael number will fool the Fermat test.")
(display "\n-----------------------------\n\n")

(define (carmichael-demo n c-num) (define c-num-to-n (fast-exp c-num n)) (= (remainder (- c-num-to-n c-num) n) 0))

(carmichael-demo 7 2) ; not a carmichael
(carmichael-demo 561 4)
(prime? 561) ; shows that 561, a non-prime, fools the fermat test, and is a Carmichael number

(newline)(newline)
(display "1.28 - ")
(display "\n-----------------------------\n\n")

