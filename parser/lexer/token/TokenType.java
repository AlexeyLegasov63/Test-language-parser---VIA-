package via.script.parser.lexer.token;

public enum TokenType
{
	EOF,
	HEX_NUMBER,
	DECIMAL_NUMBER,
	REAL_NUMBER,
	STRING,
	CHARACTER,
	BOOLEAN,
	WORD,
	NULL,
	EXCL,
	EQLS, EQEQ,
	PLUS, PLPL,
	MINS, MNMN,
	SLSH,
	STAR,
	BRBR, BR,
	ANAN, AN,
	PERC,
	LPAR,
	RPAR,
	LBAR,
	RBAR,
	LBRC,
	RBRC,
	LTEQ,
	RTEQ,
	NTEQ,
	COLN,
	ZERO,
	COMM,
	PONT, PNPNPN,
	LT, LTLT,
	RT, RTRT, RTRTRT,
	XOR,
	SWIP,
	NUM, TEXT, BOOL, CHAR, ARRAY, TABLE, VOID,
	BEGIN,
	EXTERN,
	BECOME,
	FLAT, WIDE,
	GLOBAL,
	PASS, DYN,
	FLAG,
	EXCEPT,
	EXCLIPIT,
	IMPLICIT,
	ASSERT,
	BEHAVIOR,
	IF,
	ELSE,
	TRY,
	TRAP,
	AFTER,
	LOOP,
	EXIT,
	STOP,
	UNTIL,
	DO, WHILE,
	FOR,
	SIFT,
	RETURN,
	YIELD, RESULT,
	JUMP,
	MATCH, DECIDE, SIMILAR,
	REPEAT,
	CONTEXT, EXPAND,
	EXPEL,
	
	;
	
	public boolean match(TokenType type) {
		return this == type;
	}
}