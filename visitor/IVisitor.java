package via.script.visitor;

import via.script.parser.ast.declare.DynamicVariable;
import via.script.parser.ast.declare.FieldVariable;
import via.script.parser.ast.declare.PassFunction;
import via.script.parser.ast.declare.PassPrime;
import via.script.parser.ast.expression.BinaryExpression;
import via.script.parser.ast.expression.ConditionalExpression;
import via.script.parser.ast.expression.FieldAccessExpression;
import via.script.parser.ast.expression.InvokePassExpression;
import via.script.parser.ast.expression.PrimaryExpression;
import via.script.parser.ast.expression.UnaryExpression;
import via.script.parser.ast.statement.BlockStatement;
import via.script.parser.ast.statement.DoWhileStatement;
import via.script.parser.ast.statement.EvalStatement;
import via.script.parser.ast.statement.FieldDeclarationStatement;
import via.script.parser.ast.statement.IfStatement;
import via.script.parser.ast.statement.LoopStatement;
import via.script.parser.ast.statement.WhileStatement;

public interface IVisitor
{

	void visit(DynamicVariable v);

	void visit(FieldVariable v);

	void visit(PrimaryExpression v);

	void visit(BlockStatement v);

	void visit(InvokePassExpression v);

	void visit(PassFunction v);

	void visit(PassPrime v);

	void visit(BinaryExpression v);

	void visit(EvalStatement v);

	void visit(IfStatement v);

	void visit(WhileStatement v);

	void visit(DoWhileStatement v);

	void visit(LoopStatement v);

	void visit(FieldDeclarationStatement v);

	void visit(FieldAccessExpression v);

	void visit(ConditionalExpression v);

	void visit(UnaryExpression v);
	
}
