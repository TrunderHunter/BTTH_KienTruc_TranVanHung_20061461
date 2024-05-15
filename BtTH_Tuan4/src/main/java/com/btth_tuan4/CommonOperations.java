package com.btth_tuan4;

import ch.qos.logback.core.pattern.parser.Parser;
import org.apache.logging.log4j.util.Strings;

import java.io.File;

public class CommonOperations {
    public static void listMethodCalls(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                Parser<Object> StaticJavaParser = null;
                new VoidVisitorAdapter<Object>() {
                    class MethodDeclaration {
                    }

                    @Override
                    public void visit(PackageDeclaration n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(n.getNameAsString());
                    }

                    @Override
                    public void visit(FieldDeclaration n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(" [L " + n.getBegin() + "]" + n);
                    }

                    @Override
                    public void visit(MethodDeclaration n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(" [L " + n.getBegin() + "]" + n.getDeclarationAsString());
                    }
                }.visit(StaticJavaParser.parse(file), null);
            } catch (Exception e) {
                new RuntimeException(e);
            }
        }).explore(projectDir);
    }
}
