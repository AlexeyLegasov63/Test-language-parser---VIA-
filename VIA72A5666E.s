section 0x72A5666E
	0	alt %0, [STRING string,txt]
	1	push %0, Hello world!
	2	aload [%txt]
	3	nline 3
	4	col 83
	5	col 1
	6	acs %0,txt
	7	call [printf,1]
	8	ret
