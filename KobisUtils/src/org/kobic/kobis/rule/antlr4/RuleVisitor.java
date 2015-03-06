package org.kobic.kobis.rule.antlr4;
// Generated from Rule.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RuleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RuleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RuleParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(RuleParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(RuleParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(RuleParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(RuleParser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(RuleParser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(RuleParser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(RuleParser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(RuleParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(RuleParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_lf_classOrInterfaceType(RuleParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_lfno_classOrInterfaceType(RuleParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(RuleParser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType_lf_classOrInterfaceType(RuleParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType_lfno_classOrInterfaceType(RuleParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(RuleParser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(RuleParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(RuleParser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(RuleParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(RuleParser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(RuleParser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(RuleParser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(RuleParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(RuleParser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(RuleParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(RuleParser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(RuleParser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(RuleParser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(RuleParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(RuleParser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName(RuleParser.ExpressionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(RuleParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#ambiguousName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmbiguousName(RuleParser.AmbiguousNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(RuleParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(RuleParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(RuleParser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(RuleParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(RuleParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(RuleParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(RuleParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(RuleParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(RuleParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(RuleParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(RuleParser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(RuleParser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(RuleParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(RuleParser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#superclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclass(RuleParser.SuperclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#superinterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperinterfaces(RuleParser.SuperinterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(RuleParser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(RuleParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(RuleParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(RuleParser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(RuleParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(RuleParser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(RuleParser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(RuleParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(RuleParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(RuleParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType(RuleParser.UnannTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType(RuleParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType(RuleParser.UnannReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(RuleParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(RuleParser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType_lf_unannClassOrInterfaceType(RuleParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType_lfno_unannClassOrInterfaceType(RuleParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(RuleParser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType_lf_unannClassOrInterfaceType(RuleParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType_lfno_unannClassOrInterfaceType(RuleParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(RuleParser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayType(RuleParser.UnannArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(RuleParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(RuleParser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(RuleParser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(RuleParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(RuleParser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(RuleParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(RuleParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(RuleParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(RuleParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameter(RuleParser.LastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(RuleParser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#throws_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrows_(RuleParser.Throws_Context ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(RuleParser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(RuleParser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(RuleParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(RuleParser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(RuleParser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(RuleParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(RuleParser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(RuleParser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(RuleParser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(RuleParser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(RuleParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(RuleParser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(RuleParser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(RuleParser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(RuleParser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(RuleParser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(RuleParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(RuleParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(RuleParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(RuleParser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsInterfaces(RuleParser.ExtendsInterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(RuleParser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(RuleParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(RuleParser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(RuleParser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(RuleParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(RuleParser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeDeclaration(RuleParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeBody(RuleParser.AnnotationTypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeMemberDeclaration(RuleParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementDeclaration(RuleParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementModifier(RuleParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(RuleParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(RuleParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(RuleParser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(RuleParser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(RuleParser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(RuleParser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(RuleParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(RuleParser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(RuleParser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(RuleParser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(RuleParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(RuleParser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(RuleParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(RuleParser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(RuleParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(RuleParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(RuleParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(RuleParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(RuleParser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement(RuleParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(RuleParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(RuleParser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(RuleParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(RuleParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(RuleParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(RuleParser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(RuleParser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(RuleParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(RuleParser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(RuleParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(RuleParser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(RuleParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#switchLabels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabels(RuleParser.SwitchLabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(RuleParser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enumConstantName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantName(RuleParser.EnumConstantNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(RuleParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(RuleParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(RuleParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(RuleParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(RuleParser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(RuleParser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(RuleParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(RuleParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(RuleParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(RuleParser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(RuleParser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(RuleParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(RuleParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(RuleParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(RuleParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(RuleParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(RuleParser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(RuleParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(RuleParser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(RuleParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(RuleParser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(RuleParser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#finally_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinally_(RuleParser.Finally_Context ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(RuleParser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(RuleParser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(RuleParser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(RuleParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(RuleParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray(RuleParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_arrayAccess(RuleParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess(RuleParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary(RuleParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(RuleParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(RuleParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(RuleParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(RuleParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression_lf_primary(RuleParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression_lfno_primary(RuleParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(RuleParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(RuleParser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess_lf_primary(RuleParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess_lfno_primary(RuleParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(RuleParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess_lf_primary(RuleParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess_lfno_primary(RuleParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(RuleParser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lf_primary(RuleParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lfno_primary(RuleParser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(RuleParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(RuleParser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference_lf_primary(RuleParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference_lfno_primary(RuleParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(RuleParser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(RuleParser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(RuleParser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(RuleParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(RuleParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(RuleParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(RuleParser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInferredFormalParameterList(RuleParser.InferredFormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(RuleParser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(RuleParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(RuleParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(RuleParser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(RuleParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(RuleParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(RuleParser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(RuleParser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(RuleParser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(RuleParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(RuleParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(RuleParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(RuleParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(RuleParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(RuleParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(RuleParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(RuleParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(RuleParser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(RuleParser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus(RuleParser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(RuleParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(RuleParser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression_lf_postfixExpression(RuleParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(RuleParser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression_lf_postfixExpression(RuleParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(RuleParser.CastExpressionContext ctx);
}