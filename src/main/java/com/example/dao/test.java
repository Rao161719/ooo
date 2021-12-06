package com.example.dao;


public class test {
    public static void main(String[] args) {
        /*DaoTestImpl dao = new DaoTestImpl();
        List stu = dao.getStudent();
        System.out.println(stu);*/

        tt t = new tt(20);
        System.out.println("和是："+add(10));
        System.out.println("引用是:"+and(t));
    }
    /*当try里有return时,会执行return后的代码,如果没有finally会直接结束函数
    * 如果有finally:因为finally里的代码一定会执行,会将return的值缓存起来,
    * 然后去执行finally代码块里的代码
    * 注意:当finally里对return的结果进行修改时:
    *   1.基本类型:不会被改变
    *   2.引用类型:值会被改变*/
    private static tt and(tt t) {
        try {
            return t;
        } catch (Exception e) {
            System.out.println("Catch 语句块");
        } finally {
            System.out.println("finally 语句块");
            t.setA(30);
        }
        return null;
    }
    public static int add(int a) {
        try {
            return a;
        } catch (Exception e) {
            System.out.println("Catch 语句块");
        } finally {
            System.out.println("finally 语句块");
            a+=1;
        }
        return 0;
    }
}
class tt{
    private int a;

    public tt(int a) {
        this.a = a;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    @Override
    public String toString() {
        return "tt{" +
                "a=" + a +
                '}';
    }
}