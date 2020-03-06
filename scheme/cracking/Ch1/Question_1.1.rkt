;public boolean isUnique(String s) {
;		boolean unique = true;
;		for (int i = 0; i < s.length(); i++) {
;			char a = s.charAt(i);
;			for (int j = i + 1 ; j < s.length(); j++) {
;				char b = s.charAt(j);
;				if (a == b) {
;					unique = false;
;					break;
;				}
;			}
;		}

; trying simple 0(n^2) solution to try out racket and ctci
(define (unique? str) (display str))