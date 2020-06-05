package com.atguigu.dynamic;

/**
 * 没懂！！！！！！！！！！！！！！！！
 * Created by ChengQian on 2020/6/4 16:33
 */
public class KnapsckProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500,3000,2000};//物品的价值 val[i]
        int m = 4;//背包的容量
        int n = val.length;//物品的个数

        //创建二维数组
        //v[i][j] 表示在前i个物品中能够转入容量为j的背包中的最大价值
        int[][] v = new int[n+1][m+1];
        //记录放入商品放入情况 第一一个二维数组
        int[][] path = new int[n+1][m+1];

        //初始化第一行和第一列 这里再本程序中 可以不去处理，因为默认就是0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0; //将第一列设置为0
        }
        for(int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//将第一行设置0
        }

        //根据前面的公式来动态规划处理
        for (int i = 1; i < v.length; i++) { //不处理第一行 i是1开始的
            for (int j = 1; j < v[0].length; j++) { //不处理第一列 j是从1开始的
                //公式
                if (w[i - 1] > j) {//程序i 是从1开始的 原来公式中w[i] 修改成w[i - 1]
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存到背包的情况下 我们不能直接使用上面的公式 需要使用if-else来体现公式
                    if ((v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]])) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //当前情况记录放到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出一下V 看看目前的情况
        for (int k = 0; k < v.length; k++) {
            for (int j = 0; j < v[k].length; j++) {
                System.out.print(v[k][j] + " ");
            }
            System.out.println();
        }

        //遍历path
/*        for (int i = 0; i < path.length; i++) {
            for(int j = 0; j < path[i].length; j++) {
//                if (path[i])
                System.out.printf("第%d个商品放入到背包\n",i);
            }
        }*/
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1; //列的最大下标
        while(i > 0 && j > 0) {
            if (path[i][j] == 1){
                System.out.printf("第%d个商品放入到背包\n",i);
                j -= w[i-1];
            }
            i--;
        }
    }
}