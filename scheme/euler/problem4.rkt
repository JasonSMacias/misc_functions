#lang racket

; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
; Find the largest palindrome made from the product of two 3-digit numbers.
(define (find-largest-palindrome first-num last-num)
        (find-lp-main first-num last-num first-num 0))

(define (is-palindrome? num) 
        (equal? num (string->number (list->string (reverse (string->list (number->string num)))))))

(define (find-lp-main first-num last-num curr-num largest-palindrome)
    (let ([product (* curr-num first-num)]
          [reached-end? (equal? first-num last-num)]
          [another-cycle? (equal? curr-num last-num)]
          [first-curr-equal? (equal? first-num curr-num)])
         (cond [reached-end? largest-palindrome]
               [first-curr-equal? 
                 (find-lp-main first-num last-num (+ curr-num 1) largest-palindrome)]
               [another-cycle?
                 (find-lp-main
                   (+ first-num 1) 
                   last-num 
                   first-num 
                   (if (is-palindrome? product) (max product largest-palindrome) largest-palindrome))]
               [else
                 (find-lp-main 
                   first-num 
                   last-num 
                   (+ curr-num 1) 
                   (if (is-palindrome? product) (max product largest-palindrome) largest-palindrome ))])))
; (find-largest-palindrome 10 99) ; 9009
(find-largest-palindrome 100 999) ;
