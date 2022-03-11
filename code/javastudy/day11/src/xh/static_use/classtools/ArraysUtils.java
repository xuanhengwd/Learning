package xh.static_use.classtools;

public class ArraysUtils {
    public static String toString(int arr[]){
        if(arr==null)
        {
            return null;
        }
        String s="";
        s+="[";
//        System.out.print("[");
        for(int i=0;i<arr.length;i++)
        {
            if(i==arr.length-1)
            {
                s+=arr[i];
//                System.out.print(arr[i]);
            }

            else{
                s+=(arr[i]+",");
//                System.out.print(arr[i]+",");
            }

        }
        s+="]";
//        System.out.print("]");
        return s;
    }

    public static double getAerage(double arr[])
    {
        if(arr.length<=0)
        {
            return 0;
        }
        double maxnum=arr[0];
        double minnum=arr[0];
        double aer=0;
        double sum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>maxnum){
                maxnum=arr[i];
            }
            if(arr[i]<minnum)
            {
                minnum=arr[i];
            }

            sum+=arr[i];
        }
        aer=(sum-maxnum-minnum)/(arr.length-2);
        return aer;

    }
}
