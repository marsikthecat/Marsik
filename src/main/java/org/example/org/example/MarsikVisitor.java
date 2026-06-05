// Generated from C:/Marsik/MarsikLang/src/main/java/org/example/Marsik.g4 by ANTLR 4.13.2
package org.example.org.example;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MarsikParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MarsikVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MarsikParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MarsikParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MarsikParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#type_label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_label(MarsikParser.Type_labelContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(MarsikParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call(MarsikParser.Method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#object_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_stmt(MarsikParser.Object_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(MarsikParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#const_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_decl(MarsikParser.Const_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(MarsikParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#inc_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInc_stmt(MarsikParser.Inc_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#dec_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec_stmt(MarsikParser.Dec_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#array_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_decl(MarsikParser.Array_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(MarsikParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MarsikParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MarsikParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(MarsikParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(MarsikParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MarsikParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(MarsikParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_init(MarsikParser.For_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_update(MarsikParser.For_updateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(MarsikParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#print_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_stmt(MarsikParser.Print_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#print_arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_arg(MarsikParser.Print_argContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#exit_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_stmt(MarsikParser.Exit_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#scan_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScan_stmt(MarsikParser.Scan_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(MarsikParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MarsikParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expr(MarsikParser.Or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(MarsikParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#equality_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expr(MarsikParser.Equality_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#relational_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expr(MarsikParser.Relational_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#additive_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expr(MarsikParser.Additive_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#multiplicative_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expr(MarsikParser.Multiplicative_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#unary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(MarsikParser.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#power_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower_expr(MarsikParser.Power_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#atom_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_expr(MarsikParser.Atom_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#class_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_def(MarsikParser.Class_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#class_member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_member(MarsikParser.Class_memberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_decl(MarsikParser.Field_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MarsikParser#method_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_decl(MarsikParser.Method_declContext ctx);
}