package xh.com_api.system;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SystemDemo {
    public static void main(String[] args) {

        long starttime=System.currentTimeMillis();
        System.out.println(starttime);

        int[] a={1,2,3,4,5};
        int[] b=new int[5];
        System.arraycopy(a,0,b,2,3);
        System.out.println(Arrays.toString(b));

        long endtime=System.currentTimeMillis();
        System.out.println(endtime);

        for (int i=0;i<10000000;i++)
        {
            int a2=i+i;
        }

        double time=(endtime-starttime)/1000.0;
        System.out.println(time+"s");

    }
}
