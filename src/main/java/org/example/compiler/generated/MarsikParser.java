// Generated from c:/Marsik/MarsikLang/src/main/java/org/example/Marsik.g4 by ANTLR 4.13.1
package org.example.compiler.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MarsikParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, PLUSPLUS=9, 
		MINUSMINUS=10, LSQB=11, RSQB=12, COMMA=13, SEMI=14, EQUAL=15, LPAR=16, 
		LBRACE=17, RPAR=18, RBRACE=19, COLON=20, PLUS=21, MINUS=22, STAR=23, SLASH=24, 
		VBAR=25, AMPER=26, LESS=27, GREATER=28, DOT=29, PERCENT=30, BACKQUOTE=31, 
		EQEQUAL=32, INEQUAL=33, NOTEQUAL=34, LESSEQUAL=35, GREATEREQUAL=36, TILDE=37, 
		CIRCUMFLEX=38, LEFTSHIFT=39, RIGHTSHIFT=40, DOUBLESTAR=41, PLUSEQUAL=42, 
		MINEQUAL=43, STAREQUAL=44, SLASHEQUAL=45, NEW=46, BREAK=47, FUNCTION=48, 
		ELSE=49, FOR=50, IF=51, PRINT=52, PRINTLN=53, RETURN=54, WHILE=55, EXIT=56, 
		CONST=57, SCAN=58, AR_TYPE=59, INT_TYPE=60, DOUBLE_TYPE=61, CHAR_TYPE=62, 
		BOOL_TYPE=63, STRING_TYPE=64, BABY_INT_TYPE=65, INTEGER=66, BABY_INTEGER=67, 
		STRING=68, CHAR=69, DOUBLE=70, BOOLEAN=71, NAME=72, NEWLINE=73, COMMENT=74, 
		WS=75;
	public static final int
		RULE_program = 0, RULE_type = 1, RULE_type_label = 2, RULE_stmt = 3, RULE_method_call = 4, 
		RULE_object_stmt = 5, RULE_var_decl = 6, RULE_const_decl = 7, RULE_assign_stmt = 8, 
		RULE_inc_stmt = 9, RULE_dec_stmt = 10, RULE_array_decl = 11, RULE_funcdef = 12, 
		RULE_parameters = 13, RULE_parameter = 14, RULE_if_stmt = 15, RULE_while_stmt = 16, 
		RULE_block = 17, RULE_for_stmt = 18, RULE_for_init = 19, RULE_for_update = 20, 
		RULE_return_stmt = 21, RULE_print_stmt = 22, RULE_println_stmt = 23, RULE_scan_stmt = 24, 
		RULE_print_arg = 25, RULE_exit_stmt = 26, RULE_arguments = 27, RULE_expr = 28, 
		RULE_or_expr = 29, RULE_and_expr = 30, RULE_equality_expr = 31, RULE_relational_expr = 32, 
		RULE_additive_expr = 33, RULE_multiplicative_expr = 34, RULE_unary_expr = 35, 
		RULE_power_expr = 36, RULE_atom_expr = 37, RULE_class_def = 38, RULE_class_member = 39, 
		RULE_field_decl = 40, RULE_method_decl = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "type_label", "stmt", "method_call", "object_stmt", 
			"var_decl", "const_decl", "assign_stmt", "inc_stmt", "dec_stmt", "array_decl", 
			"funcdef", "parameters", "parameter", "if_stmt", "while_stmt", "block", 
			"for_stmt", "for_init", "for_update", "return_stmt", "print_stmt", "println_stmt", 
			"scan_stmt", "print_arg", "exit_stmt", "arguments", "expr", "or_expr", 
			"and_expr", "equality_expr", "relational_expr", "additive_expr", "multiplicative_expr", 
			"unary_expr", "power_expr", "atom_expr", "class_def", "class_member", 
			"field_decl", "method_decl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'()'", "'or'", "'and'", "'not'", "'class'", "'public'", "'internal'", 
			"'Method:'", "'++'", "'--'", "'['", "']'", "','", "';'", "'='", "'('", 
			"'{'", "')'", "'}'", "':'", "'+'", "'-'", "'*'", "'/'", "'|'", "'&'", 
			"'<'", "'>'", "'.'", "'%'", "'`'", "'=='", "'<>'", "'!='", "'<='", "'>='", 
			"'~'", "'^'", "'<<'", "'>>'", "'**'", "'+='", "'-='", "'*='", "'/='", 
			"'new'", "'break'", "'function'", "'else'", "'for'", "'if'", "'print'", 
			"'printLine'", "'return'", "'while'", "'exit'", "'const'", "'scan'", 
			"'array'", "'int'", "'double'", "'char'", "'boolean'", "'string'", "'baby_int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "PLUSPLUS", "MINUSMINUS", 
			"LSQB", "RSQB", "COMMA", "SEMI", "EQUAL", "LPAR", "LBRACE", "RPAR", "RBRACE", 
			"COLON", "PLUS", "MINUS", "STAR", "SLASH", "VBAR", "AMPER", "LESS", "GREATER", 
			"DOT", "PERCENT", "BACKQUOTE", "EQEQUAL", "INEQUAL", "NOTEQUAL", "LESSEQUAL", 
			"GREATEREQUAL", "TILDE", "CIRCUMFLEX", "LEFTSHIFT", "RIGHTSHIFT", "DOUBLESTAR", 
			"PLUSEQUAL", "MINEQUAL", "STAREQUAL", "SLASHEQUAL", "NEW", "BREAK", "FUNCTION", 
			"ELSE", "FOR", "IF", "PRINT", "PRINTLN", "RETURN", "WHILE", "EXIT", "CONST", 
			"SCAN", "AR_TYPE", "INT_TYPE", "DOUBLE_TYPE", "CHAR_TYPE", "BOOL_TYPE", 
			"STRING_TYPE", "BABY_INT_TYPE", "INTEGER", "BABY_INTEGER", "STRING", 
			"CHAR", "DOUBLE", "BOOLEAN", "NAME", "NEWLINE", "COMMENT", "WS"
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
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case T__3:
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
			case INT_TYPE:
			case DOUBLE_TYPE:
			case CHAR_TYPE:
			case BOOL_TYPE:
			case STRING_TYPE:
			case BABY_INT_TYPE:
			case INTEGER:
			case BABY_INTEGER:
			case STRING:
			case CHAR:
			case DOUBLE:
			case BOOLEAN:
			case NAME:
				{
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -865535553378910192L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 511L) != 0)) {
					{
					{
					setState(84);
					stmt();
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				{
				setState(90);
				class_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(93);
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
		public TerminalNode BABY_INTEGER() { return getToken(MarsikParser.BABY_INTEGER, 0); }
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
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
			setState(95);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 63L) != 0)) ) {
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
		public TerminalNode BABY_INT_TYPE() { return getToken(MarsikParser.BABY_INT_TYPE, 0); }
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
			setState(97);
			_la = _input.LA(1);
			if ( !(((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & 63L) != 0)) ) {
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
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
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
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Array_declContext array_decl() {
			return getRuleContext(Array_declContext.class,0);
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
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public Println_stmtContext println_stmt() {
			return getRuleContext(Println_stmtContext.class,0);
		}
		public Exit_stmtContext exit_stmt() {
			return getRuleContext(Exit_stmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(99);
				var_decl();
				}
				break;
			case 2:
				{
				setState(100);
				const_decl();
				}
				break;
			case 3:
				{
				setState(101);
				assign_stmt();
				}
				break;
			case 4:
				{
				setState(102);
				method_call();
				}
				break;
			case 5:
				{
				setState(103);
				if_stmt();
				}
				break;
			case 6:
				{
				setState(104);
				while_stmt();
				}
				break;
			case 7:
				{
				setState(105);
				return_stmt();
				}
				break;
			case 8:
				{
				setState(106);
				funcdef();
				}
				break;
			case 9:
				{
				setState(107);
				for_stmt();
				}
				break;
			case 10:
				{
				setState(108);
				array_decl();
				}
				break;
			case 11:
				{
				setState(109);
				inc_stmt();
				}
				break;
			case 12:
				{
				setState(110);
				dec_stmt();
				}
				break;
			case 13:
				{
				setState(111);
				object_stmt();
				}
				break;
			case 14:
				{
				setState(112);
				print_stmt();
				}
				break;
			case 15:
				{
				setState(113);
				println_stmt();
				}
				break;
			case 16:
				{
				setState(114);
				exit_stmt();
				}
				break;
			case 17:
				{
				setState(115);
				expr();
				}
				break;
			}
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(118);
					match(NEWLINE);
					}
					} 
				}
				setState(123);
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
			setState(124);
			match(NAME);
			setState(125);
			match(DOT);
			setState(126);
			match(NAME);
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(127);
				match(LPAR);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6357008L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 127L) != 0)) {
					{
					setState(128);
					arguments();
					}
				}

				setState(131);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(132);
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
	public static class Object_stmtContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(MarsikParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(MarsikParser.NAME, i);
		}
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public TerminalNode NEW() { return getToken(MarsikParser.NEW, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public TerminalNode LESS() { return getToken(MarsikParser.LESS, 0); }
		public List<Type_labelContext> type_label() {
			return getRuleContexts(Type_labelContext.class);
		}
		public Type_labelContext type_label(int i) {
			return getRuleContext(Type_labelContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(MarsikParser.GREATER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(MarsikParser.COMMA, 0); }
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
			setState(135);
			match(NAME);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(136);
				match(LESS);
				setState(137);
				type_label();
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(138);
					match(COMMA);
					setState(139);
					type_label();
					}
				}

				setState(142);
				match(GREATER);
				}
			}

			setState(146);
			match(NAME);
			setState(147);
			match(EQUAL);
			setState(148);
			match(NEW);
			setState(149);
			match(NAME);
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(150);
				match(LPAR);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6357008L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 127L) != 0)) {
					{
					setState(151);
					arguments();
					}
				}

				setState(154);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(155);
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
		public Scan_stmtContext scan_stmt() {
			return getRuleContext(Scan_stmtContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
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
		enterRule(_localctx, 12, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			type_label();
			setState(159);
			match(NAME);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(160);
				match(EQUAL);
				setState(165);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(161);
					type();
					}
					break;
				case 2:
					{
					setState(162);
					scan_stmt();
					}
					break;
				case 3:
					{
					setState(163);
					method_call();
					}
					break;
				case 4:
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
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
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
		enterRule(_localctx, 14, RULE_const_decl);
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
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(MarsikParser.NEWLINE, 0); }
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
		enterRule(_localctx, 16, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(NAME);
			setState(180);
			match(EQUAL);
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(181);
				type();
				}
				break;
			case 2:
				{
				setState(182);
				method_call();
				}
				break;
			case 3:
				{
				setState(183);
				expr();
				}
				break;
			}
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(186);
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
		enterRule(_localctx, 18, RULE_inc_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(NAME);
			setState(190);
			match(PLUSPLUS);
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(191);
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
		enterRule(_localctx, 20, RULE_dec_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(NAME);
			setState(195);
			match(MINUSMINUS);
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(196);
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
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
		}
		public List<TerminalNode> LSQB() { return getTokens(MarsikParser.LSQB); }
		public TerminalNode LSQB(int i) {
			return getToken(MarsikParser.LSQB, i);
		}
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
		public List<TerminalNode> RSQB() { return getTokens(MarsikParser.RSQB); }
		public TerminalNode RSQB(int i) {
			return getToken(MarsikParser.RSQB, i);
		}
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
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
		enterRule(_localctx, 22, RULE_array_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			type_label();
			setState(200);
			match(LSQB);
			setState(201);
			match(INTEGER);
			setState(202);
			match(RSQB);
			setState(203);
			match(NAME);
			setState(204);
			match(EQUAL);
			setState(205);
			match(LSQB);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 63L) != 0)) {
				{
				setState(206);
				type();
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(207);
					match(COMMA);
					setState(208);
					type();
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(216);
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
		enterRule(_localctx, 24, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(FUNCTION);
			setState(219);
			match(NAME);
			setState(220);
			match(LPAR);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & 63L) != 0)) {
				{
				setState(221);
				parameters();
				}
			}

			setState(224);
			match(RPAR);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(225);
				match(NEWLINE);
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
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
		enterRule(_localctx, 26, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			parameter();
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(234);
				match(COMMA);
				setState(235);
				parameter();
				}
				}
				setState(240);
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
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
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
		enterRule(_localctx, 28, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			type_label();
			setState(242);
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
		enterRule(_localctx, 30, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(IF);
			setState(245);
			match(LPAR);
			setState(246);
			expr();
			setState(247);
			match(RPAR);
			setState(248);
			block();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(249);
				match(ELSE);
				setState(250);
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
		enterRule(_localctx, 32, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(WHILE);
			setState(254);
			match(LPAR);
			setState(255);
			expr();
			setState(256);
			match(RPAR);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(257);
				match(NEWLINE);
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(263);
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
		enterRule(_localctx, 34, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(LBRACE);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -865535553378910192L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 511L) != 0)) {
				{
				{
				setState(266);
				stmt();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
			match(NEWLINE);
			setState(273);
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
		enterRule(_localctx, 36, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(FOR);
			setState(276);
			match(LPAR);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & 4159L) != 0)) {
				{
				setState(277);
				for_init();
				}
			}

			setState(280);
			match(SEMI);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6357008L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 127L) != 0)) {
				{
				setState(281);
				expr();
				}
			}

			setState(284);
			match(SEMI);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(285);
				for_update();
				}
			}

			setState(288);
			match(RPAR);
			setState(289);
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
		enterRule(_localctx, 38, RULE_for_init);
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
			case DOUBLE_TYPE:
			case CHAR_TYPE:
			case BOOL_TYPE:
			case STRING_TYPE:
			case BABY_INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				var_decl();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
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
		enterRule(_localctx, 40, RULE_for_update);
		try {
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				inc_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
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
		enterRule(_localctx, 42, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(RETURN);
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(300);
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
	public static class Print_stmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(MarsikParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public List<Print_argContext> print_arg() {
			return getRuleContexts(Print_argContext.class);
		}
		public Print_argContext print_arg(int i) {
			return getRuleContext(Print_argContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MarsikParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MarsikParser.COMMA, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(PRINT);
			setState(304);
			match(LPAR);
			setState(305);
			print_arg();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(306);
				match(COMMA);
				setState(307);
				print_arg();
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
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
	public static class Println_stmtContext extends ParserRuleContext {
		public TerminalNode PRINTLN() { return getToken(MarsikParser.PRINTLN, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public List<Print_argContext> print_arg() {
			return getRuleContexts(Print_argContext.class);
		}
		public Print_argContext print_arg(int i) {
			return getRuleContext(Print_argContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MarsikParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MarsikParser.COMMA, i);
		}
		public Println_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_println_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitPrintln_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Println_stmtContext println_stmt() throws RecognitionException {
		Println_stmtContext _localctx = new Println_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_println_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(PRINTLN);
			setState(316);
			match(LPAR);
			setState(317);
			print_arg();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(318);
				match(COMMA);
				setState(319);
				print_arg();
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Scan_stmtContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(MarsikParser.SCAN, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public List<Print_argContext> print_arg() {
			return getRuleContexts(Print_argContext.class);
		}
		public Print_argContext print_arg(int i) {
			return getRuleContext(Print_argContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MarsikParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MarsikParser.COMMA, i);
		}
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
		enterRule(_localctx, 48, RULE_scan_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(SCAN);
			setState(328);
			match(LPAR);
			setState(329);
			print_arg();
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(330);
				match(COMMA);
				setState(331);
				print_arg();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Print_argContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_arg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitPrint_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_argContext print_arg() throws RecognitionException {
		Print_argContext _localctx = new Print_argContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_print_arg);
		try {
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				expr();
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
		enterRule(_localctx, 52, RULE_exit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(EXIT);
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(344);
				match(LPAR);
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTEGER) {
					{
					setState(345);
					match(INTEGER);
					}
				}

				setState(348);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(349);
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
		enterRule(_localctx, 54, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			expr();
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(353);
				match(COMMA);
				setState(354);
				expr();
				}
				}
				setState(359);
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
		enterRule(_localctx, 56, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
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
		enterRule(_localctx, 58, RULE_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			and_expr();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(363);
				match(T__1);
				setState(364);
				and_expr();
				}
				}
				setState(369);
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
		enterRule(_localctx, 60, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			equality_expr();
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(371);
				match(T__2);
				setState(372);
				equality_expr();
				}
				}
				setState(377);
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
		enterRule(_localctx, 62, RULE_equality_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			relational_expr();
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(379);
				_la = _input.LA(1);
				if ( !(_la==EQEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(380);
				relational_expr();
				}
				}
				setState(385);
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
		enterRule(_localctx, 64, RULE_relational_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			additive_expr();
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103481868288L) != 0)) {
				{
				{
				setState(387);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 103481868288L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(388);
				additive_expr();
				}
				}
				setState(393);
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
		enterRule(_localctx, 66, RULE_additive_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			multiplicative_expr();
			setState(399);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(395);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(396);
					multiplicative_expr();
					}
					} 
				}
				setState(401);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
		enterRule(_localctx, 68, RULE_multiplicative_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			unary_expr();
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1098907648L) != 0)) {
				{
				{
				setState(403);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1098907648L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(404);
				unary_expr();
				}
				}
				setState(409);
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
		enterRule(_localctx, 70, RULE_unary_expr);
		int _la;
		try {
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6291472L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(411);
				unary_expr();
				}
				break;
			case LPAR:
			case INTEGER:
			case BABY_INTEGER:
			case STRING:
			case CHAR:
			case DOUBLE:
			case BOOLEAN:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
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
		enterRule(_localctx, 72, RULE_power_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			atom_expr();
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOUBLESTAR) {
				{
				setState(416);
				match(DOUBLESTAR);
				setState(417);
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
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
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
		enterRule(_localctx, 74, RULE_atom_expr);
		try {
			setState(432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(420);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(421);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(422);
				match(INTEGER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(423);
				match(BABY_INTEGER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(424);
				match(CHAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(425);
				match(STRING);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(426);
				match(DOUBLE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(427);
				match(BOOLEAN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(428);
				match(LPAR);
				setState(429);
				expr();
				setState(430);
				match(RPAR);
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
		enterRule(_localctx, 76, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(T__4);
			setState(435);
			match(NAME);
			setState(436);
			match(LBRACE);
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 1137158905911050247L) != 0)) {
				{
				{
				setState(437);
				class_member();
				}
				}
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(443);
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
		public Method_declContext method_decl() {
			return getRuleContext(Method_declContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MarsikParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MarsikParser.NEWLINE, i);
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
		enterRule(_localctx, 78, RULE_class_member);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case CONST:
			case INT_TYPE:
			case DOUBLE_TYPE:
			case CHAR_TYPE:
			case BOOL_TYPE:
			case STRING_TYPE:
			case BABY_INT_TYPE:
				{
				setState(445);
				field_decl();
				}
				break;
			case T__6:
			case T__7:
				{
				setState(446);
				method_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(449);
				match(NEWLINE);
				}
				}
				setState(454);
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
	public static class Field_declContext extends ParserRuleContext {
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
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
		enterRule(_localctx, 80, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(455);
				match(T__5);
				}
			}

			setState(459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(458);
				match(CONST);
				}
			}

			setState(461);
			type_label();
			setState(462);
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
	public static class Method_declContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
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
		enterRule(_localctx, 82, RULE_method_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(464);
				match(T__6);
				}
			}

			setState(467);
			match(T__7);
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & 63L) != 0)) {
				{
				setState(468);
				type_label();
				}
			}

			setState(471);
			match(NAME);
			setState(472);
			match(LPAR);
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & 63L) != 0)) {
				{
				setState(473);
				parameters();
				}
			}

			setState(476);
			match(RPAR);
			setState(477);
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
		"\u0004\u0001K\u01e0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0005\u0000V\b\u0000\n\u0000\f\u0000"+
		"Y\t\u0000\u0001\u0000\u0003\u0000\\\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003u\b\u0003\u0001\u0003\u0005"+
		"\u0003x\b\u0003\n\u0003\f\u0003{\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0082\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004\u0086\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u008d\b\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u0091\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u0099\b\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u009d\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00a6\b\u0006\u0003\u0006\u00a8"+
		"\b\u0006\u0001\u0006\u0003\u0006\u00ab\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b9\b\b\u0001\b\u0003\b\u00bc\b\b"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u00c1\b\t\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00c6\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00d2\b\u000b\n\u000b\f\u000b\u00d5\t\u000b\u0003\u000b\u00d7\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00df"+
		"\b\f\u0001\f\u0001\f\u0005\f\u00e3\b\f\n\f\f\f\u00e6\t\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0005\r\u00ed\b\r\n\r\f\r\u00f0\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00fc\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0103\b\u0010"+
		"\n\u0010\f\u0010\u0106\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u010c\b\u0011\n\u0011\f\u0011\u010f\t\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u0117\b\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u011b\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u011f\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u0126\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u012a\b\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u012e"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u0135\b\u0016\n\u0016\f\u0016\u0138\t\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u0141\b\u0017\n\u0017\f\u0017\u0144\t\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u014d"+
		"\b\u0018\n\u0018\f\u0018\u0150\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0156\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u015b\b\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u015f\b"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0164\b\u001b\n"+
		"\u001b\f\u001b\u0167\t\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0005\u001d\u016e\b\u001d\n\u001d\f\u001d\u0171\t\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0176\b\u001e\n\u001e"+
		"\f\u001e\u0179\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f"+
		"\u017e\b\u001f\n\u001f\f\u001f\u0181\t\u001f\u0001 \u0001 \u0001 \u0005"+
		" \u0186\b \n \f \u0189\t \u0001!\u0001!\u0001!\u0005!\u018e\b!\n!\f!\u0191"+
		"\t!\u0001\"\u0001\"\u0001\"\u0005\"\u0196\b\"\n\"\f\"\u0199\t\"\u0001"+
		"#\u0001#\u0001#\u0003#\u019e\b#\u0001$\u0001$\u0001$\u0003$\u01a3\b$\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0003%\u01b1\b%\u0001&\u0001&\u0001&\u0001&\u0005&\u01b7\b&\n"+
		"&\f&\u01ba\t&\u0001&\u0001&\u0001\'\u0001\'\u0003\'\u01c0\b\'\u0001\'"+
		"\u0005\'\u01c3\b\'\n\'\f\'\u01c6\t\'\u0001(\u0003(\u01c9\b(\u0001(\u0003"+
		"(\u01cc\b(\u0001(\u0001(\u0001(\u0001)\u0003)\u01d2\b)\u0001)\u0001)\u0003"+
		")\u01d6\b)\u0001)\u0001)\u0001)\u0003)\u01db\b)\u0001)\u0001)\u0001)\u0001"+
		")\u0000\u0000*\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR\u0000\u0007\u0001"+
		"\u0000BG\u0001\u0000<A\u0002\u0000  \"\"\u0002\u0000\u001b\u001c#$\u0001"+
		"\u0000\u0015\u0016\u0002\u0000\u0017\u0018\u001e\u001e\u0002\u0000\u0004"+
		"\u0004\u0015\u0016\u0205\u0000[\u0001\u0000\u0000\u0000\u0002_\u0001\u0000"+
		"\u0000\u0000\u0004a\u0001\u0000\u0000\u0000\u0006t\u0001\u0000\u0000\u0000"+
		"\b|\u0001\u0000\u0000\u0000\n\u0087\u0001\u0000\u0000\u0000\f\u009e\u0001"+
		"\u0000\u0000\u0000\u000e\u00ac\u0001\u0000\u0000\u0000\u0010\u00b3\u0001"+
		"\u0000\u0000\u0000\u0012\u00bd\u0001\u0000\u0000\u0000\u0014\u00c2\u0001"+
		"\u0000\u0000\u0000\u0016\u00c7\u0001\u0000\u0000\u0000\u0018\u00da\u0001"+
		"\u0000\u0000\u0000\u001a\u00e9\u0001\u0000\u0000\u0000\u001c\u00f1\u0001"+
		"\u0000\u0000\u0000\u001e\u00f4\u0001\u0000\u0000\u0000 \u00fd\u0001\u0000"+
		"\u0000\u0000\"\u0109\u0001\u0000\u0000\u0000$\u0113\u0001\u0000\u0000"+
		"\u0000&\u0125\u0001\u0000\u0000\u0000(\u0129\u0001\u0000\u0000\u0000*"+
		"\u012b\u0001\u0000\u0000\u0000,\u012f\u0001\u0000\u0000\u0000.\u013b\u0001"+
		"\u0000\u0000\u00000\u0147\u0001\u0000\u0000\u00002\u0155\u0001\u0000\u0000"+
		"\u00004\u0157\u0001\u0000\u0000\u00006\u0160\u0001\u0000\u0000\u00008"+
		"\u0168\u0001\u0000\u0000\u0000:\u016a\u0001\u0000\u0000\u0000<\u0172\u0001"+
		"\u0000\u0000\u0000>\u017a\u0001\u0000\u0000\u0000@\u0182\u0001\u0000\u0000"+
		"\u0000B\u018a\u0001\u0000\u0000\u0000D\u0192\u0001\u0000\u0000\u0000F"+
		"\u019d\u0001\u0000\u0000\u0000H\u019f\u0001\u0000\u0000\u0000J\u01b0\u0001"+
		"\u0000\u0000\u0000L\u01b2\u0001\u0000\u0000\u0000N\u01bf\u0001\u0000\u0000"+
		"\u0000P\u01c8\u0001\u0000\u0000\u0000R\u01d1\u0001\u0000\u0000\u0000T"+
		"V\u0003\u0006\u0003\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X\\\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000Z\\\u0003L&\u0000[W\u0001\u0000"+
		"\u0000\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005"+
		"\u0000\u0000\u0001^\u0001\u0001\u0000\u0000\u0000_`\u0007\u0000\u0000"+
		"\u0000`\u0003\u0001\u0000\u0000\u0000ab\u0007\u0001\u0000\u0000b\u0005"+
		"\u0001\u0000\u0000\u0000cu\u0003\f\u0006\u0000du\u0003\u000e\u0007\u0000"+
		"eu\u0003\u0010\b\u0000fu\u0003\b\u0004\u0000gu\u0003\u001e\u000f\u0000"+
		"hu\u0003 \u0010\u0000iu\u0003*\u0015\u0000ju\u0003\u0018\f\u0000ku\u0003"+
		"$\u0012\u0000lu\u0003\u0016\u000b\u0000mu\u0003\u0012\t\u0000nu\u0003"+
		"\u0014\n\u0000ou\u0003\n\u0005\u0000pu\u0003,\u0016\u0000qu\u0003.\u0017"+
		"\u0000ru\u00034\u001a\u0000su\u00038\u001c\u0000tc\u0001\u0000\u0000\u0000"+
		"td\u0001\u0000\u0000\u0000te\u0001\u0000\u0000\u0000tf\u0001\u0000\u0000"+
		"\u0000tg\u0001\u0000\u0000\u0000th\u0001\u0000\u0000\u0000ti\u0001\u0000"+
		"\u0000\u0000tj\u0001\u0000\u0000\u0000tk\u0001\u0000\u0000\u0000tl\u0001"+
		"\u0000\u0000\u0000tm\u0001\u0000\u0000\u0000tn\u0001\u0000\u0000\u0000"+
		"to\u0001\u0000\u0000\u0000tp\u0001\u0000\u0000\u0000tq\u0001\u0000\u0000"+
		"\u0000tr\u0001\u0000\u0000\u0000ts\u0001\u0000\u0000\u0000uy\u0001\u0000"+
		"\u0000\u0000vx\u0005I\u0000\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z\u0007"+
		"\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000|}\u0005H\u0000\u0000"+
		"}~\u0005\u001d\u0000\u0000~\u0085\u0005H\u0000\u0000\u007f\u0081\u0005"+
		"\u0010\u0000\u0000\u0080\u0082\u00036\u001b\u0000\u0081\u0080\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0086\u0005\u0012\u0000\u0000\u0084\u0086\u0005\u0001"+
		"\u0000\u0000\u0085\u007f\u0001\u0000\u0000\u0000\u0085\u0084\u0001\u0000"+
		"\u0000\u0000\u0086\t\u0001\u0000\u0000\u0000\u0087\u0090\u0005H\u0000"+
		"\u0000\u0088\u0089\u0005\u001b\u0000\u0000\u0089\u008c\u0003\u0004\u0002"+
		"\u0000\u008a\u008b\u0005\r\u0000\u0000\u008b\u008d\u0003\u0004\u0002\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u001c\u0000\u0000"+
		"\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u0088\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0005H\u0000\u0000\u0093\u0094\u0005\u000f\u0000\u0000\u0094"+
		"\u0095\u0005.\u0000\u0000\u0095\u009c\u0005H\u0000\u0000\u0096\u0098\u0005"+
		"\u0010\u0000\u0000\u0097\u0099\u00036\u001b\u0000\u0098\u0097\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000"+
		"\u0000\u0000\u009a\u009d\u0005\u0012\u0000\u0000\u009b\u009d\u0005\u0001"+
		"\u0000\u0000\u009c\u0096\u0001\u0000\u0000\u0000\u009c\u009b\u0001\u0000"+
		"\u0000\u0000\u009d\u000b\u0001\u0000\u0000\u0000\u009e\u009f\u0003\u0004"+
		"\u0002\u0000\u009f\u00a7\u0005H\u0000\u0000\u00a0\u00a5\u0005\u000f\u0000"+
		"\u0000\u00a1\u00a6\u0003\u0002\u0001\u0000\u00a2\u00a6\u00030\u0018\u0000"+
		"\u00a3\u00a6\u0003\b\u0004\u0000\u00a4\u00a6\u00038\u001c\u0000\u00a5"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a5\u00a2\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a0\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ab\u0005I\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ab\r\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005"+
		"9\u0000\u0000\u00ad\u00ae\u0003\u0004\u0002\u0000\u00ae\u00af\u0005H\u0000"+
		"\u0000\u00af\u00b0\u0005\u000f\u0000\u0000\u00b0\u00b1\u0003\u0002\u0001"+
		"\u0000\u00b1\u00b2\u0005I\u0000\u0000\u00b2\u000f\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0005H\u0000\u0000\u00b4\u00b8\u0005\u000f\u0000\u0000\u00b5"+
		"\u00b9\u0003\u0002\u0001\u0000\u00b6\u00b9\u0003\b\u0004\u0000\u00b7\u00b9"+
		"\u00038\u001c\u0000\u00b8\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00bb\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bc\u0005I\u0000\u0000\u00bb\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u0011\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0005H\u0000\u0000\u00be\u00c0\u0005\t\u0000"+
		"\u0000\u00bf\u00c1\u0005B\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u0013\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0005H\u0000\u0000\u00c3\u00c5\u0005\n\u0000\u0000\u00c4"+
		"\u00c6\u0005B\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c6\u0015\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0003\u0004\u0002\u0000\u00c8\u00c9\u0005\u000b\u0000\u0000\u00c9\u00ca"+
		"\u0005B\u0000\u0000\u00ca\u00cb\u0005\f\u0000\u0000\u00cb\u00cc\u0005"+
		"H\u0000\u0000\u00cc\u00cd\u0005\u000f\u0000\u0000\u00cd\u00d6\u0005\u000b"+
		"\u0000\u0000\u00ce\u00d3\u0003\u0002\u0001\u0000\u00cf\u00d0\u0005\r\u0000"+
		"\u0000\u00d0\u00d2\u0003\u0002\u0001\u0000\u00d1\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0005\f\u0000\u0000\u00d9\u0017\u0001\u0000\u0000\u0000"+
		"\u00da\u00db\u00050\u0000\u0000\u00db\u00dc\u0005H\u0000\u0000\u00dc\u00de"+
		"\u0005\u0010\u0000\u0000\u00dd\u00df\u0003\u001a\r\u0000\u00de\u00dd\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e0\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e4\u0005\u0012\u0000\u0000\u00e1\u00e3\u0005"+
		"I\u0000\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0003\"\u0011\u0000\u00e8\u0019\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ee\u0003\u001c\u000e\u0000\u00ea\u00eb\u0005\r\u0000\u0000"+
		"\u00eb\u00ed\u0003\u001c\u000e\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u001b\u0001\u0000\u0000\u0000"+
		"\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f2\u0003\u0004\u0002\u0000"+
		"\u00f2\u00f3\u0005H\u0000\u0000\u00f3\u001d\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f5\u00053\u0000\u0000\u00f5\u00f6\u0005\u0010\u0000\u0000\u00f6\u00f7"+
		"\u00038\u001c\u0000\u00f7\u00f8\u0005\u0012\u0000\u0000\u00f8\u00fb\u0003"+
		"\"\u0011\u0000\u00f9\u00fa\u00051\u0000\u0000\u00fa\u00fc\u0003\"\u0011"+
		"\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fc\u001f\u0001\u0000\u0000\u0000\u00fd\u00fe\u00057\u0000\u0000"+
		"\u00fe\u00ff\u0005\u0010\u0000\u0000\u00ff\u0100\u00038\u001c\u0000\u0100"+
		"\u0104\u0005\u0012\u0000\u0000\u0101\u0103\u0005I\u0000\u0000\u0102\u0101"+
		"\u0001\u0000\u0000\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104\u0102"+
		"\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0107"+
		"\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0003\"\u0011\u0000\u0108!\u0001\u0000\u0000\u0000\u0109\u010d\u0005"+
		"\u0011\u0000\u0000\u010a\u010c\u0003\u0006\u0003\u0000\u010b\u010a\u0001"+
		"\u0000\u0000\u0000\u010c\u010f\u0001\u0000\u0000\u0000\u010d\u010b\u0001"+
		"\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u0110\u0001"+
		"\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u0110\u0111\u0005"+
		"I\u0000\u0000\u0111\u0112\u0005\u0013\u0000\u0000\u0112#\u0001\u0000\u0000"+
		"\u0000\u0113\u0114\u00052\u0000\u0000\u0114\u0116\u0005\u0010\u0000\u0000"+
		"\u0115\u0117\u0003&\u0013\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0116"+
		"\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118"+
		"\u011a\u0005\u000e\u0000\u0000\u0119\u011b\u00038\u001c\u0000\u011a\u0119"+
		"\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011c"+
		"\u0001\u0000\u0000\u0000\u011c\u011e\u0005\u000e\u0000\u0000\u011d\u011f"+
		"\u0003(\u0014\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011e\u011f\u0001"+
		"\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0005"+
		"\u0012\u0000\u0000\u0121\u0122\u0003\"\u0011\u0000\u0122%\u0001\u0000"+
		"\u0000\u0000\u0123\u0126\u0003\f\u0006\u0000\u0124\u0126\u0003\u0010\b"+
		"\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0124\u0001\u0000\u0000"+
		"\u0000\u0126\'\u0001\u0000\u0000\u0000\u0127\u012a\u0003\u0012\t\u0000"+
		"\u0128\u012a\u0003\u0014\n\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129"+
		"\u0128\u0001\u0000\u0000\u0000\u012a)\u0001\u0000\u0000\u0000\u012b\u012d"+
		"\u00056\u0000\u0000\u012c\u012e\u00038\u001c\u0000\u012d\u012c\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e+\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u00054\u0000\u0000\u0130\u0131\u0005\u0010\u0000\u0000"+
		"\u0131\u0136\u00032\u0019\u0000\u0132\u0133\u0005\r\u0000\u0000\u0133"+
		"\u0135\u00032\u0019\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135\u0138"+
		"\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0001\u0000\u0000\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u0139\u013a\u0005\u0012\u0000\u0000\u013a-\u0001"+
		"\u0000\u0000\u0000\u013b\u013c\u00055\u0000\u0000\u013c\u013d\u0005\u0010"+
		"\u0000\u0000\u013d\u0142\u00032\u0019\u0000\u013e\u013f\u0005\r\u0000"+
		"\u0000\u013f\u0141\u00032\u0019\u0000\u0140\u013e\u0001\u0000\u0000\u0000"+
		"\u0141\u0144\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000"+
		"\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0145\u0001\u0000\u0000\u0000"+
		"\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0146\u0005\u0012\u0000\u0000"+
		"\u0146/\u0001\u0000\u0000\u0000\u0147\u0148\u0005:\u0000\u0000\u0148\u0149"+
		"\u0005\u0010\u0000\u0000\u0149\u014e\u00032\u0019\u0000\u014a\u014b\u0005"+
		"\r\u0000\u0000\u014b\u014d\u00032\u0019\u0000\u014c\u014a\u0001\u0000"+
		"\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000"+
		"\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u0151\u0001\u0000"+
		"\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0151\u0152\u0005\u0012"+
		"\u0000\u0000\u01521\u0001\u0000\u0000\u0000\u0153\u0156\u0005D\u0000\u0000"+
		"\u0154\u0156\u00038\u001c\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0155"+
		"\u0154\u0001\u0000\u0000\u0000\u01563\u0001\u0000\u0000\u0000\u0157\u015e"+
		"\u00058\u0000\u0000\u0158\u015a\u0005\u0010\u0000\u0000\u0159\u015b\u0005"+
		"B\u0000\u0000\u015a\u0159\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000"+
		"\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u015f\u0005\u0012"+
		"\u0000\u0000\u015d\u015f\u0005\u0001\u0000\u0000\u015e\u0158\u0001\u0000"+
		"\u0000\u0000\u015e\u015d\u0001\u0000\u0000\u0000\u015f5\u0001\u0000\u0000"+
		"\u0000\u0160\u0165\u00038\u001c\u0000\u0161\u0162\u0005\r\u0000\u0000"+
		"\u0162\u0164\u00038\u001c\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0164"+
		"\u0167\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0001\u0000\u0000\u0000\u01667\u0001\u0000\u0000\u0000\u0167\u0165"+
		"\u0001\u0000\u0000\u0000\u0168\u0169\u0003:\u001d\u0000\u01699\u0001\u0000"+
		"\u0000\u0000\u016a\u016f\u0003<\u001e\u0000\u016b\u016c\u0005\u0002\u0000"+
		"\u0000\u016c\u016e\u0003<\u001e\u0000\u016d\u016b\u0001\u0000\u0000\u0000"+
		"\u016e\u0171\u0001\u0000\u0000\u0000\u016f\u016d\u0001\u0000\u0000\u0000"+
		"\u016f\u0170\u0001\u0000\u0000\u0000\u0170;\u0001\u0000\u0000\u0000\u0171"+
		"\u016f\u0001\u0000\u0000\u0000\u0172\u0177\u0003>\u001f\u0000\u0173\u0174"+
		"\u0005\u0003\u0000\u0000\u0174\u0176\u0003>\u001f\u0000\u0175\u0173\u0001"+
		"\u0000\u0000\u0000\u0176\u0179\u0001\u0000\u0000\u0000\u0177\u0175\u0001"+
		"\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178=\u0001\u0000"+
		"\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u017a\u017f\u0003@ \u0000"+
		"\u017b\u017c\u0007\u0002\u0000\u0000\u017c\u017e\u0003@ \u0000\u017d\u017b"+
		"\u0001\u0000\u0000\u0000\u017e\u0181\u0001\u0000\u0000\u0000\u017f\u017d"+
		"\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180?\u0001"+
		"\u0000\u0000\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0182\u0187\u0003"+
		"B!\u0000\u0183\u0184\u0007\u0003\u0000\u0000\u0184\u0186\u0003B!\u0000"+
		"\u0185\u0183\u0001\u0000\u0000\u0000\u0186\u0189\u0001\u0000\u0000\u0000"+
		"\u0187\u0185\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000"+
		"\u0188A\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u018a"+
		"\u018f\u0003D\"\u0000\u018b\u018c\u0007\u0004\u0000\u0000\u018c\u018e"+
		"\u0003D\"\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e\u0191\u0001"+
		"\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f\u0190\u0001"+
		"\u0000\u0000\u0000\u0190C\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000"+
		"\u0000\u0000\u0192\u0197\u0003F#\u0000\u0193\u0194\u0007\u0005\u0000\u0000"+
		"\u0194\u0196\u0003F#\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0196\u0199"+
		"\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0198"+
		"\u0001\u0000\u0000\u0000\u0198E\u0001\u0000\u0000\u0000\u0199\u0197\u0001"+
		"\u0000\u0000\u0000\u019a\u019b\u0007\u0006\u0000\u0000\u019b\u019e\u0003"+
		"F#\u0000\u019c\u019e\u0003H$\u0000\u019d\u019a\u0001\u0000\u0000\u0000"+
		"\u019d\u019c\u0001\u0000\u0000\u0000\u019eG\u0001\u0000\u0000\u0000\u019f"+
		"\u01a2\u0003J%\u0000\u01a0\u01a1\u0005)\u0000\u0000\u01a1\u01a3\u0003"+
		"F#\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a3I\u0001\u0000\u0000\u0000\u01a4\u01b1\u0003\b\u0004\u0000"+
		"\u01a5\u01b1\u0005H\u0000\u0000\u01a6\u01b1\u0005B\u0000\u0000\u01a7\u01b1"+
		"\u0005C\u0000\u0000\u01a8\u01b1\u0005E\u0000\u0000\u01a9\u01b1\u0005D"+
		"\u0000\u0000\u01aa\u01b1\u0005F\u0000\u0000\u01ab\u01b1\u0005G\u0000\u0000"+
		"\u01ac\u01ad\u0005\u0010\u0000\u0000\u01ad\u01ae\u00038\u001c\u0000\u01ae"+
		"\u01af\u0005\u0012\u0000\u0000\u01af\u01b1\u0001\u0000\u0000\u0000\u01b0"+
		"\u01a4\u0001\u0000\u0000\u0000\u01b0\u01a5\u0001\u0000\u0000\u0000\u01b0"+
		"\u01a6\u0001\u0000\u0000\u0000\u01b0\u01a7\u0001\u0000\u0000\u0000\u01b0"+
		"\u01a8\u0001\u0000\u0000\u0000\u01b0\u01a9\u0001\u0000\u0000\u0000\u01b0"+
		"\u01aa\u0001\u0000\u0000\u0000\u01b0\u01ab\u0001\u0000\u0000\u0000\u01b0"+
		"\u01ac\u0001\u0000\u0000\u0000\u01b1K\u0001\u0000\u0000\u0000\u01b2\u01b3"+
		"\u0005\u0005\u0000\u0000\u01b3\u01b4\u0005H\u0000\u0000\u01b4\u01b8\u0005"+
		"\u0011\u0000\u0000\u01b5\u01b7\u0003N\'\u0000\u01b6\u01b5\u0001\u0000"+
		"\u0000\u0000\u01b7\u01ba\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000"+
		"\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01bb\u0001\u0000"+
		"\u0000\u0000\u01ba\u01b8\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005\u0013"+
		"\u0000\u0000\u01bcM\u0001\u0000\u0000\u0000\u01bd\u01c0\u0003P(\u0000"+
		"\u01be\u01c0\u0003R)\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01bf\u01be"+
		"\u0001\u0000\u0000\u0000\u01c0\u01c4\u0001\u0000\u0000\u0000\u01c1\u01c3"+
		"\u0005I\u0000\u0000\u01c2\u01c1\u0001\u0000\u0000\u0000\u01c3\u01c6\u0001"+
		"\u0000\u0000\u0000\u01c4\u01c2\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c5O\u0001\u0000\u0000\u0000\u01c6\u01c4\u0001\u0000"+
		"\u0000\u0000\u01c7\u01c9\u0005\u0006\u0000\u0000\u01c8\u01c7\u0001\u0000"+
		"\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01cb\u0001\u0000"+
		"\u0000\u0000\u01ca\u01cc\u00059\u0000\u0000\u01cb\u01ca\u0001\u0000\u0000"+
		"\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000"+
		"\u0000\u01cd\u01ce\u0003\u0004\u0002\u0000\u01ce\u01cf\u0005H\u0000\u0000"+
		"\u01cfQ\u0001\u0000\u0000\u0000\u01d0\u01d2\u0005\u0007\u0000\u0000\u01d1"+
		"\u01d0\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d5\u0005\b\u0000\u0000\u01d4\u01d6"+
		"\u0003\u0004\u0002\u0000\u01d5\u01d4\u0001\u0000\u0000\u0000\u01d5\u01d6"+
		"\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7\u01d8"+
		"\u0005H\u0000\u0000\u01d8\u01da\u0005\u0010\u0000\u0000\u01d9\u01db\u0003"+
		"\u001a\r\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000"+
		"\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc\u01dd\u0005\u0012"+
		"\u0000\u0000\u01dd\u01de\u0003\"\u0011\u0000\u01deS\u0001\u0000\u0000"+
		"\u00007W[ty\u0081\u0085\u008c\u0090\u0098\u009c\u00a5\u00a7\u00aa\u00b8"+
		"\u00bb\u00c0\u00c5\u00d3\u00d6\u00de\u00e4\u00ee\u00fb\u0104\u010d\u0116"+
		"\u011a\u011e\u0125\u0129\u012d\u0136\u0142\u014e\u0155\u015a\u015e\u0165"+
		"\u016f\u0177\u017f\u0187\u018f\u0197\u019d\u01a2\u01b0\u01b8\u01bf\u01c4"+
		"\u01c8\u01cb\u01d1\u01d5\u01da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}