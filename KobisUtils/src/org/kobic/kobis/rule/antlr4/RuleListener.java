package org.kobic.kobis.rule.antlr4;
// Generated from Rule.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RuleParser}.
 */
public interface RuleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(@NotNull RuleParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(@NotNull RuleParser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(@NotNull RuleParser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(@NotNull RuleParser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(@NotNull RuleParser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(@NotNull RuleParser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(@NotNull RuleParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(@NotNull RuleParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(@NotNull RuleParser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(@NotNull RuleParser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration(@NotNull RuleParser.ClassMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration(@NotNull RuleParser.ClassMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(@NotNull RuleParser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(@NotNull RuleParser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#throws_}.
	 * @param ctx the parse tree
	 */
	void enterThrows_(@NotNull RuleParser.Throws_Context ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#throws_}.
	 * @param ctx the parse tree
	 */
	void exitThrows_(@NotNull RuleParser.Throws_Context ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(@NotNull RuleParser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(@NotNull RuleParser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression_lf_postfixExpression(@NotNull RuleParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression_lf_postfixExpression(@NotNull RuleParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(@NotNull RuleParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(@NotNull RuleParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull RuleParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull RuleParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(@NotNull RuleParser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(@NotNull RuleParser.EnumConstantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(@NotNull RuleParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(@NotNull RuleParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(@NotNull RuleParser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(@NotNull RuleParser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(@NotNull RuleParser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(@NotNull RuleParser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(@NotNull RuleParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(@NotNull RuleParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(@NotNull RuleParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(@NotNull RuleParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#superclass}.
	 * @param ctx the parse tree
	 */
	void enterSuperclass(@NotNull RuleParser.SuperclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#superclass}.
	 * @param ctx the parse tree
	 */
	void exitSuperclass(@NotNull RuleParser.SuperclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(@NotNull RuleParser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(@NotNull RuleParser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(@NotNull RuleParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(@NotNull RuleParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(@NotNull RuleParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(@NotNull RuleParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(@NotNull RuleParser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(@NotNull RuleParser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(@NotNull RuleParser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(@NotNull RuleParser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(@NotNull RuleParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(@NotNull RuleParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(@NotNull RuleParser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(@NotNull RuleParser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(@NotNull RuleParser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(@NotNull RuleParser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(@NotNull RuleParser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(@NotNull RuleParser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(@NotNull RuleParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(@NotNull RuleParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(@NotNull RuleParser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(@NotNull RuleParser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(@NotNull RuleParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(@NotNull RuleParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(@NotNull RuleParser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(@NotNull RuleParser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray(@NotNull RuleParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray(@NotNull RuleParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(@NotNull RuleParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(@NotNull RuleParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(@NotNull RuleParser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(@NotNull RuleParser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(@NotNull RuleParser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(@NotNull RuleParser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(@NotNull RuleParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(@NotNull RuleParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(@NotNull RuleParser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(@NotNull RuleParser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(@NotNull RuleParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(@NotNull RuleParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(@NotNull RuleParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(@NotNull RuleParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(@NotNull RuleParser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(@NotNull RuleParser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(@NotNull RuleParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(@NotNull RuleParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(@NotNull RuleParser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(@NotNull RuleParser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary(@NotNull RuleParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary(@NotNull RuleParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(@NotNull RuleParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(@NotNull RuleParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(@NotNull RuleParser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(@NotNull RuleParser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull RuleParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull RuleParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(@NotNull RuleParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(@NotNull RuleParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageModifier(@NotNull RuleParser.PackageModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageModifier(@NotNull RuleParser.PackageModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(@NotNull RuleParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(@NotNull RuleParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(@NotNull RuleParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(@NotNull RuleParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(@NotNull RuleParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(@NotNull RuleParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(@NotNull RuleParser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(@NotNull RuleParser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(@NotNull RuleParser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(@NotNull RuleParser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(@NotNull RuleParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(@NotNull RuleParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(@NotNull RuleParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(@NotNull RuleParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(@NotNull RuleParser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(@NotNull RuleParser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull RuleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull RuleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(@NotNull RuleParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(@NotNull RuleParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(@NotNull RuleParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(@NotNull RuleParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantModifier(@NotNull RuleParser.EnumConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantModifier(@NotNull RuleParser.EnumConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lf_unannClassOrInterfaceType(@NotNull RuleParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lf_unannClassOrInterfaceType(@NotNull RuleParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(@NotNull RuleParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(@NotNull RuleParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(@NotNull RuleParser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(@NotNull RuleParser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(@NotNull RuleParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(@NotNull RuleParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(@NotNull RuleParser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(@NotNull RuleParser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantModifier(@NotNull RuleParser.ConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantModifier(@NotNull RuleParser.ConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(@NotNull RuleParser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(@NotNull RuleParser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(@NotNull RuleParser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(@NotNull RuleParser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(@NotNull RuleParser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(@NotNull RuleParser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull RuleParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull RuleParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void enterSuperinterfaces(@NotNull RuleParser.SuperinterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void exitSuperinterfaces(@NotNull RuleParser.SuperinterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(@NotNull RuleParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(@NotNull RuleParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(@NotNull RuleParser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(@NotNull RuleParser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(@NotNull RuleParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(@NotNull RuleParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_arrayAccess(@NotNull RuleParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_arrayAccess(@NotNull RuleParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(@NotNull RuleParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(@NotNull RuleParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleStaticImportDeclaration(@NotNull RuleParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleStaticImportDeclaration(@NotNull RuleParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(@NotNull RuleParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(@NotNull RuleParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(@NotNull RuleParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(@NotNull RuleParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchLabels}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabels(@NotNull RuleParser.SwitchLabelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchLabels}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabels(@NotNull RuleParser.SwitchLabelsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(@NotNull RuleParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(@NotNull RuleParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassType_lf_classOrInterfaceType(@NotNull RuleParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassType_lf_classOrInterfaceType(@NotNull RuleParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(@NotNull RuleParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(@NotNull RuleParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(@NotNull RuleParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(@NotNull RuleParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(@NotNull RuleParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(@NotNull RuleParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(@NotNull RuleParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(@NotNull RuleParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(@NotNull RuleParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(@NotNull RuleParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(@NotNull RuleParser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(@NotNull RuleParser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus(@NotNull RuleParser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus(@NotNull RuleParser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(@NotNull RuleParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(@NotNull RuleParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(@NotNull RuleParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(@NotNull RuleParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(@NotNull RuleParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(@NotNull RuleParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(@NotNull RuleParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(@NotNull RuleParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(@NotNull RuleParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(@NotNull RuleParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(@NotNull RuleParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(@NotNull RuleParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType_lf_classOrInterfaceType(@NotNull RuleParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType_lf_classOrInterfaceType(@NotNull RuleParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(@NotNull RuleParser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(@NotNull RuleParser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(@NotNull RuleParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(@NotNull RuleParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(@NotNull RuleParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(@NotNull RuleParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(@NotNull RuleParser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(@NotNull RuleParser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(@NotNull RuleParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(@NotNull RuleParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(@NotNull RuleParser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(@NotNull RuleParser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull RuleParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull RuleParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType_lfno_classOrInterfaceType(@NotNull RuleParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType_lfno_classOrInterfaceType(@NotNull RuleParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(@NotNull RuleParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(@NotNull RuleParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(@NotNull RuleParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(@NotNull RuleParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess(@NotNull RuleParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess(@NotNull RuleParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(@NotNull RuleParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(@NotNull RuleParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(@NotNull RuleParser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(@NotNull RuleParser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(@NotNull RuleParser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(@NotNull RuleParser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(@NotNull RuleParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(@NotNull RuleParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(@NotNull RuleParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(@NotNull RuleParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(@NotNull RuleParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(@NotNull RuleParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(@NotNull RuleParser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(@NotNull RuleParser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(@NotNull RuleParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(@NotNull RuleParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(@NotNull RuleParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(@NotNull RuleParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(@NotNull RuleParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(@NotNull RuleParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void enterExtendsInterfaces(@NotNull RuleParser.ExtendsInterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void exitExtendsInterfaces(@NotNull RuleParser.ExtendsInterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(@NotNull RuleParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(@NotNull RuleParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(@NotNull RuleParser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(@NotNull RuleParser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(@NotNull RuleParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(@NotNull RuleParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull RuleParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull RuleParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(@NotNull RuleParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(@NotNull RuleParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#finally_}.
	 * @param ctx the parse tree
	 */
	void enterFinally_(@NotNull RuleParser.Finally_Context ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#finally_}.
	 * @param ctx the parse tree
	 */
	void exitFinally_(@NotNull RuleParser.Finally_Context ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(@NotNull RuleParser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(@NotNull RuleParser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(@NotNull RuleParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(@NotNull RuleParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(@NotNull RuleParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(@NotNull RuleParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(@NotNull RuleParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(@NotNull RuleParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(@NotNull RuleParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(@NotNull RuleParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(@NotNull RuleParser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(@NotNull RuleParser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(@NotNull RuleParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(@NotNull RuleParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(@NotNull RuleParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(@NotNull RuleParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(@NotNull RuleParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(@NotNull RuleParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lfno_primary(@NotNull RuleParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lfno_primary(@NotNull RuleParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(@NotNull RuleParser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(@NotNull RuleParser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeMemberDeclaration(@NotNull RuleParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeMemberDeclaration(@NotNull RuleParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType(@NotNull RuleParser.UnannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType(@NotNull RuleParser.UnannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(@NotNull RuleParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(@NotNull RuleParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(@NotNull RuleParser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(@NotNull RuleParser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(@NotNull RuleParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(@NotNull RuleParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementModifier(@NotNull RuleParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementModifier(@NotNull RuleParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(@NotNull RuleParser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(@NotNull RuleParser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(@NotNull RuleParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(@NotNull RuleParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(@NotNull RuleParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(@NotNull RuleParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(@NotNull RuleParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(@NotNull RuleParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(@NotNull RuleParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(@NotNull RuleParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lf_primary(@NotNull RuleParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lf_primary(@NotNull RuleParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(@NotNull RuleParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(@NotNull RuleParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(@NotNull RuleParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(@NotNull RuleParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(@NotNull RuleParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(@NotNull RuleParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull RuleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull RuleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary(@NotNull RuleParser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary(@NotNull RuleParser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(@NotNull RuleParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(@NotNull RuleParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(@NotNull RuleParser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(@NotNull RuleParser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(@NotNull RuleParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(@NotNull RuleParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(@NotNull RuleParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(@NotNull RuleParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(@NotNull RuleParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(@NotNull RuleParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(@NotNull RuleParser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(@NotNull RuleParser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(@NotNull RuleParser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(@NotNull RuleParser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(@NotNull RuleParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(@NotNull RuleParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(@NotNull RuleParser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(@NotNull RuleParser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(@NotNull RuleParser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(@NotNull RuleParser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(@NotNull RuleParser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(@NotNull RuleParser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(@NotNull RuleParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(@NotNull RuleParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lfno_primary(@NotNull RuleParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lfno_primary(@NotNull RuleParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(@NotNull RuleParser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(@NotNull RuleParser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(@NotNull RuleParser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(@NotNull RuleParser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lfno_unannClassOrInterfaceType(@NotNull RuleParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lfno_unannClassOrInterfaceType(@NotNull RuleParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(@NotNull RuleParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(@NotNull RuleParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(@NotNull RuleParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(@NotNull RuleParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(@NotNull RuleParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(@NotNull RuleParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lf_primary(@NotNull RuleParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lf_primary(@NotNull RuleParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterInferredFormalParameterList(@NotNull RuleParser.InferredFormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitInferredFormalParameterList(@NotNull RuleParser.InferredFormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(@NotNull RuleParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(@NotNull RuleParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(@NotNull RuleParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(@NotNull RuleParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(@NotNull RuleParser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(@NotNull RuleParser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(@NotNull RuleParser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(@NotNull RuleParser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(@NotNull RuleParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(@NotNull RuleParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lf_primary(@NotNull RuleParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lf_primary(@NotNull RuleParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary(@NotNull RuleParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary(@NotNull RuleParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lfno_primary(@NotNull RuleParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lfno_primary(@NotNull RuleParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull RuleParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull RuleParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lf_primary(@NotNull RuleParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lf_primary(@NotNull RuleParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(@NotNull RuleParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(@NotNull RuleParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lfno_primary(@NotNull RuleParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lfno_primary(@NotNull RuleParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void enterAmbiguousName(@NotNull RuleParser.AmbiguousNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void exitAmbiguousName(@NotNull RuleParser.AmbiguousNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull RuleParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull RuleParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(@NotNull RuleParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(@NotNull RuleParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(@NotNull RuleParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(@NotNull RuleParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(@NotNull RuleParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(@NotNull RuleParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(@NotNull RuleParser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(@NotNull RuleParser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(@NotNull RuleParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(@NotNull RuleParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeImportOnDemandDeclaration(@NotNull RuleParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeImportOnDemandDeclaration(@NotNull RuleParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(@NotNull RuleParser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(@NotNull RuleParser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(@NotNull RuleParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(@NotNull RuleParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchFormalParameter(@NotNull RuleParser.CatchFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchFormalParameter(@NotNull RuleParser.CatchFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(@NotNull RuleParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(@NotNull RuleParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull RuleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull RuleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(@NotNull RuleParser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(@NotNull RuleParser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType(@NotNull RuleParser.UnannInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType(@NotNull RuleParser.UnannInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(@NotNull RuleParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(@NotNull RuleParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(@NotNull RuleParser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(@NotNull RuleParser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(@NotNull RuleParser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(@NotNull RuleParser.PackageOrTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lf_primary(@NotNull RuleParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lf_primary(@NotNull RuleParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(@NotNull RuleParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(@NotNull RuleParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(@NotNull RuleParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(@NotNull RuleParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(@NotNull RuleParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(@NotNull RuleParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(@NotNull RuleParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(@NotNull RuleParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(@NotNull RuleParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(@NotNull RuleParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(@NotNull RuleParser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(@NotNull RuleParser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(@NotNull RuleParser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(@NotNull RuleParser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(@NotNull RuleParser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(@NotNull RuleParser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(@NotNull RuleParser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(@NotNull RuleParser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(@NotNull RuleParser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(@NotNull RuleParser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(@NotNull RuleParser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(@NotNull RuleParser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(@NotNull RuleParser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(@NotNull RuleParser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticImportOnDemandDeclaration(@NotNull RuleParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticImportOnDemandDeclaration(@NotNull RuleParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(@NotNull RuleParser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(@NotNull RuleParser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(@NotNull RuleParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(@NotNull RuleParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(@NotNull RuleParser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(@NotNull RuleParser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(@NotNull RuleParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(@NotNull RuleParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(@NotNull RuleParser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(@NotNull RuleParser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(@NotNull RuleParser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(@NotNull RuleParser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lf_unannClassOrInterfaceType(@NotNull RuleParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lf_unannClassOrInterfaceType(@NotNull RuleParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(@NotNull RuleParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(@NotNull RuleParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(@NotNull RuleParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(@NotNull RuleParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression_lf_postfixExpression(@NotNull RuleParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression_lf_postfixExpression(@NotNull RuleParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(@NotNull RuleParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(@NotNull RuleParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(@NotNull RuleParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(@NotNull RuleParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassType_lfno_classOrInterfaceType(@NotNull RuleParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassType_lfno_classOrInterfaceType(@NotNull RuleParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(@NotNull RuleParser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(@NotNull RuleParser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(@NotNull RuleParser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(@NotNull RuleParser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(@NotNull RuleParser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(@NotNull RuleParser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull RuleParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull RuleParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(@NotNull RuleParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(@NotNull RuleParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(@NotNull RuleParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(@NotNull RuleParser.SwitchBlockStatementGroupContext ctx);
}