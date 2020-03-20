#lang racket

; Cracking the Coding Interview, chapter 1, question 1
; write a function to check if a string has all unique characters.  What if you cannot use additional data structures?


; trying simple 0(n^2) solution to try out racket and ctci
(define (unique? str) 
  (define (unique?-recur str ind1 ind2)
      (cond  ((and (equal? (string-ref str ind1) (string-ref str ind2)) (not (= ind1 ind2))) #f)
              ((< ind2 (- (string-length str) 1)) (unique?-recur str ind1 (+ ind2 1)))
              ((and (>= ind2 (- (string-length str) 1)) (< ind1 (- (string-length str) 1))) (unique?-recur str (+ ind1 1) 0))
              ((and (>= ind2 (- (string-length str) 1)) (>= ind1 (- (string-length str) 1))) #t)))
  (unique?-recur str 0 0))

  ; trying it with a set, O(n log n) as hashset in racket are apparently accesed in log n time.
(define (unique2? str)
  (let ([start-set (set)]
        [create-charset
         (lambda (set-starter str-starter)
           (foldl (lambda (ch current-set)
                    (set-add current-set (if (set-member? current-set ch) #f ch)))
                  set-starter (string->list str-starter)))])
    (not (set-member? (create-charset start-set str) #f))))

  ; TODO: implement a method that uses a sorted list of chars to do it in O(n log n) (i.e., don't use an additional data structure
(define (unique3? str) ())


(unique? "abcdefg")
(unique? "abcdecg")
(unique2? "abcdefg")
(unique2? "abcdecg")