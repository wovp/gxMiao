package com.gx.gxmiao.utils;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 拆红包的算法工具类
 * 拆红包的算法--->二倍均值算法
 */
public class RedPackageUtil {

    /**
     * 拆红包的算法--->二倍均值算法
     *
     * @param totalMoney
     * @param redPackageNumber
     * @return
     */
    public static BigDecimal[] splitRedPackageAlgorithm(BigDecimal totalMoney, int redPackageNumber) {
        BigDecimal[] redPackageAmounts = new BigDecimal[redPackageNumber];
        // 已经被抢夺的红包金额，已经被拆分塞进子红包的金额
        BigDecimal useMoney = BigDecimal.ZERO;

        for (int i = 0; i < redPackageNumber; i++) {
            if (i == redPackageNumber - 1) {
                redPackageAmounts[i] = totalMoney.subtract(useMoney);
            } else {
                // 二倍均值算法，每次拆分后塞进子红包的金额 = 随机区间(0, (剩余红包金额M ÷ 未被抢的剩余红包个数N) * 2)
                BigDecimal avgMoney = totalMoney.subtract(useMoney)
                        .divide(BigDecimal.valueOf(redPackageNumber - i), 2, BigDecimal.ROUND_HALF_UP)
                        .multiply(BigDecimal.valueOf(2));
                BigDecimal random = BigDecimal.valueOf(0.01)
                        .add(avgMoney.subtract(BigDecimal.valueOf(0.01))
                                .multiply(BigDecimal.valueOf(new Random().nextDouble()))).setScale(2, BigDecimal.ROUND_HALF_UP); // 设置小数位数为2
                redPackageAmounts[i] = random;
            }
            useMoney = useMoney.add(redPackageAmounts[i]);
        }
        return redPackageAmounts;
    }

    public static void main(String[] args) {
        BigDecimal[] redPackages = splitRedPackageAlgorithm(BigDecimal.valueOf(100), 5);
        for (BigDecimal amount : redPackages) {
            System.out.println(amount);
        }
    }
}