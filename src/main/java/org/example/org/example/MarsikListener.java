// Generated from C:/Users/dani_/Desktop/MarsikLang2/src/main/java/org/example/Marsik.g4 by ANTLR 4.13.2
package org.example;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.example.org.example.MarsikParser;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MarsikParser}.
 */
public interface MarsikListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MarsikParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MarsikParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MarsikParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MarsikParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MarsikParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#type_label}.
	 * @param ctx the parse tree
	 */
	void enterType_label(MarsikParser.Type_labelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#type_label}.
	 * @param ctx the parse tree
	 */
	void exitType_label(MarsikParser.Type_labelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(MarsikParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(MarsikParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call(MarsikParser.Method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call(MarsikParser.Method_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#object_stmt}.
	 * @param ctx the parse tree
	 */
	void enterObject_stmt(MarsikParser.Object_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#object_stmt}.
	 * @param ctx the parse tree
	 */
	void exitObject_stmt(MarsikParser.Object_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(MarsikParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(MarsikParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#const_decl}.
	 * @param ctx the parse tree
	 */
	void enterConst_decl(MarsikParser.Const_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#const_decl}.
	 * @param ctx the parse tree
	 */
	void exitConst_decl(MarsikParser.Const_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(MarsikParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(MarsikParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#inc_stmt}.
	 * @param ctx the parse tree
	 */
	void enterInc_stmt(MarsikParser.Inc_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#inc_stmt}.
	 * @param ctx the parse tree
	 */
	void exitInc_stmt(MarsikParser.Inc_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#dec_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDec_stmt(MarsikParser.Dec_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#dec_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDec_stmt(MarsikParser.Dec_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#array_decl}.
	 * @param ctx the parse tree
	 */
	void enterArray_decl(MarsikParser.Array_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#array_decl}.
	 * @param ctx the parse tree
	 */
	void exitArray_decl(MarsikParser.Array_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(MarsikParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(MarsikParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MarsikParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MarsikParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MarsikParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MarsikParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(MarsikParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(MarsikParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(MarsikParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(MarsikParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MarsikParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MarsikParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(MarsikParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(MarsikParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterFor_init(MarsikParser.For_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitFor_init(MarsikParser.For_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterFor_update(MarsikParser.For_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitFor_update(MarsikParser.For_updateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(MarsikParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(MarsikParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint_stmt(MarsikParser.Print_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint_stmt(MarsikParser.Print_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#exit_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExit_stmt(MarsikParser.Exit_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#exit_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExit_stmt(MarsikParser.Exit_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#scan_stmt}.
	 * @param ctx the parse tree
	 */
	void enterScan_stmt(MarsikParser.Scan_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#scan_stmt}.
	 * @param ctx the parse tree
	 */
	void exitScan_stmt(MarsikParser.Scan_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(MarsikParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(MarsikParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MarsikParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MarsikParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_expr(MarsikParser.Or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_expr(MarsikParser.Or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(MarsikParser.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(MarsikParser.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#equality_expr}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expr(MarsikParser.Equality_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#equality_expr}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expr(MarsikParser.Equality_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#relational_expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expr(MarsikParser.Relational_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#relational_expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expr(MarsikParser.Relational_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#additive_expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expr(MarsikParser.Additive_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#additive_expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expr(MarsikParser.Additive_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#multiplicative_expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expr(MarsikParser.Multiplicative_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#multiplicative_expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expr(MarsikParser.Multiplicative_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(MarsikParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(MarsikParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#power_expr}.
	 * @param ctx the parse tree
	 */
	void enterPower_expr(MarsikParser.Power_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#power_expr}.
	 * @param ctx the parse tree
	 */
	void exitPower_expr(MarsikParser.Power_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterAtom_expr(MarsikParser.Atom_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitAtom_expr(MarsikParser.Atom_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(MarsikParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(MarsikParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#class_member}.
	 * @param ctx the parse tree
	 */
	void enterClass_member(MarsikParser.Class_memberContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#class_member}.
	 * @param ctx the parse tree
	 */
	void exitClass_member(MarsikParser.Class_memberContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void enterField_decl(MarsikParser.Field_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void exitField_decl(MarsikParser.Field_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MarsikParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void enterMethod_decl(MarsikParser.Method_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MarsikParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void exitMethod_decl(MarsikParser.Method_declContext ctx);
}