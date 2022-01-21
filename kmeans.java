

import java.util.*;
class kmeans
{
    static int count1,count2,count3,count4,count5,count6,count7,count8;
    static int d1[],d2[];
    static int k1[][],k2[][];
    static int tempk1[][],tempk2[][];
    static double m1[],m2[];
    static double diff1[],diff2[];
    static int n1,p1,n2,p2;

    static int cal_diff1(int a) // This method will determine the cluster in which an element go at a particular step.
    {
        int temp1=0;
        for(int i=0;i<p1;++i)
        {
            if(a>m1[i])
                diff1[i]=a-m1[i];
            else
                diff1[i]=m1[i]-a;
        }
        int val=0;
        double temp=diff1[0];
        for(int i=0;i<p1;++i)
        {
            if(diff1[i]<temp)
            {
                temp=diff1[i];
                val=i;
            }
        }//end of for loop
        return val;
    }

    static int cal_diff2(int a) // This method will determine the cluster in which an element go at a particular step.
    {
        int temp1=0;
        for(int i=0;i<p2;++i)
        {
            if(a>m2[i])
                diff2[i]=a-m2[i];
            else
                diff2[i]=m2[i]-a;
        }
        int val=0;
        double temp=diff2[0];
        for(int i=0;i<p2;++i)
        {
            if(diff2[i]<temp)
            {
                temp=diff2[i];
                val=i;
            }
        }//end of for loop
        return val;
    }

    static void cal_mean1() // This method will determine intermediate mean values
    {
        for(int i=0;i<p1;++i)
            m1[i]=0; // initializing means to 0
        int cnt=0;
        for(int i=0;i<p1;++i)
        {
            cnt=0;
            for(int j=0;j<n1-1;++j)
            {
                if(k1[i][j]!=-1)
                {
                    m1[i]+=k1[i][j];
                    ++cnt;
                }}
            m1[i]=m1[i]/cnt;
        }
    }


    static void cal_mean2() // This method will determine intermediate mean values
    {
        for(int i=0;i<p2;++i)
            m2[i]=0; // initializing means to 0
        int cnt=0;
        for(int i=0;i<p2;++i)
        {
            cnt=0;
            for(int j=0;j<n2-1;++j)
            {
                if(k2[i][j]!=-1)
                {
                    m2[i]+=k2[i][j];
                    ++cnt;
                }}
            m2[i]=m2[i]/cnt;
        }
    }

    static int check1() // This checks if previous k ie. tempk and current k are same.Used as terminating case.
    {
        for(int i=0;i<p1;++i)
            for(int j=0;j<n1;++j)
                if(tempk1[i][j]!=k1[i][j])
                {
                    return 0;
                }
        return 1;
    }

    static int check2() // This checks if previous k ie. tempk and current k are same.Used as terminating case.
    {
        for(int i=0;i<p2;++i)
            for(int j=0;j<n2;++j)
                if(tempk2[i][j]!=k2[i][j])
                {
                    return 0;
                }
        return 1;
    }

    public static void main(String args[])
    {
        Scanner scr=new Scanner(System.in);
        /* Accepting number of elements */
        System.out.println("Enter the number of elements ");
        n1=scr.nextInt();
        d1=new int[n1];
        /* Accepting elements */
        System.out.println("Enter "+n1+" elements: ");
        for(int i=0;i<n1;++i)
            d1[i]=scr.nextInt();
        /* Accepting num of clusters */
        System.out.println("Enter the number of clusters: ");
        p1=scr.nextInt();
        /* Initialising arrays */
        k1=new int[p1][n1];
        tempk1=new int[p1][n1];
        m1=new double[p1];
        diff1=new double[p1];
        /* Initializing m */
        for(int i=0;i<p1;++i)
            m1[i]=d1[i];

        int temp1=0;
        int flag1=0;
        do
        {
            for(int i=0;i<p1;++i)
                for(int j=0;j<n1;++j)
                {
                    k1[i][j]=-1;
                }
            for(int i=0;i<n1;++i) // for loop will cal cal_diff(int) for every element.
            {
                temp1=cal_diff1(d1[i]);
                if(temp1==0)
                    k1[temp1][count1++]=d1[i];
                else if(temp1==1)
                    k1[temp1][count2++]=d1[i];
                else if(temp1==2)
                    k1[temp1][count3++]=d1[i];
/* else if(temp1==3)
k1[temp1][count4++]=d1[i];
else if(temp1==4)
k1[temp1][count5++]=d1[i]; */
            }
            cal_mean1(); // call to method which will calculate mean at this step.
            flag1=check1(); // check if terminating condition is satisfied.
            if(flag1!=1)
                /*Take backup of k in tempk so that you can check for equivalence in next step*/
                for(int i=0;i<p1;++i)
                    for(int j=0;j<n1;++j)
                        tempk1[i][j]=k1[i][j];
          //  System.out.println("\n\nAt this step");
            System.out.println("\nValue of clusters");
            for(int i=0;i<p1;++i)
            {
                System.out.print("K"+(i+1)+"{ ");
                for(int j=0;k1[i][j]!=-1 && j<n1-1;++j)
                    System.out.print(k1[i][j]+" ");
                System.out.println("}");
            }//end of for loop
            System.out.println("\nValue of m ");
            for(int i=0;i<p1;++i)
                System.out.print("m"+(i+1)+"="+m1[i]+"  ");

            count1=0;count2=0;count3=0;//count4=0;count5=0;
        }
        while(flag1==0);

        System.out.println("\n\n\nThe Final Clusters By Kmeans are as follows: ");
        for(int i=0;i<p1;++i)
        {
            System.out.print("K"+(i+1)+"{ ");
            for(int j=0;k1[i][j]!=-1 && j<n1-1;++j)
                System.out.print(k1[i][j]+" ");
            System.out.println("}");

        }


        /* Accepting number of elements */
        System.out.println("Enter the number of elements ");
        n2=scr.nextInt();
        d2=new int[n2];
        /* Accepting elements */
        System.out.println("Enter "+n2+" elements: ");
        for(int i=0;i<n2;++i)
            d2[i]=scr.nextInt();
        /* Accepting num of clusters */
        System.out.println("Enter the number of clusters: ");
        p2=scr.nextInt();
        /* Initialising arrays */
        k2=new int[p2][n2];
        tempk2=new int[p2][n2];
        m2=new double[p2];
        diff2=new double[p2];
        /* Initializing m */
        for(int i=0;i<p2;++i)
            m2[i]=d2[i];

        int temp2=0;
        int flag2=0;
        do
        {
            for(int i=0;i<p2;++i)
                for(int j=0;j<n2;++j)
                {
                    k2[i][j]=-1;
                }
            for(int i=0;i<n2;++i) // for loop will cal cal_diff(int) for every element.
            {
                temp2=cal_diff2(d2[i]);
                if(temp2==0)
                    k2[temp2][count4++]=d2[i];
                else if(temp2==1)
                    k2[temp2][count5++]=d2[i];
                else if(temp2==2)
                    k2[temp2][count6++]=d2[i];
                else if(temp2==3)
                    k2[temp2][count7++]=d2[i];
                else if(temp2==4)
                    k2[temp2][count8++]=d2[i];
            }
            cal_mean2(); // call to method which will calculate mean at this step.
            flag2=check2(); // check if terminating condition is satisfied.
            if(flag2!=1)
                /*Take backup of k in tempk so that you can check for equivalence in next step*/
                for(int i=0;i<p2;++i)
                    for(int j=0;j<n2;++j)
                        tempk2[i][j]=k2[i][j];
            System.out.println("\n\nAt this step");
            System.out.println("\nValue of clusters");
            for(int i=0;i<p2;++i)
            {
                System.out.print("K"+(i+1)+"{ ");
                for(int j=0;k2[i][j]!=-1 && j<n2-1;++j)
                    System.out.print(k2[i][j]+" ");
                System.out.println("}");
            }//end of for loop
            System.out.println("\nValue of m ");
            for(int i=0;i<p2;++i)
                System.out.print("m"+(i+1)+"="+m2[i]+"  ");

            count4=0;count5=0;count6=0;count7=0;count8=0;
        }
        while(flag2==0);

        System.out.println("\n\n\nThe Final Clusters By Kmeans are as follows: ");
        for(int i=0;i<p2;++i)
        {
            System.out.print("K"+(i+1)+"{ ");
            for(int j=0;k2[i][j]!=-1 && j<n2-1;++j)
                System.out.print(k2[i][j]+" ");
            System.out.println("}");
        }

        int accu[][]=new int[3][5];

        for(int p=0;p<p1;p++)
        {
            for(int r=0;r<p2;r++)
            { int count=0;
                for(int q=0;k1[p][q]!=-1 && q<n1-1;q++)
                {
                    for(int s=0;k2[r][s]!=-1 && s<n2-1;s++)
                    {
                        if(k1[p][q]==k2[r][s])
                        {
                            count++;
                        }
                        accu[p][r]=count;
                    }
                }
            }
        }


        for(int i=0;i<3;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(" "+accu[i][j]);
            }
            System.out.println();
        }

        double max_ele,sum=0,ac;
        for(int i=0;i<3;i++)
        {
            max_ele=accu[i][0];
            for(int j=1;j<5;j++)
            {
                if(accu[i][j]>max_ele)
                { max_ele=accu[i][j]; }
            }
            sum+=max_ele;
        }
        ac=sum/15;

        System.out.println("Accuracy for k-means will be " +ac);
    }
}
