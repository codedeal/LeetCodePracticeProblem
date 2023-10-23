package org.practiceproblem;

import java.util.*;

public class BasicProblems
{
    public float multiplyFloat(float f1,float f2)
    {
       return f1*f2;
    }

    public void swapTwoNumber(int a, int b)
    {
        int c = 0;
        a=c;
        b=a;
        b=c;
    }


    public static String addTwoBinary(String a, String b) {
        int n1= Integer.parseInt(a,2);
        int n2=Integer.parseInt(b,2);
        return Integer.toBinaryString(n1+n2);
    }
    public static int largestNumberAmongThree(int a,int b, int c)
    {
        if(a>b&&a>c)
            return a;
        else if(b>a&&b>c)
            return c;
        else
            return c;

    }
    public static void printAllPrime(int n)
    {
        for(int i=2;i<=n;i++)
        {
            boolean isPrime=true;
            for(int j=2;j<=Math.sqrt(i);j++)
            {
                if(i%j==0)
                {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime)
                System.out.println(i+" ");
        }

    }
    public static boolean isLeapYear(int year)
    {
       if(year%400==0&&year%100==0)
           return true;
       else if (year%4==0&&year%100!=0) {
           return true;

       }else {
           return false;
       }
    }

    public static void isArmstrong(int num)
    {
        int sum=0;
        while (num>0)
        {
            int digit=num%10;
            sum+= Math.pow(digit,3);
            num=num/10;


        }


        System.out.println(sum);

    }

    public static int printFactorial(int n)
    {
        if(n==0||n==1)
            return 1;

        return n*printFactorial(n-1);

    }

    public  static int findmissingNumberfromListofNumber(int num[])
    {
        int n=num.length+1;
        System.out.println(n);
        int sum = (n*(n+1))/2;

        int sumOfNumbers = 0;
        for (int number : num) {
            sumOfNumbers += number;
        }
        return sum-sumOfNumbers;

    }

    public static String replaceCharAtSpecificIndex(String str,char ch, int index)
    {
        return str.substring(0,index)+ch+str.substring(index+1);
    }

    public  static int[] reverseArray(int arr[],int N)
    {
     for(int i=0;i<arr.length;i+=N)
     {
         int left=i;
         int right=Math.min(i+N-1,arr.length-1);
         while (left<right)
         {
             int temp=arr[left];
             arr[left]=arr[right];
             arr[right]=temp;
             left++;
             right--;
         }

     }
     return arr;
    }

    public static int[] rotate(int nums[],int k)
    {
        int n=nums.length;
        k=k%n;
        //Reveres the entire array
        reverse(nums,0,n-1);

        //Reverse the first k element
        reverse(nums,0,k-1);

        //Reverse the element after k
        reverse(nums,k,n-1);

        System.out.println(Arrays.toString(nums));
        return nums;
    }
    private static void reverse(int[] nums, int start, int end)
    {
        while (start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public static boolean isPangram(String str)
    {
        boolean []alphabet= new boolean[26];
        str=str.toLowerCase();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch>='a'&&ch<='z')
                alphabet[ch-'a']=true;

        }
        for (boolean letter:alphabet)
        {
            if(!letter)
                return false;


        }
        return true;
    }

    public static String integerToRoman(int num)
    {
        String[] romanNums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb= new StringBuilder();
         int i=0;
         while(num>0)
         {
             if(num-values[i]>=0) {
                 sb.append(romanNums[i]);
                 num=num-values[i];
             }
             else
             {
                 i++;
             }

         }

         return sb.toString();
    }

    public static String IntegerToRoman(int num)
    {
        String romanNums[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (num>0)
        {
            if(num-values[i]>=0)
            {
                sb.append(romanNums[i]);
                num=num-values[i];
            }
            else
            {
                i++;
            }
        }
         return sb.toString();
    }
    public static void RomanToInteger(String s)
    {
        Map<Character,Integer>map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int prevValue=0;
        int result=0;

        for(int i=s.length()-1;i>=0;i--)
        {
            int currentValue= map.get(s.charAt(i));
            if(currentValue<prevValue)
            {
                result=result-currentValue;
            }else
            {
                result=result+currentValue;
            };
            prevValue=currentValue;
        }

        System.out.println(result);
    }
    public void bestTimToSellStock(int prices[])
    {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int price:prices)
        {
            minPrice=Math.min(minPrice,price);
            maxProfit=Math.max(maxProfit,price-minPrice);
        }
        System.out.println(maxProfit);
    }

    public static void permutateString(String str,int left,int right)
    {
        if(left==right)
            System.out.println(str);
        else
        {
            for (int i=0;i<=right;i++)
            {
                str=swap(str,left,i);
                permutateString(str,left+1,right);
                str=swap(str,left,i);
            }

        }
    }

    private static String swap(String str, int left, int i)
    {
        char temp;
        char []arr=str.toCharArray();
        temp=arr[left];
        arr[left]=arr[i];
        arr[i]=temp;

        return String.valueOf(arr);

    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void SeperateStringFromNumAndSum(String s)
    {
        int sum=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)))
                sb.append(s.charAt(i));
            else
            {
                if(sb.length()>0)
                {
                    sum=sum+Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if(sb.length()>0)
        {
            sum=sum+Integer.parseInt(sb.toString());

        }
        System.out.println(sum);
    }
    public static String LongestCommonPrfix(String str[])
    {
        if(str==null||str.length==0)
            return "";
        String prefix=str[0];
        for (int i=1;i<str.length;i++)
        {
            while (str[i].indexOf(prefix)!=0)
            {
                prefix=prefix.substring(0,prefix.length()-1);
                System.out.println("truncated prefix "+ prefix);
                if(prefix.isEmpty())
                    return "";
            }
        }
      return prefix;
    }
    public static int StairCaseClimbing(int n)
    {
        if(n<2)
            return n;
        int dp[]= new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i< dp.length;i++)
            dp[i]=dp[i-1]+dp[i-2];

        return dp[n];
    }
    public static int findPeakElement(int arr[])
    {
        int left=0;int right=arr.length-1;
        while (left<right)
        {
            int mid=(left+right)/2;
            if(arr[mid]<arr[mid+1])
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }




    public static void lengthOfLongestSubstringWithoutRepetation(String s)
    {
        int n = s.length();
        int i = 0, j = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (i < n && j < n) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        System.out.println(maxLength);
    }

    public static int findNumberOfTrailingZeroInNFactorial(int n)
    {
        int count =0;
        while (n>0)
        {
            n=n/5;
            count+=n;
        }


        return count;
    }

    public static int findMajorityElement(int arr[])
    {
        int count=0;
        int majority=0;
        for (int i:arr)
        {
            if(count==0)
            {
                majority=i;
                count=1;
                continue;

            }
            count=(i==majority)?count+1:count-1;
        }
        return majority;
    }


    public static int[] removeDuplicates(int[] nums)
    {
         int n=nums.length;
         for(int i=0;i<n;i++)
         {
             for(int j=i+1;j<nums.length;j++)
             {
                 if(nums[i]==nums[j])
                 {
                     for(int k=j;k<n-1;k++)
                     {
                         nums[k]=nums[k+1];
                     }
                     n--;
                     j--;
                 }
             }
         }
      return Arrays.copyOf(nums,n);
    }

    public static int maximumSubArray(int[] arr)
    {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for (int i:arr)
        {
               sum=Math.max(sum,0)+i;
               maxSum=Math.max(maxSum,sum);
        }
      return maxSum;
    }

    public static int lengthOflasWordOfString(String s)
    {
        int i=s.length()-1; int length=0;
        while (i>=0&&s.charAt(i)==' ') i--;
        while (i>=0&&s.charAt(i)!=' ')
        {
            length++;
            i--;
        }
        return length;
    }
    public static int findCeling(int arr[],int val)
    {
         Arrays.sort(arr);
         int left=0;
         int result=-1;
         int right=arr.length-1;
         while (left<=right)
         {
             int mid=left+(right-left)/2;
             System.out.println(mid);

             if(arr[mid]==val)
                 return arr[mid];
             else if (arr[mid]>val)
             {
                 result=arr[mid];
                 right=mid-1;
             }
             else
             {
                 left=mid+1;
             }

         }
         return result;
    }

    public static void findPairs(int []arr,int key)
    {
        Set<Integer>set = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            int complement=key-arr[i];
            if(set.contains(complement))
            {
                System.out.println("("+arr[i]+","+complement+")");
            }

            set.add(arr[i]);
            set.forEach(x-> System.out.print(x+"  "));
        }


    }

    public  boolean findMountainArray(int []arr)
    {
        // Valid Mountain Array
        //https://leetcode.com/problems/valid-mountain-array/description/
        int n=arr.length;
        int i=0;
        int j=n-1;
        while (i+1<n&&arr[i]<arr[i+1])i++;
        while (j>0&&arr[j-1]>arr[j]) j--;

        return i>0&&i==j&&j<n-1;

    }

    public static void moveAllNegativeNumberToStart(int []arr)
    {
        int i=0;
        int j=arr.length-1;
        while (i<=j)
        {
            if(arr[i]<0)
                i++;
            else if (arr[j]>=0)
                      j--;
                 else
            {
                int temp=arr[j];
                 arr[j]=arr[i];
                 arr[i]=temp;
                i++;j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void findSmallerNumberToLeftOFArray(int[] arr)
    {
        //https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/

        int result[]= new int[arr.length];
        Stack<Integer> stack= new Stack();
        for (int i=0;i<arr.length;i++)
        {
            while (!stack.isEmpty() && stack.peek()>arr[i])
                stack.pop();
            if(stack.isEmpty())
                result[i]=-1;
            else
                result[i]=stack.peek();

            stack.push(arr[i]);

        }
        System.out.println(Arrays.toString(result));
    }


    public static void main(String[] args) {

        System.out.println("MAJ -----"+findMajorityElement(new int []{3,2,3,2,3,2}));
        System.out.println("MAJ -----"+findMajorityElement(new int []{1, 2, 2, 2, 3, 4, 2}));
        int[] arr1 = {1, 2, 2, 2, 3, 4, 2};
        System.out.println(findMajorityElement(arr1)); // expected output: 2

        int[] arr2 = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(findMajorityElement(arr2)); // expected output: 2

        int[] arr3 = {1, 1, 1, 2, 2};
        System.out.println(findMajorityElement(arr3)); // expected output: 1

        int[] arr4 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(findMajorityElement(arr4)); // expected output: 4

        int[] arr5 = {1, 2, 3};
        System.out.println(findMajorityElement(arr5)); // expected output: -1
        System.out.println(Arrays.toString(reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8},3)));


        System.out.println(  isLeapYear(1904));
       // System.out.println( addTwoBinary("011","100"));

       // printAllPrime(5);
    /*   isArmstrong(153);

        System.out.println(printFactorial(5));
        System.out.println(findmissingNumberfromListofNumber(new int[]{1,2,3,4,5,6,8}));
        System.out.println(replaceCharAtSpecificIndex("Alpha",'f',2));
        System.out.println(replaceCharAtSpecificIndex("Games of Brones",'T',9));

        System.out.println(isPangram("Abcdefghijklmnopqrstuvwxyz"));
        System.out.println(IntegerToRoman(3990));
        RomanToInteger("MMMCMXC");
        permutateString("ABC",0,2);
        permutateString("ABCD",0,3);
        System.out.println(isBalanced("(({}))"));
        SeperateStringFromNumAndSum("abc25def15gh10");
        System.out.println(LongestCommonPrfix(new String[]{"flower","flow","flight"}));
        System.out.println(StairCaseClimbing(5));
        System.out.println(findPeakElement(new int[]{3,4,7,6,6,8}));*/
        System.out.println(isLeapYear(1800));
        lengthOfLongestSubstringWithoutRepetation("abcddabcd");
        System.out.println(findNumberOfTrailingZeroInNFactorial(10));

        System.out.println(lengthOflasWordOfString("Hello World"));
        System.out.println(lengthOflasWordOfString("Hi pop papa"));
        System.out.println(findCeling(new int[]{2,5,8,1,3,7},9));
        findPairs(new int[]{1,2,5,4,3},9);
      //  System.out.println(removeDuplicateFromSortedArrayTwoPointerApproach(new int[]{2,3,3,4,5,5}));
      //  removeDuplicates(new int[]{1,2,2,3,4,4});
        moveAllNegativeNumberToStart(new int []{-1,3,4,-5,6,-7,-8});
        findSmallerNumberToLeftOFArray(new int[]{1,6,4,10,2,5});
    }

}
