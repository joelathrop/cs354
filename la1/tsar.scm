;; tsar.scm 
  
(define (teq? l s)
  (if (eq? l s)
      #t
      (if (or (or (null? l) (null? s))
	      (not (and (list? l) (list? s))))
	  #f
	  (if (and (list? (car l)) (list? (car s)))
	      (and (teq? (car l) (car s))
		   (teq? (cdr l) (cdr s)))
	      (and (eq? (car l) (car s))
		   (teq? (cdr l) (cdr s)))))))

(define (tsar l s r) 
  (if (null? l)
      (if (teq? l s)
	  (cons r '())
	  l)
      (if (list? l)
	  (if (teq? s (car l))
	      (cons r (tsar (cdr l) s r))
	      (if (list? (car l))
		  (cons (tsar (car l) s r)
			(tsar (cdr l) s r))
		  (cons (car l) (tsar (cdr l) s r))))
	  (if (teq? l s)
	      (cons r (tsar '() s r))
	      (cons l (tsar '() s r))))))
