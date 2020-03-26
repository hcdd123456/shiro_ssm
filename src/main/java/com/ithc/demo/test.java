package com.ithc.demo;
import java.util.Random;
import java.util.Scanner;

public class test {


    static Scanner in1 = new Scanner(System.in);
    static final double contentionPeriod =in1.nextDouble();

    public static void main(String[] args) {

        System.out.println("***二进制退避指数算法演示***");
        int k = 0; // 用以表示重传的次数

        Scanner in=new Scanner(System.in);
        System.out.print("请输入冲突次数：");
        int stop=in.nextInt();//用以暂停重传

        int p = 56; // 用于自己设置发生碰撞的概率

        double sum=0,n;
        if(args.length>0)
        {
            p= Integer.parseInt(args[0]);
        }
        System.out.println("每次传送发生碰撞的概率为p%,请输入p的值" + "(范围为0到100之间的整数）："+p);
        System.out.println();
        while (true) {
            if(getRand(1,100)<=p) //如果发生碰撞，其概率为p%
            {
                k++;
                if(k==stop+1){
                    k=k-1;
                    System.out.println("传送成功！！共重传" + k + "次。");
                    break;
                }
                if (k <= 16) // 最大重传送次数为16
                {

                    System.out.println("***发生碰撞!" + "准备进行第" + k + "次重传！***");
//                    resend(k);
                    n=resend(k);
                    sum=sum+n;
                    if(k==stop){
                    System.out.println("冲突后等待时间:"+sum);}
                    continue;
                }
                if (k > 16) {
                    System.out.println("重传16次仍未成功，丢弃本帧，向高层报告！");
                    break;
                }

            }

//            if(getRand(1,100)>p) //如果没有发生碰撞，其概率为1-p%
//            {
//                System.out.println("本次未发生碰撞，传送成功！！共重传" + k + "次。");
//                break;
//            }
        }
    }

    static int getRand(int min, int max) // 得到min到max之间的一个随机数
    {
        int r ;
        Random random = new Random();
        r=random.nextInt(max-min+1)+min;
        return r ;
    }

    static int twoPowerK(int k) // 二的k次幂
    {
        int a = 2;
        int f = 1;
        for(int i = k ; i>0 ;i --)
        { f *= a; }
        return f;
    }

      static double resend(int i) {
        // 第i次重传操作，计算重传退避时间，等待后重传(具休实现未定义，仅用于演示，显示退避时间)
        int r = 0 , max = 0;
        double backTime;
        System.out.println("开始退避操作！");
        if (i <= 10)
            max = twoPowerK(i) - 1;
        if (i > 10)
        {
            System.out.println("重传次数超过10，从10截止。");
            max = twoPowerK(10) - 1;
        }
        System.out.println("随机数范围:"+"0到"+max);
        r=getRand(0,max);
        System.out.println("得到的随机数r为:"+r);
        backTime = r * contentionPeriod;
        System.out.println("退避时间为:"+"51.2*"+r+"="+backTime+"微秒");
        try {
            Thread.sleep((long)(backTime/1000)); //暂停200毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退避完成，开始重传！");
        System.out.println();
        return backTime;
    }
}