public class RevisionTest
{
    public static void isPrime(int n)
    {
       for(int i=2;i<n;i++)
       {
           boolean isPrime=true;
           for(int j=2;j<=Math.sqrt(i);j++)
           {
               if(i%j==0)
               {
                   isPrime=false;
                   continue;
               }


           }
           if(isPrime)
               System.out.print(" "+i+" ");

       }
    }
    public static void commonElemntBetweenThreeArray(int arr1[],int arr2[],int arr3[])
    {

    }
    public static void main(String[] args) {
         isPrime(15);
    }
}
