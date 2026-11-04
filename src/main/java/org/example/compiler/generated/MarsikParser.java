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
		MINUSMINUS=10, COMMA=11, SEMI=12, EQUAL=13, LPAR=14, RPAR=15, LBRACE=16, 
		RBRACE=17, COLON=18, DOT=19, PLUS=20, MINUS=21, STAR=22, SLASH=23, PERCENT=24, 
		LESS=25, GREATER=26, EQEQUAL=27, NOTEQUAL=28, LESSEQUAL=29, GREATEREQUAL=30, 
		DOUBLESTAR=31, NEW=32, BREAK=33, FUNCTION=34, ELSE=35, FOR=36, IF=37, 
		PRINT=38, PRINTLN=39, RETURN=40, WHILE=41, EXIT=42, CONST=43, SCAN=44, 
		CLASS=45, AND=46, OR=47, NOT=48, NULL_LITERAL=49, BOOL=50, NUMBER=51, 
		STRING=52, NAME=53, NEWLINE=54, COMMENT=55, WS=56;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_block = 2, RULE_var_decl = 3, RULE_const_decl = 4, 
		RULE_assign_stmt = 5, RULE_funcdef = 6, RULE_parameters = 7, RULE_parameter = 8, 
		RULE_if_stmt = 9, RULE_while_stmt = 10, RULE_for_stmt = 11, RULE_for_init = 12, 
		RULE_for_update = 13, RULE_return_stmt = 14, RULE_inc_stmt = 15, RULE_dec_stmt = 16, 
		RULE_print_stmt = 17, RULE_println_stmt = 18, RULE_scan_stmt = 19, RULE_print_arg = 20, 
		RULE_exit_stmt = 21, RULE_method_call = 22, RULE_arguments = 23, RULE_expr = 24, 
		RULE_or_expr = 25, RULE_and_expr = 26, RULE_equality_expr = 27, RULE_relational_expr = 28, 
		RULE_additive_expr = 29, RULE_multiplicative_expr = 30, RULE_unary_expr = 31, 
		RULE_power_expr = 32, RULE_atom = 33, RULE_array_literal = 34, RULE_class_def = 35, 
		RULE_class_member = 36, RULE_field_decl = 37, RULE_method_decl = 38, RULE_constructor_decl = 39, 
		RULE_object_stmt = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "block", "var_decl", "const_decl", "assign_stmt", 
			"funcdef", "parameters", "parameter", "if_stmt", "while_stmt", "for_stmt", 
			"for_init", "for_update", "return_stmt", "inc_stmt", "dec_stmt", "print_stmt", 
			"println_stmt", "scan_stmt", "print_arg", "exit_stmt", "method_call", 
			"arguments", "expr", "or_expr", "and_expr", "equality_expr", "relational_expr", 
			"additive_expr", "multiplicative_expr", "unary_expr", "power_expr", "atom", 
			"array_literal", "class_def", "class_member", "field_decl", "method_decl", 
			"constructor_decl", "object_stmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'()'", "'['", "']'", "'public'", "'private'", "'internal'", "'Method:'", 
			"'Constructor'", "'++'", "'--'", "','", "';'", "'='", "'('", "')'", "'{'", 
			"'}'", "':'", "'.'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'>'", 
			"'=='", "'!='", "'<='", "'>='", "'**'", "'new'", "'break'", "'function'", 
			"'else'", "'for'", "'if'", "'print'", "'printLine'", "'return'", "'while'", 
			"'exit'", "'const'", "'scan'", "'class'", "'and'", "'or'", "'not'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "PLUSPLUS", "MINUSMINUS", 
			"COMMA", "SEMI", "EQUAL", "LPAR", "RPAR", "LBRACE", "RBRACE", "COLON", 
			"DOT", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "LESS", "GREATER", 
			"EQEQUAL", "NOTEQUAL", "LESSEQUAL", "GREATEREQUAL", "DOUBLESTAR", "NEW", 
			"BREAK", "FUNCTION", "ELSE", "FOR", "IF", "PRINT", "PRINTLN", "RETURN", 
			"WHILE", "EXIT", "CONST", "SCAN", "CLASS", "AND", "OR", "NOT", "NULL_LITERAL", 
			"BOOL", "NUMBER", "STRING", "NAME", "NEWLINE", "COMMENT", "WS"
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
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35817639249985540L) != 0)) {
				{
				{
				setState(82);
				stmt();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
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
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public Println_stmtContext println_stmt() {
			return getRuleContext(Println_stmtContext.class,0);
		}
		public Scan_stmtContext scan_stmt() {
			return getRuleContext(Scan_stmtContext.class,0);
		}
		public Exit_stmtContext exit_stmt() {
			return getRuleContext(Exit_stmtContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Object_stmtContext object_stmt() {
			return getRuleContext(Object_stmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(MarsikParser.NEWLINE, 0); }
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
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				const_decl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				assign_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				if_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				while_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				for_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(96);
				return_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(97);
				funcdef();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(98);
				print_stmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(99);
				println_stmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(100);
				scan_stmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(101);
				exit_stmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(102);
				method_call();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(103);
				object_stmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(104);
				expr();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(105);
				class_def();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(106);
				match(NEWLINE);
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
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(LBRACE);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(110);
					match(NEWLINE);
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(116);
					stmt();
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(122);
				match(NEWLINE);
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
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
	public static class Var_declContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public TerminalNode NEWLINE() { return getToken(MarsikParser.NEWLINE, 0); }
		public Scan_stmtContext scan_stmt() {
			return getRuleContext(Scan_stmtContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Object_stmtContext object_stmt() {
			return getRuleContext(Object_stmtContext.class,0);
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
		enterRule(_localctx, 6, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(NAME);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(131);
				match(EQUAL);
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(132);
					scan_stmt();
					}
					break;
				case 2:
					{
					setState(133);
					method_call();
					}
					break;
				case 3:
					{
					setState(134);
					object_stmt();
					}
					break;
				case 4:
					{
					setState(135);
					expr();
					}
					break;
				}
				}
			}

			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(140);
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
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 8, RULE_const_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(CONST);
			setState(144);
			match(NAME);
			setState(145);
			match(EQUAL);
			setState(146);
			expr();
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(147);
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
	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Object_stmtContext object_stmt() {
			return getRuleContext(Object_stmtContext.class,0);
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
		enterRule(_localctx, 10, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(NAME);
			setState(151);
			match(EQUAL);
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(152);
				method_call();
				}
				break;
			case 2:
				{
				setState(153);
				object_stmt();
				}
				break;
			case 3:
				{
				setState(154);
				expr();
				}
				break;
			}
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(157);
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
		enterRule(_localctx, 12, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(FUNCTION);
			setState(161);
			match(NAME);
			setState(162);
			match(LPAR);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(163);
				parameters();
				}
			}

			setState(166);
			match(RPAR);
			setState(167);
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
		enterRule(_localctx, 14, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			parameter();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(170);
				match(COMMA);
				setState(171);
				parameter();
				}
				}
				setState(176);
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
		enterRule(_localctx, 16, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
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
		enterRule(_localctx, 18, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(IF);
			setState(180);
			match(LPAR);
			setState(181);
			expr();
			setState(182);
			match(RPAR);
			setState(183);
			block();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(184);
				match(ELSE);
				setState(185);
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
		enterRule(_localctx, 20, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(WHILE);
			setState(189);
			match(LPAR);
			setState(190);
			expr();
			setState(191);
			match(RPAR);
			setState(192);
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
		enterRule(_localctx, 22, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(FOR);
			setState(195);
			match(LPAR);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(196);
				for_init();
				}
			}

			setState(199);
			match(SEMI);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732923535933444L) != 0)) {
				{
				setState(200);
				expr();
				}
			}

			setState(203);
			match(SEMI);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(204);
				for_update();
				}
			}

			setState(207);
			match(RPAR);
			setState(208);
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
		enterRule(_localctx, 24, RULE_for_init);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
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
		enterRule(_localctx, 26, RULE_for_update);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				inc_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
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
		public TerminalNode NEWLINE() { return getToken(MarsikParser.NEWLINE, 0); }
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
		enterRule(_localctx, 28, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(RETURN);
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(219);
				expr();
				}
				break;
			}
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(222);
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
		public TerminalNode NUMBER() { return getToken(MarsikParser.NUMBER, 0); }
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
		enterRule(_localctx, 30, RULE_inc_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(NAME);
			setState(226);
			match(PLUSPLUS);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(227);
				match(NUMBER);
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
	public static class Dec_stmtContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode MINUSMINUS() { return getToken(MarsikParser.MINUSMINUS, 0); }
		public TerminalNode NUMBER() { return getToken(MarsikParser.NUMBER, 0); }
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
		enterRule(_localctx, 32, RULE_dec_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(NAME);
			setState(231);
			match(MINUSMINUS);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(232);
				match(NUMBER);
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
		enterRule(_localctx, 34, RULE_print_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(PRINT);
			setState(236);
			match(LPAR);
			setState(237);
			print_arg();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(238);
				match(COMMA);
				setState(239);
				print_arg();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245);
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
		enterRule(_localctx, 36, RULE_println_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(PRINTLN);
			setState(248);
			match(LPAR);
			setState(249);
			print_arg();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(250);
				match(COMMA);
				setState(251);
				print_arg();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257);
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
		enterRule(_localctx, 38, RULE_scan_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(SCAN);
			setState(260);
			match(LPAR);
			setState(261);
			print_arg();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(262);
				match(COMMA);
				setState(263);
				print_arg();
				}
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(269);
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
		enterRule(_localctx, 40, RULE_print_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			expr();
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
		public TerminalNode NUMBER() { return getToken(MarsikParser.NUMBER, 0); }
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
		enterRule(_localctx, 42, RULE_exit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(EXIT);
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(274);
				match(LPAR);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(275);
					match(NUMBER);
					}
				}

				setState(278);
				match(RPAR);
				}
				break;
			case 2:
				{
				setState(279);
				match(T__0);
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
	public static class Method_callContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(MarsikParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(MarsikParser.NAME, i);
		}
		public List<TerminalNode> DOT() { return getTokens(MarsikParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MarsikParser.DOT, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(MarsikParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(MarsikParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(MarsikParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(MarsikParser.RPAR, i);
		}
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
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
		enterRule(_localctx, 44, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(NAME);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(283);
				match(DOT);
				setState(284);
				match(NAME);
				setState(290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(285);
					match(LPAR);
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732923535933444L) != 0)) {
						{
						setState(286);
						arguments();
						}
					}

					setState(289);
					match(RPAR);
					}
					break;
				}
				}
				}
				setState(296);
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
		enterRule(_localctx, 46, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			expr();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(298);
				match(COMMA);
				setState(299);
				expr();
				}
				}
				setState(304);
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
		enterRule(_localctx, 48, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
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
		public List<TerminalNode> OR() { return getTokens(MarsikParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MarsikParser.OR, i);
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
		enterRule(_localctx, 50, RULE_or_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			and_expr();
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(308);
					match(OR);
					setState(309);
					and_expr();
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		public List<TerminalNode> AND() { return getTokens(MarsikParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MarsikParser.AND, i);
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
		enterRule(_localctx, 52, RULE_and_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			equality_expr();
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(316);
					match(AND);
					setState(317);
					equality_expr();
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 54, RULE_equality_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			relational_expr();
			setState(328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(324);
					_la = _input.LA(1);
					if ( !(_la==EQEQUAL || _la==NOTEQUAL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(325);
					relational_expr();
					}
					} 
				}
				setState(330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 56, RULE_relational_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			additive_expr();
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(332);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1711276032L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(333);
					additive_expr();
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		enterRule(_localctx, 58, RULE_additive_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			multiplicative_expr();
			setState(344);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(340);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(341);
					multiplicative_expr();
					}
					} 
				}
				setState(346);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 60, RULE_multiplicative_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			unary_expr();
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(348);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360128L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(349);
					unary_expr();
					}
					} 
				}
				setState(354);
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
	public static class Unary_exprContext extends ParserRuleContext {
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(MarsikParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MarsikParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(MarsikParser.NOT, 0); }
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
		enterRule(_localctx, 62, RULE_unary_expr);
		int _la;
		try {
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474979856384L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(356);
				unary_expr();
				}
				break;
			case T__1:
			case LPAR:
			case NULL_LITERAL:
			case BOOL:
			case NUMBER:
			case STRING:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
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
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
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
		enterRule(_localctx, 64, RULE_power_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			atom();
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(361);
				match(DOUBLESTAR);
				setState(362);
				unary_expr();
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
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(MarsikParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(MarsikParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(MarsikParser.BOOL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(MarsikParser.NULL_LITERAL, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(MarsikParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(MarsikParser.RPAR, i);
		}
		public Array_literalContext array_literal() {
			return getRuleContext(Array_literalContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_atom);
		try {
			int _alt;
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				match(STRING);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
				match(BOOL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(368);
				match(NULL_LITERAL);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(369);
				method_call();
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(370);
				match(LPAR);
				setState(371);
				expr();
				setState(375);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(372);
						match(RPAR);
						}
						} 
					}
					setState(377);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 7);
				{
				setState(378);
				array_literal();
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
	public static class Array_literalContext extends ParserRuleContext {
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
		public Array_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MarsikVisitor ) return ((MarsikVisitor<? extends T>)visitor).visitArray_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literalContext array_literal() throws RecognitionException {
		Array_literalContext _localctx = new Array_literalContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_array_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(T__1);
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732923535933444L) != 0)) {
				{
				setState(382);
				expr();
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(383);
					match(COMMA);
					setState(384);
					expr();
					}
					}
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(392);
			match(T__2);
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
		public TerminalNode CLASS() { return getToken(MarsikParser.CLASS, 0); }
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
		enterRule(_localctx, 70, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(CLASS);
			setState(395);
			match(NAME);
			setState(396);
			match(LBRACE);
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9015995347763696L) != 0)) {
				{
				{
				setState(397);
				class_member();
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(403);
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
		enterRule(_localctx, 72, RULE_class_member);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case CONST:
			case NAME:
				{
				setState(405);
				field_decl();
				}
				break;
			case T__5:
			case T__6:
				{
				setState(406);
				method_decl();
				}
				break;
			case T__7:
				{
				setState(407);
				constructor_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(410);
				match(NEWLINE);
				}
				}
				setState(415);
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
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode CONST() { return getToken(MarsikParser.CONST, 0); }
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 74, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3 || _la==T__4) {
				{
				setState(416);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(419);
				match(CONST);
				}
			}

			setState(422);
			match(NAME);
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(423);
				match(EQUAL);
				setState(424);
				expr();
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
	public static class Method_declContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MarsikParser.NAME, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 76, RULE_method_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(427);
				match(T__5);
				}
			}

			setState(430);
			match(T__6);
			setState(431);
			match(NAME);
			setState(432);
			match(LPAR);
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(433);
				parameters();
				}
			}

			setState(436);
			match(RPAR);
			setState(437);
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
		enterRule(_localctx, 78, RULE_constructor_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(T__7);
			setState(440);
			match(LPAR);
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(441);
				parameters();
				}
			}

			setState(444);
			match(RPAR);
			setState(445);
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
	public static class Object_stmtContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(MarsikParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(MarsikParser.NAME, i);
		}
		public TerminalNode EQUAL() { return getToken(MarsikParser.EQUAL, 0); }
		public TerminalNode NEW() { return getToken(MarsikParser.NEW, 0); }
		public TerminalNode LPAR() { return getToken(MarsikParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(MarsikParser.RPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
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
		enterRule(_localctx, 80, RULE_object_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(NAME);
			setState(448);
			match(EQUAL);
			setState(449);
			match(NEW);
			setState(450);
			match(NAME);
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(451);
				match(LPAR);
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17732923535933444L) != 0)) {
					{
					setState(452);
					arguments();
					}
				}

				setState(455);
				match(RPAR);
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

	public static final String _serializedATN =
		"\u0004\u00018\u01cb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0001\u0000\u0005\u0000T\b\u0000\n\u0000\f\u0000W\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001l\b\u0001\u0001\u0002\u0001\u0002\u0005\u0002p\b\u0002"+
		"\n\u0002\f\u0002s\t\u0002\u0001\u0002\u0005\u0002v\b\u0002\n\u0002\f\u0002"+
		"y\t\u0002\u0001\u0002\u0005\u0002|\b\u0002\n\u0002\f\u0002\u007f\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u0089\b\u0003\u0003\u0003\u008b\b"+
		"\u0003\u0001\u0003\u0003\u0003\u008e\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0095\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u009c\b\u0005\u0001"+
		"\u0005\u0003\u0005\u009f\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00a5\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00ad\b\u0007\n\u0007\f\u0007"+
		"\u00b0\t\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0003\t\u00bb\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c6\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00ca\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00ce\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0003\f\u00d5\b\f\u0001\r\u0001\r\u0003\r\u00d9\b\r\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00dd\b\u000e\u0001\u000e\u0003\u000e\u00e0\b"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e5\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ea\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00f1\b\u0011\n"+
		"\u0011\f\u0011\u00f4\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00fd\b\u0012\n"+
		"\u0012\f\u0012\u0100\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0109\b\u0013\n"+
		"\u0013\f\u0013\u010c\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0115\b\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0119\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0120\b\u0016\u0001\u0016\u0003"+
		"\u0016\u0123\b\u0016\u0005\u0016\u0125\b\u0016\n\u0016\f\u0016\u0128\t"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u012d\b\u0017\n"+
		"\u0017\f\u0017\u0130\t\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u0137\b\u0019\n\u0019\f\u0019\u013a\t\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u013f\b\u001a\n\u001a"+
		"\f\u001a\u0142\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b"+
		"\u0147\b\u001b\n\u001b\f\u001b\u014a\t\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u014f\b\u001c\n\u001c\f\u001c\u0152\t\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0005\u001d\u0157\b\u001d\n\u001d\f\u001d\u015a"+
		"\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u015f\b\u001e"+
		"\n\u001e\f\u001e\u0162\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0003"+
		"\u001f\u0167\b\u001f\u0001 \u0001 \u0001 \u0003 \u016c\b \u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0005!\u0176\b!\n!\f!\u0179"+
		"\t!\u0001!\u0003!\u017c\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0005\"\u0182"+
		"\b\"\n\"\f\"\u0185\t\"\u0003\"\u0187\b\"\u0001\"\u0001\"\u0001#\u0001"+
		"#\u0001#\u0001#\u0005#\u018f\b#\n#\f#\u0192\t#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0003$\u0199\b$\u0001$\u0005$\u019c\b$\n$\f$\u019f\t$\u0001%"+
		"\u0003%\u01a2\b%\u0001%\u0003%\u01a5\b%\u0001%\u0001%\u0001%\u0003%\u01aa"+
		"\b%\u0001&\u0003&\u01ad\b&\u0001&\u0001&\u0001&\u0001&\u0003&\u01b3\b"+
		"&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0003\'\u01bb\b\'\u0001"+
		"\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u01c6"+
		"\b(\u0001(\u0003(\u01c9\b(\u0001(\u0000\u0000)\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNP\u0000\u0006\u0001\u0000\u001b\u001c\u0002\u0000\u0019"+
		"\u001a\u001d\u001e\u0001\u0000\u0014\u0015\u0001\u0000\u0016\u0018\u0002"+
		"\u0000\u0014\u001500\u0001\u0000\u0004\u0005\u01f1\u0000U\u0001\u0000"+
		"\u0000\u0000\u0002k\u0001\u0000\u0000\u0000\u0004m\u0001\u0000\u0000\u0000"+
		"\u0006\u0082\u0001\u0000\u0000\u0000\b\u008f\u0001\u0000\u0000\u0000\n"+
		"\u0096\u0001\u0000\u0000\u0000\f\u00a0\u0001\u0000\u0000\u0000\u000e\u00a9"+
		"\u0001\u0000\u0000\u0000\u0010\u00b1\u0001\u0000\u0000\u0000\u0012\u00b3"+
		"\u0001\u0000\u0000\u0000\u0014\u00bc\u0001\u0000\u0000\u0000\u0016\u00c2"+
		"\u0001\u0000\u0000\u0000\u0018\u00d4\u0001\u0000\u0000\u0000\u001a\u00d8"+
		"\u0001\u0000\u0000\u0000\u001c\u00da\u0001\u0000\u0000\u0000\u001e\u00e1"+
		"\u0001\u0000\u0000\u0000 \u00e6\u0001\u0000\u0000\u0000\"\u00eb\u0001"+
		"\u0000\u0000\u0000$\u00f7\u0001\u0000\u0000\u0000&\u0103\u0001\u0000\u0000"+
		"\u0000(\u010f\u0001\u0000\u0000\u0000*\u0111\u0001\u0000\u0000\u0000,"+
		"\u011a\u0001\u0000\u0000\u0000.\u0129\u0001\u0000\u0000\u00000\u0131\u0001"+
		"\u0000\u0000\u00002\u0133\u0001\u0000\u0000\u00004\u013b\u0001\u0000\u0000"+
		"\u00006\u0143\u0001\u0000\u0000\u00008\u014b\u0001\u0000\u0000\u0000:"+
		"\u0153\u0001\u0000\u0000\u0000<\u015b\u0001\u0000\u0000\u0000>\u0166\u0001"+
		"\u0000\u0000\u0000@\u0168\u0001\u0000\u0000\u0000B\u017b\u0001\u0000\u0000"+
		"\u0000D\u017d\u0001\u0000\u0000\u0000F\u018a\u0001\u0000\u0000\u0000H"+
		"\u0198\u0001\u0000\u0000\u0000J\u01a1\u0001\u0000\u0000\u0000L\u01ac\u0001"+
		"\u0000\u0000\u0000N\u01b7\u0001\u0000\u0000\u0000P\u01bf\u0001\u0000\u0000"+
		"\u0000RT\u0003\u0002\u0001\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000"+
		"\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0005\u0000\u0000\u0001"+
		"Y\u0001\u0001\u0000\u0000\u0000Zl\u0003\u0006\u0003\u0000[l\u0003\b\u0004"+
		"\u0000\\l\u0003\n\u0005\u0000]l\u0003\u0012\t\u0000^l\u0003\u0014\n\u0000"+
		"_l\u0003\u0016\u000b\u0000`l\u0003\u001c\u000e\u0000al\u0003\f\u0006\u0000"+
		"bl\u0003\"\u0011\u0000cl\u0003$\u0012\u0000dl\u0003&\u0013\u0000el\u0003"+
		"*\u0015\u0000fl\u0003,\u0016\u0000gl\u0003P(\u0000hl\u00030\u0018\u0000"+
		"il\u0003F#\u0000jl\u00056\u0000\u0000kZ\u0001\u0000\u0000\u0000k[\u0001"+
		"\u0000\u0000\u0000k\\\u0001\u0000\u0000\u0000k]\u0001\u0000\u0000\u0000"+
		"k^\u0001\u0000\u0000\u0000k_\u0001\u0000\u0000\u0000k`\u0001\u0000\u0000"+
		"\u0000ka\u0001\u0000\u0000\u0000kb\u0001\u0000\u0000\u0000kc\u0001\u0000"+
		"\u0000\u0000kd\u0001\u0000\u0000\u0000ke\u0001\u0000\u0000\u0000kf\u0001"+
		"\u0000\u0000\u0000kg\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000l\u0003\u0001\u0000"+
		"\u0000\u0000mq\u0005\u0010\u0000\u0000np\u00056\u0000\u0000on\u0001\u0000"+
		"\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rw\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000"+
		"tv\u0003\u0002\u0001\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x}\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000z|\u00056\u0000\u0000{z\u0001\u0000"+
		"\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0005\u0011\u0000\u0000\u0081\u0005\u0001"+
		"\u0000\u0000\u0000\u0082\u008a\u00055\u0000\u0000\u0083\u0088\u0005\r"+
		"\u0000\u0000\u0084\u0089\u0003&\u0013\u0000\u0085\u0089\u0003,\u0016\u0000"+
		"\u0086\u0089\u0003P(\u0000\u0087\u0089\u00030\u0018\u0000\u0088\u0084"+
		"\u0001\u0000\u0000\u0000\u0088\u0085\u0001\u0000\u0000\u0000\u0088\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008b"+
		"\u0001\u0000\u0000\u0000\u008a\u0083\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c\u008e"+
		"\u00056\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008e\u0007\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		"+\u0000\u0000\u0090\u0091\u00055\u0000\u0000\u0091\u0092\u0005\r\u0000"+
		"\u0000\u0092\u0094\u00030\u0018\u0000\u0093\u0095\u00056\u0000\u0000\u0094"+
		"\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\t\u0001\u0000\u0000\u0000\u0096\u0097\u00055\u0000\u0000\u0097\u009b"+
		"\u0005\r\u0000\u0000\u0098\u009c\u0003,\u0016\u0000\u0099\u009c\u0003"+
		"P(\u0000\u009a\u009c\u00030\u0018\u0000\u009b\u0098\u0001\u0000\u0000"+
		"\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009d\u009f\u00056\u0000\u0000"+
		"\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u000b\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\"\u0000\u0000\u00a1"+
		"\u00a2\u00055\u0000\u0000\u00a2\u00a4\u0005\u000e\u0000\u0000\u00a3\u00a5"+
		"\u0003\u000e\u0007\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0005\u000f\u0000\u0000\u00a7\u00a8\u0003\u0004\u0002\u0000\u00a8\r\u0001"+
		"\u0000\u0000\u0000\u00a9\u00ae\u0003\u0010\b\u0000\u00aa\u00ab\u0005\u000b"+
		"\u0000\u0000\u00ab\u00ad\u0003\u0010\b\u0000\u00ac\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u000f\u0001\u0000\u0000"+
		"\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b2\u00055\u0000\u0000"+
		"\u00b2\u0011\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005%\u0000\u0000\u00b4"+
		"\u00b5\u0005\u000e\u0000\u0000\u00b5\u00b6\u00030\u0018\u0000\u00b6\u00b7"+
		"\u0005\u000f\u0000\u0000\u00b7\u00ba\u0003\u0004\u0002\u0000\u00b8\u00b9"+
		"\u0005#\u0000\u0000\u00b9\u00bb\u0003\u0004\u0002\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u0013\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0005)\u0000\u0000\u00bd\u00be\u0005\u000e"+
		"\u0000\u0000\u00be\u00bf\u00030\u0018\u0000\u00bf\u00c0\u0005\u000f\u0000"+
		"\u0000\u00c0\u00c1\u0003\u0004\u0002\u0000\u00c1\u0015\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0005$\u0000\u0000\u00c3\u00c5\u0005\u000e\u0000\u0000"+
		"\u00c4\u00c6\u0003\u0018\f\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c9\u0005\f\u0000\u0000\u00c8\u00ca\u00030\u0018\u0000\u00c9\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cd\u0005\f\u0000\u0000\u00cc\u00ce\u0003"+
		"\u001a\r\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u000f"+
		"\u0000\u0000\u00d0\u00d1\u0003\u0004\u0002\u0000\u00d1\u0017\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d5\u0003\u0006\u0003\u0000\u00d3\u00d5\u0003\n\u0005"+
		"\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d5\u0019\u0001\u0000\u0000\u0000\u00d6\u00d9\u0003\u001e\u000f"+
		"\u0000\u00d7\u00d9\u0003 \u0010\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9\u001b\u0001\u0000\u0000\u0000"+
		"\u00da\u00dc\u0005(\u0000\u0000\u00db\u00dd\u00030\u0018\u0000\u00dc\u00db"+
		"\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00df"+
		"\u0001\u0000\u0000\u0000\u00de\u00e0\u00056\u0000\u0000\u00df\u00de\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u001d\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e2\u00055\u0000\u0000\u00e2\u00e4\u0005\t"+
		"\u0000\u0000\u00e3\u00e5\u00053\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u001f\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u00055\u0000\u0000\u00e7\u00e9\u0005\n\u0000\u0000"+
		"\u00e8\u00ea\u00053\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ea!\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0005&\u0000\u0000\u00ec\u00ed\u0005\u000e\u0000\u0000\u00ed\u00f2\u0003"+
		"(\u0014\u0000\u00ee\u00ef\u0005\u000b\u0000\u0000\u00ef\u00f1\u0003(\u0014"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f5\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0005\u000f\u0000\u0000\u00f6#\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0005\'\u0000\u0000\u00f8\u00f9\u0005\u000e\u0000\u0000\u00f9"+
		"\u00fe\u0003(\u0014\u0000\u00fa\u00fb\u0005\u000b\u0000\u0000\u00fb\u00fd"+
		"\u0003(\u0014\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fd\u0100\u0001"+
		"\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001"+
		"\u0000\u0000\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fe\u0001"+
		"\u0000\u0000\u0000\u0101\u0102\u0005\u000f\u0000\u0000\u0102%\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0005,\u0000\u0000\u0104\u0105\u0005\u000e\u0000"+
		"\u0000\u0105\u010a\u0003(\u0014\u0000\u0106\u0107\u0005\u000b\u0000\u0000"+
		"\u0107\u0109\u0003(\u0014\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109"+
		"\u010c\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0001\u0000\u0000\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c"+
		"\u010a\u0001\u0000\u0000\u0000\u010d\u010e\u0005\u000f\u0000\u0000\u010e"+
		"\'\u0001\u0000\u0000\u0000\u010f\u0110\u00030\u0018\u0000\u0110)\u0001"+
		"\u0000\u0000\u0000\u0111\u0118\u0005*\u0000\u0000\u0112\u0114\u0005\u000e"+
		"\u0000\u0000\u0113\u0115\u00053\u0000\u0000\u0114\u0113\u0001\u0000\u0000"+
		"\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000"+
		"\u0000\u0116\u0119\u0005\u000f\u0000\u0000\u0117\u0119\u0005\u0001\u0000"+
		"\u0000\u0118\u0112\u0001\u0000\u0000\u0000\u0118\u0117\u0001\u0000\u0000"+
		"\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119+\u0001\u0000\u0000\u0000"+
		"\u011a\u0126\u00055\u0000\u0000\u011b\u011c\u0005\u0013\u0000\u0000\u011c"+
		"\u0122\u00055\u0000\u0000\u011d\u011f\u0005\u000e\u0000\u0000\u011e\u0120"+
		"\u0003.\u0017\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u011f\u0120\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0123\u0005"+
		"\u000f\u0000\u0000\u0122\u011d\u0001\u0000\u0000\u0000\u0122\u0123\u0001"+
		"\u0000\u0000\u0000\u0123\u0125\u0001\u0000\u0000\u0000\u0124\u011b\u0001"+
		"\u0000\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127-\u0001\u0000"+
		"\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129\u012e\u00030\u0018"+
		"\u0000\u012a\u012b\u0005\u000b\u0000\u0000\u012b\u012d\u00030\u0018\u0000"+
		"\u012c\u012a\u0001\u0000\u0000\u0000\u012d\u0130\u0001\u0000\u0000\u0000"+
		"\u012e\u012c\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000"+
		"\u012f/\u0001\u0000\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u00032\u0019\u0000\u01321\u0001\u0000\u0000\u0000\u0133\u0138\u0003"+
		"4\u001a\u0000\u0134\u0135\u0005/\u0000\u0000\u0135\u0137\u00034\u001a"+
		"\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000"+
		"\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000"+
		"\u0000\u01393\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000"+
		"\u013b\u0140\u00036\u001b\u0000\u013c\u013d\u0005.\u0000\u0000\u013d\u013f"+
		"\u00036\u001b\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u0142\u0001"+
		"\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001"+
		"\u0000\u0000\u0000\u01415\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000"+
		"\u0000\u0000\u0143\u0148\u00038\u001c\u0000\u0144\u0145\u0007\u0000\u0000"+
		"\u0000\u0145\u0147\u00038\u001c\u0000\u0146\u0144\u0001\u0000\u0000\u0000"+
		"\u0147\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0001\u0000\u0000\u0000\u01497\u0001\u0000\u0000\u0000\u014a"+
		"\u0148\u0001\u0000\u0000\u0000\u014b\u0150\u0003:\u001d\u0000\u014c\u014d"+
		"\u0007\u0001\u0000\u0000\u014d\u014f\u0003:\u001d\u0000\u014e\u014c\u0001"+
		"\u0000\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u01519\u0001\u0000"+
		"\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0158\u0003<\u001e"+
		"\u0000\u0154\u0155\u0007\u0002\u0000\u0000\u0155\u0157\u0003<\u001e\u0000"+
		"\u0156\u0154\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000"+
		"\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000"+
		"\u0159;\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015b"+
		"\u0160\u0003>\u001f\u0000\u015c\u015d\u0007\u0003\u0000\u0000\u015d\u015f"+
		"\u0003>\u001f\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015f\u0162\u0001"+
		"\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001"+
		"\u0000\u0000\u0000\u0161=\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000"+
		"\u0000\u0000\u0163\u0164\u0007\u0004\u0000\u0000\u0164\u0167\u0003>\u001f"+
		"\u0000\u0165\u0167\u0003@ \u0000\u0166\u0163\u0001\u0000\u0000\u0000\u0166"+
		"\u0165\u0001\u0000\u0000\u0000\u0167?\u0001\u0000\u0000\u0000\u0168\u016b"+
		"\u0003B!\u0000\u0169\u016a\u0005\u001f\u0000\u0000\u016a\u016c\u0003>"+
		"\u001f\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000"+
		"\u0000\u0000\u016cA\u0001\u0000\u0000\u0000\u016d\u017c\u00053\u0000\u0000"+
		"\u016e\u017c\u00054\u0000\u0000\u016f\u017c\u00052\u0000\u0000\u0170\u017c"+
		"\u00051\u0000\u0000\u0171\u017c\u0003,\u0016\u0000\u0172\u0173\u0005\u000e"+
		"\u0000\u0000\u0173\u0177\u00030\u0018\u0000\u0174\u0176\u0005\u000f\u0000"+
		"\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0176\u0179\u0001\u0000\u0000"+
		"\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000"+
		"\u0000\u0178\u017c\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000"+
		"\u0000\u017a\u017c\u0003D\"\u0000\u017b\u016d\u0001\u0000\u0000\u0000"+
		"\u017b\u016e\u0001\u0000\u0000\u0000\u017b\u016f\u0001\u0000\u0000\u0000"+
		"\u017b\u0170\u0001\u0000\u0000\u0000\u017b\u0171\u0001\u0000\u0000\u0000"+
		"\u017b\u0172\u0001\u0000\u0000\u0000\u017b\u017a\u0001\u0000\u0000\u0000"+
		"\u017cC\u0001\u0000\u0000\u0000\u017d\u0186\u0005\u0002\u0000\u0000\u017e"+
		"\u0183\u00030\u0018\u0000\u017f\u0180\u0005\u000b\u0000\u0000\u0180\u0182"+
		"\u00030\u0018\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0182\u0185\u0001"+
		"\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001"+
		"\u0000\u0000\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185\u0183\u0001"+
		"\u0000\u0000\u0000\u0186\u017e\u0001\u0000\u0000\u0000\u0186\u0187\u0001"+
		"\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0189\u0005"+
		"\u0003\u0000\u0000\u0189E\u0001\u0000\u0000\u0000\u018a\u018b\u0005-\u0000"+
		"\u0000\u018b\u018c\u00055\u0000\u0000\u018c\u0190\u0005\u0010\u0000\u0000"+
		"\u018d\u018f\u0003H$\u0000\u018e\u018d\u0001\u0000\u0000\u0000\u018f\u0192"+
		"\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0190\u0191"+
		"\u0001\u0000\u0000\u0000\u0191\u0193\u0001\u0000\u0000\u0000\u0192\u0190"+
		"\u0001\u0000\u0000\u0000\u0193\u0194\u0005\u0011\u0000\u0000\u0194G\u0001"+
		"\u0000\u0000\u0000\u0195\u0199\u0003J%\u0000\u0196\u0199\u0003L&\u0000"+
		"\u0197\u0199\u0003N\'\u0000\u0198\u0195\u0001\u0000\u0000\u0000\u0198"+
		"\u0196\u0001\u0000\u0000\u0000\u0198\u0197\u0001\u0000\u0000\u0000\u0199"+
		"\u019d\u0001\u0000\u0000\u0000\u019a\u019c\u00056\u0000\u0000\u019b\u019a"+
		"\u0001\u0000\u0000\u0000\u019c\u019f\u0001\u0000\u0000\u0000\u019d\u019b"+
		"\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019eI\u0001"+
		"\u0000\u0000\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u01a2\u0007"+
		"\u0005\u0000\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a4\u0001\u0000\u0000\u0000\u01a3\u01a5\u0005"+
		"+\u0000\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6\u01a9\u00055\u0000"+
		"\u0000\u01a7\u01a8\u0005\r\u0000\u0000\u01a8\u01aa\u00030\u0018\u0000"+
		"\u01a9\u01a7\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000"+
		"\u01aaK\u0001\u0000\u0000\u0000\u01ab\u01ad\u0005\u0006\u0000\u0000\u01ac"+
		"\u01ab\u0001\u0000\u0000\u0000\u01ac\u01ad\u0001\u0000\u0000\u0000\u01ad"+
		"\u01ae\u0001\u0000\u0000\u0000\u01ae\u01af\u0005\u0007\u0000\u0000\u01af"+
		"\u01b0\u00055\u0000\u0000\u01b0\u01b2\u0005\u000e\u0000\u0000\u01b1\u01b3"+
		"\u0003\u000e\u0007\u0000\u01b2\u01b1\u0001\u0000\u0000\u0000\u01b2\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b5"+
		"\u0005\u000f\u0000\u0000\u01b5\u01b6\u0003\u0004\u0002\u0000\u01b6M\u0001"+
		"\u0000\u0000\u0000\u01b7\u01b8\u0005\b\u0000\u0000\u01b8\u01ba\u0005\u000e"+
		"\u0000\u0000\u01b9\u01bb\u0003\u000e\u0007\u0000\u01ba\u01b9\u0001\u0000"+
		"\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000"+
		"\u0000\u0000\u01bc\u01bd\u0005\u000f\u0000\u0000\u01bd\u01be\u0003\u0004"+
		"\u0002\u0000\u01beO\u0001\u0000\u0000\u0000\u01bf\u01c0\u00055\u0000\u0000"+
		"\u01c0\u01c1\u0005\r\u0000\u0000\u01c1\u01c2\u0005 \u0000\u0000\u01c2"+
		"\u01c8\u00055\u0000\u0000\u01c3\u01c5\u0005\u000e\u0000\u0000\u01c4\u01c6"+
		"\u0003.\u0017\u0000\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001"+
		"\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c9\u0005"+
		"\u000f\u0000\u0000\u01c8\u01c3\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001"+
		"\u0000\u0000\u0000\u01c9Q\u0001\u0000\u0000\u00007Ukqw}\u0088\u008a\u008d"+
		"\u0094\u009b\u009e\u00a4\u00ae\u00ba\u00c5\u00c9\u00cd\u00d4\u00d8\u00dc"+
		"\u00df\u00e4\u00e9\u00f2\u00fe\u010a\u0114\u0118\u011f\u0122\u0126\u012e"+
		"\u0138\u0140\u0148\u0150\u0158\u0160\u0166\u016b\u0177\u017b\u0183\u0186"+
		"\u0190\u0198\u019d\u01a1\u01a4\u01a9\u01ac\u01b2\u01ba\u01c5\u01c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}