; Cracking the Coding Interview, chapter 1, question 1

; trying simple 0(n^2) solution to try out racket and ctci
(define (unique? str) 
  (define (unique?-recur str ind1 ind2)
      (cond  ((and (equal? (string-ref str ind1) (string-ref str ind2)) (not (= ind1 ind2))) #f)
              ((< ind2 (- (string-length str) 1)) (unique?-recur str ind1 (+ ind2 1)))
              ((and (>= ind2 (- (string-length str) 1)) (< ind1 (- (string-length str) 1))) (unique?-recur str (+ ind1 1) 0))
              ((and (>= ind2 (- (string-length str) 1)) (>= ind1 (- (string-length str) 1))) #t)))
  (unique?-recur str 0 0))

(unique? "abcdefg")
(unique? "abcdecg")