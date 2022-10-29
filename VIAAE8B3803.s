section 0xAE8B3803
	0	nline 1
	1	col 83
	2	col 1
	3	push %0, 3
	4	call [printf,1]
	5	alt %0, [BOOLEAN boolean,a]
	6	push %0, false
	7	aload [%a]
	8	alt %0, [NUMBER number,b]
	9	push %0, 123
	10	aload [%b]
	11	nline 5
	12	col 83
	13	col 1
	14	acs %0,b
	15	call [printf,1]
	16	nline 6
	17	col 83
	18	col 1
	19	acs %0,b
	20	neg
	21	call [printf,1]
	22	acs %0,a
	23	push %0, true
	24	cmp EQEQ
	25	acs %0,b
	26	push %0, 123
	27	cmp EQEQ
	28	cmp OR
	29	equ %0,1 $- goto 31
	30	goto 32
	31	goto 11
	32	nline 11
	33	col 83
	34	col 1
	35	push %0, 6
	36	call [printf,1]
	37	ret
