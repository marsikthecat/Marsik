// Generated from C:/Marsik/MarsikLang/src/main/java/org/example/Marsik.g4 by ANTLR 4.13.2
package org.example;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MarsikParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		STANDARDLIBS=10, PLUSPLUS=11, MINUSMINUS=12, LSQB=13, RSQB=14, COMMA=15, 
		SEMI=16, EQUAL=17, LPAR=18, LBRACE=19, RPAR=20, RBRACE=21, COLON=22, PLUS=23, 
		MINUS=24, STAR=25, SLASH=26, VBAR=27, AMPER=28, LESS=29, GREATER=30, DOT=31, 
		PERCENT=32, BACKQUOTE=33, EQEQUAL=34, INEQUAL=35, NOTEQUAL=36, LESSEQUAL=37, 
		GREATEREQUAL=38, TILDE=39, CIRCUMFLEX=40, LEFTSHIFT=41, RIGHTSHIFT=42, 
		DOUBLESTAR=43, PLUSEQUAL=44, MINEQUAL=45, STAREQUAL=46, SLASHEQUAL=47, 
		NEW=48, BREAK=49, FUNCTION=50, ELSE=51, FOR=52, IF=53, PRINT=54, PRINTLN=55, 
		RETURN=56, TRY=57, WHILE=58, EXIT=59, CONST=60, SCAN=61, TIME_MILLIS=62, 
		AR_TYPE=63, INT_TYPE=64, DOUBLE_TYPE=65, CHAR_TYPE=66, BOOL_TYPE=67, STRING_TYPE=68, 
		CRYPTODATA_TYPE=69, NAME=70, NEWLINE=71, COMMENT=72, WS=73, INTEGER=74, 
		BABY_INTEGER=75, STRING=76, CHAR=77, DOUBLE=78, BOOLEAN=79;
	public static final int
		RULE_program = 0, RULE_type = 1, RULE_type_label = 2, RULE_stmt = 3, RULE_method_call = 4, 
		RULE_object_stmt = 5, RULE_build_in_stmt = 6, RULE_var_decl = 7, RULE_const_decl = 8, 
		RULE_assign_stmt = 9, RULE_inc_stmt = 10, RULE_dec_stmt = 11, RULE_array_decl = 12, 
		RULE_funcdef = 13, RULE_parameters = 14, RULE_parameter = 15, RULE_if_stmt = 16, 
		RULE_while_stmt = 17, RULE_block = 18, RULE_for_stmt = 19, RULE_for_init = 20, 
		RULE_for_update = 21, RULE_print_stmt = 22, RULE_printLn_stmt = 23, RULE_exit_stmt = 24, 
		RULE_scan_stmt = 25, RULE_time_stmt = 26, RULE_other_stmt = 27, RULE_arguments = 28, 
		RULE_return_stmt = 29, RULE_expr = 30, RULE_or_expr = 31, RULE_and_expr = 32, 
		RULE_equality_expr = 33, RULE_relational_expr = 34, RULE_additive_expr = 35, 
		RULE_multiplicative_expr = 36, RULE_unary_expr = 37, RULE_power_expr = 38, 
		RULE_atom_expr = 39, RULE_class_def = 40, RULE_class_member = 41, RULE_field_decl = 42, 
		RULE_constructor_decl = 43, RULE_method_decl = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "type_label", "stmt", "method_call", "object_stmt", 
			"build_in_stmt", "var_decl", "const_decl", "assign_stmt", "inc_stmt", 
			"dec_stmt", "array_decl", "funcdef", "parameters", "parameter", "if_stmt", 
			"while_stmt", "block", "for_stmt", "for_init", "for_update", "print_stmt", 
			"printLn_stmt", "exit_stmt", "scan_stmt", "time_stmt", "other_stmt", 
			"arguments", "return_stmt", "expr", "or_expr", "and_expr", "equality_expr", 
			"relational_expr", "additive_expr", "multiplicative_expr", "unary_expr", 
			"power_expr", "atom_expr", "class_def", "class_member", "field_decl", 
			"constructor_decl", "method_decl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'()'", "'or'", "'and'", "'not'", "'class'", "'public'", "'_constructor'", 
			"'internal'", "'Method'", null, "'++'", "'--'", "'['", "']'", "','", 
			"';'", "'='", "'('", "'{'", "')'", "'}'", "':'", "'+'", "'-'", "'*'", 
			"'/'", "'|'", "'&'", "'<'", "'>'", "'.'", "'%'", "'`'", "'=='", "'<>'", 
			"'!='", "'<='", "'>='", "'~'", "'^'", "'<<'", "'>>'", "'**'", "'+='", 
			"'-='", "'*='", "'/='", "'new'", "'break'", "'function'", "'else'", "'for'", 
			"'if'", "'print'", "'printLine'", "'return'", "'try'", "'while'", "'exit'", 
			"'const'", "'scan'", "'getTime'", "'array'", "'int'", "'double'", "'char'", 
			"'boolean'", "'string'", "'CryptoData'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "STANDARDLIBS", 
			"PLUSPLUS", "MINUSMINUS", "LSQB", "RSQB", "COMMA", "SEMI", "EQUAL", "LPAR", 
			"LBRACE", "RPAR", "RBRACE", "COLON", "PLUS", "MINUS", "STAR", "SLASH", 
			"VBAR", "AMPER", "LESS", "GREATER", "DOT", "PERCENT", "BACKQUOTE", "EQEQUAL", 
			"INEQUAL", "NOTEQUAL", "LESSEQUAL", "GREATEREQUAL", "TILDE", "CIRCUMFLEX", 
			"LEFTSHIFT", "RIGHTSHIFT", "DOUBLESTAR", "PLUSEQUAL", "MINEQUAL", "STAREQUAL", 
			"SLASHEQUAL", "NEW", "BREAK", "FUNCTION", "ELSE", "FOR", "IF", "PRINT", 
			"PRINTLN", "RETURN", "TRY", "WHILE", "EXIT", "CONST", "SCAN", "TIME_MILLIS", 
			"AR_TYPE", "INT_TYPE", "DOUBLE_TYPE", "CHAR_TYPE", "BOOL_TYPE", "STRING_TYPE", 
			"CRYPTODATA_TYPE", "NAME", "NEWLINE", "COMMENT", "WS", "INTEGER", "BABY_INTEGER", 
			"STRING", "CHAR", "DOUBLE", "BOOLEAN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Marsik.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MarsikParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MarsikParser.EOF, 0); }
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case T__3:
			case STANDARDLIBS:
			case LPAR:
			case PLUS:
			case MINUS:
			case FUNCTION:
			case FOR:
			case IF:
			case PRINT:
			case PRINTLN:
			case RETURN:
			case WHILE:
			case EXIT:
			case CONST:
			case AR_TYPE:
			case INT_TYPE:
			case DOUBLE_TYPE:
			case CHAR_TYPE:
			case BOOL_TYPE:
			case STRING_TYPE:
			case CRYPTODATA_TYPE:
			case NAME:
			case INTEGER:
			case BABY_INTEGER:
			case STRING:
			case CHAR:
			case DOUBLE:
			case BOOLEAN:
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7065021915412036592L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 64639L) != 0)) {
					{
					{
					setState(90);
					stmt();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				{
				setState(96);
				class_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(99);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
		public TerminalNode BABY_INTEGER() { return getToken(MarsikParser.BABY_INTEGER, 0); }
		public TerminalNode CHAR() { return getToken(MarsikParser.CHAR, 0); }
		public TerminalNode BOOLEAN() { return getToken(MarsikParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public TerminalNode DOUBLE() { return getToken(MarsikParser.DOUBLE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_la = _input.LA(1);
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 63L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_labelContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(MarsikParser.INT_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(MarsikParser.DOUBLE_TYPE, 0); }
		public TerminalNode CHAR_TYPE() { return getToken(MarsikParser.CHAR_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(MarsikParser.BOOL_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(MarsikParser.STRING_TYPE, 0); }
		public TerminalNode AR_TYPE() { return getToken(MarsikParser.AR_TYPE, 0); }
		public TerminalNode CRYPTODATA_TYPE() { return getToken(MarsikParser.CRYPTODATA_TYPE, 0); }
		public Type_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitType_label(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_labelContext type_label() throws RecognitionException {
		Type_labelContext _localctx = new Type_labelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 127L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Const_declContext const_decl() {
			return getRuleContext(Const_declContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Array_declContext array_decl() {
			return getRuleContext(Array_declContext.class,0);
		}
		public Build_in_stmtContext build_in_stmt() {
			return getRuleContext(Build_in_stmtContext.class,0);
		}
		public Inc_stmtContext inc_stmt() {
			return getRuleContext(Inc_stmtContext.class,0);
		}
		public Dec_stmtContext dec_stmt() {
			return getRuleContext(Dec_stmtContext.class,0);
		}
		public Object_stmtContext object_stmt() {
			return getRuleContext(Object_stmtContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public PrintLn_stmtContext printLn_stmt() {
			return getRuleContext(PrintLn_stmtContext.class,0);
		}
		public Exit_stmtContext exit_stmt() {
			return getRuleContext(Exit_stmtContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MarsikParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MarsikParser.NEWLINE, i);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(105);
				var_decl();
				}
				break;
			case 2:
				{
				setState(106);
				const_decl();
				}
				break;
			case 3:
				{
				setState(107);
				assign_stmt();
				}
				break;
			case 4:
				{
				setState(108);
				if_stmt();
				}
				break;
			case 5:
				{
				setState(109);
				while_stmt();
				}
				break;
			case 6:
				{
				setState(110);
				return_stmt();
				}
				break;
			case 7:
				{
				setState(111);
				expr();
				}
				break;
			case 8:
				{
				setState(112);
				funcdef();
				}
				break;
			case 9:
				{
				setState(113);
				for_stmt();
				}
				break;
			case 10:
				{
				setState(114);
				array_decl();
				}
				break;
			case 11:
				{
				setState(115);
				build_in_stmt();
				}
				break;
			case 12:
				{
				setState(116);
				inc_stmt();
				}
				break;
			case 13:
				{
				setState(117);
				dec_stmt();
				}
				break;
			case 14:
				{
				setState(118);
				object_stmt();
				}
				break;
			case 15:
				{
				setState(119);
				method_call();
				}
				break;
			case 16:
				{
				setState(120);
				print_stmt();
				}
				break;
			case 17:
				{
				setState(121);
				printLn_stmt();
				}
				break;
			case 18:
				{
				setState(122);
				exit_stmt();
				}
				break;
			}
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(125);
					match(NEWLINE);
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_callContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(MarsikParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(MarsikParser.NAME, i);
		}
		public TerminalNode DOT() { return getToken(MarsikParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitMethod_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(NAME);
			setState(132);
			match(DOT);
			setState(133);
			match(NAME);
			setState(134);
			match(LPAR);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25429008L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 1009L) != 0)) {
				{
				setState(135);
				arguments();
				}
			}

			setState(138);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Object_stmtContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(MarsikParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(MarsikParser.NAME, i);
		}
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public TerminalNode NEW() { return getToken(MarsikParser.NEW, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Object_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitObject_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_stmtContext object_stmt() throws RecognitionException {
		Object_stmtContext _localctx = new Object_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_object_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(NAME);
			setState(141);
			match(NAME);
			setState(142);
			match(EQUAL);
			setState(143);
			match(NEW);
			setState(144);
			match(NAME);
			setState(145);
			match(LPAR);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 63L) != 0)) {
				{
				setState(146);
				parameters();
				}
			}

			setState(149);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Build_in_stmtContext extends ParserRuleContext {
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public Scan_stmtContext scan_stmt() {
			return getRuleContext(Scan_stmtContext.class,0);
		}
		public Time_stmtContext time_stmt() {
			return getRuleContext(Time_stmtContext.class,0);
		}
		public Other_stmtContext other_stmt() {
			return getRuleContext(Other_stmtContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Build_in_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_build_in_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitBuild_in_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Build_in_stmtContext build_in_stmt() throws RecognitionException {
		Build_in_stmtContext _localctx = new Build_in_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_build_in_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			type_label();
			setState(152);
			match(NAME);
			setState(153);
			match(EQUAL);
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SCAN:
				{
				setState(154);
				scan_stmt();
				}
				break;
			case TIME_MILLIS:
				{
				setState(155);
				time_stmt();
				}
				break;
			case STANDARDLIBS:
				{
				setState(156);
				other_stmt();
				}
				break;
			case NAME:
				{
				setState(157);
				method_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declContext extends ParserRuleContext {
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public TerminalNode NEWLINE() { return getToken(MarsikParser.NEWLINE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			type_label();
			setState(161);
			match(NAME);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(162);
				match(EQUAL);
				setState(165);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(163);
					type();
					}
					break;
				case 2:
					{
					setState(164);
					expr();
					}
					break;
				}
				}
			}

			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(169);
				match(NEWLINE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Const_declContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(MarsikParser.CONST, 0); }
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(MarsikParser.NEWLINE, 0); }
		public Const_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitConst_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_declContext const_decl() throws RecognitionException {
		Const_declContext _localctx = new Const_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_const_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(CONST);
			setState(173);
			type_label();
			setState(174);
			match(NAME);
			setState(175);
			match(EQUAL);
			setState(176);
			type();
			setState(177);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(NAME);
			setState(180);
			match(EQUAL);
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(181);
				type();
				}
				break;
			case 2:
				{
				setState(182);
				expr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Inc_stmtContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode PLUSPLUS() { return getToken(MarsikParser.PLUSPLUS, 0); }
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
		public Inc_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inc_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitInc_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inc_stmtContext inc_stmt() throws RecognitionException {
		Inc_stmtContext _localctx = new Inc_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inc_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(NAME);
			setState(186);
			match(PLUSPLUS);
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(187);
				match(INTEGER);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dec_stmtContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode MINUSMINUS() { return getToken(MarsikParser.MINUSMINUS, 0); }
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
		public Dec_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitDec_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dec_stmtContext dec_stmt() throws RecognitionException {
		Dec_stmtContext _localctx = new Dec_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dec_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(NAME);
			setState(191);
			match(MINUSMINUS);
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(192);
				match(INTEGER);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_declContext extends ParserRuleContext {
		public TerminalNode AR_TYPE() { return getToken(MarsikParser.AR_TYPE, 0); }
		public TerminalNode LESS() { return getToken(MarsikParser.LESS, 0); }
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(MarsikParser.GREATER, 0); }
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public TerminalNode LSQB() { return getToken(MarsikParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(MarsikParser.RSQB, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MarsikParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MarsikParser.COMMA, i);
		}
		public Array_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitArray_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_declContext array_decl() throws RecognitionException {
		Array_declContext _localctx = new Array_declContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_array_decl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(AR_TYPE);
			setState(196);
			match(LESS);
			setState(197);
			type_label();
			setState(198);
			match(GREATER);
			setState(199);
			match(NAME);
			setState(200);
			match(EQUAL);
			setState(201);
			match(LSQB);
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(202);
				type();
				}
				break;
			case 2:
				{
				{
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(203);
						type();
						setState(204);
						match(COMMA);
						}
						} 
					}
					setState(210);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(211);
				type();
				}
				}
				break;
			}
			setState(214);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MarsikParser.FUNCTION, 0); }
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MarsikParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MarsikParser.NEWLINE, i);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitFuncdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(FUNCTION);
			setState(217);
			match(NAME);
			setState(218);
			match(LPAR);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 63L) != 0)) {
				{
				setState(219);
				parameters();
				}
			}

			setState(222);
			match(RPAR);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(223);
				match(NEWLINE);
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MarsikParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MarsikParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			parameter();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(232);
				match(COMMA);
				setState(233);
				parameter();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			type();
			setState(240);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MarsikParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MarsikParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(IF);
			setState(243);
			match(LPAR);
			setState(244);
			expr();
			setState(245);
			match(RPAR);
			setState(246);
			block();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(247);
				match(ELSE);
				setState(248);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MarsikParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MarsikParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MarsikParser.NEWLINE, i);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(WHILE);
			setState(252);
			match(LPAR);
			setState(253);
			expr();
			setState(254);
			match(RPAR);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(255);
				match(NEWLINE);
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(261);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MarsikParser.LBRACE, 0); }
		public TerminalNode NEWLINE() { return getToken(MarsikParser.NEWLINE, 0); }
		public TerminalNode RBRACE() { return getToken(MarsikParser.RBRACE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(LBRACE);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7065021915412036592L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 64639L) != 0)) {
				{
				{
				setState(264);
				stmt();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			match(NEWLINE);
			setState(271);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MarsikParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public List<TerminalNode> SEMI() { return getTokens(MarsikParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MarsikParser.SEMI, i);
		}
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_updateContext for_update() {
			return getRuleContext(For_updateContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(FOR);
			setState(274);
			match(LPAR);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 255L) != 0)) {
				{
				setState(275);
				for_init();
				}
			}

			setState(278);
			match(SEMI);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25429008L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 1009L) != 0)) {
				{
				setState(279);
				expr();
				}
			}

			setState(282);
			match(SEMI);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(283);
				for_update();
				}
			}

			setState(286);
			match(RPAR);
			setState(287);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_initContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public For_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitFor_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_for_init);
		try {
			setState(291);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AR_TYPE:
			case INT_TYPE:
			case DOUBLE_TYPE:
			case CHAR_TYPE:
			case BOOL_TYPE:
			case STRING_TYPE:
			case CRYPTODATA_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				var_decl();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				assign_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_updateContext extends ParserRuleContext {
		public Inc_stmtContext inc_stmt() {
			return getRuleContext(Inc_stmtContext.class,0);
		}
		public Dec_stmtContext dec_stmt() {
			return getRuleContext(Dec_stmtContext.class,0);
		}
		public For_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_update; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitFor_update(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_updateContext for_update() throws RecognitionException {
		For_updateContext _localctx = new For_updateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_for_update);
		try {
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				inc_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				dec_stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Print_stmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(MarsikParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitPrint_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_stmtContext print_stmt() throws RecognitionException {
		Print_stmtContext _localctx = new Print_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_print_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(PRINT);
			setState(298);
			match(LPAR);
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(299);
				match(STRING);
				}
				break;
			case 2:
				{
				setState(300);
				expr();
				}
				break;
			}
			setState(303);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintLn_stmtContext extends ParserRuleContext {
		public TerminalNode PRINTLN() { return getToken(MarsikParser.PRINTLN, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintLn_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printLn_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitPrintLn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintLn_stmtContext printLn_stmt() throws RecognitionException {
		PrintLn_stmtContext _localctx = new PrintLn_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_printLn_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(PRINTLN);
			setState(306);
			match(LPAR);
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(307);
				match(STRING);
				}
				break;
			case 2:
				{
				setState(308);
				expr();
				}
				break;
			}
			setState(311);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exit_stmtContext extends ParserRuleContext {
		public TerminalNode EXIT() { return getToken(MarsikParser.EXIT, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
		public Exit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitExit_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exit_stmtContext exit_stmt() throws RecognitionException {
		Exit_stmtContext _localctx = new Exit_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(EXIT);
			setState(320);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(314);
				match(LPAR);
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTEGER) {
					{
					setState(315);
					match(INTEGER);
					}
				}

				setState(318);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(319);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scan_stmtContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(MarsikParser.SCAN, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public Scan_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scan_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitScan_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scan_stmtContext scan_stmt() throws RecognitionException {
		Scan_stmtContext _localctx = new Scan_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_scan_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(SCAN);
			setState(323);
			match(LPAR);
			setState(324);
			match(STRING);
			setState(325);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Time_stmtContext extends ParserRuleContext {
		public TerminalNode TIME_MILLIS() { return getToken(MarsikParser.TIME_MILLIS, 0); }
		public Time_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitTime_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_stmtContext time_stmt() throws RecognitionException {
		Time_stmtContext _localctx = new Time_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_time_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(TIME_MILLIS);
			setState(328);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Other_stmtContext extends ParserRuleContext {
		public TerminalNode STANDARDLIBS() { return getToken(MarsikParser.STANDARDLIBS, 0); }
		public TerminalNode DOT() { return getToken(MarsikParser.DOT, 0); }
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Other_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_other_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitOther_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Other_stmtContext other_stmt() throws RecognitionException {
		Other_stmtContext _localctx = new Other_stmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_other_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(STANDARDLIBS);
			setState(331);
			match(DOT);
			setState(332);
			match(NAME);
			setState(333);
			match(LPAR);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25429008L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 1009L) != 0)) {
				{
				setState(334);
				arguments();
				}
			}

			setState(337);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MarsikParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MarsikParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			expr();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(340);
				match(COMMA);
				setState(341);
				expr();
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MarsikParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(RETURN);
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(348);
				expr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			or_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Or_exprContext extends ParserRuleContext {
		public List<And_exprContext> and_expr() {
			return getRuleContexts(And_exprContext.class);
		}
		public And_exprContext and_expr(int i) {
			return getRuleContext(And_exprContext.class,i);
		}
		public Or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitOr_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_exprContext or_expr() throws RecognitionException {
		Or_exprContext _localctx = new Or_exprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			and_expr();
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(354);
				match(T__1);
				setState(355);
				and_expr();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class And_exprContext extends ParserRuleContext {
		public List<Equality_exprContext> equality_expr() {
			return getRuleContexts(Equality_exprContext.class);
		}
		public Equality_exprContext equality_expr(int i) {
			return getRuleContext(Equality_exprContext.class,i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			equality_expr();
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(362);
				match(T__2);
				setState(363);
				equality_expr();
				}
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Equality_exprContext extends ParserRuleContext {
		public List<Relational_exprContext> relational_expr() {
			return getRuleContexts(Relational_exprContext.class);
		}
		public Relational_exprContext relational_expr(int i) {
			return getRuleContext(Relational_exprContext.class,i);
		}
		public List<TerminalNode> EQEQUAL() { return getTokens(MarsikParser.EQEQUAL); }
		public TerminalNode EQEQUAL(int i) {
			return getToken(MarsikParser.EQEQUAL, i);
		}
		public List<TerminalNode> NOTEQUAL() { return getTokens(MarsikParser.NOTEQUAL); }
		public TerminalNode NOTEQUAL(int i) {
			return getToken(MarsikParser.NOTEQUAL, i);
		}
		public Equality_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitEquality_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_exprContext equality_expr() throws RecognitionException {
		Equality_exprContext _localctx = new Equality_exprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_equality_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			relational_expr();
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(370);
				_la = _input.LA(1);
				if ( !(_la==EQEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(371);
				relational_expr();
				}
				}
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Relational_exprContext extends ParserRuleContext {
		public List<Additive_exprContext> additive_expr() {
			return getRuleContexts(Additive_exprContext.class);
		}
		public Additive_exprContext additive_expr(int i) {
			return getRuleContext(Additive_exprContext.class,i);
		}
		public List<TerminalNode> LESS() { return getTokens(MarsikParser.LESS); }
		public TerminalNode LESS(int i) {
			return getToken(MarsikParser.LESS, i);
		}
		public List<TerminalNode> GREATER() { return getTokens(MarsikParser.GREATER); }
		public TerminalNode GREATER(int i) {
			return getToken(MarsikParser.GREATER, i);
		}
		public List<TerminalNode> LESSEQUAL() { return getTokens(MarsikParser.LESSEQUAL); }
		public TerminalNode LESSEQUAL(int i) {
			return getToken(MarsikParser.LESSEQUAL, i);
		}
		public List<TerminalNode> GREATEREQUAL() { return getTokens(MarsikParser.GREATEREQUAL); }
		public TerminalNode GREATEREQUAL(int i) {
			return getToken(MarsikParser.GREATEREQUAL, i);
		}
		public Relational_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitRelational_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_exprContext relational_expr() throws RecognitionException {
		Relational_exprContext _localctx = new Relational_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_relational_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			additive_expr();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 413927473152L) != 0)) {
				{
				{
				setState(378);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 413927473152L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(379);
				additive_expr();
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Additive_exprContext extends ParserRuleContext {
		public List<Multiplicative_exprContext> multiplicative_expr() {
			return getRuleContexts(Multiplicative_exprContext.class);
		}
		public Multiplicative_exprContext multiplicative_expr(int i) {
			return getRuleContext(Multiplicative_exprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(MarsikParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(MarsikParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(MarsikParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(MarsikParser.MINUS, i);
		}
		public Additive_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitAdditive_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_exprContext additive_expr() throws RecognitionException {
		Additive_exprContext _localctx = new Additive_exprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_additive_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			multiplicative_expr();
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(386);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(387);
					multiplicative_expr();
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiplicative_exprContext extends ParserRuleContext {
		public List<Unary_exprContext> unary_expr() {
			return getRuleContexts(Unary_exprContext.class);
		}
		public Unary_exprContext unary_expr(int i) {
			return getRuleContext(Unary_exprContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(MarsikParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(MarsikParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(MarsikParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(MarsikParser.SLASH, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(MarsikParser.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(MarsikParser.PERCENT, i);
		}
		public Multiplicative_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitMultiplicative_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_exprContext multiplicative_expr() throws RecognitionException {
		Multiplicative_exprContext _localctx = new Multiplicative_exprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_multiplicative_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			unary_expr();
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4395630592L) != 0)) {
				{
				{
				setState(394);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4395630592L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(395);
				unary_expr();
				}
				}
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_exprContext extends ParserRuleContext {
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(MarsikParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MarsikParser.MINUS, 0); }
		public Power_exprContext power_expr() {
			return getRuleContext(Power_exprContext.class,0);
		}
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_unary_expr);
		int _la;
		try {
			setState(404);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 25165840L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(402);
				unary_expr();
				}
				break;
			case STANDARDLIBS:
			case LPAR:
			case NAME:
			case INTEGER:
			case BABY_INTEGER:
			case STRING:
			case CHAR:
			case DOUBLE:
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				power_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Power_exprContext extends ParserRuleContext {
		public Atom_exprContext atom_expr() {
			return getRuleContext(Atom_exprContext.class,0);
		}
		public TerminalNode DOUBLESTAR() { return getToken(MarsikParser.DOUBLESTAR, 0); }
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public Power_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitPower_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Power_exprContext power_expr() throws RecognitionException {
		Power_exprContext _localctx = new Power_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_power_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			atom_expr();
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOUBLESTAR) {
				{
				setState(407);
				match(DOUBLESTAR);
				setState(408);
				unary_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Atom_exprContext extends ParserRuleContext {
		public Other_stmtContext other_stmt() {
			return getRuleContext(Other_stmtContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
		public TerminalNode BABY_INTEGER() { return getToken(MarsikParser.BABY_INTEGER, 0); }
		public TerminalNode CHAR() { return getToken(MarsikParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public TerminalNode DOUBLE() { return getToken(MarsikParser.DOUBLE, 0); }
		public TerminalNode BOOLEAN() { return getToken(MarsikParser.BOOLEAN, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public Atom_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitAtom_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atom_exprContext atom_expr() throws RecognitionException {
		Atom_exprContext _localctx = new Atom_exprContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_atom_expr);
		try {
			setState(423);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STANDARDLIBS:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				other_stmt();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(NAME);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				match(INTEGER);
				}
				break;
			case BABY_INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(414);
				match(BABY_INTEGER);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(415);
				match(CHAR);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 6);
				{
				setState(416);
				match(STRING);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(417);
				match(DOUBLE);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 8);
				{
				setState(418);
				match(BOOLEAN);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 9);
				{
				setState(419);
				match(LPAR);
				setState(420);
				expr();
				setState(421);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_defContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LBRACE() { return getToken(MarsikParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MarsikParser.RBRACE, 0); }
		public List<Class_memberContext> class_member() {
			return getRuleContexts(Class_memberContext.class);
		}
		public Class_memberContext class_member(int i) {
			return getRuleContext(Class_memberContext.class,i);
		}
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitClass_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(T__4);
			setState(426);
			match(NAME);
			setState(427);
			match(LBRACE);
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921504606847936L) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 63L) != 0)) {
				{
				{
				setState(428);
				class_member();
				}
				}
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(434);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_memberContext extends ParserRuleContext {
		public Field_declContext field_decl() {
			return getRuleContext(Field_declContext.class,0);
		}
		public Constructor_declContext constructor_decl() {
			return getRuleContext(Constructor_declContext.class,0);
		}
		public Method_declContext method_decl() {
			return getRuleContext(Method_declContext.class,0);
		}
		public Class_memberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_member; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitClass_member(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_memberContext class_member() throws RecognitionException {
		Class_memberContext _localctx = new Class_memberContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_class_member);
		try {
			setState(439);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case CONST:
			case INTEGER:
			case BABY_INTEGER:
			case STRING:
			case CHAR:
			case DOUBLE:
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				field_decl();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				constructor_decl();
				}
				break;
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(438);
				method_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode CONST() { return getToken(MarsikParser.CONST, 0); }
		public Field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitField_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declContext field_decl() throws RecognitionException {
		Field_declContext _localctx = new Field_declContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(441);
				match(T__5);
				}
			}

			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(444);
				match(CONST);
				}
			}

			setState(447);
			type();
			setState(448);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Constructor_declContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Constructor_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitConstructor_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constructor_declContext constructor_decl() throws RecognitionException {
		Constructor_declContext _localctx = new Constructor_declContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_constructor_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(T__6);
			setState(451);
			match(LPAR);
			setState(453);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 63L) != 0)) {
				{
				setState(452);
				parameters();
				}
			}

			setState(455);
			match(RPAR);
			setState(456);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_declContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MarsikParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitMethod_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_method_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(458);
				match(T__7);
				}
			}

			setState(461);
			match(T__8);
			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(462);
				match(COLON);
				setState(463);
				type();
				}
			}

			setState(466);
			match(NAME);
			setState(467);
			match(LPAR);
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 63L) != 0)) {
				{
				setState(468);
				parameters();
				}
			}

			setState(471);
			match(RPAR);
			setState(472);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001O\u01db\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0001"+
		"\u0000\u0005\u0000\\\b\u0000\n\u0000\f\u0000_\t\u0000\u0001\u0000\u0003"+
		"\u0000b\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003|\b\u0003\u0001\u0003\u0005\u0003\u007f"+
		"\b\u0003\n\u0003\f\u0003\u0082\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u0089\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0094\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u009f\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00a6\b\u0007\u0003\u0007\u00a8\b\u0007\u0001"+
		"\u0007\u0003\u0007\u00ab\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b8\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00bd\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00c2\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00cf\b\f\n\f\f\f\u00d2"+
		"\t\f\u0001\f\u0003\f\u00d5\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0003\r\u00dd\b\r\u0001\r\u0001\r\u0005\r\u00e1\b\r\n\r\f\r\u00e4"+
		"\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00eb"+
		"\b\u000e\n\u000e\f\u000e\u00ee\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00fa\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u0101\b\u0011\n\u0011\f\u0011\u0104"+
		"\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005\u0012\u010a"+
		"\b\u0012\n\u0012\f\u0012\u010d\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0115\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0119\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u011d\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0124\b\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u0128\b"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u012e"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u0136\b\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u013d\b\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u0141\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0150\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0157\b\u001c\n"+
		"\u001c\f\u001c\u015a\t\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u015e"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u0165\b\u001f\n\u001f\f\u001f\u0168\t\u001f\u0001 \u0001 \u0001"+
		" \u0005 \u016d\b \n \f \u0170\t \u0001!\u0001!\u0001!\u0005!\u0175\b!"+
		"\n!\f!\u0178\t!\u0001\"\u0001\"\u0001\"\u0005\"\u017d\b\"\n\"\f\"\u0180"+
		"\t\"\u0001#\u0001#\u0001#\u0005#\u0185\b#\n#\f#\u0188\t#\u0001$\u0001"+
		"$\u0001$\u0005$\u018d\b$\n$\f$\u0190\t$\u0001%\u0001%\u0001%\u0003%\u0195"+
		"\b%\u0001&\u0001&\u0001&\u0003&\u019a\b&\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003"+
		"\'\u01a8\b\'\u0001(\u0001(\u0001(\u0001(\u0005(\u01ae\b(\n(\f(\u01b1\t"+
		"(\u0001(\u0001(\u0001)\u0001)\u0001)\u0003)\u01b8\b)\u0001*\u0003*\u01bb"+
		"\b*\u0001*\u0003*\u01be\b*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0003"+
		"+\u01c6\b+\u0001+\u0001+\u0001+\u0001,\u0003,\u01cc\b,\u0001,\u0001,\u0001"+
		",\u0003,\u01d1\b,\u0001,\u0001,\u0001,\u0003,\u01d6\b,\u0001,\u0001,\u0001"+
		",\u0001,\u0000\u0000-\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVX\u0000"+
		"\u0007\u0001\u0000JO\u0001\u0000?E\u0002\u0000\"\"$$\u0002\u0000\u001d"+
		"\u001e%&\u0001\u0000\u0017\u0018\u0002\u0000\u0019\u001a  \u0002\u0000"+
		"\u0004\u0004\u0017\u0018\u01fa\u0000a\u0001\u0000\u0000\u0000\u0002e\u0001"+
		"\u0000\u0000\u0000\u0004g\u0001\u0000\u0000\u0000\u0006{\u0001\u0000\u0000"+
		"\u0000\b\u0083\u0001\u0000\u0000\u0000\n\u008c\u0001\u0000\u0000\u0000"+
		"\f\u0097\u0001\u0000\u0000\u0000\u000e\u00a0\u0001\u0000\u0000\u0000\u0010"+
		"\u00ac\u0001\u0000\u0000\u0000\u0012\u00b3\u0001\u0000\u0000\u0000\u0014"+
		"\u00b9\u0001\u0000\u0000\u0000\u0016\u00be\u0001\u0000\u0000\u0000\u0018"+
		"\u00c3\u0001\u0000\u0000\u0000\u001a\u00d8\u0001\u0000\u0000\u0000\u001c"+
		"\u00e7\u0001\u0000\u0000\u0000\u001e\u00ef\u0001\u0000\u0000\u0000 \u00f2"+
		"\u0001\u0000\u0000\u0000\"\u00fb\u0001\u0000\u0000\u0000$\u0107\u0001"+
		"\u0000\u0000\u0000&\u0111\u0001\u0000\u0000\u0000(\u0123\u0001\u0000\u0000"+
		"\u0000*\u0127\u0001\u0000\u0000\u0000,\u0129\u0001\u0000\u0000\u0000."+
		"\u0131\u0001\u0000\u0000\u00000\u0139\u0001\u0000\u0000\u00002\u0142\u0001"+
		"\u0000\u0000\u00004\u0147\u0001\u0000\u0000\u00006\u014a\u0001\u0000\u0000"+
		"\u00008\u0153\u0001\u0000\u0000\u0000:\u015b\u0001\u0000\u0000\u0000<"+
		"\u015f\u0001\u0000\u0000\u0000>\u0161\u0001\u0000\u0000\u0000@\u0169\u0001"+
		"\u0000\u0000\u0000B\u0171\u0001\u0000\u0000\u0000D\u0179\u0001\u0000\u0000"+
		"\u0000F\u0181\u0001\u0000\u0000\u0000H\u0189\u0001\u0000\u0000\u0000J"+
		"\u0194\u0001\u0000\u0000\u0000L\u0196\u0001\u0000\u0000\u0000N\u01a7\u0001"+
		"\u0000\u0000\u0000P\u01a9\u0001\u0000\u0000\u0000R\u01b7\u0001\u0000\u0000"+
		"\u0000T\u01ba\u0001\u0000\u0000\u0000V\u01c2\u0001\u0000\u0000\u0000X"+
		"\u01cb\u0001\u0000\u0000\u0000Z\\\u0003\u0006\u0003\u0000[Z\u0001\u0000"+
		"\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^b\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"`b\u0003P(\u0000a]\u0001\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000b"+
		"c\u0001\u0000\u0000\u0000cd\u0005\u0000\u0000\u0001d\u0001\u0001\u0000"+
		"\u0000\u0000ef\u0007\u0000\u0000\u0000f\u0003\u0001\u0000\u0000\u0000"+
		"gh\u0007\u0001\u0000\u0000h\u0005\u0001\u0000\u0000\u0000i|\u0003\u000e"+
		"\u0007\u0000j|\u0003\u0010\b\u0000k|\u0003\u0012\t\u0000l|\u0003 \u0010"+
		"\u0000m|\u0003\"\u0011\u0000n|\u0003:\u001d\u0000o|\u0003<\u001e\u0000"+
		"p|\u0003\u001a\r\u0000q|\u0003&\u0013\u0000r|\u0003\u0018\f\u0000s|\u0003"+
		"\f\u0006\u0000t|\u0003\u0014\n\u0000u|\u0003\u0016\u000b\u0000v|\u0003"+
		"\n\u0005\u0000w|\u0003\b\u0004\u0000x|\u0003,\u0016\u0000y|\u0003.\u0017"+
		"\u0000z|\u00030\u0018\u0000{i\u0001\u0000\u0000\u0000{j\u0001\u0000\u0000"+
		"\u0000{k\u0001\u0000\u0000\u0000{l\u0001\u0000\u0000\u0000{m\u0001\u0000"+
		"\u0000\u0000{n\u0001\u0000\u0000\u0000{o\u0001\u0000\u0000\u0000{p\u0001"+
		"\u0000\u0000\u0000{q\u0001\u0000\u0000\u0000{r\u0001\u0000\u0000\u0000"+
		"{s\u0001\u0000\u0000\u0000{t\u0001\u0000\u0000\u0000{u\u0001\u0000\u0000"+
		"\u0000{v\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000\u0000{x\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|\u0080"+
		"\u0001\u0000\u0000\u0000}\u007f\u0005G\u0000\u0000~}\u0001\u0000\u0000"+
		"\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0007\u0001\u0000\u0000\u0000"+
		"\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0084\u0005F\u0000\u0000\u0084"+
		"\u0085\u0005\u001f\u0000\u0000\u0085\u0086\u0005F\u0000\u0000\u0086\u0088"+
		"\u0005\u0012\u0000\u0000\u0087\u0089\u00038\u001c\u0000\u0088\u0087\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0005\u0014\u0000\u0000\u008b\t\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0005F\u0000\u0000\u008d\u008e\u0005F\u0000\u0000"+
		"\u008e\u008f\u0005\u0011\u0000\u0000\u008f\u0090\u00050\u0000\u0000\u0090"+
		"\u0091\u0005F\u0000\u0000\u0091\u0093\u0005\u0012\u0000\u0000\u0092\u0094"+
		"\u0003\u001c\u000e\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005\u0014\u0000\u0000\u0096\u000b\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0003\u0004\u0002\u0000\u0098\u0099\u0005F\u0000\u0000\u0099\u009e\u0005"+
		"\u0011\u0000\u0000\u009a\u009f\u00032\u0019\u0000\u009b\u009f\u00034\u001a"+
		"\u0000\u009c\u009f\u00036\u001b\u0000\u009d\u009f\u0003\b\u0004\u0000"+
		"\u009e\u009a\u0001\u0000\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\r\u0001\u0000\u0000\u0000\u00a0\u00a1\u0003\u0004\u0002\u0000\u00a1"+
		"\u00a7\u0005F\u0000\u0000\u00a2\u00a5\u0005\u0011\u0000\u0000\u00a3\u00a6"+
		"\u0003\u0002\u0001\u0000\u00a4\u00a6\u0003<\u001e\u0000\u00a5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a2\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005"+
		"G\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ab\u000f\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005<\u0000"+
		"\u0000\u00ad\u00ae\u0003\u0004\u0002\u0000\u00ae\u00af\u0005F\u0000\u0000"+
		"\u00af\u00b0\u0005\u0011\u0000\u0000\u00b0\u00b1\u0003\u0002\u0001\u0000"+
		"\u00b1\u00b2\u0005G\u0000\u0000\u00b2\u0011\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0005F\u0000\u0000\u00b4\u00b7\u0005\u0011\u0000\u0000\u00b5\u00b8"+
		"\u0003\u0002\u0001\u0000\u00b6\u00b8\u0003<\u001e\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u0013\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0005F\u0000\u0000\u00ba\u00bc\u0005\u000b"+
		"\u0000\u0000\u00bb\u00bd\u0005J\u0000\u0000\u00bc\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u0015\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0005F\u0000\u0000\u00bf\u00c1\u0005\f\u0000\u0000"+
		"\u00c0\u00c2\u0005J\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u0017\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0005?\u0000\u0000\u00c4\u00c5\u0005\u001d\u0000\u0000\u00c5\u00c6"+
		"\u0003\u0004\u0002\u0000\u00c6\u00c7\u0005\u001e\u0000\u0000\u00c7\u00c8"+
		"\u0005F\u0000\u0000\u00c8\u00c9\u0005\u0011\u0000\u0000\u00c9\u00d4\u0005"+
		"\r\u0000\u0000\u00ca\u00d5\u0003\u0002\u0001\u0000\u00cb\u00cc\u0003\u0002"+
		"\u0001\u0000\u00cc\u00cd\u0005\u000f\u0000\u0000\u00cd\u00cf\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cb\u0001\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d5\u0003\u0002\u0001\u0000\u00d4\u00ca\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d0\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u000e"+
		"\u0000\u0000\u00d7\u0019\u0001\u0000\u0000\u0000\u00d8\u00d9\u00052\u0000"+
		"\u0000\u00d9\u00da\u0005F\u0000\u0000\u00da\u00dc\u0005\u0012\u0000\u0000"+
		"\u00db\u00dd\u0003\u001c\u000e\u0000\u00dc\u00db\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000"+
		"\u00de\u00e2\u0005\u0014\u0000\u0000\u00df\u00e1\u0005G\u0000\u0000\u00e0"+
		"\u00df\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0003$\u0012\u0000\u00e6\u001b\u0001\u0000\u0000\u0000\u00e7\u00ec"+
		"\u0003\u001e\u000f\u0000\u00e8\u00e9\u0005\u000f\u0000\u0000\u00e9\u00eb"+
		"\u0003\u001e\u000f\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ee"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ed\u001d\u0001\u0000\u0000\u0000\u00ee\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f0\u0003\u0002\u0001\u0000\u00f0\u00f1"+
		"\u0005F\u0000\u0000\u00f1\u001f\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005"+
		"5\u0000\u0000\u00f3\u00f4\u0005\u0012\u0000\u0000\u00f4\u00f5\u0003<\u001e"+
		"\u0000\u00f5\u00f6\u0005\u0014\u0000\u0000\u00f6\u00f9\u0003$\u0012\u0000"+
		"\u00f7\u00f8\u00053\u0000\u0000\u00f8\u00fa\u0003$\u0012\u0000\u00f9\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa!\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0005:\u0000\u0000\u00fc\u00fd\u0005\u0012"+
		"\u0000\u0000\u00fd\u00fe\u0003<\u001e\u0000\u00fe\u0102\u0005\u0014\u0000"+
		"\u0000\u00ff\u0101\u0005G\u0000\u0000\u0100\u00ff\u0001\u0000\u0000\u0000"+
		"\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0105\u0001\u0000\u0000\u0000"+
		"\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0106\u0003$\u0012\u0000\u0106"+
		"#\u0001\u0000\u0000\u0000\u0107\u010b\u0005\u0013\u0000\u0000\u0108\u010a"+
		"\u0003\u0006\u0003\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010d"+
		"\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c"+
		"\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u010b"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0005G\u0000\u0000\u010f\u0110\u0005"+
		"\u0015\u0000\u0000\u0110%\u0001\u0000\u0000\u0000\u0111\u0112\u00054\u0000"+
		"\u0000\u0112\u0114\u0005\u0012\u0000\u0000\u0113\u0115\u0003(\u0014\u0000"+
		"\u0114\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u0005\u0010\u0000\u0000"+
		"\u0117\u0119\u0003<\u001e\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0118"+
		"\u0119\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a"+
		"\u011c\u0005\u0010\u0000\u0000\u011b\u011d\u0003*\u0015\u0000\u011c\u011b"+
		"\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011e"+
		"\u0001\u0000\u0000\u0000\u011e\u011f\u0005\u0014\u0000\u0000\u011f\u0120"+
		"\u0003$\u0012\u0000\u0120\'\u0001\u0000\u0000\u0000\u0121\u0124\u0003"+
		"\u000e\u0007\u0000\u0122\u0124\u0003\u0012\t\u0000\u0123\u0121\u0001\u0000"+
		"\u0000\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124)\u0001\u0000\u0000"+
		"\u0000\u0125\u0128\u0003\u0014\n\u0000\u0126\u0128\u0003\u0016\u000b\u0000"+
		"\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0126\u0001\u0000\u0000\u0000"+
		"\u0128+\u0001\u0000\u0000\u0000\u0129\u012a\u00056\u0000\u0000\u012a\u012d"+
		"\u0005\u0012\u0000\u0000\u012b\u012e\u0005L\u0000\u0000\u012c\u012e\u0003"+
		"<\u001e\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012c\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0130\u0005\u0014"+
		"\u0000\u0000\u0130-\u0001\u0000\u0000\u0000\u0131\u0132\u00057\u0000\u0000"+
		"\u0132\u0135\u0005\u0012\u0000\u0000\u0133\u0136\u0005L\u0000\u0000\u0134"+
		"\u0136\u0003<\u001e\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135\u0134"+
		"\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0005\u0014\u0000\u0000\u0138/\u0001\u0000\u0000\u0000\u0139\u0140\u0005"+
		";\u0000\u0000\u013a\u013c\u0005\u0012\u0000\u0000\u013b\u013d\u0005J\u0000"+
		"\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000"+
		"\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u0141\u0005\u0014\u0000"+
		"\u0000\u013f\u0141\u0005\u0001\u0000\u0000\u0140\u013a\u0001\u0000\u0000"+
		"\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u01411\u0001\u0000\u0000\u0000"+
		"\u0142\u0143\u0005=\u0000\u0000\u0143\u0144\u0005\u0012\u0000\u0000\u0144"+
		"\u0145\u0005L\u0000\u0000\u0145\u0146\u0005\u0014\u0000\u0000\u01463\u0001"+
		"\u0000\u0000\u0000\u0147\u0148\u0005>\u0000\u0000\u0148\u0149\u0005\u0001"+
		"\u0000\u0000\u01495\u0001\u0000\u0000\u0000\u014a\u014b\u0005\n\u0000"+
		"\u0000\u014b\u014c\u0005\u001f\u0000\u0000\u014c\u014d\u0005F\u0000\u0000"+
		"\u014d\u014f\u0005\u0012\u0000\u0000\u014e\u0150\u00038\u001c\u0000\u014f"+
		"\u014e\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150"+
		"\u0151\u0001\u0000\u0000\u0000\u0151\u0152\u0005\u0014\u0000\u0000\u0152"+
		"7\u0001\u0000\u0000\u0000\u0153\u0158\u0003<\u001e\u0000\u0154\u0155\u0005"+
		"\u000f\u0000\u0000\u0155\u0157\u0003<\u001e\u0000\u0156\u0154\u0001\u0000"+
		"\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000"+
		"\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u01599\u0001\u0000\u0000"+
		"\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015b\u015d\u00058\u0000\u0000"+
		"\u015c\u015e\u0003<\u001e\u0000\u015d\u015c\u0001\u0000\u0000\u0000\u015d"+
		"\u015e\u0001\u0000\u0000\u0000\u015e;\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0003>\u001f\u0000\u0160=\u0001\u0000\u0000\u0000\u0161\u0166\u0003@"+
		" \u0000\u0162\u0163\u0005\u0002\u0000\u0000\u0163\u0165\u0003@ \u0000"+
		"\u0164\u0162\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000\u0000\u0000"+
		"\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000"+
		"\u0167?\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169"+
		"\u016e\u0003B!\u0000\u016a\u016b\u0005\u0003\u0000\u0000\u016b\u016d\u0003"+
		"B!\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u0170\u0001\u0000\u0000"+
		"\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000"+
		"\u0000\u016fA\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000"+
		"\u0171\u0176\u0003D\"\u0000\u0172\u0173\u0007\u0002\u0000\u0000\u0173"+
		"\u0175\u0003D\"\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0175\u0178"+
		"\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0176\u0177"+
		"\u0001\u0000\u0000\u0000\u0177C\u0001\u0000\u0000\u0000\u0178\u0176\u0001"+
		"\u0000\u0000\u0000\u0179\u017e\u0003F#\u0000\u017a\u017b\u0007\u0003\u0000"+
		"\u0000\u017b\u017d\u0003F#\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017d"+
		"\u0180\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017e"+
		"\u017f\u0001\u0000\u0000\u0000\u017fE\u0001\u0000\u0000\u0000\u0180\u017e"+
		"\u0001\u0000\u0000\u0000\u0181\u0186\u0003H$\u0000\u0182\u0183\u0007\u0004"+
		"\u0000\u0000\u0183\u0185\u0003H$\u0000\u0184\u0182\u0001\u0000\u0000\u0000"+
		"\u0185\u0188\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000"+
		"\u0186\u0187\u0001\u0000\u0000\u0000\u0187G\u0001\u0000\u0000\u0000\u0188"+
		"\u0186\u0001\u0000\u0000\u0000\u0189\u018e\u0003J%\u0000\u018a\u018b\u0007"+
		"\u0005\u0000\u0000\u018b\u018d\u0003J%\u0000\u018c\u018a\u0001\u0000\u0000"+
		"\u0000\u018d\u0190\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000\u0000"+
		"\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018fI\u0001\u0000\u0000\u0000"+
		"\u0190\u018e\u0001\u0000\u0000\u0000\u0191\u0192\u0007\u0006\u0000\u0000"+
		"\u0192\u0195\u0003J%\u0000\u0193\u0195\u0003L&\u0000\u0194\u0191\u0001"+
		"\u0000\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0195K\u0001\u0000"+
		"\u0000\u0000\u0196\u0199\u0003N\'\u0000\u0197\u0198\u0005+\u0000\u0000"+
		"\u0198\u019a\u0003J%\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u0199\u019a"+
		"\u0001\u0000\u0000\u0000\u019aM\u0001\u0000\u0000\u0000\u019b\u01a8\u0003"+
		"6\u001b\u0000\u019c\u01a8\u0005F\u0000\u0000\u019d\u01a8\u0005J\u0000"+
		"\u0000\u019e\u01a8\u0005K\u0000\u0000\u019f\u01a8\u0005M\u0000\u0000\u01a0"+
		"\u01a8\u0005L\u0000\u0000\u01a1\u01a8\u0005N\u0000\u0000\u01a2\u01a8\u0005"+
		"O\u0000\u0000\u01a3\u01a4\u0005\u0012\u0000\u0000\u01a4\u01a5\u0003<\u001e"+
		"\u0000\u01a5\u01a6\u0005\u0014\u0000\u0000\u01a6\u01a8\u0001\u0000\u0000"+
		"\u0000\u01a7\u019b\u0001\u0000\u0000\u0000\u01a7\u019c\u0001\u0000\u0000"+
		"\u0000\u01a7\u019d\u0001\u0000\u0000\u0000\u01a7\u019e\u0001\u0000\u0000"+
		"\u0000\u01a7\u019f\u0001\u0000\u0000\u0000\u01a7\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a1\u0001\u0000\u0000\u0000\u01a7\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a3\u0001\u0000\u0000\u0000\u01a8O\u0001\u0000\u0000\u0000"+
		"\u01a9\u01aa\u0005\u0005\u0000\u0000\u01aa\u01ab\u0005F\u0000\u0000\u01ab"+
		"\u01af\u0005\u0013\u0000\u0000\u01ac\u01ae\u0003R)\u0000\u01ad\u01ac\u0001"+
		"\u0000\u0000\u0000\u01ae\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad\u0001"+
		"\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005"+
		"\u0015\u0000\u0000\u01b3Q\u0001\u0000\u0000\u0000\u01b4\u01b8\u0003T*"+
		"\u0000\u01b5\u01b8\u0003V+\u0000\u01b6\u01b8\u0003X,\u0000\u01b7\u01b4"+
		"\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b6"+
		"\u0001\u0000\u0000\u0000\u01b8S\u0001\u0000\u0000\u0000\u01b9\u01bb\u0005"+
		"\u0006\u0000\u0000\u01ba\u01b9\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001"+
		"\u0000\u0000\u0000\u01bb\u01bd\u0001\u0000\u0000\u0000\u01bc\u01be\u0005"+
		"<\u0000\u0000\u01bd\u01bc\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000"+
		"\u0000\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c0\u0003\u0002"+
		"\u0001\u0000\u01c0\u01c1\u0005F\u0000\u0000\u01c1U\u0001\u0000\u0000\u0000"+
		"\u01c2\u01c3\u0005\u0007\u0000\u0000\u01c3\u01c5\u0005\u0012\u0000\u0000"+
		"\u01c4\u01c6\u0003\u001c\u000e\u0000\u01c5\u01c4\u0001\u0000\u0000\u0000"+
		"\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000"+
		"\u01c7\u01c8\u0005\u0014\u0000\u0000\u01c8\u01c9\u0003$\u0012\u0000\u01c9"+
		"W\u0001\u0000\u0000\u0000\u01ca\u01cc\u0005\b\u0000\u0000\u01cb\u01ca"+
		"\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000\u01cc\u01cd"+
		"\u0001\u0000\u0000\u0000\u01cd\u01d0\u0005\t\u0000\u0000\u01ce\u01cf\u0005"+
		"\u0016\u0000\u0000\u01cf\u01d1\u0003\u0002\u0001\u0000\u01d0\u01ce\u0001"+
		"\u0000\u0000\u0000\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d3\u0005F\u0000\u0000\u01d3\u01d5\u0005\u0012"+
		"\u0000\u0000\u01d4\u01d6\u0003\u001c\u000e\u0000\u01d5\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d7\u01d8\u0005\u0014\u0000\u0000\u01d8\u01d9\u0003$\u0012"+
		"\u0000\u01d9Y\u0001\u0000\u0000\u00002]a{\u0080\u0088\u0093\u009e\u00a5"+
		"\u00a7\u00aa\u00b7\u00bc\u00c1\u00d0\u00d4\u00dc\u00e2\u00ec\u00f9\u0102"+
		"\u010b\u0114\u0118\u011c\u0123\u0127\u012d\u0135\u013c\u0140\u014f\u0158"+
		"\u015d\u0166\u016e\u0176\u017e\u0186\u018e\u0194\u0199\u01a7\u01af\u01b7"+
		"\u01ba\u01bd\u01c5\u01cb\u01d0\u01d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}