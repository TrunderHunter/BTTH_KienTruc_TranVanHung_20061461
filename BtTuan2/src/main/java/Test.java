import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        ParseResult<CompilationUnit> result = null;
        FileInputStream in = new FileInputStream("C:\\Users\\User\\Desktop\\JavaParser\\src\\main\\java\\Test.java");
        try {
            JavaParser javaParser = new JavaParser();
            result = javaParser.parse(in);
            Optional<CompilationUnit> cu = result.getResult();
            if (cu.isPresent()) {
                getFields(cu.get());
                System.out.println("=====================================");
                getMethods(cu.get());
                System.out.println("=====================================");
                getClasses(cu.get());
                System.out.println("=====================================");
                getImports(cu.get());
            }
        } finally {
            in.close();
        }
    }

    public static void getFields(CompilationUnit cu) {
        cu.findAll(FieldDeclaration.class).forEach(fd -> {
            System.out.println(fd.getVariables().get(0).getName());
        });
    }

    public static void getMethods(CompilationUnit cu) {
        cu.findAll(MethodDeclaration.class).forEach(md -> {
            System.out.println(md.getName());
        });
    }

    public static void getClasses(CompilationUnit cu) {
        cu.getClassByName("Test").ifPresent(c -> {
            System.out.println(c.getName());
        });
    }

    public static void getImports(CompilationUnit cu) {
        cu.getImports().forEach(i -> {
            System.out.println(i.getNameAsString());
        });
    }
}
