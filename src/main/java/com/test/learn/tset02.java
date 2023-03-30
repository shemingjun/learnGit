package com.test.learn;

/**
 * @author smj
 * @Title: tset02
 * @ProjectName learnGit
 * @packageName com.test.learn
 * @date 2023/2/20 8:58
 */

public class tset02 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        try {
            int result = 1/0;
            return  0;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;
        } finally {
            System.out.println("finally");
        }
    }
}
