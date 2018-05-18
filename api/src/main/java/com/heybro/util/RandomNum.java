package com.heybro.util;

import java.util.Random;

/**
 * 随机数
 */
public class RandomNum {

    /**
     * 随机6位数字
     *
     * @return
     */
    public static int getRandNum(int num) {
       Random random = new Random();
       String result = "";
       for (int i = 0; i < num; i++) {
           if(i == 0){
               result += String.valueOf(random.nextInt(9)+1);
           }else{
               result += String.valueOf(random.nextInt(10));
           }
           System.out.println(result);
       }

       return Integer.valueOf(result);
    }


    public static void main(String arg[]){
        System.out.println(RandomNum.getRandNum(6));
    }
}
