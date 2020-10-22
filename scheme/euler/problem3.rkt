#lang racket

; The prime factors of 13195 are 5, 7, 13 and 29.
; What is the largest prime factor of the number 600851475143 ?

(define (getLPF num) (getLPF-main num 1 3 (sqrt num)))

(define (getLPF-main num ret-val iteration orig-sqrt)
  (let ([2-remainder (remainder num 2)]
        [i-remainder (remainder num iteration)]) 
        (if (= 2-remainder 0) 
            (getLPF-main (/ num 2) (if (> num ret-val) 2 ret-val) 3 orig-sqrt) 
            (cond
              [(> iteration orig-sqrt) (if (> num 2) num ret-val)]
              [(= i-remainder 0)
               (getLPF-main (/ num iteration) 
                        (if (> iteration ret-val) iteration ret-val)
                        3
                        orig-sqrt)]
              [else (getLPF-main num ret-val (+ iteration 1) orig-sqrt)]))))

(getLPF 13195) ; 29
(getLPF 600851475143) ; 6857
(getLPF 27)