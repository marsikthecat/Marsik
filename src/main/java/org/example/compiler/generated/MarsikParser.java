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
		MODULE=49, IMPORT=50, ELSE=51, FOR=52, IF=53, PRINT=54, PRINTLN=55, RETURN=56, 
		WHILE=57, EXIT=58, CONST=59, SCAN=60, AR_TYPE=61, INT_TYPE=62, DOUBLE_TYPE=63, 
		CHAR_TYPE=64, BOOL_TYPE=65, STRING_TYPE=66, INTEGER=67, STRING=68, CHAR=69, 
		DOUBLE=70, BOOLEAN=71, NAME=72, NEWLINE=73, COMMENT=74, WS=75;
	public static final int
		RULE_program = 0, RULE_import_decl = 1, RULE_imports = 2, RULE_type = 3, 
		RULE_type_label = 4, RULE_stmt = 5, RULE_method_call = 6, RULE_function_call = 7, 
		RULE_object_stmt = 8, RULE_var_decl = 9, RULE_const_decl = 10, RULE_assign_stmt = 11, 
		RULE_inc_stmt = 12, RULE_dec_stmt = 13, RULE_array_decl = 14, RULE_funcdef = 15, 
		RULE_function_signature = 16, RULE_parameters = 17, RULE_parameter = 18, 
		RULE_if_stmt = 19, RULE_while_stmt = 20, RULE_block = 21, RULE_for_stmt = 22, 
		RULE_for_init = 23, RULE_for_update = 24, RULE_return_stmt = 25, RULE_print_stmt = 26, 
		RULE_println_stmt = 27, RULE_scan_stmt = 28, RULE_print_arg = 29, RULE_exit_stmt = 30, 
		RULE_arguments = 31, RULE_expr = 32, RULE_or_expr = 33, RULE_and_expr = 34, 
		RULE_equality_expr = 35, RULE_relational_expr = 36, RULE_additive_expr = 37, 
		RULE_multiplicative_expr = 38, RULE_unary_expr = 39, RULE_power_expr = 40, 
		RULE_atom_expr = 41, RULE_class_def = 42, RULE_module_def = 43, RULE_class_member = 44, 
		RULE_field_decl = 45, RULE_method_decl = 46, RULE_constructor_decl = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "import_decl", "imports", "type", "type_label", "stmt", "method_call", 
			"function_call", "object_stmt", "var_decl", "const_decl", "assign_stmt", 
			"inc_stmt", "dec_stmt", "array_decl", "funcdef", "function_signature", 
			"parameters", "parameter", "if_stmt", "while_stmt", "block", "for_stmt", 
			"for_init", "for_update", "return_stmt", "print_stmt", "println_stmt", 
			"scan_stmt", "print_arg", "exit_stmt", "arguments", "expr", "or_expr", 
			"and_expr", "equality_expr", "relational_expr", "additive_expr", "multiplicative_expr", 
			"unary_expr", "power_expr", "atom_expr", "class_def", "module_def", "class_member", 
			"field_decl", "method_decl", "constructor_decl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'()'", "'or'", "'and'", "'not'", "'class'", "'public'", "'internal'", 
			"'Constructor'", "'++'", "'--'", "'['", "']'", "','", "';'", "'='", "'('", 
			"'{'", "')'", "'}'", "':'", "'+'", "'-'", "'*'", "'/'", "'|'", "'&'", 
			"'<'", "'>'", "'.'", "'%'", "'`'", "'=='", "'<>'", "'!='", "'<='", "'>='", 
			"'~'", "'^'", "'<<'", "'>>'", "'**'", "'+='", "'-='", "'*='", "'/='", 
			"'new'", "'break'", "'function'", "'module'", "'import'", "'else'", "'for'", 
			"'if'", "'print'", "'printLine'", "'return'", "'while'", "'exit'", "'const'", 
			"'scan'", "'array'", "'int'", "'double'", "'char'", "'boolean'", "'string'"
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
			"MODULE", "IMPORT", "ELSE", "FOR", "IF", "PRINT", "PRINTLN", "RETURN", 
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
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public Module_defContext module_def() {
			return getRuleContext(Module_defContext.class,0);
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
			setState(96);
			imports();
			setState(105);
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
			case INTEGER:
			case STRING:
			case CHAR:
			case DOUBLE:
			case BOOLEAN:
			case NAME:
				{
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3462986638464843760L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 511L) != 0)) {
					{
					{
					setState(97);
					stmt();
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				{
				setState(103);
				class_def();
				}
				break;
			case MODULE:
				{
				setState(104);
				module_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(107);
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
			setState(109);
			match(IMPORT);
			setState(110);
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
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(112);
				import_decl();
				}
				}
				setState(117);
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
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(INTEGER);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(CHAR);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				match(BOOLEAN);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				match(STRING);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				match(DOUBLE);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 6);
				{
				setState(123);
				match(MINUS);
				setState(124);
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
			setState(127);
			_la = _input.LA(1);
			if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & 1055L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(128);
				match(LESS);
				setState(129);
				type_label();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(130);
					match(COMMA);
					setState(131);
					type_label();
					}
				}

				setState(134);
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
		enterRule(_localctx, 10, RULE_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
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
				method_call();
				}
				break;
			case 5:
				{
				setState(142);
				function_call();
				}
				break;
			case 6:
				{
				setState(143);
				if_stmt();
				}
				break;
			case 7:
				{
				setState(144);
				while_stmt();
				}
				break;
			case 8:
				{
				setState(145);
				return_stmt();
				}
				break;
			case 9:
				{
				setState(146);
				funcdef();
				}
				break;
			case 10:
				{
				setState(147);
				for_stmt();
				}
				break;
			case 11:
				{
				setState(148);
				array_decl();
				}
				break;
			case 12:
				{
				setState(149);
				inc_stmt();
				}
				break;
			case 13:
				{
				setState(150);
				dec_stmt();
				}
				break;
			case 14:
				{
				setState(151);
				object_stmt();
				}
				break;
			case 15:
				{
				setState(152);
				print_stmt();
				}
				break;
			case 16:
				{
				setState(153);
				println_stmt();
				}
				break;
			case 17:
				{
				setState(154);
				exit_stmt();
				}
				break;
			case 18:
				{
				setState(155);
				expr();
				}
				break;
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(158);
				match(NEWLINE);
				}
				}
				setState(163);
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
		enterRule(_localctx, 12, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(NAME);
			setState(165);
			match(DOT);
			setState(166);
			match(NAME);
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(167);
				match(LPAR);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6357008L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 63L) != 0)) {
					{
					setState(168);
					arguments();
					}
				}

				setState(171);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(172);
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
	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
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
			setState(175);
			match(NAME);
			setState(176);
			match(LPAR);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6357008L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 63L) != 0)) {
				{
				setState(177);
				arguments();
				}
			}

			setState(180);
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
			setState(182);
			match(NAME);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(183);
				match(LESS);
				setState(184);
				type_label();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(185);
					match(COMMA);
					setState(186);
					type_label();
					}
				}

				setState(189);
				match(GREATER);
				}
			}

			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(193);
				match(NAME);
				}
			}

			setState(196);
			match(EQUAL);
			setState(197);
			match(NEW);
			setState(198);
			match(NAME);
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(199);
				match(LPAR);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6357008L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 63L) != 0)) {
					{
					setState(200);
					arguments();
					}
				}

				setState(203);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(204);
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
		enterRule(_localctx, 18, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			type_label();
			setState(208);
			match(NAME);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(209);
				match(EQUAL);
				setState(214);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(210);
					type();
					}
					break;
				case 2:
					{
					setState(211);
					scan_stmt();
					}
					break;
				case 3:
					{
					setState(212);
					method_call();
					}
					break;
				case 4:
					{
					setState(213);
					expr();
					}
					break;
				}
				}
			}

			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(218);
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
			setState(221);
			match(CONST);
			setState(222);
			type_label();
			setState(223);
			match(NAME);
			setState(224);
			match(EQUAL);
			setState(225);
			type();
			setState(226);
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
		enterRule(_localctx, 22, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(NAME);
			setState(229);
			match(EQUAL);
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(230);
				type();
				}
				break;
			case 2:
				{
				setState(231);
				method_call();
				}
				break;
			case 3:
				{
				setState(232);
				expr();
				}
				break;
			}
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(235);
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
			setState(238);
			match(NAME);
			setState(239);
			match(PLUSPLUS);
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(240);
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
			setState(243);
			match(NAME);
			setState(244);
			match(MINUSMINUS);
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(245);
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
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
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
			setState(248);
			type_label();
			setState(249);
			match(LSQB);
			setState(250);
			match(INTEGER);
			setState(251);
			match(RSQB);
			setState(252);
			match(NAME);
			setState(253);
			match(EQUAL);
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LSQB:
				{
				setState(254);
				match(LSQB);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & 1090715534753793L) != 0)) {
					{
					setState(255);
					type();
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(256);
						match(COMMA);
						setState(257);
						type();
						}
						}
						setState(262);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(265);
				match(RSQB);
				}
				break;
			case NAME:
				{
				setState(266);
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
	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MarsikParser.FUNCTION, 0); }
		public Function_signatureContext function_signature() {
			return getRuleContext(Function_signatureContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 30, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(FUNCTION);
			setState(270);
			function_signature();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(271);
				match(NEWLINE);
				}
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(277);
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
	public static class Function_signatureContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public Type_labelContext type_label() {
			return getRuleContext(Type_labelContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Function_signatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_signature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitFunction_signature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_signatureContext function_signature() throws RecognitionException {
		Function_signatureContext _localctx = new Function_signatureContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_function_signature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(279);
				type_label();
				}
				break;
			}
			setState(282);
			match(NAME);
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(283);
				match(LPAR);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & 1055L) != 0)) {
					{
					setState(284);
					parameters();
					}
				}

				setState(287);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(288);
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
		enterRule(_localctx, 34, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			parameter();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292);
				match(COMMA);
				setState(293);
				parameter();
				}
				}
				setState(298);
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
		enterRule(_localctx, 36, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			type_label();
			setState(300);
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
		enterRule(_localctx, 38, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(IF);
			setState(303);
			match(LPAR);
			setState(304);
			expr();
			setState(305);
			match(RPAR);
			setState(306);
			block();
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(307);
				match(ELSE);
				setState(308);
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
		enterRule(_localctx, 40, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(WHILE);
			setState(312);
			match(LPAR);
			setState(313);
			expr();
			setState(314);
			match(RPAR);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(315);
				match(NEWLINE);
				}
				}
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(321);
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
		enterRule(_localctx, 42, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(LBRACE);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(324);
				match(NEWLINE);
				}
				}
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3462986638464843760L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 511L) != 0)) {
				{
				{
				setState(330);
				stmt();
				}
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(336);
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
		enterRule(_localctx, 44, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(FOR);
			setState(339);
			match(LPAR);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & 1055L) != 0)) {
				{
				setState(340);
				for_init();
				}
			}

			setState(343);
			match(SEMI);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6357008L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 63L) != 0)) {
				{
				setState(344);
				expr();
				}
			}

			setState(347);
			match(SEMI);
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(348);
				for_update();
				}
			}

			setState(351);
			match(RPAR);
			setState(352);
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
		enterRule(_localctx, 46, RULE_for_init);
		try {
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
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
		enterRule(_localctx, 48, RULE_for_update);
		try {
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				inc_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
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
		enterRule(_localctx, 50, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(RETURN);
			setState(364);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(363);
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
		enterRule(_localctx, 52, RULE_print_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(PRINT);
			setState(367);
			match(LPAR);
			setState(368);
			print_arg();
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(369);
				match(COMMA);
				setState(370);
				print_arg();
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(376);
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
		enterRule(_localctx, 54, RULE_println_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(PRINTLN);
			setState(379);
			match(LPAR);
			setState(380);
			print_arg();
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(381);
				match(COMMA);
				setState(382);
				print_arg();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
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
		enterRule(_localctx, 56, RULE_scan_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(SCAN);
			setState(391);
			match(LPAR);
			setState(392);
			print_arg();
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(393);
				match(COMMA);
				setState(394);
				print_arg();
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(400);
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
		enterRule(_localctx, 58, RULE_print_arg);
		try {
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
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
		enterRule(_localctx, 60, RULE_exit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(EXIT);
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(407);
				match(LPAR);
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTEGER) {
					{
					setState(408);
					match(INTEGER);
					}
				}

				setState(411);
				match(RPAR);
				}
				break;
			case T__0:
				{
				setState(412);
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
		enterRule(_localctx, 62, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			expr();
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(416);
				match(COMMA);
				setState(417);
				expr();
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
		enterRule(_localctx, 64, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
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
		enterRule(_localctx, 66, RULE_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			and_expr();
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(426);
				match(T__1);
				setState(427);
				and_expr();
				}
				}
				setState(432);
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
		enterRule(_localctx, 68, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			equality_expr();
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(434);
				match(T__2);
				setState(435);
				equality_expr();
				}
				}
				setState(440);
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
		enterRule(_localctx, 70, RULE_equality_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			relational_expr();
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(442);
				_la = _input.LA(1);
				if ( !(_la==EQEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(443);
				relational_expr();
				}
				}
				setState(448);
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
		enterRule(_localctx, 72, RULE_relational_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			additive_expr();
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103481868288L) != 0)) {
				{
				{
				setState(450);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 103481868288L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(451);
				additive_expr();
				}
				}
				setState(456);
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
		enterRule(_localctx, 74, RULE_additive_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			multiplicative_expr();
			setState(462);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(458);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(459);
					multiplicative_expr();
					}
					} 
				}
				setState(464);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
		enterRule(_localctx, 76, RULE_multiplicative_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			unary_expr();
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1098907648L) != 0)) {
				{
				{
				setState(466);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1098907648L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(467);
				unary_expr();
				}
				}
				setState(472);
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
		enterRule(_localctx, 78, RULE_unary_expr);
		int _la;
		try {
			setState(476);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6291472L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(474);
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
				setState(475);
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
		enterRule(_localctx, 80, RULE_power_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			atom_expr();
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOUBLESTAR) {
				{
				setState(479);
				match(DOUBLESTAR);
				setState(480);
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
		enterRule(_localctx, 82, RULE_atom_expr);
		try {
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(483);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(484);
				function_call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(485);
				match(NAME);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(486);
				match(INTEGER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(487);
				match(CHAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(488);
				match(STRING);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(489);
				match(DOUBLE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(490);
				match(BOOLEAN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(491);
				match(LPAR);
				setState(492);
				expr();
				setState(493);
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
		public List<Function_callContext> function_call() {
			return getRuleContexts(Function_callContext.class);
		}
		public Function_callContext function_call(int i) {
			return getRuleContext(Function_callContext.class,i);
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
		enterRule(_localctx, 84, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(T__4);
			setState(498);
			match(NAME);
			setState(513);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(499);
				match(LBRACE);
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4034943791147253312L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 263L) != 0)) {
					{
					{
					setState(500);
					class_member();
					}
					}
					setState(505);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(506);
				match(RBRACE);
				}
				break;
			case EOF:
			case NAME:
				{
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(507);
					function_call();
					}
					}
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class Module_defContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(MarsikParser.MODULE, 0); }
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LBRACE() { return getToken(MarsikParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MarsikParser.RBRACE, 0); }
		public List<FuncdefContext> funcdef() {
			return getRuleContexts(FuncdefContext.class);
		}
		public FuncdefContext funcdef(int i) {
			return getRuleContext(FuncdefContext.class,i);
		}
		public Module_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitModule_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_defContext module_def() throws RecognitionException {
		Module_defContext _localctx = new Module_defContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_module_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(MODULE);
			setState(516);
			match(NAME);
			setState(517);
			match(LBRACE);
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION) {
				{
				{
				setState(518);
				funcdef();
				}
				}
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(524);
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
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public Constructor_declContext constructor_decl() {
			return getRuleContext(Constructor_declContext.class,0);
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
		enterRule(_localctx, 88, RULE_class_member);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(526);
				field_decl();
				}
				break;
			case 2:
				{
				setState(527);
				method_decl();
				}
				break;
			case 3:
				{
				setState(528);
				funcdef();
				}
				break;
			case 4:
				{
				setState(529);
				constructor_decl();
				}
				break;
			}
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(532);
				match(NEWLINE);
				}
				}
				setState(537);
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
		enterRule(_localctx, 90, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(538);
				match(T__5);
				}
			}

			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(541);
				match(CONST);
				}
			}

			setState(544);
			type_label();
			setState(545);
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
		public Function_signatureContext function_signature() {
			return getRuleContext(Function_signatureContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MarsikParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MarsikParser.NEWLINE, i);
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
		enterRule(_localctx, 92, RULE_method_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(547);
				match(T__6);
				}
			}

			setState(550);
			function_signature();
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(551);
				match(NEWLINE);
				}
				}
				setState(556);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(557);
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
		enterRule(_localctx, 94, RULE_constructor_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(T__7);
			setState(560);
			match(LPAR);
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & 1055L) != 0)) {
				{
				setState(561);
				parameters();
				}
			}

			setState(564);
			match(RPAR);
			setState(565);
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
		"\u0004\u0001K\u0238\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000\u0001\u0000\u0005\u0000"+
		"c\b\u0000\n\u0000\f\u0000f\t\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"j\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0005\u0002r\b\u0002\n\u0002\f\u0002u\t\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003~\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0085\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u0089\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u009d\b\u0005\u0001\u0005\u0005\u0005\u00a0\b"+
		"\u0005\n\u0005\f\u0005\u00a3\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00aa\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u00ae\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00b3\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0003\b\u00bc\b\b\u0001\b\u0001\b\u0003\b\u00c0\b\b\u0001\b\u0003"+
		"\b\u00c3\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ca\b\b"+
		"\u0001\b\u0001\b\u0003\b\u00ce\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00d7\b\t\u0003\t\u00d9\b\t\u0001\t\u0003\t"+
		"\u00dc\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00ea"+
		"\b\u000b\u0001\u000b\u0003\u000b\u00ed\b\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u00f2\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u00f7\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0103\b\u000e\n\u000e"+
		"\f\u000e\u0106\t\u000e\u0003\u000e\u0108\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u010c\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u0111\b\u000f\n\u000f\f\u000f\u0114\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0003\u0010\u0119\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u011e\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0122\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0127\b\u0011\n\u0011"+
		"\f\u0011\u012a\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0136\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u013d\b\u0014\n\u0014\f\u0014\u0140\t\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u0146\b\u0015\n"+
		"\u0015\f\u0015\u0149\t\u0015\u0001\u0015\u0005\u0015\u014c\b\u0015\n\u0015"+
		"\f\u0015\u014f\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u0156\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u015a\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u015e\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u0165"+
		"\b\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u0169\b\u0018\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u016d\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0005\u001a\u0174\b\u001a\n\u001a\f\u001a\u0177"+
		"\t\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u0180\b\u001b\n\u001b\f\u001b\u0183\t\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0005\u001c\u018c\b\u001c\n\u001c\f\u001c\u018f\t\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u0195\b\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u019a\b\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u019e\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u01a3\b\u001f\n\u001f\f\u001f\u01a6\t\u001f\u0001 \u0001 \u0001"+
		"!\u0001!\u0001!\u0005!\u01ad\b!\n!\f!\u01b0\t!\u0001\"\u0001\"\u0001\""+
		"\u0005\"\u01b5\b\"\n\"\f\"\u01b8\t\"\u0001#\u0001#\u0001#\u0005#\u01bd"+
		"\b#\n#\f#\u01c0\t#\u0001$\u0001$\u0001$\u0005$\u01c5\b$\n$\f$\u01c8\t"+
		"$\u0001%\u0001%\u0001%\u0005%\u01cd\b%\n%\f%\u01d0\t%\u0001&\u0001&\u0001"+
		"&\u0005&\u01d5\b&\n&\f&\u01d8\t&\u0001\'\u0001\'\u0001\'\u0003\'\u01dd"+
		"\b\'\u0001(\u0001(\u0001(\u0003(\u01e2\b(\u0001)\u0001)\u0001)\u0001)"+
		"\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u01f0"+
		"\b)\u0001*\u0001*\u0001*\u0001*\u0005*\u01f6\b*\n*\f*\u01f9\t*\u0001*"+
		"\u0001*\u0005*\u01fd\b*\n*\f*\u0200\t*\u0003*\u0202\b*\u0001+\u0001+\u0001"+
		"+\u0001+\u0005+\u0208\b+\n+\f+\u020b\t+\u0001+\u0001+\u0001,\u0001,\u0001"+
		",\u0001,\u0003,\u0213\b,\u0001,\u0005,\u0216\b,\n,\f,\u0219\t,\u0001-"+
		"\u0003-\u021c\b-\u0001-\u0003-\u021f\b-\u0001-\u0001-\u0001-\u0001.\u0003"+
		".\u0225\b.\u0001.\u0001.\u0005.\u0229\b.\n.\f.\u022c\t.\u0001.\u0001."+
		"\u0001/\u0001/\u0001/\u0003/\u0233\b/\u0001/\u0001/\u0001/\u0001/\u0000"+
		"\u00000\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^\u0000\u0007\u0002"+
		"\u0000CCFF\u0002\u0000>BHH\u0002\u0000  \"\"\u0002\u0000\u001b\u001c#"+
		"$\u0001\u0000\u0015\u0016\u0002\u0000\u0017\u0018\u001e\u001e\u0002\u0000"+
		"\u0004\u0004\u0015\u0016\u026c\u0000`\u0001\u0000\u0000\u0000\u0002m\u0001"+
		"\u0000\u0000\u0000\u0004s\u0001\u0000\u0000\u0000\u0006}\u0001\u0000\u0000"+
		"\u0000\b\u007f\u0001\u0000\u0000\u0000\n\u009c\u0001\u0000\u0000\u0000"+
		"\f\u00a4\u0001\u0000\u0000\u0000\u000e\u00af\u0001\u0000\u0000\u0000\u0010"+
		"\u00b6\u0001\u0000\u0000\u0000\u0012\u00cf\u0001\u0000\u0000\u0000\u0014"+
		"\u00dd\u0001\u0000\u0000\u0000\u0016\u00e4\u0001\u0000\u0000\u0000\u0018"+
		"\u00ee\u0001\u0000\u0000\u0000\u001a\u00f3\u0001\u0000\u0000\u0000\u001c"+
		"\u00f8\u0001\u0000\u0000\u0000\u001e\u010d\u0001\u0000\u0000\u0000 \u0118"+
		"\u0001\u0000\u0000\u0000\"\u0123\u0001\u0000\u0000\u0000$\u012b\u0001"+
		"\u0000\u0000\u0000&\u012e\u0001\u0000\u0000\u0000(\u0137\u0001\u0000\u0000"+
		"\u0000*\u0143\u0001\u0000\u0000\u0000,\u0152\u0001\u0000\u0000\u0000."+
		"\u0164\u0001\u0000\u0000\u00000\u0168\u0001\u0000\u0000\u00002\u016a\u0001"+
		"\u0000\u0000\u00004\u016e\u0001\u0000\u0000\u00006\u017a\u0001\u0000\u0000"+
		"\u00008\u0186\u0001\u0000\u0000\u0000:\u0194\u0001\u0000\u0000\u0000<"+
		"\u0196\u0001\u0000\u0000\u0000>\u019f\u0001\u0000\u0000\u0000@\u01a7\u0001"+
		"\u0000\u0000\u0000B\u01a9\u0001\u0000\u0000\u0000D\u01b1\u0001\u0000\u0000"+
		"\u0000F\u01b9\u0001\u0000\u0000\u0000H\u01c1\u0001\u0000\u0000\u0000J"+
		"\u01c9\u0001\u0000\u0000\u0000L\u01d1\u0001\u0000\u0000\u0000N\u01dc\u0001"+
		"\u0000\u0000\u0000P\u01de\u0001\u0000\u0000\u0000R\u01ef\u0001\u0000\u0000"+
		"\u0000T\u01f1\u0001\u0000\u0000\u0000V\u0203\u0001\u0000\u0000\u0000X"+
		"\u0212\u0001\u0000\u0000\u0000Z\u021b\u0001\u0000\u0000\u0000\\\u0224"+
		"\u0001\u0000\u0000\u0000^\u022f\u0001\u0000\u0000\u0000`i\u0003\u0004"+
		"\u0002\u0000ac\u0003\n\u0005\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ej\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gj\u0003T*\u0000hj\u0003V"+
		"+\u0000id\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ih\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0005\u0000\u0000\u0001l\u0001"+
		"\u0001\u0000\u0000\u0000mn\u00052\u0000\u0000no\u0005D\u0000\u0000o\u0003"+
		"\u0001\u0000\u0000\u0000pr\u0003\u0002\u0001\u0000qp\u0001\u0000\u0000"+
		"\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000t\u0005\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"v~\u0005C\u0000\u0000w~\u0005E\u0000\u0000x~\u0005G\u0000\u0000y~\u0005"+
		"D\u0000\u0000z~\u0005F\u0000\u0000{|\u0005\u0016\u0000\u0000|~\u0007\u0000"+
		"\u0000\u0000}v\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000}x\u0001"+
		"\u0000\u0000\u0000}y\u0001\u0000\u0000\u0000}z\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u0007\u0001\u0000\u0000\u0000\u007f\u0088"+
		"\u0007\u0001\u0000\u0000\u0080\u0081\u0005\u001b\u0000\u0000\u0081\u0084"+
		"\u0003\b\u0004\u0000\u0082\u0083\u0005\r\u0000\u0000\u0083\u0085\u0003"+
		"\b\u0004\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u001c"+
		"\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0080\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\t\u0001\u0000\u0000"+
		"\u0000\u008a\u009d\u0003\u0012\t\u0000\u008b\u009d\u0003\u0014\n\u0000"+
		"\u008c\u009d\u0003\u0016\u000b\u0000\u008d\u009d\u0003\f\u0006\u0000\u008e"+
		"\u009d\u0003\u000e\u0007\u0000\u008f\u009d\u0003&\u0013\u0000\u0090\u009d"+
		"\u0003(\u0014\u0000\u0091\u009d\u00032\u0019\u0000\u0092\u009d\u0003\u001e"+
		"\u000f\u0000\u0093\u009d\u0003,\u0016\u0000\u0094\u009d\u0003\u001c\u000e"+
		"\u0000\u0095\u009d\u0003\u0018\f\u0000\u0096\u009d\u0003\u001a\r\u0000"+
		"\u0097\u009d\u0003\u0010\b\u0000\u0098\u009d\u00034\u001a\u0000\u0099"+
		"\u009d\u00036\u001b\u0000\u009a\u009d\u0003<\u001e\u0000\u009b\u009d\u0003"+
		"@ \u0000\u009c\u008a\u0001\u0000\u0000\u0000\u009c\u008b\u0001\u0000\u0000"+
		"\u0000\u009c\u008c\u0001\u0000\u0000\u0000\u009c\u008d\u0001\u0000\u0000"+
		"\u0000\u009c\u008e\u0001\u0000\u0000\u0000\u009c\u008f\u0001\u0000\u0000"+
		"\u0000\u009c\u0090\u0001\u0000\u0000\u0000\u009c\u0091\u0001\u0000\u0000"+
		"\u0000\u009c\u0092\u0001\u0000\u0000\u0000\u009c\u0093\u0001\u0000\u0000"+
		"\u0000\u009c\u0094\u0001\u0000\u0000\u0000\u009c\u0095\u0001\u0000\u0000"+
		"\u0000\u009c\u0096\u0001\u0000\u0000\u0000\u009c\u0097\u0001\u0000\u0000"+
		"\u0000\u009c\u0098\u0001\u0000\u0000\u0000\u009c\u0099\u0001\u0000\u0000"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u00a1\u0001\u0000\u0000\u0000\u009e\u00a0\u0005I\u0000\u0000"+
		"\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2\u000b\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0005H\u0000\u0000\u00a5\u00a6\u0005\u001d\u0000\u0000\u00a6"+
		"\u00ad\u0005H\u0000\u0000\u00a7\u00a9\u0005\u0010\u0000\u0000\u00a8\u00aa"+
		"\u0003>\u001f\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ae\u0005"+
		"\u0012\u0000\u0000\u00ac\u00ae\u0005\u0001\u0000\u0000\u00ad\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\r\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0005H\u0000\u0000\u00b0\u00b2\u0005\u0010\u0000"+
		"\u0000\u00b1\u00b3\u0003>\u001f\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0005\u0012\u0000\u0000\u00b5\u000f\u0001\u0000\u0000\u0000"+
		"\u00b6\u00bf\u0005H\u0000\u0000\u00b7\u00b8\u0005\u001b\u0000\u0000\u00b8"+
		"\u00bb\u0003\b\u0004\u0000\u00b9\u00ba\u0005\r\u0000\u0000\u00ba\u00bc"+
		"\u0003\b\u0004\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0005"+
		"\u001c\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00b7\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c3\u0005H\u0000\u0000\u00c2\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005\u000f\u0000\u0000\u00c5\u00c6\u0005.\u0000"+
		"\u0000\u00c6\u00cd\u0005H\u0000\u0000\u00c7\u00c9\u0005\u0010\u0000\u0000"+
		"\u00c8\u00ca\u0003>\u001f\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00ce\u0005\u0012\u0000\u0000\u00cc\u00ce\u0005\u0001\u0000\u0000\u00cd"+
		"\u00c7\u0001\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce"+
		"\u0011\u0001\u0000\u0000\u0000\u00cf\u00d0\u0003\b\u0004\u0000\u00d0\u00d8"+
		"\u0005H\u0000\u0000\u00d1\u00d6\u0005\u000f\u0000\u0000\u00d2\u00d7\u0003"+
		"\u0006\u0003\u0000\u00d3\u00d7\u00038\u001c\u0000\u00d4\u00d7\u0003\f"+
		"\u0006\u0000\u00d5\u00d7\u0003@ \u0000\u00d6\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d1\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00dc\u0005I\u0000\u0000\u00db"+
		"\u00da\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u0013\u0001\u0000\u0000\u0000\u00dd\u00de\u0005;\u0000\u0000\u00de\u00df"+
		"\u0003\b\u0004\u0000\u00df\u00e0\u0005H\u0000\u0000\u00e0\u00e1\u0005"+
		"\u000f\u0000\u0000\u00e1\u00e2\u0003\u0006\u0003\u0000\u00e2\u00e3\u0005"+
		"I\u0000\u0000\u00e3\u0015\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005H\u0000"+
		"\u0000\u00e5\u00e9\u0005\u000f\u0000\u0000\u00e6\u00ea\u0003\u0006\u0003"+
		"\u0000\u00e7\u00ea\u0003\f\u0006\u0000\u00e8\u00ea\u0003@ \u0000\u00e9"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ea\u00ec\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ed\u0005I\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ed\u0017\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0005H\u0000\u0000\u00ef\u00f1\u0005\t\u0000\u0000\u00f0\u00f2\u0005"+
		"C\u0000\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\u0019\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005H\u0000"+
		"\u0000\u00f4\u00f6\u0005\n\u0000\u0000\u00f5\u00f7\u0005C\u0000\u0000"+
		"\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f7\u001b\u0001\u0000\u0000\u0000\u00f8\u00f9\u0003\b\u0004\u0000\u00f9"+
		"\u00fa\u0005\u000b\u0000\u0000\u00fa\u00fb\u0005C\u0000\u0000\u00fb\u00fc"+
		"\u0005\f\u0000\u0000\u00fc\u00fd\u0005H\u0000\u0000\u00fd\u010b\u0005"+
		"\u000f\u0000\u0000\u00fe\u0107\u0005\u000b\u0000\u0000\u00ff\u0104\u0003"+
		"\u0006\u0003\u0000\u0100\u0101\u0005\r\u0000\u0000\u0101\u0103\u0003\u0006"+
		"\u0003\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0106\u0001\u0000"+
		"\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000"+
		"\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000"+
		"\u0000\u0000\u0107\u00ff\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010c\u0005\f\u0000"+
		"\u0000\u010a\u010c\u0003\f\u0006\u0000\u010b\u00fe\u0001\u0000\u0000\u0000"+
		"\u010b\u010a\u0001\u0000\u0000\u0000\u010c\u001d\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u00050\u0000\u0000\u010e\u0112\u0003 \u0010\u0000\u010f\u0111"+
		"\u0005I\u0000\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0111\u0114\u0001"+
		"\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001"+
		"\u0000\u0000\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u0112\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0003*\u0015\u0000\u0116\u001f\u0001\u0000"+
		"\u0000\u0000\u0117\u0119\u0003\b\u0004\u0000\u0118\u0117\u0001\u0000\u0000"+
		"\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000"+
		"\u0000\u011a\u0121\u0005H\u0000\u0000\u011b\u011d\u0005\u0010\u0000\u0000"+
		"\u011c\u011e\u0003\"\u0011\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f"+
		"\u0122\u0005\u0012\u0000\u0000\u0120\u0122\u0005\u0001\u0000\u0000\u0121"+
		"\u011b\u0001\u0000\u0000\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0122"+
		"!\u0001\u0000\u0000\u0000\u0123\u0128\u0003$\u0012\u0000\u0124\u0125\u0005"+
		"\r\u0000\u0000\u0125\u0127\u0003$\u0012\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129#\u0001\u0000\u0000"+
		"\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012c\u0003\b\u0004\u0000"+
		"\u012c\u012d\u0005H\u0000\u0000\u012d%\u0001\u0000\u0000\u0000\u012e\u012f"+
		"\u00055\u0000\u0000\u012f\u0130\u0005\u0010\u0000\u0000\u0130\u0131\u0003"+
		"@ \u0000\u0131\u0132\u0005\u0012\u0000\u0000\u0132\u0135\u0003*\u0015"+
		"\u0000\u0133\u0134\u00053\u0000\u0000\u0134\u0136\u0003*\u0015\u0000\u0135"+
		"\u0133\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136"+
		"\'\u0001\u0000\u0000\u0000\u0137\u0138\u00059\u0000\u0000\u0138\u0139"+
		"\u0005\u0010\u0000\u0000\u0139\u013a\u0003@ \u0000\u013a\u013e\u0005\u0012"+
		"\u0000\u0000\u013b\u013d\u0005I\u0000\u0000\u013c\u013b\u0001\u0000\u0000"+
		"\u0000\u013d\u0140\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000"+
		"\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0141\u0001\u0000\u0000"+
		"\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0141\u0142\u0003*\u0015\u0000"+
		"\u0142)\u0001\u0000\u0000\u0000\u0143\u0147\u0005\u0011\u0000\u0000\u0144"+
		"\u0146\u0005I\u0000\u0000\u0145\u0144\u0001\u0000\u0000\u0000\u0146\u0149"+
		"\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u0001\u0000\u0000\u0000\u0148\u014d\u0001\u0000\u0000\u0000\u0149\u0147"+
		"\u0001\u0000\u0000\u0000\u014a\u014c\u0003\n\u0005\u0000\u014b\u014a\u0001"+
		"\u0000\u0000\u0000\u014c\u014f\u0001\u0000\u0000\u0000\u014d\u014b\u0001"+
		"\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e\u0150\u0001"+
		"\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0151\u0005"+
		"\u0013\u0000\u0000\u0151+\u0001\u0000\u0000\u0000\u0152\u0153\u00054\u0000"+
		"\u0000\u0153\u0155\u0005\u0010\u0000\u0000\u0154\u0156\u0003.\u0017\u0000"+
		"\u0155\u0154\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0001\u0000\u0000\u0000\u0157\u0159\u0005\u000e\u0000\u0000"+
		"\u0158\u015a\u0003@ \u0000\u0159\u0158\u0001\u0000\u0000\u0000\u0159\u015a"+
		"\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015d"+
		"\u0005\u000e\u0000\u0000\u015c\u015e\u00030\u0018\u0000\u015d\u015c\u0001"+
		"\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u015f\u0001"+
		"\u0000\u0000\u0000\u015f\u0160\u0005\u0012\u0000\u0000\u0160\u0161\u0003"+
		"*\u0015\u0000\u0161-\u0001\u0000\u0000\u0000\u0162\u0165\u0003\u0012\t"+
		"\u0000\u0163\u0165\u0003\u0016\u000b\u0000\u0164\u0162\u0001\u0000\u0000"+
		"\u0000\u0164\u0163\u0001\u0000\u0000\u0000\u0165/\u0001\u0000\u0000\u0000"+
		"\u0166\u0169\u0003\u0018\f\u0000\u0167\u0169\u0003\u001a\r\u0000\u0168"+
		"\u0166\u0001\u0000\u0000\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0169"+
		"1\u0001\u0000\u0000\u0000\u016a\u016c\u00058\u0000\u0000\u016b\u016d\u0003"+
		"@ \u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000"+
		"\u0000\u016d3\u0001\u0000\u0000\u0000\u016e\u016f\u00056\u0000\u0000\u016f"+
		"\u0170\u0005\u0010\u0000\u0000\u0170\u0175\u0003:\u001d\u0000\u0171\u0172"+
		"\u0005\r\u0000\u0000\u0172\u0174\u0003:\u001d\u0000\u0173\u0171\u0001"+
		"\u0000\u0000\u0000\u0174\u0177\u0001\u0000\u0000\u0000\u0175\u0173\u0001"+
		"\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0178\u0001"+
		"\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0178\u0179\u0005"+
		"\u0012\u0000\u0000\u01795\u0001\u0000\u0000\u0000\u017a\u017b\u00057\u0000"+
		"\u0000\u017b\u017c\u0005\u0010\u0000\u0000\u017c\u0181\u0003:\u001d\u0000"+
		"\u017d\u017e\u0005\r\u0000\u0000\u017e\u0180\u0003:\u001d\u0000\u017f"+
		"\u017d\u0001\u0000\u0000\u0000\u0180\u0183\u0001\u0000\u0000\u0000\u0181"+
		"\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182"+
		"\u0184\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0184"+
		"\u0185\u0005\u0012\u0000\u0000\u01857\u0001\u0000\u0000\u0000\u0186\u0187"+
		"\u0005<\u0000\u0000\u0187\u0188\u0005\u0010\u0000\u0000\u0188\u018d\u0003"+
		":\u001d\u0000\u0189\u018a\u0005\r\u0000\u0000\u018a\u018c\u0003:\u001d"+
		"\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018c\u018f\u0001\u0000\u0000"+
		"\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000"+
		"\u0000\u018e\u0190\u0001\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000"+
		"\u0000\u0190\u0191\u0005\u0012\u0000\u0000\u01919\u0001\u0000\u0000\u0000"+
		"\u0192\u0195\u0005D\u0000\u0000\u0193\u0195\u0003@ \u0000\u0194\u0192"+
		"\u0001\u0000\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0195;\u0001"+
		"\u0000\u0000\u0000\u0196\u019d\u0005:\u0000\u0000\u0197\u0199\u0005\u0010"+
		"\u0000\u0000\u0198\u019a\u0005C\u0000\u0000\u0199\u0198\u0001\u0000\u0000"+
		"\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000"+
		"\u0000\u019b\u019e\u0005\u0012\u0000\u0000\u019c\u019e\u0005\u0001\u0000"+
		"\u0000\u019d\u0197\u0001\u0000\u0000\u0000\u019d\u019c\u0001\u0000\u0000"+
		"\u0000\u019e=\u0001\u0000\u0000\u0000\u019f\u01a4\u0003@ \u0000\u01a0"+
		"\u01a1\u0005\r\u0000\u0000\u01a1\u01a3\u0003@ \u0000\u01a2\u01a0\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a6\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5?\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a7\u01a8\u0003B!\u0000"+
		"\u01a8A\u0001\u0000\u0000\u0000\u01a9\u01ae\u0003D\"\u0000\u01aa\u01ab"+
		"\u0005\u0002\u0000\u0000\u01ab\u01ad\u0003D\"\u0000\u01ac\u01aa\u0001"+
		"\u0000\u0000\u0000\u01ad\u01b0\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001"+
		"\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01afC\u0001\u0000"+
		"\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b1\u01b6\u0003F#\u0000"+
		"\u01b2\u01b3\u0005\u0003\u0000\u0000\u01b3\u01b5\u0003F#\u0000\u01b4\u01b2"+
		"\u0001\u0000\u0000\u0000\u01b5\u01b8\u0001\u0000\u0000\u0000\u01b6\u01b4"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7E\u0001"+
		"\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b9\u01be\u0003"+
		"H$\u0000\u01ba\u01bb\u0007\u0002\u0000\u0000\u01bb\u01bd\u0003H$\u0000"+
		"\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bd\u01c0\u0001\u0000\u0000\u0000"+
		"\u01be\u01bc\u0001\u0000\u0000\u0000\u01be\u01bf\u0001\u0000\u0000\u0000"+
		"\u01bfG\u0001\u0000\u0000\u0000\u01c0\u01be\u0001\u0000\u0000\u0000\u01c1"+
		"\u01c6\u0003J%\u0000\u01c2\u01c3\u0007\u0003\u0000\u0000\u01c3\u01c5\u0003"+
		"J%\u0000\u01c4\u01c2\u0001\u0000\u0000\u0000\u01c5\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c4\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000"+
		"\u0000\u01c7I\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001\u0000\u0000\u0000"+
		"\u01c9\u01ce\u0003L&\u0000\u01ca\u01cb\u0007\u0004\u0000\u0000\u01cb\u01cd"+
		"\u0003L&\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000\u01cd\u01d0\u0001\u0000"+
		"\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000"+
		"\u0000\u0000\u01cfK\u0001\u0000\u0000\u0000\u01d0\u01ce\u0001\u0000\u0000"+
		"\u0000\u01d1\u01d6\u0003N\'\u0000\u01d2\u01d3\u0007\u0005\u0000\u0000"+
		"\u01d3\u01d5\u0003N\'\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d8\u0001\u0000\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6"+
		"\u01d7\u0001\u0000\u0000\u0000\u01d7M\u0001\u0000\u0000\u0000\u01d8\u01d6"+
		"\u0001\u0000\u0000\u0000\u01d9\u01da\u0007\u0006\u0000\u0000\u01da\u01dd"+
		"\u0003N\'\u0000\u01db\u01dd\u0003P(\u0000\u01dc\u01d9\u0001\u0000\u0000"+
		"\u0000\u01dc\u01db\u0001\u0000\u0000\u0000\u01ddO\u0001\u0000\u0000\u0000"+
		"\u01de\u01e1\u0003R)\u0000\u01df\u01e0\u0005)\u0000\u0000\u01e0\u01e2"+
		"\u0003N\'\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001"+
		"\u0000\u0000\u0000\u01e2Q\u0001\u0000\u0000\u0000\u01e3\u01f0\u0003\f"+
		"\u0006\u0000\u01e4\u01f0\u0003\u000e\u0007\u0000\u01e5\u01f0\u0005H\u0000"+
		"\u0000\u01e6\u01f0\u0005C\u0000\u0000\u01e7\u01f0\u0005E\u0000\u0000\u01e8"+
		"\u01f0\u0005D\u0000\u0000\u01e9\u01f0\u0005F\u0000\u0000\u01ea\u01f0\u0005"+
		"G\u0000\u0000\u01eb\u01ec\u0005\u0010\u0000\u0000\u01ec\u01ed\u0003@ "+
		"\u0000\u01ed\u01ee\u0005\u0012\u0000\u0000\u01ee\u01f0\u0001\u0000\u0000"+
		"\u0000\u01ef\u01e3\u0001\u0000\u0000\u0000\u01ef\u01e4\u0001\u0000\u0000"+
		"\u0000\u01ef\u01e5\u0001\u0000\u0000\u0000\u01ef\u01e6\u0001\u0000\u0000"+
		"\u0000\u01ef\u01e7\u0001\u0000\u0000\u0000\u01ef\u01e8\u0001\u0000\u0000"+
		"\u0000\u01ef\u01e9\u0001\u0000\u0000\u0000\u01ef\u01ea\u0001\u0000\u0000"+
		"\u0000\u01ef\u01eb\u0001\u0000\u0000\u0000\u01f0S\u0001\u0000\u0000\u0000"+
		"\u01f1\u01f2\u0005\u0005\u0000\u0000\u01f2\u0201\u0005H\u0000\u0000\u01f3"+
		"\u01f7\u0005\u0011\u0000\u0000\u01f4\u01f6\u0003X,\u0000\u01f5\u01f4\u0001"+
		"\u0000\u0000\u0000\u01f6\u01f9\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001"+
		"\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8\u01fa\u0001"+
		"\u0000\u0000\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01fa\u0202\u0005"+
		"\u0013\u0000\u0000\u01fb\u01fd\u0003\u000e\u0007\u0000\u01fc\u01fb\u0001"+
		"\u0000\u0000\u0000\u01fd\u0200\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001"+
		"\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff\u0202\u0001"+
		"\u0000\u0000\u0000\u0200\u01fe\u0001\u0000\u0000\u0000\u0201\u01f3\u0001"+
		"\u0000\u0000\u0000\u0201\u01fe\u0001\u0000\u0000\u0000\u0202U\u0001\u0000"+
		"\u0000\u0000\u0203\u0204\u00051\u0000\u0000\u0204\u0205\u0005H\u0000\u0000"+
		"\u0205\u0209\u0005\u0011\u0000\u0000\u0206\u0208\u0003\u001e\u000f\u0000"+
		"\u0207\u0206\u0001\u0000\u0000\u0000\u0208\u020b\u0001\u0000\u0000\u0000"+
		"\u0209\u0207\u0001\u0000\u0000\u0000\u0209\u020a\u0001\u0000\u0000\u0000"+
		"\u020a\u020c\u0001\u0000\u0000\u0000\u020b\u0209\u0001\u0000\u0000\u0000"+
		"\u020c\u020d\u0005\u0013\u0000\u0000\u020dW\u0001\u0000\u0000\u0000\u020e"+
		"\u0213\u0003Z-\u0000\u020f\u0213\u0003\\.\u0000\u0210\u0213\u0003\u001e"+
		"\u000f\u0000\u0211\u0213\u0003^/\u0000\u0212\u020e\u0001\u0000\u0000\u0000"+
		"\u0212\u020f\u0001\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000"+
		"\u0212\u0211\u0001\u0000\u0000\u0000\u0213\u0217\u0001\u0000\u0000\u0000"+
		"\u0214\u0216\u0005I\u0000\u0000\u0215\u0214\u0001\u0000\u0000\u0000\u0216"+
		"\u0219\u0001\u0000\u0000\u0000\u0217\u0215\u0001\u0000\u0000\u0000\u0217"+
		"\u0218\u0001\u0000\u0000\u0000\u0218Y\u0001\u0000\u0000\u0000\u0219\u0217"+
		"\u0001\u0000\u0000\u0000\u021a\u021c\u0005\u0006\u0000\u0000\u021b\u021a"+
		"\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c\u021e"+
		"\u0001\u0000\u0000\u0000\u021d\u021f\u0005;\u0000\u0000\u021e\u021d\u0001"+
		"\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f\u0220\u0001"+
		"\u0000\u0000\u0000\u0220\u0221\u0003\b\u0004\u0000\u0221\u0222\u0005H"+
		"\u0000\u0000\u0222[\u0001\u0000\u0000\u0000\u0223\u0225\u0005\u0007\u0000"+
		"\u0000\u0224\u0223\u0001\u0000\u0000\u0000\u0224\u0225\u0001\u0000\u0000"+
		"\u0000\u0225\u0226\u0001\u0000\u0000\u0000\u0226\u022a\u0003 \u0010\u0000"+
		"\u0227\u0229\u0005I\u0000\u0000\u0228\u0227\u0001\u0000\u0000\u0000\u0229"+
		"\u022c\u0001\u0000\u0000\u0000\u022a\u0228\u0001\u0000\u0000\u0000\u022a"+
		"\u022b\u0001\u0000\u0000\u0000\u022b\u022d\u0001\u0000\u0000\u0000\u022c"+
		"\u022a\u0001\u0000\u0000\u0000\u022d\u022e\u0003*\u0015\u0000\u022e]\u0001"+
		"\u0000\u0000\u0000\u022f\u0230\u0005\b\u0000\u0000\u0230\u0232\u0005\u0010"+
		"\u0000\u0000\u0231\u0233\u0003\"\u0011\u0000\u0232\u0231\u0001\u0000\u0000"+
		"\u0000\u0232\u0233\u0001\u0000\u0000\u0000\u0233\u0234\u0001\u0000\u0000"+
		"\u0000\u0234\u0235\u0005\u0012\u0000\u0000\u0235\u0236\u0003*\u0015\u0000"+
		"\u0236_\u0001\u0000\u0000\u0000Ddis}\u0084\u0088\u009c\u00a1\u00a9\u00ad"+
		"\u00b2\u00bb\u00bf\u00c2\u00c9\u00cd\u00d6\u00d8\u00db\u00e9\u00ec\u00f1"+
		"\u00f6\u0104\u0107\u010b\u0112\u0118\u011d\u0121\u0128\u0135\u013e\u0147"+
		"\u014d\u0155\u0159\u015d\u0164\u0168\u016c\u0175\u0181\u018d\u0194\u0199"+
		"\u019d\u01a4\u01ae\u01b6\u01be\u01c6\u01ce\u01d6\u01dc\u01e1\u01ef\u01f7"+
		"\u01fe\u0201\u0209\u0212\u0217\u021b\u021e\u0224\u022a\u0232";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}