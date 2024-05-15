package com.btth_tuan4;

public class VoidVisitorAdapter<T> {
    public void visit(PackageDeclaration n, T arg) {
        super.visit(n, arg);
        System.out.println(n.getNameAsString());
    }

    public void visit(FieldDeclaration n, T arg) {
        super.visit(n, arg);
        System.out.println(" [L " + n.getBegin() + "]" + n);
    }

    public void visit(MethodDeclaration n, T arg) {
        super.visit(n, arg);
        System.out.println(" [L " + n.getBegin() + "]" + n.getDeclarationAsString());
    }

    protected void visit(T n, T arg) {
    }
}
