package ex3;

import ex3.entity.Account;

import java.lang.reflect.Method;

public class TestRef {
    public static void main(String[] args) throws Exception {
        Account account = new Account();
//        Class<? extends Account> cls = account.getClass();

        Class<?> clz = Class.forName("ex3.entity.Account");

        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+ " " + method.getReturnType());
        }
    }

    public void getFields() {
        Account account = new Account();
        Class<? extends Account> cls = account.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+ " " + method.getReturnType());
        }
    }

    public void getMethods() {
        Account account = new Account();
        Class<? extends Account> cls = account.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+ " " + method.getReturnType());
        }
    }

    public void getClasses() {
        Account account = new Account();
        Class<? extends Account> cls = account.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+ " " + method.getReturnType());
        }
    }
}
