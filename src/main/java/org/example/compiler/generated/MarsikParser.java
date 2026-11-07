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
		T__0=1, T__1=2, T__2=3, T__3=4, PLUSPLUS=5, MINUSMINUS=6, LSQB=7, RSQB=8, 
		COMMA=9, SEMI=10, EQUAL=11, LPAR=12, LBRACE=13, RPAR=14, RBRACE=15, COLON=16, 
		PLUS=17, MINUS=18, STAR=19, SLASH=20, VBAR=21, AMPER=22, LESS=23, GREATER=24, 
		DOT=25, PERCENT=26, BACKQUOTE=27, EQEQUAL=28, INEQUAL=29, NOTEQUAL=30, 
		LESSEQUAL=31, GREATEREQUAL=32, TILDE=33, CIRCUMFLEX=34, LEFTSHIFT=35, 
		RIGHTSHIFT=36, DOUBLESTAR=37, PLUSEQUAL=38, MINEQUAL=39, STAREQUAL=40, 
		SLASHEQUAL=41, TYPE=42, BREAK=43, FUNCTION=44, IMPORT=45, ELSE=46, FOR=47, 
		IF=48, PRINT=49, PRINTLN=50, RETURN=51, WHILE=52, EXIT=53, CONST=54, SCAN=55, 
		AR_TYPE=56, INT_TYPE=57, DOUBLE_TYPE=58, CHAR_TYPE=59, BOOL_TYPE=60, STRING_TYPE=61, 
		INTEGER=62, STRING=63, CHAR=64, DOUBLE=65, BOOLEAN=66, NAME=67, NEWLINE=68, 
		COMMENT=69, WS=70;
	public static final int
		RULE_program = 0, RULE_import_decl = 1, RULE_imports = 2, RULE_type = 3, 
		RULE_type_label = 4, RULE_custom_type = 5, RULE_stmt = 6, RULE_function_call = 7, 
		RULE_object_stmt = 8, RULE_var_decl = 9, RULE_const_decl = 10, RULE_assign_stmt = 11, 
		RULE_inc_stmt = 12, RULE_dec_stmt = 13, RULE_array_decl = 14, RULE_parameters = 15, 
		RULE_parameter = 16, RULE_if_stmt = 17, RULE_while_stmt = 18, RULE_block = 19, 
		RULE_for_stmt = 20, RULE_for_init = 21, RULE_for_update = 22, RULE_return_stmt = 23, 
		RULE_print_stmt = 24, RULE_println_stmt = 25, RULE_scan_stmt = 26, RULE_print_arg = 27, 
		RULE_exit_stmt = 28, RULE_arguments = 29, RULE_expr = 30, RULE_or_expr = 31, 
		RULE_and_expr = 32, RULE_equality_expr = 33, RULE_relational_expr = 34, 
		RULE_additive_expr = 35, RULE_multiplicative_expr = 36, RULE_unary_expr = 37, 
		RULE_power_expr = 38, RULE_atom_expr = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "import_decl", "imports", "type", "type_label", "custom_type", 
			"stmt", "function_call", "object_stmt", "var_decl", "const_decl", "assign_stmt", 
			"inc_stmt", "dec_stmt", "array_decl", "parameters", "parameter", "if_stmt", 
			"while_stmt", "block", "for_stmt", "for_init", "for_update", "return_stmt", 
			"print_stmt", "println_stmt", "scan_stmt", "print_arg", "exit_stmt", 
			"arguments", "expr", "or_expr", "and_expr", "equality_expr", "relational_expr", 
			"additive_expr", "multiplicative_expr", "unary_expr", "power_expr", "atom_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'()'", "'or'", "'and'", "'not'", "'++'", "'--'", "'['", "']'", 
			"','", "';'", "'='", "'('", "'{'", "')'", "'}'", "':'", "'+'", "'-'", 
			"'*'", "'/'", "'|'", "'&'", "'<'", "'>'", "'.'", "'%'", "'`'", "'=='", 
			"'<>'", "'!='", "'<='", "'>='", "'~'", "'^'", "'<<'", "'>>'", "'**'", 
			"'+='", "'-='", "'*='", "'/='", "'type'", "'break'", "'function'", "'import'", 
			"'else'", "'for'", "'if'", "'print'", "'printLine'", "'return'", "'while'", 
			"'exit'", "'const'", "'scan'", "'array'", "'int'", "'double'", "'char'", 
			"'boolean'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "PLUSPLUS", "MINUSMINUS", "LSQB", "RSQB", 
			"COMMA", "SEMI", "EQUAL", "LPAR", "LBRACE", "RPAR", "RBRACE", "COLON", 
			"PLUS", "MINUS", "STAR", "SLASH", "VBAR", "AMPER", "LESS", "GREATER", 
			"DOT", "PERCENT", "BACKQUOTE", "EQEQUAL", "INEQUAL", "NOTEQUAL", "LESSEQUAL", 
			"GREATEREQUAL", "TILDE", "CIRCUMFLEX", "LEFTSHIFT", "RIGHTSHIFT", "DOUBLESTAR", 
			"PLUSEQUAL", "MINEQUAL", "STAREQUAL", "SLASHEQUAL", "TYPE", "BREAK", 
			"FUNCTION", "IMPORT", "ELSE", "FOR", "IF", "PRINT", "PRINTLN", "RETURN", 
			"WHILE", "EXIT", "CONST", "SCAN", "AR_TYPE", "INT_TYPE", "DOUBLE_TYPE", 
			"CHAR_TYPE", "BOOL_TYPE", "STRING_TYPE", "INTEGER", "STRING", "CHAR", 
			"DOUBLE", "BOOLEAN", "NAME", "NEWLINE", "COMMENT", "WS"
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
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MarsikParser.EOF, 0); }
		public List<Custom_typeContext> custom_type() {
			return getRuleContexts(Custom_typeContext.class);
		}
		public Custom_typeContext custom_type(int i) {
			return getRuleContext(Custom_typeContext.class,i);
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
			setState(80);
			imports();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(81);
				custom_type();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & -6764195534053119L) != 0)) {
				{
				{
				setState(87);
				stmt();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Import_declContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(MarsikParser.IMPORT, 0); }
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public Import_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitImport_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_declContext import_decl() throws RecognitionException {
		Import_declContext _localctx = new Import_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_import_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(IMPORT);
			setState(96);
			match(STRING);
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
	public static class ImportsContext extends ParserRuleContext {
		public List<Import_declContext> import_decl() {
			return getRuleContexts(Import_declContext.class);
		}
		public Import_declContext import_decl(int i) {
			return getRuleContext(Import_declContext.class,i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(98);
				import_decl();
				}
				}
				setState(103);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
		public TerminalNode CHAR() { return getToken(MarsikParser.CHAR, 0); }
		public TerminalNode BOOLEAN() { return getToken(MarsikParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public TerminalNode DOUBLE() { return getToken(MarsikParser.DOUBLE, 0); }
		public TerminalNode MINUS() { return getToken(MarsikParser.MINUS, 0); }
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
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(INTEGER);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(CHAR);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(BOOLEAN);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				match(STRING);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				match(DOUBLE);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				match(MINUS);
				setState(110);
				_la = _input.LA(1);
				if ( !(_la==INTEGER || _la==DOUBLE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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
	public static class Type_labelContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(MarsikParser.INT_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(MarsikParser.DOUBLE_TYPE, 0); }
		public TerminalNode CHAR_TYPE() { return getToken(MarsikParser.CHAR_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(MarsikParser.BOOL_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(MarsikParser.STRING_TYPE, 0); }
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LESS() { return getToken(MarsikParser.LESS, 0); }
		public List<Type_labelContext> type_label() {
			return getRuleContexts(Type_labelContext.class);
		}
		public Type_labelContext type_label(int i) {
			return getRuleContext(Type_labelContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(MarsikParser.GREATER, 0); }
		public TerminalNode COMMA() { return getToken(MarsikParser.COMMA, 0); }
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
		enterRule(_localctx, 8, RULE_type_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !(((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & 1055L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(114);
				match(LESS);
				setState(115);
				type_label();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(116);
					match(COMMA);
					setState(117);
					type_label();
					}
				}

				setState(120);
				match(GREATER);
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
	public static class Custom_typeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(MarsikParser.TYPE, 0); }
		public List<TerminalNode> NAME() { return getTokens(MarsikParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(MarsikParser.NAME, i);
		}
		public TerminalNode LBRACE() { return getToken(MarsikParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MarsikParser.RBRACE, 0); }
		public List<Type_labelContext> type_label() {
			return getRuleContexts(Type_labelContext.class);
		}
		public Type_labelContext type_label(int i) {
			return getRuleContext(Type_labelContext.class,i);
		}
		public List<Object_stmtContext> object_stmt() {
			return getRuleContexts(Object_stmtContext.class);
		}
		public Object_stmtContext object_stmt(int i) {
			return getRuleContext(Object_stmtContext.class,i);
		}
		public Custom_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_custom_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitCustom_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Custom_typeContext custom_type() throws RecognitionException {
		Custom_typeContext _localctx = new Custom_typeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_custom_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(TYPE);
			setState(125);
			match(NAME);
			setState(126);
			match(LBRACE);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & 1055L) != 0)) {
				{
				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(127);
					type_label();
					setState(128);
					match(NAME);
					}
					break;
				case 2:
					{
					setState(130);
					object_stmt();
					}
					break;
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
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
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
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
		enterRule(_localctx, 12, RULE_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(138);
				var_decl();
				}
				break;
			case 2:
				{
				setState(139);
				const_decl();
				}
				break;
			case 3:
				{
				setState(140);
				assign_stmt();
				}
				break;
			case 4:
				{
				setState(141);
				function_call();
				}
				break;
			case 5:
				{
				setState(142);
				if_stmt();
				}
				break;
			case 6:
				{
				setState(143);
				while_stmt();
				}
				break;
			case 7:
				{
				setState(144);
				return_stmt();
				}
				break;
			case 8:
				{
				setState(145);
				for_stmt();
				}
				break;
			case 9:
				{
				setState(146);
				array_decl();
				}
				break;
			case 10:
				{
				setState(147);
				inc_stmt();
				}
				break;
			case 11:
				{
				setState(148);
				dec_stmt();
				}
				break;
			case 12:
				{
				setState(149);
				print_stmt();
				}
				break;
			case 13:
				{
				setState(150);
				println_stmt();
				}
				break;
			case 14:
				{
				setState(151);
				exit_stmt();
				}
				break;
			case 15:
				{
				setState(152);
				expr();
				}
				break;
			}
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(155);
				match(NEWLINE);
				}
				}
				setState(160);
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
	public static class Function_callContext extends ParserRuleContext {
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
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(NAME);
			setState(162);
			match(DOT);
			setState(163);
			match(NAME);
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(164);
				match(LPAR);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & -288230376151686911L) != 0)) {
					{
					setState(165);
					arguments();
					}
				}

				setState(168);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(169);
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
		enterRule(_localctx, 16, RULE_object_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(NAME);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(173);
				match(LESS);
				setState(174);
				type_label();
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(175);
					match(COMMA);
					setState(176);
					type_label();
					}
				}

				setState(179);
				match(GREATER);
				}
			}

			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(183);
				match(NAME);
				}
			}

			setState(186);
			match(EQUAL);
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(187);
				match(LPAR);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & -288230376151686911L) != 0)) {
					{
					setState(188);
					arguments();
					}
				}

				setState(191);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(192);
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
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
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
		enterRule(_localctx, 18, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			type_label();
			setState(196);
			match(NAME);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(197);
				match(EQUAL);
				setState(202);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(198);
					type();
					}
					break;
				case 2:
					{
					setState(199);
					scan_stmt();
					}
					break;
				case 3:
					{
					setState(200);
					function_call();
					}
					break;
				case 4:
					{
					setState(201);
					expr();
					}
					break;
				}
				}
			}

			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(206);
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
		enterRule(_localctx, 20, RULE_const_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(CONST);
			setState(210);
			type_label();
			setState(211);
			match(NAME);
			setState(212);
			match(EQUAL);
			setState(213);
			type();
			setState(214);
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
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
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
		enterRule(_localctx, 22, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(NAME);
			setState(217);
			match(EQUAL);
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(218);
				type();
				}
				break;
			case 2:
				{
				setState(219);
				function_call();
				}
				break;
			case 3:
				{
				setState(220);
				expr();
				}
				break;
			}
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(223);
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
		enterRule(_localctx, 24, RULE_inc_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(NAME);
			setState(227);
			match(PLUSPLUS);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(228);
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
		enterRule(_localctx, 26, RULE_dec_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(NAME);
			setState(232);
			match(MINUSMINUS);
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(233);
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
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
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
		enterRule(_localctx, 28, RULE_array_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			type_label();
			setState(237);
			match(LSQB);
			setState(238);
			match(INTEGER);
			setState(239);
			match(RSQB);
			setState(240);
			match(NAME);
			setState(241);
			match(EQUAL);
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LSQB:
				{
				setState(242);
				match(LSQB);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & 545357767376897L) != 0)) {
					{
					setState(243);
					type();
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(244);
						match(COMMA);
						setState(245);
						type();
						}
						}
						setState(250);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(253);
				match(RSQB);
				}
				break;
			case NAME:
				{
				setState(254);
				function_call();
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
		enterRule(_localctx, 30, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			parameter();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(258);
				match(COMMA);
				setState(259);
				parameter();
				}
				}
				setState(264);
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
		enterRule(_localctx, 32, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			type_label();
			setState(266);
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
		enterRule(_localctx, 34, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(IF);
			setState(269);
			match(LPAR);
			setState(270);
			expr();
			setState(271);
			match(RPAR);
			setState(272);
			block();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(273);
				match(ELSE);
				setState(274);
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
		enterRule(_localctx, 36, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(WHILE);
			setState(278);
			match(LPAR);
			setState(279);
			expr();
			setState(280);
			match(RPAR);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(281);
				match(NEWLINE);
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MarsikParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MarsikParser.RBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(MarsikParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MarsikParser.NEWLINE, i);
		}
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
		enterRule(_localctx, 38, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(LBRACE);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(290);
				match(NEWLINE);
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & -6764195534053119L) != 0)) {
				{
				{
				setState(296);
				stmt();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
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
		enterRule(_localctx, 40, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(FOR);
			setState(305);
			match(LPAR);
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & 1055L) != 0)) {
				{
				setState(306);
				for_init();
				}
			}

			setState(309);
			match(SEMI);
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & -288230376151686911L) != 0)) {
				{
				setState(310);
				expr();
				}
			}

			setState(313);
			match(SEMI);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(314);
				for_update();
				}
			}

			setState(317);
			match(RPAR);
			setState(318);
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
		enterRule(_localctx, 42, RULE_for_init);
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				assign_stmt();
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
		enterRule(_localctx, 44, RULE_for_update);
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				inc_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
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
		enterRule(_localctx, 46, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(RETURN);
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(329);
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
		enterRule(_localctx, 48, RULE_print_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(PRINT);
			setState(333);
			match(LPAR);
			setState(334);
			print_arg();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(335);
				match(COMMA);
				setState(336);
				print_arg();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
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
		enterRule(_localctx, 50, RULE_println_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(PRINTLN);
			setState(345);
			match(LPAR);
			setState(346);
			print_arg();
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(347);
				match(COMMA);
				setState(348);
				print_arg();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354);
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
		enterRule(_localctx, 52, RULE_scan_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(SCAN);
			setState(357);
			match(LPAR);
			setState(358);
			print_arg();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(359);
				match(COMMA);
				setState(360);
				print_arg();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(366);
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
		enterRule(_localctx, 54, RULE_print_arg);
		try {
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
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
		enterRule(_localctx, 56, RULE_exit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(EXIT);
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(373);
				match(LPAR);
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTEGER) {
					{
					setState(374);
					match(INTEGER);
					}
				}

				setState(377);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(378);
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
		enterRule(_localctx, 58, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			expr();
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(382);
				match(COMMA);
				setState(383);
				expr();
				}
				}
				setState(388);
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
		enterRule(_localctx, 60, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
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
			setState(391);
			and_expr();
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(392);
				match(T__1);
				setState(393);
				and_expr();
				}
				}
				setState(398);
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
			setState(399);
			equality_expr();
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(400);
				match(T__2);
				setState(401);
				equality_expr();
				}
				}
				setState(406);
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
			setState(407);
			relational_expr();
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(408);
				_la = _input.LA(1);
				if ( !(_la==EQEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(409);
				relational_expr();
				}
				}
				setState(414);
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
			setState(415);
			additive_expr();
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6467616768L) != 0)) {
				{
				{
				setState(416);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6467616768L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(417);
				additive_expr();
				}
				}
				setState(422);
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
			setState(423);
			multiplicative_expr();
			setState(428);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(424);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(425);
					multiplicative_expr();
					}
					} 
				}
				setState(430);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
			setState(431);
			unary_expr();
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68681728L) != 0)) {
				{
				{
				setState(432);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68681728L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(433);
				unary_expr();
				}
				}
				setState(438);
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
			setState(442);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 393232L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(440);
				unary_expr();
				}
				break;
			case LPAR:
			case INTEGER:
			case STRING:
			case CHAR:
			case DOUBLE:
			case BOOLEAN:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(441);
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
			setState(444);
			atom_expr();
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOUBLESTAR) {
				{
				setState(445);
				match(DOUBLESTAR);
				setState(446);
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
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode INTEGER() { return getToken(MarsikParser.INTEGER, 0); }
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
			setState(460);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(451);
				match(INTEGER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(452);
				match(CHAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(453);
				match(STRING);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(454);
				match(DOUBLE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(455);
				match(BOOLEAN);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(456);
				match(LPAR);
				setState(457);
				expr();
				setState(458);
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

	public static final String _serializedATN =
		"\u0004\u0001F\u01cf\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0001"+
		"\u0000\u0001\u0000\u0005\u0000S\b\u0000\n\u0000\f\u0000V\t\u0000\u0001"+
		"\u0000\u0005\u0000Y\b\u0000\n\u0000\f\u0000\\\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002d\b"+
		"\u0002\n\u0002\f\u0002g\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003p\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004w\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004{\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u0084\b\u0005\n\u0005\f\u0005\u0087\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009a\b\u0006\u0001\u0006"+
		"\u0005\u0006\u009d\b\u0006\n\u0006\f\u0006\u00a0\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a7\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00ab\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00b2\b\b\u0001\b\u0001\b\u0003\b\u00b6\b\b\u0001\b"+
		"\u0003\b\u00b9\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u00be\b\b\u0001\b\u0001"+
		"\b\u0003\b\u00c2\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00cb\b\t\u0003\t\u00cd\b\t\u0001\t\u0003\t\u00d0\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00de\b\u000b\u0001\u000b"+
		"\u0003\u000b\u00e1\b\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u00e6\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00eb\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u00f7\b\u000e\n\u000e\f\u000e\u00fa\t\u000e\u0003"+
		"\u000e\u00fc\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0100\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0105\b\u000f\n\u000f"+
		"\f\u000f\u0108\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0114\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u011b\b\u0012\n\u0012\f\u0012\u011e\t\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0005\u0013\u0124\b\u0013\n"+
		"\u0013\f\u0013\u0127\t\u0013\u0001\u0013\u0005\u0013\u012a\b\u0013\n\u0013"+
		"\f\u0013\u012d\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u0134\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u0138\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u013c\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u0143"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u0147\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u014b\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u0152\b\u0018\n\u0018\f\u0018\u0155"+
		"\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u015e\b\u0019\n\u0019\f\u0019\u0161\t\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0005\u001a\u016a\b\u001a\n\u001a\f\u001a\u016d\t\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u0173\b\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0178\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u017c\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u0181\b\u001d\n\u001d\f\u001d\u0184\t\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u018b\b\u001f\n\u001f"+
		"\f\u001f\u018e\t\u001f\u0001 \u0001 \u0001 \u0005 \u0193\b \n \f \u0196"+
		"\t \u0001!\u0001!\u0001!\u0005!\u019b\b!\n!\f!\u019e\t!\u0001\"\u0001"+
		"\"\u0001\"\u0005\"\u01a3\b\"\n\"\f\"\u01a6\t\"\u0001#\u0001#\u0001#\u0005"+
		"#\u01ab\b#\n#\f#\u01ae\t#\u0001$\u0001$\u0001$\u0005$\u01b3\b$\n$\f$\u01b6"+
		"\t$\u0001%\u0001%\u0001%\u0003%\u01bb\b%\u0001&\u0001&\u0001&\u0003&\u01c0"+
		"\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0003\'\u01cd\b\'\u0001\'\u0000\u0000(\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLN\u0000\u0007\u0002\u0000>>AA\u0002\u00009=CC"+
		"\u0002\u0000\u001c\u001c\u001e\u001e\u0002\u0000\u0017\u0018\u001f \u0001"+
		"\u0000\u0011\u0012\u0002\u0000\u0013\u0014\u001a\u001a\u0002\u0000\u0004"+
		"\u0004\u0011\u0012\u01f6\u0000P\u0001\u0000\u0000\u0000\u0002_\u0001\u0000"+
		"\u0000\u0000\u0004e\u0001\u0000\u0000\u0000\u0006o\u0001\u0000\u0000\u0000"+
		"\bq\u0001\u0000\u0000\u0000\n|\u0001\u0000\u0000\u0000\f\u0099\u0001\u0000"+
		"\u0000\u0000\u000e\u00a1\u0001\u0000\u0000\u0000\u0010\u00ac\u0001\u0000"+
		"\u0000\u0000\u0012\u00c3\u0001\u0000\u0000\u0000\u0014\u00d1\u0001\u0000"+
		"\u0000\u0000\u0016\u00d8\u0001\u0000\u0000\u0000\u0018\u00e2\u0001\u0000"+
		"\u0000\u0000\u001a\u00e7\u0001\u0000\u0000\u0000\u001c\u00ec\u0001\u0000"+
		"\u0000\u0000\u001e\u0101\u0001\u0000\u0000\u0000 \u0109\u0001\u0000\u0000"+
		"\u0000\"\u010c\u0001\u0000\u0000\u0000$\u0115\u0001\u0000\u0000\u0000"+
		"&\u0121\u0001\u0000\u0000\u0000(\u0130\u0001\u0000\u0000\u0000*\u0142"+
		"\u0001\u0000\u0000\u0000,\u0146\u0001\u0000\u0000\u0000.\u0148\u0001\u0000"+
		"\u0000\u00000\u014c\u0001\u0000\u0000\u00002\u0158\u0001\u0000\u0000\u0000"+
		"4\u0164\u0001\u0000\u0000\u00006\u0172\u0001\u0000\u0000\u00008\u0174"+
		"\u0001\u0000\u0000\u0000:\u017d\u0001\u0000\u0000\u0000<\u0185\u0001\u0000"+
		"\u0000\u0000>\u0187\u0001\u0000\u0000\u0000@\u018f\u0001\u0000\u0000\u0000"+
		"B\u0197\u0001\u0000\u0000\u0000D\u019f\u0001\u0000\u0000\u0000F\u01a7"+
		"\u0001\u0000\u0000\u0000H\u01af\u0001\u0000\u0000\u0000J\u01ba\u0001\u0000"+
		"\u0000\u0000L\u01bc\u0001\u0000\u0000\u0000N\u01cc\u0001\u0000\u0000\u0000"+
		"PT\u0003\u0004\u0002\u0000QS\u0003\n\u0005\u0000RQ\u0001\u0000\u0000\u0000"+
		"SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000"+
		"\u0000UZ\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WY\u0003\f\u0006"+
		"\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001"+
		"\u0000\u0000\u0000]^\u0005\u0000\u0000\u0001^\u0001\u0001\u0000\u0000"+
		"\u0000_`\u0005-\u0000\u0000`a\u0005?\u0000\u0000a\u0003\u0001\u0000\u0000"+
		"\u0000bd\u0003\u0002\u0001\u0000cb\u0001\u0000\u0000\u0000dg\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u0005"+
		"\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000hp\u0005>\u0000\u0000"+
		"ip\u0005@\u0000\u0000jp\u0005B\u0000\u0000kp\u0005?\u0000\u0000lp\u0005"+
		"A\u0000\u0000mn\u0005\u0012\u0000\u0000np\u0007\u0000\u0000\u0000oh\u0001"+
		"\u0000\u0000\u0000oi\u0001\u0000\u0000\u0000oj\u0001\u0000\u0000\u0000"+
		"ok\u0001\u0000\u0000\u0000ol\u0001\u0000\u0000\u0000om\u0001\u0000\u0000"+
		"\u0000p\u0007\u0001\u0000\u0000\u0000qz\u0007\u0001\u0000\u0000rs\u0005"+
		"\u0017\u0000\u0000sv\u0003\b\u0004\u0000tu\u0005\t\u0000\u0000uw\u0003"+
		"\b\u0004\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0005\u0018\u0000\u0000y{\u0001\u0000\u0000\u0000"+
		"zr\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\t\u0001\u0000\u0000"+
		"\u0000|}\u0005*\u0000\u0000}~\u0005C\u0000\u0000~\u0085\u0005\r\u0000"+
		"\u0000\u007f\u0080\u0003\b\u0004\u0000\u0080\u0081\u0005C\u0000\u0000"+
		"\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0084\u0003\u0010\b\u0000\u0083"+
		"\u007f\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u000f\u0000\u0000\u0089"+
		"\u000b\u0001\u0000\u0000\u0000\u008a\u009a\u0003\u0012\t\u0000\u008b\u009a"+
		"\u0003\u0014\n\u0000\u008c\u009a\u0003\u0016\u000b\u0000\u008d\u009a\u0003"+
		"\u000e\u0007\u0000\u008e\u009a\u0003\"\u0011\u0000\u008f\u009a\u0003$"+
		"\u0012\u0000\u0090\u009a\u0003.\u0017\u0000\u0091\u009a\u0003(\u0014\u0000"+
		"\u0092\u009a\u0003\u001c\u000e\u0000\u0093\u009a\u0003\u0018\f\u0000\u0094"+
		"\u009a\u0003\u001a\r\u0000\u0095\u009a\u00030\u0018\u0000\u0096\u009a"+
		"\u00032\u0019\u0000\u0097\u009a\u00038\u001c\u0000\u0098\u009a\u0003<"+
		"\u001e\u0000\u0099\u008a\u0001\u0000\u0000\u0000\u0099\u008b\u0001\u0000"+
		"\u0000\u0000\u0099\u008c\u0001\u0000\u0000\u0000\u0099\u008d\u0001\u0000"+
		"\u0000\u0000\u0099\u008e\u0001\u0000\u0000\u0000\u0099\u008f\u0001\u0000"+
		"\u0000\u0000\u0099\u0090\u0001\u0000\u0000\u0000\u0099\u0091\u0001\u0000"+
		"\u0000\u0000\u0099\u0092\u0001\u0000\u0000\u0000\u0099\u0093\u0001\u0000"+
		"\u0000\u0000\u0099\u0094\u0001\u0000\u0000\u0000\u0099\u0095\u0001\u0000"+
		"\u0000\u0000\u0099\u0096\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000"+
		"\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009e\u0001\u0000"+
		"\u0000\u0000\u009b\u009d\u0005D\u0000\u0000\u009c\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\r\u0001\u0000\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005C\u0000\u0000\u00a2"+
		"\u00a3\u0005\u0019\u0000\u0000\u00a3\u00aa\u0005C\u0000\u0000\u00a4\u00a6"+
		"\u0005\f\u0000\u0000\u00a5\u00a7\u0003:\u001d\u0000\u00a6\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00ab\u0005\u000e\u0000\u0000\u00a9\u00ab\u0005"+
		"\u0001\u0000\u0000\u00aa\u00a4\u0001\u0000\u0000\u0000\u00aa\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ab\u000f\u0001\u0000\u0000\u0000\u00ac\u00b5\u0005"+
		"C\u0000\u0000\u00ad\u00ae\u0005\u0017\u0000\u0000\u00ae\u00b1\u0003\b"+
		"\u0004\u0000\u00af\u00b0\u0005\t\u0000\u0000\u00b0\u00b2\u0003\b\u0004"+
		"\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0018\u0000"+
		"\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b9\u0005C\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000"+
		"\u00ba\u00c1\u0005\u000b\u0000\u0000\u00bb\u00bd\u0005\f\u0000\u0000\u00bc"+
		"\u00be\u0003:\u001d\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c2"+
		"\u0005\u000e\u0000\u0000\u00c0\u00c2\u0005\u0001\u0000\u0000\u00c1\u00bb"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u0011"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003\b\u0004\u0000\u00c4\u00cc\u0005"+
		"C\u0000\u0000\u00c5\u00ca\u0005\u000b\u0000\u0000\u00c6\u00cb\u0003\u0006"+
		"\u0003\u0000\u00c7\u00cb\u00034\u001a\u0000\u00c8\u00cb\u0003\u000e\u0007"+
		"\u0000\u00c9\u00cb\u0003<\u001e\u0000\u00ca\u00c6\u0001\u0000\u0000\u0000"+
		"\u00ca\u00c7\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000"+
		"\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cc\u00c5\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce\u00d0\u0005D\u0000\u0000\u00cf"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u0013\u0001\u0000\u0000\u0000\u00d1\u00d2\u00056\u0000\u0000\u00d2\u00d3"+
		"\u0003\b\u0004\u0000\u00d3\u00d4\u0005C\u0000\u0000\u00d4\u00d5\u0005"+
		"\u000b\u0000\u0000\u00d5\u00d6\u0003\u0006\u0003\u0000\u00d6\u00d7\u0005"+
		"D\u0000\u0000\u00d7\u0015\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005C\u0000"+
		"\u0000\u00d9\u00dd\u0005\u000b\u0000\u0000\u00da\u00de\u0003\u0006\u0003"+
		"\u0000\u00db\u00de\u0003\u000e\u0007\u0000\u00dc\u00de\u0003<\u001e\u0000"+
		"\u00dd\u00da\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"+
		"\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000"+
		"\u00df\u00e1\u0005D\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u0017\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0005C\u0000\u0000\u00e3\u00e5\u0005\u0005\u0000\u0000\u00e4\u00e6"+
		"\u0005>\u0000\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e6\u0019\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005"+
		"C\u0000\u0000\u00e8\u00ea\u0005\u0006\u0000\u0000\u00e9\u00eb\u0005>\u0000"+
		"\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000"+
		"\u0000\u00eb\u001b\u0001\u0000\u0000\u0000\u00ec\u00ed\u0003\b\u0004\u0000"+
		"\u00ed\u00ee\u0005\u0007\u0000\u0000\u00ee\u00ef\u0005>\u0000\u0000\u00ef"+
		"\u00f0\u0005\b\u0000\u0000\u00f0\u00f1\u0005C\u0000\u0000\u00f1\u00ff"+
		"\u0005\u000b\u0000\u0000\u00f2\u00fb\u0005\u0007\u0000\u0000\u00f3\u00f8"+
		"\u0003\u0006\u0003\u0000\u00f4\u00f5\u0005\t\u0000\u0000\u00f5\u00f7\u0003"+
		"\u0006\u0003\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001"+
		"\u0000\u0000\u0000\u00fb\u00f3\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u0100\u0005"+
		"\b\u0000\u0000\u00fe\u0100\u0003\u000e\u0007\u0000\u00ff\u00f2\u0001\u0000"+
		"\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100\u001d\u0001\u0000"+
		"\u0000\u0000\u0101\u0106\u0003 \u0010\u0000\u0102\u0103\u0005\t\u0000"+
		"\u0000\u0103\u0105\u0003 \u0010\u0000\u0104\u0102\u0001\u0000\u0000\u0000"+
		"\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u001f\u0001\u0000\u0000\u0000"+
		"\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u010a\u0003\b\u0004\u0000\u010a"+
		"\u010b\u0005C\u0000\u0000\u010b!\u0001\u0000\u0000\u0000\u010c\u010d\u0005"+
		"0\u0000\u0000\u010d\u010e\u0005\f\u0000\u0000\u010e\u010f\u0003<\u001e"+
		"\u0000\u010f\u0110\u0005\u000e\u0000\u0000\u0110\u0113\u0003&\u0013\u0000"+
		"\u0111\u0112\u0005.\u0000\u0000\u0112\u0114\u0003&\u0013\u0000\u0113\u0111"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114#\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u00054\u0000\u0000\u0116\u0117\u0005\f"+
		"\u0000\u0000\u0117\u0118\u0003<\u001e\u0000\u0118\u011c\u0005\u000e\u0000"+
		"\u0000\u0119\u011b\u0005D\u0000\u0000\u011a\u0119\u0001\u0000\u0000\u0000"+
		"\u011b\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000"+
		"\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000"+
		"\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0120\u0003&\u0013\u0000\u0120"+
		"%\u0001\u0000\u0000\u0000\u0121\u0125\u0005\r\u0000\u0000\u0122\u0124"+
		"\u0005D\u0000\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0127\u0001"+
		"\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001"+
		"\u0000\u0000\u0000\u0126\u012b\u0001\u0000\u0000\u0000\u0127\u0125\u0001"+
		"\u0000\u0000\u0000\u0128\u012a\u0003\f\u0006\u0000\u0129\u0128\u0001\u0000"+
		"\u0000\u0000\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012e\u0001\u0000"+
		"\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012e\u012f\u0005\u000f"+
		"\u0000\u0000\u012f\'\u0001\u0000\u0000\u0000\u0130\u0131\u0005/\u0000"+
		"\u0000\u0131\u0133\u0005\f\u0000\u0000\u0132\u0134\u0003*\u0015\u0000"+
		"\u0133\u0132\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0137\u0005\n\u0000\u0000\u0136"+
		"\u0138\u0003<\u001e\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013b"+
		"\u0005\n\u0000\u0000\u013a\u013c\u0003,\u0016\u0000\u013b\u013a\u0001"+
		"\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013d\u0001"+
		"\u0000\u0000\u0000\u013d\u013e\u0005\u000e\u0000\u0000\u013e\u013f\u0003"+
		"&\u0013\u0000\u013f)\u0001\u0000\u0000\u0000\u0140\u0143\u0003\u0012\t"+
		"\u0000\u0141\u0143\u0003\u0016\u000b\u0000\u0142\u0140\u0001\u0000\u0000"+
		"\u0000\u0142\u0141\u0001\u0000\u0000\u0000\u0143+\u0001\u0000\u0000\u0000"+
		"\u0144\u0147\u0003\u0018\f\u0000\u0145\u0147\u0003\u001a\r\u0000\u0146"+
		"\u0144\u0001\u0000\u0000\u0000\u0146\u0145\u0001\u0000\u0000\u0000\u0147"+
		"-\u0001\u0000\u0000\u0000\u0148\u014a\u00053\u0000\u0000\u0149\u014b\u0003"+
		"<\u001e\u0000\u014a\u0149\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000"+
		"\u0000\u0000\u014b/\u0001\u0000\u0000\u0000\u014c\u014d\u00051\u0000\u0000"+
		"\u014d\u014e\u0005\f\u0000\u0000\u014e\u0153\u00036\u001b\u0000\u014f"+
		"\u0150\u0005\t\u0000\u0000\u0150\u0152\u00036\u001b\u0000\u0151\u014f"+
		"\u0001\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153\u0151"+
		"\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0156"+
		"\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156\u0157"+
		"\u0005\u000e\u0000\u0000\u01571\u0001\u0000\u0000\u0000\u0158\u0159\u0005"+
		"2\u0000\u0000\u0159\u015a\u0005\f\u0000\u0000\u015a\u015f\u00036\u001b"+
		"\u0000\u015b\u015c\u0005\t\u0000\u0000\u015c\u015e\u00036\u001b\u0000"+
		"\u015d\u015b\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000\u0000"+
		"\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000"+
		"\u0160\u0162\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000"+
		"\u0162\u0163\u0005\u000e\u0000\u0000\u01633\u0001\u0000\u0000\u0000\u0164"+
		"\u0165\u00057\u0000\u0000\u0165\u0166\u0005\f\u0000\u0000\u0166\u016b"+
		"\u00036\u001b\u0000\u0167\u0168\u0005\t\u0000\u0000\u0168\u016a\u0003"+
		"6\u001b\u0000\u0169\u0167\u0001\u0000\u0000\u0000\u016a\u016d\u0001\u0000"+
		"\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000"+
		"\u0000\u0000\u016c\u016e\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000"+
		"\u0000\u0000\u016e\u016f\u0005\u000e\u0000\u0000\u016f5\u0001\u0000\u0000"+
		"\u0000\u0170\u0173\u0005?\u0000\u0000\u0171\u0173\u0003<\u001e\u0000\u0172"+
		"\u0170\u0001\u0000\u0000\u0000\u0172\u0171\u0001\u0000\u0000\u0000\u0173"+
		"7\u0001\u0000\u0000\u0000\u0174\u017b\u00055\u0000\u0000\u0175\u0177\u0005"+
		"\f\u0000\u0000\u0176\u0178\u0005>\u0000\u0000\u0177\u0176\u0001\u0000"+
		"\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000"+
		"\u0000\u0000\u0179\u017c\u0005\u000e\u0000\u0000\u017a\u017c\u0005\u0001"+
		"\u0000\u0000\u017b\u0175\u0001\u0000\u0000\u0000\u017b\u017a\u0001\u0000"+
		"\u0000\u0000\u017c9\u0001\u0000\u0000\u0000\u017d\u0182\u0003<\u001e\u0000"+
		"\u017e\u017f\u0005\t\u0000\u0000\u017f\u0181\u0003<\u001e\u0000\u0180"+
		"\u017e\u0001\u0000\u0000\u0000\u0181\u0184\u0001\u0000\u0000\u0000\u0182"+
		"\u0180\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183"+
		";\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0185\u0186"+
		"\u0003>\u001f\u0000\u0186=\u0001\u0000\u0000\u0000\u0187\u018c\u0003@"+
		" \u0000\u0188\u0189\u0005\u0002\u0000\u0000\u0189\u018b\u0003@ \u0000"+
		"\u018a\u0188\u0001\u0000\u0000\u0000\u018b\u018e\u0001\u0000\u0000\u0000"+
		"\u018c\u018a\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000"+
		"\u018d?\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018f"+
		"\u0194\u0003B!\u0000\u0190\u0191\u0005\u0003\u0000\u0000\u0191\u0193\u0003"+
		"B!\u0000\u0192\u0190\u0001\u0000\u0000\u0000\u0193\u0196\u0001\u0000\u0000"+
		"\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000"+
		"\u0000\u0195A\u0001\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000"+
		"\u0197\u019c\u0003D\"\u0000\u0198\u0199\u0007\u0002\u0000\u0000\u0199"+
		"\u019b\u0003D\"\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019b\u019e"+
		"\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019c\u019d"+
		"\u0001\u0000\u0000\u0000\u019dC\u0001\u0000\u0000\u0000\u019e\u019c\u0001"+
		"\u0000\u0000\u0000\u019f\u01a4\u0003F#\u0000\u01a0\u01a1\u0007\u0003\u0000"+
		"\u0000\u01a1\u01a3\u0003F#\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a3"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a5\u0001\u0000\u0000\u0000\u01a5E\u0001\u0000\u0000\u0000\u01a6\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a7\u01ac\u0003H$\u0000\u01a8\u01a9\u0007\u0004"+
		"\u0000\u0000\u01a9\u01ab\u0003H$\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000"+
		"\u01ab\u01ae\u0001\u0000\u0000\u0000\u01ac\u01aa\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ad\u0001\u0000\u0000\u0000\u01adG\u0001\u0000\u0000\u0000\u01ae"+
		"\u01ac\u0001\u0000\u0000\u0000\u01af\u01b4\u0003J%\u0000\u01b0\u01b1\u0007"+
		"\u0005\u0000\u0000\u01b1\u01b3\u0003J%\u0000\u01b2\u01b0\u0001\u0000\u0000"+
		"\u0000\u01b3\u01b6\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5I\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b7\u01b8\u0007\u0006\u0000\u0000"+
		"\u01b8\u01bb\u0003J%\u0000\u01b9\u01bb\u0003L&\u0000\u01ba\u01b7\u0001"+
		"\u0000\u0000\u0000\u01ba\u01b9\u0001\u0000\u0000\u0000\u01bbK\u0001\u0000"+
		"\u0000\u0000\u01bc\u01bf\u0003N\'\u0000\u01bd\u01be\u0005%\u0000\u0000"+
		"\u01be\u01c0\u0003J%\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c0"+
		"\u0001\u0000\u0000\u0000\u01c0M\u0001\u0000\u0000\u0000\u01c1\u01cd\u0003"+
		"\u000e\u0007\u0000\u01c2\u01cd\u0005C\u0000\u0000\u01c3\u01cd\u0005>\u0000"+
		"\u0000\u01c4\u01cd\u0005@\u0000\u0000\u01c5\u01cd\u0005?\u0000\u0000\u01c6"+
		"\u01cd\u0005A\u0000\u0000\u01c7\u01cd\u0005B\u0000\u0000\u01c8\u01c9\u0005"+
		"\f\u0000\u0000\u01c9\u01ca\u0003<\u001e\u0000\u01ca\u01cb\u0005\u000e"+
		"\u0000\u0000\u01cb\u01cd\u0001\u0000\u0000\u0000\u01cc\u01c1\u0001\u0000"+
		"\u0000\u0000\u01cc\u01c2\u0001\u0000\u0000\u0000\u01cc\u01c3\u0001\u0000"+
		"\u0000\u0000\u01cc\u01c4\u0001\u0000\u0000\u0000\u01cc\u01c5\u0001\u0000"+
		"\u0000\u0000\u01cc\u01c6\u0001\u0000\u0000\u0000\u01cc\u01c7\u0001\u0000"+
		"\u0000\u0000\u01cc\u01c8\u0001\u0000\u0000\u0000\u01cdO\u0001\u0000\u0000"+
		"\u00006TZeovz\u0083\u0085\u0099\u009e\u00a6\u00aa\u00b1\u00b5\u00b8\u00bd"+
		"\u00c1\u00ca\u00cc\u00cf\u00dd\u00e0\u00e5\u00ea\u00f8\u00fb\u00ff\u0106"+
		"\u0113\u011c\u0125\u012b\u0133\u0137\u013b\u0142\u0146\u014a\u0153\u015f"+
		"\u016b\u0172\u0177\u017b\u0182\u018c\u0194\u019c\u01a4\u01ac\u01b4\u01ba"+
		"\u01bf\u01cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}