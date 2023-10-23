package org.revise0203;

public class Revise04
{
    public static void primeNumber(int n)
    {
        boolean isPrime=true;
        for(int i=2;i<n;i++)
        {

            for(int j=2;j<Math.sqrt(i);j++)
            {
                if(i%2==0)
                {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime)
                System.out.print(" "+i);
        }
    }
    public static void missingNumber(int arr[])
    {
        int n=arr.length+1;
        int sum=n*(n+1)/2;
        int totalSum=0;
        for (int i: arr)
        {
         totalSum+=i;
        }
        System.out.println(sum-totalSum);
    }
    public static void integerToRoman(int num)
    {
        String[]romanValue={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (num>0)
        {
            if(num-values[i]>=0)
            {
                sb.append(romanValue[i]);
                num=num-values[i];

            }
            else
            {
                i++;
            }
        }
        System.out.println(sb.toString());
    }
    public static void bestTimeToSellStock(int[]prices)
    {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int price:prices)
        {
            minPrice=Math.min(price,minPrice);
            maxProfit=Math.max(price,price-minPrice);

        }
        System.out.println(maxProfit);
    }
    public static void seprateIntAndSum(String str)
    {
        StringBuilder stringBuilder= new StringBuilder();
        int sum=0;
        for(int i=0;i<str.length();i++)
        {
            char c =str.charAt(i);
            if(Character.isDigit(c))
            {
                stringBuilder.append(c);
            }
            else {
                if(stringBuilder.length()>0)
                {
                    sum+=Integer.parseInt(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
            }
        }
        if(stringBuilder.length()>0) {
            sum += Integer.parseInt(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        primeNumber(10);
        missingNumber(new int[]{1,2,3,4,5,6,8});
        integerToRoman(978);
        seprateIntAndSum("Ap3p4le56pq9");
    }
}
