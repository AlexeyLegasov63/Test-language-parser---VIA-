section 0x8DD2FFF9
	0	push %0, true
	1	equ %0,1 $- goto 7
	2	nline 3
	3	col 83
	4	col 1
	5	push %0, got
	6	call [printf,1]
	7	push %0, true
	8	equ %0,1 $- goto 71
	9	alt %0, [NUMBER number,a]
	10	push %0, 3
	11	aload [%a]
	12	push %0, true
	13	equ %0,1 $- goto 69
	14	alt %0, [NUMBER number,b]
	15	push %0, 4
	16	aload [%b]
	17	push %0, true
	18	equ %0,1 $- goto 67
	19	alt %0, [NUMBER number,c]
	20	push %0, 6
	21	aload [%c]
	22	push %0, true
	23	equ %0,1 $- goto 65
	24	alt %0, [NUMBER number,d]
	25	push %0, 8
	26	aload [%d]
	27	push %0, true
	28	equ %0,1 $- goto 63
	29	alt %0, [NUMBER number,e]
	30	push %0, 836
	31	aload [%e]
	32	push %0, true
	33	equ %0,1 $- goto 61
	34	alt %0, [NUMBER number,f]
	35	push %0, 52
	36	aload [%f]
	37	push %0, true
	38	equ %0,1 $- goto 59
	39	alt %0, [NUMBER number,g]
	40	push %0, 6254
	41	aload [%g]
	42	push %0, true
	43	equ %0,1 $- goto 57
	44	alt %0, [NUMBER number,h]
	45	push %0, 6
	46	aload [%h]
	47	push %0, true
	48	equ %0,1 $- goto 55
	49	alt %0, [NUMBER number,i]
	50	push %0, 54
	51	neg
	52	aload [%i]
	53	goto 55
	54	goto 47
	55	goto 57
	56	goto 42
	57	goto 59
	58	goto 37
	59	goto 61
	60	goto 32
	61	goto 63
	62	goto 27
	63	goto 65
	64	goto 22
	65	goto 67
	66	goto 17
	67	goto 69
	68	goto 12
	69	goto 71
	70	goto 7
	71	ret
