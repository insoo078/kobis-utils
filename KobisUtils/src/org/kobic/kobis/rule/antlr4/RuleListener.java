package org.kobic.kobis.rule.antlr4;
// Generated from Rule.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RuleParser}.
 */
public interface RuleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RuleParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(RuleParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(RuleParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(RuleParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(RuleParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(RuleParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(RuleParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(RuleParser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(RuleParser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(RuleParser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(RuleParser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(RuleParser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(RuleParser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(RuleParser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(RuleParser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(RuleParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(RuleParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(RuleParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(RuleParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassType_lf_classOrInterfaceType(RuleParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassType_lf_classOrInterfaceType(RuleParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassType_lfno_classOrInterfaceType(RuleParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassType_lfno_classOrInterfaceType(RuleParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(RuleParser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(RuleParser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType_lf_classOrInterfaceType(RuleParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType_lf_classOrInterfaceType(RuleParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType_lfno_classOrInterfaceType(RuleParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType_lfno_classOrInterfaceType(RuleParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(RuleParser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(RuleParser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(RuleParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(RuleParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(RuleParser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(RuleParser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(RuleParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(RuleParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(RuleParser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(RuleParser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(RuleParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(RuleParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(RuleParser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(RuleParser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(RuleParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(RuleParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(RuleParser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(RuleParser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(RuleParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(RuleParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(RuleParser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(RuleParser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(RuleParser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(RuleParser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(RuleParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(RuleParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(RuleParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(RuleParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(RuleParser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(RuleParser.PackageOrTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(RuleParser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(RuleParser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(RuleParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(RuleParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void enterAmbiguousName(RuleParser.AmbiguousNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void exitAmbiguousName(RuleParser.AmbiguousNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(RuleParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(RuleParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(RuleParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(RuleParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageModifier(RuleParser.PackageModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageModifier(RuleParser.PackageModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(RuleParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(RuleParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(RuleParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(RuleParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeImportOnDemandDeclaration(RuleParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeImportOnDemandDeclaration(RuleParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleStaticImportDeclaration(RuleParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleStaticImportDeclaration(RuleParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticImportOnDemandDeclaration(RuleParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticImportOnDemandDeclaration(RuleParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(RuleParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(RuleParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(RuleParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(RuleParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(RuleParser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(RuleParser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(RuleParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(RuleParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(RuleParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(RuleParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(RuleParser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(RuleParser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#superclass}.
	 * @param ctx the parse tree
	 */
	void enterSuperclass(RuleParser.SuperclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#superclass}.
	 * @param ctx the parse tree
	 */
	void exitSuperclass(RuleParser.SuperclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void enterSuperinterfaces(RuleParser.SuperinterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void exitSuperinterfaces(RuleParser.SuperinterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(RuleParser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(RuleParser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(RuleParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(RuleParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(RuleParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(RuleParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration(RuleParser.ClassMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration(RuleParser.ClassMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(RuleParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(RuleParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(RuleParser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(RuleParser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(RuleParser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(RuleParser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(RuleParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(RuleParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(RuleParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(RuleParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(RuleParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(RuleParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(RuleParser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(RuleParser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(RuleParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(RuleParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType(RuleParser.UnannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType(RuleParser.UnannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(RuleParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(RuleParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(RuleParser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(RuleParser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lf_unannClassOrInterfaceType(RuleParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lf_unannClassOrInterfaceType(RuleParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lfno_unannClassOrInterfaceType(RuleParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lfno_unannClassOrInterfaceType(RuleParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType(RuleParser.UnannInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType(RuleParser.UnannInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lf_unannClassOrInterfaceType(RuleParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lf_unannClassOrInterfaceType(RuleParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(RuleParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(RuleParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(RuleParser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(RuleParser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(RuleParser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(RuleParser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(RuleParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(RuleParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(RuleParser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(RuleParser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(RuleParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(RuleParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(RuleParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(RuleParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(RuleParser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(RuleParser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(RuleParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(RuleParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(RuleParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(RuleParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(RuleParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(RuleParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(RuleParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(RuleParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(RuleParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(RuleParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(RuleParser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(RuleParser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#throws_}.
	 * @param ctx the parse tree
	 */
	void enterThrows_(RuleParser.Throws_Context ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#throws_}.
	 * @param ctx the parse tree
	 */
	void exitThrows_(RuleParser.Throws_Context ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(RuleParser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(RuleParser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(RuleParser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(RuleParser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(RuleParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(RuleParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(RuleParser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(RuleParser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(RuleParser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(RuleParser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(RuleParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(RuleParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(RuleParser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(RuleParser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(RuleParser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(RuleParser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(RuleParser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(RuleParser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(RuleParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(RuleParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(RuleParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(RuleParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(RuleParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(RuleParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(RuleParser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(RuleParser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(RuleParser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(RuleParser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(RuleParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(RuleParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantModifier(RuleParser.EnumConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantModifier(RuleParser.EnumConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(RuleParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(RuleParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(RuleParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(RuleParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(RuleParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(RuleParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(RuleParser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(RuleParser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void enterExtendsInterfaces(RuleParser.ExtendsInterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void exitExtendsInterfaces(RuleParser.ExtendsInterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(RuleParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(RuleParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(RuleParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(RuleParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(RuleParser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(RuleParser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantModifier(RuleParser.ConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantModifier(RuleParser.ConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(RuleParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(RuleParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(RuleParser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(RuleParser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(RuleParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(RuleParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(RuleParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(RuleParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeMemberDeclaration(RuleParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeMemberDeclaration(RuleParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(RuleParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(RuleParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementModifier(RuleParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementModifier(RuleParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(RuleParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(RuleParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(RuleParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(RuleParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(RuleParser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(RuleParser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(RuleParser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(RuleParser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(RuleParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(RuleParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(RuleParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(RuleParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(RuleParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(RuleParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(RuleParser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(RuleParser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(RuleParser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(RuleParser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(RuleParser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(RuleParser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(RuleParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(RuleParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(RuleParser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(RuleParser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(RuleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(RuleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(RuleParser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(RuleParser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(RuleParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(RuleParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(RuleParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(RuleParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(RuleParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(RuleParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(RuleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(RuleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(RuleParser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(RuleParser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(RuleParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(RuleParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(RuleParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(RuleParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(RuleParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(RuleParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(RuleParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(RuleParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(RuleParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(RuleParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(RuleParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(RuleParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(RuleParser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(RuleParser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(RuleParser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(RuleParser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(RuleParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(RuleParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(RuleParser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(RuleParser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(RuleParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(RuleParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(RuleParser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(RuleParser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(RuleParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(RuleParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchLabels}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabels(RuleParser.SwitchLabelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchLabels}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabels(RuleParser.SwitchLabelsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(RuleParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(RuleParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(RuleParser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(RuleParser.EnumConstantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(RuleParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(RuleParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(RuleParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(RuleParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(RuleParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(RuleParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(RuleParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(RuleParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(RuleParser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(RuleParser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(RuleParser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(RuleParser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(RuleParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(RuleParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(RuleParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(RuleParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(RuleParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(RuleParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(RuleParser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(RuleParser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(RuleParser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(RuleParser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(RuleParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(RuleParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(RuleParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(RuleParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(RuleParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(RuleParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(RuleParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(RuleParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(RuleParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(RuleParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(RuleParser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(RuleParser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(RuleParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(RuleParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(RuleParser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(RuleParser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(RuleParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(RuleParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchFormalParameter(RuleParser.CatchFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchFormalParameter(RuleParser.CatchFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(RuleParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(RuleParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#finally_}.
	 * @param ctx the parse tree
	 */
	void enterFinally_(RuleParser.Finally_Context ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#finally_}.
	 * @param ctx the parse tree
	 */
	void exitFinally_(RuleParser.Finally_Context ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(RuleParser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(RuleParser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(RuleParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(RuleParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(RuleParser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(RuleParser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(RuleParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(RuleParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(RuleParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(RuleParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray(RuleParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray(RuleParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_arrayAccess(RuleParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_arrayAccess(RuleParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess(RuleParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess(RuleParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary(RuleParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary(RuleParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(RuleParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(RuleParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(RuleParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(RuleParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(RuleParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(RuleParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lf_primary(RuleParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lf_primary(RuleParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lfno_primary(RuleParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lfno_primary(RuleParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(RuleParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(RuleParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(RuleParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(RuleParser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lf_primary(RuleParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lf_primary(RuleParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lfno_primary(RuleParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lfno_primary(RuleParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(RuleParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(RuleParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lf_primary(RuleParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lf_primary(RuleParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lfno_primary(RuleParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lfno_primary(RuleParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(RuleParser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(RuleParser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lf_primary(RuleParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lf_primary(RuleParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary(RuleParser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary(RuleParser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(RuleParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(RuleParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(RuleParser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(RuleParser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lf_primary(RuleParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lf_primary(RuleParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lfno_primary(RuleParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lfno_primary(RuleParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(RuleParser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(RuleParser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(RuleParser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(RuleParser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(RuleParser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(RuleParser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(RuleParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(RuleParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(RuleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(RuleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(RuleParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(RuleParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(RuleParser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(RuleParser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterInferredFormalParameterList(RuleParser.InferredFormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitInferredFormalParameterList(RuleParser.InferredFormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(RuleParser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(RuleParser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(RuleParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(RuleParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(RuleParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(RuleParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(RuleParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(RuleParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(RuleParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(RuleParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(RuleParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(RuleParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(RuleParser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(RuleParser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(RuleParser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(RuleParser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(RuleParser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(RuleParser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(RuleParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(RuleParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(RuleParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(RuleParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(RuleParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(RuleParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(RuleParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(RuleParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(RuleParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(RuleParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(RuleParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(RuleParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(RuleParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(RuleParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(RuleParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(RuleParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(RuleParser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(RuleParser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(RuleParser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(RuleParser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus(RuleParser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus(RuleParser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(RuleParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(RuleParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(RuleParser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(RuleParser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression_lf_postfixExpression(RuleParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression_lf_postfixExpression(RuleParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(RuleParser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(RuleParser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression_lf_postfixExpression(RuleParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression_lf_postfixExpression(RuleParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(RuleParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(RuleParser.CastExpressionContext ctx);
}