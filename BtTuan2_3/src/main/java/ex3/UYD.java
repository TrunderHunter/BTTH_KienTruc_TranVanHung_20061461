package ex3;

import java.io.OutputStream;

public class UYD {
    public static void main(String[] args) throws Exception {
        String cmd = "java -cp target/classes E:\\ProjectBtTuan3\\text.txt";
        Process p = Runtime.getRuntime().exec(cmd);
        OutputStream os = p.getOutputStream();
        os.write("Thực Hành bài tập thực hành 3".getBytes());
        os.flush();
        os.close();
        p.waitFor();
        System.out.println(p.exitValue());

    }
}
