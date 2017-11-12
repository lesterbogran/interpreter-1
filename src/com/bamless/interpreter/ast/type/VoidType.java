package com.bamless.interpreter.ast.type;

public class VoidType extends Type {

	@Override
	public Type plus(Type other) {
		return null;
	}

	@Override
	public Type minus(Type other) {
		return null;
	}

	@Override
	public Type mul(Type other) {
		return null;
	}

	@Override
	public Type div(Type other) {
		return null;
	}

	@Override
	public Type modulus(Type other) {
		return null;
	}

	@Override
	public Type logicalOp(Type other) {
		return null;
	}

	@Override
	public Type relationalOp(Type other) {
		return null;
	}

	@Override
	public Type equalityOp(Type other) {
		return null;
	}

	@Override
	public boolean canAssign(Type other) {
		return other == Type.VOID;
	}

	@Override
	public boolean isArray() {
		return false;
	}

	@Override
	public String toString() {
		return "VOID";
	}

}
