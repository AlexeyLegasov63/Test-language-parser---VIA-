package via.script.intermediate;

import java.util.HashMap;
import java.util.Stack;

import via.script.parser.CompileContext;
import via.script.parser.ast.*;
import via.script.parser.ast.expression.ConditionalExpression.ConditionalOperator;

public class IntermediateProgramBuilder
{
	private final IntermediateStatement[] result = new IntermediateStatement[0x7fffff];
	private final HashMap<Integer, Integer> labels = new HashMap<>();
	private final Stack<Integer> cycles = new Stack<>();
	private int position, label, last;
	public IntermediateProgramBuilder() {
		labels.put(-1, 0);					// Make start label
	}
	public IntermediateProgram build() {
		return new IntermediateProgram(result, labels, position);
	}

	public void makeNeg() {
		append(new IntermediateNeg());
	}
	public void replaceToNeg() {
		replace(new IntermediateNeg());
	}
	public void makeInv() {
		append(new IntermediateInv());
	}
	public void replaceToInv() {
		replace(new IntermediateInv());
	}
	public void replaceToFieldAccess(String n) {
		replace(new IntermediateVariableAccess(n));
	}
	public void makeFieldAccess(String n) {
		append(new IntermediateVariableAccess(n));
	}
	public void makeAlt(TypeIndifier t, String n) {
		append(new IntermediateDyn(n, t));
	}
	public void replaceToAlt(TypeIndifier t, String n) {
		replace(new IntermediateDyn(n, t));
	}
	public void makeAload(String n) {
		append(new IntermediateAload(n));
	}
	public void replaceToAload(String n) {
		replace(new IntermediateAload(n));
	}
	public int witness(int p) {
		return cycles.push(p);
	}
	public int peekWitness() {
		return cycles.peek();
	}
	public int popWitness() {
		return cycles.pop();
	}
	public void makeCmp(ConditionalOperator p) {
		append(new IntermediateCond(p));
	}
	public void replaceToCmp(ConditionalOperator p) {
		replace(new IntermediateCond(p));
	}
	public void makeEquals(int p) {
		append(new IntermediateJe(new IntermediateGoto(p)));
	}
	public void replaceToEquals(int p) {
		replace(new IntermediateJe(new IntermediateGoto(p)));
	}
	public void makeEquals(IntermediateGoto tr) {
		append(new IntermediateJe(tr));
	}
	public void replaceToEquals(IntermediateGoto tr) {
		replace(new IntermediateJe(tr));
	}
	public void makeNotEquals(int p) {
		append(new IntermediateJne(new IntermediateGoto(p)));
	}
	public void replaceToNotEquals(int p) {
		replace(new IntermediateJne(new IntermediateGoto(p)));
	}
	public void makeNotEquals(IntermediateGoto tr) {
		append(new IntermediateJne(tr));
	}
	public void replaceToNotEquals(IntermediateGoto tr) {
		replace(new IntermediateJne(tr));
	}
	public IntermediateGoto makeGoto() {
		return new IntermediateGoto(0);
	}
	public void makeRowSet(int row) {
		append(new IntermediateRow(row));
	}
	public void replaceToRowSet(int row) {
		replace(new IntermediateRow(row));
	}
	public void makeRemove() {
		append(new IntermediateRemove());
	}
	public void replaceToRemove() {
		replace(new IntermediateRemove());
	}
	public void makeCollect(int n) {
		append(new IntermediateCollect(n));
	}
	public void replaceToCollect(int n) {
		replace(new IntermediateCollect(n));
	}
	public void makeCallback(String name, int n) {
		append(new IntermediateCallback(name, n));
	}
	public void replaceToCallback(String name, int n) {
		replace(new IntermediateCallback(name, n));
	}
	public void makeSub() {
		append(new IntermediateSub());
	}
	public void replaceToSub() {
		replace(new IntermediateSub());
	}
	public void makeMul() {
		append(new IntermediateMul());
	}
	public void replaceToMul() {
		replace(new IntermediateMul());
	}
	public void makeDivs() {
		append(new IntermediateDivs());
	}
	public void replaceToDivs() {
		replace(new IntermediateDivs());
	}
	public void makeDiv() {
		append(new IntermediateDiv());
	}
	public void replaceToDiv() {
		replace(new IntermediateDiv());
	}
	public void makeAddLetter() {
		append(new IntermediateAddLetter());
	}
	public void replaceToAddLetter() {
		replace(new IntermediateAddLetter());
	}
	public void makeAdd() {
		append(new IntermediateAdd());
	}
	public void replaceToAdd() {
		replace(new IntermediateAdd());
	}
	public void makePush(IValue value) {
		append(new IntermediatePush(value));
	}
	public void makePop() {
		append(new IntermediatePop());
	}
	public void makePushReg() {
		append(new IntermediatePushReg());
	}
	public void makePopReg() {
		append(new IntermediatePopReg());
	}
	public void replaceToPushReg() {
		replace(new IntermediatePushReg());
	}
	public void replaceToPopReg() {
		replace(new IntermediatePopReg());
	}
	
	public IntermediateGoto makeGoto(int to) {
		IntermediateGoto ig = new IntermediateGoto(to);
		append(ig);
		return ig;
	}
	public void resume() {
		position--;
	}
	public void replaceToPush(IValue value) {
		replace(new IntermediatePush(value));
	}
	public void replaceToPop() {
		replace(new IntermediatePop());
	}
	public void replaceToGoto(int to) {
		replace(new IntermediateGoto(to));
	}
	public void append(IntermediateStatement st) {
		result[position++] = st;
	}
	public void replace(IntermediateStatement st) {
		result[position] = st;
	}
	public int makeLabel(int add) {
		try {
			return position + add;
		} finally {
			labels.put(label++, position + add);
		}
	}
	public int getLabel() {
		return position;
	}
	public CompileContext getContext() {
		return null;
	}
}
