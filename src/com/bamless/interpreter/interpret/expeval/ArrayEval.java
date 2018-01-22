package com.bamless.interpreter.interpret.expeval;

import com.bamless.interpreter.ast.expression.ArrayAccess;
import com.bamless.interpreter.ast.expression.AssignExpression;
import com.bamless.interpreter.ast.expression.FuncCallExpression;
import com.bamless.interpreter.ast.expression.Lvalue;
import com.bamless.interpreter.ast.expression.VarLiteral;
import com.bamless.interpreter.interpret.Interpreter;
import com.bamless.interpreter.interpret.memenv.Array;
import com.bamless.interpreter.interpret.memenv.MemoryEnvironment.Frame;
import com.bamless.interpreter.visitor.VisitorAdapter;

public class ArrayEval extends VisitorAdapter<Array, Frame> {
	private Interpreter interpreter;
	
	public ArrayEval(Interpreter interpreter) {
		this.interpreter = interpreter;
	}
	
	@Override
	public Array visit(VarLiteral v, Frame frame) {
		return frame.<Array>retrieve(v);
	}
	
	@Override
	public Array visit(ArrayAccess a, Frame frame) {
		return frame.<Array>retrieve(a);
	}
	
	@Override
	public Array visit(AssignExpression e, Frame frame) {
		Array res = e.getExpression().accept(this, frame);
		frame.set((Lvalue) e.getLvalue(), res);
		return res;
	}
	
	@Override
	public Array visit(FuncCallExpression f, Frame frame) {
		interpreter.callFunction(f);
		return frame.<Array>getReturnRegister();
	}

}