import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class sbc {

        public sbc() {
            //   initComponents();
        }



        static List<List<String>> ar = new ArrayList<>();
        static List<Float> d = new ArrayList<>();
        static List<Float> d2 = new ArrayList<>();
        static List<Float> cl = new ArrayList<>();
        static List<Float> cl2 = new ArrayList<>();
        static List<Float> temp = new ArrayList<>();
        static List<Float> temp2 = new ArrayList<>();
        static Map<Float,  List<Float> > map = new HashMap<Float, List<Float>>();
        static  Map<Float,  List<Float> > map2 = new HashMap<Float, List<Float>>();
        static List<List<Float>> Result_1= new ArrayList<>();
        static List<List<Float>> Result_2= new ArrayList<>();
        static int i=0;

        public static void main(String args[]){
            try {

                JFileChooser chooser= new JFileChooser();
                chooser.showOpenDialog(null);
                File f=chooser.getSelectedFile();
                String filename=f.getAbsolutePath();

                FileReader reader=new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                // jTextArea1.read(br,null);

                //jTextArea1.requestFocus();


                String str;
                str = br.readLine();
                int r = 0;
                int c=0;
                int ele=0;
                while ((str = br.readLine())!= null) {
                    r++;
                    List<String> inner = new ArrayList<>();
                    String s[]= str.split(",");
                    for (int i=0;i<s.length;i++){
                        inner.add(s[i]);
                        ele++;
                    }
                    ar.add(inner);//System.out.println(str);
                }
                c=ele/r;
                System.out.println("rows: "+r);
                System.out.println("Col:"+c);

                float probab[][]= new float[r][r];
                for(int i=0;i<r;i++)
                {
                    for(int j=0;j<c;j++)
                    {
                        for(int l=0;l<r;l++)
                        {
                            float num=0;
                            for(int k=0;k<c;k++)
                            {
                                if(ar.get(i).get(k).equals(ar.get(l).get(k)))
                                { num++; }
                            }
                            probab[i][l]=num/c;
                        }
                    }
                }

                br.close();
                System.out.print("\nDataset:\n");
                for(int i=0;i<r;i++)
                {
                    System.out.println();
                    for(int j=0;j<c;j++)
                    {
                        String message=ar.get(i).get(j);
                        System.out.print(message+" ");
                    }
                }
                System.out.print("\nSpace Structure Matrix:\n");
                for(int i=0;i<r;i++)
                {
                    System.out.println();
                    for(int j=0;j<r;j++)
                    {
                       // System.out.print(probab[i][j]+" ");


                    }
                }


                Scanner scr=new Scanner(System.in);

                //Repeat code for different no. of clusters from here
                System.out.println("For different num of clusters");
                System.out.println("\nEnter the number of clusters centres");
                int p=scr.nextInt();
                System.out.println("\nEnter the value of cluster centres(Choose from the eucledian matrix): ");

                float x=0,x2=0;
                int val=0,val2=0;
                int fl=0,f2=0;
                float t2=0,t3=0,t4=0,t5=0;
                float value=0,value2=0;

                float z[]= new float[p];
                int k=0;

                for(int i=0;i<p;i++)
                {
                    z[i]=scr.nextFloat();
                }
                for(int i=0;i<p;i++)
                {
                    System.out.print(z[i]+" ");
                }

                for(k=0;k<p;k++)
                {

                    for(int i=0;i<r;i++)
                    {

                        for(int j=0;j<c;j++)
                        {
                            x=probab[i][j]-z[k];
                            d.add(x);
                            if(!(map.containsKey(x)))
                            {
                                List<Float> dmap = new ArrayList<Float>();
                                dmap.add(probab[i][j]);
                                map.put(x, dmap);
                            }

                            else{
                                List<Float> dmap = new ArrayList<Float>();
                                dmap=map.get(x);
                                dmap.add(probab[i][j]);
                                map.put(x,dmap);
                            }
                        }
                    }
                }
                int m=0;

               // System.out.println(d);
                cl.add(d.get(0));
                for( m=0;m<d.size();m++)
                {
                    for(int n=m+1;n<d.size();n++)
                    {
                        if (d.get(m).equals(d.get(n)))
                        {
                            temp.add(d.get(n));
                            for(int t=0;t<temp.size();t++)
                            {
                                for(int tt=0;tt<cl.size();tt++)
                                {

                                    {
                                        t2=temp.get(t);
                                        t3=cl.get(tt);
                                        if(t2!=t3)
                                        {
                                            fl=1;


                                        }
                                        else
                                        {
                                            fl=0;
                                            break;

                                        }
                                    }
                                }
                                if(fl==1){
                                    //System.out.println(d.get(m));
                                    cl.add(d.get(m));

                                }
                                else
                                {	 }

                            }
                        }
                    }
                }//System.out.println("a"+cl);
                for(int v=0;v<p;v++)
                {
                    System.out.println(/*"Distance:  "+cl.get(v)+"\n"+*/"Cluster"+v+":  "+map.get(cl.get(v)));
                }


                // Code starts again from here
                System.out.println("\nEnter the number of clusters");
                int p2=scr.nextInt();
                System.out.println("\nEnter the value of cluster centres(Choose from the eucledian matrix): ");
                float z2[]= new float[p2];

                for(int i=0;i<p2;i++)
                {
                    z2[i]=scr.nextFloat();
                }
                for(int i=0;i<p2;i++)
                {
                    //System.out.println(z2[i]);
                }

                for(k=0;k<p2;k++)
                {

                    for(int i=0;i<r;i++)
                    {

                        for(int j=0;j<c;j++)
                        {
                            x=probab[i][j]-z2[k];
                            d2.add(x);
                            if(!(map2.containsKey(x)))
                            {
                                List<Float> dmap = new ArrayList<Float>();
                                dmap.add(probab[i][j]);
                                map2.put(x, dmap);
                            }

                            else{
                                List<Float> dmap = new ArrayList<Float>();
                                dmap=map2.get(x);
                                dmap.add(probab[i][j]);
                                map2.put(x,dmap);
                            }
                        }
                    }
                }


                //System.out.println(d2);
                cl2.add(d2.get(0));

                for( m=0;m<d2.size();m++)
                {
                    for(int n=m+1;n<d2.size();n++)
                    {
                        if (d2.get(m).equals(d2.get(n)))
                        {
                            temp2.add(d2.get(n));
                            for(int t=0;t<temp2.size();t++)
                            {
                                for(int tt=0;tt<cl2.size();tt++)
                                {

                                    {
                                        t4=temp2.get(t);
                                        t5=cl2.get(tt);
                                        if(t4!=t5)
                                        {
                                            fl=1;


                                        }
                                        else
                                        {
                                            fl=0;
                                            break;

                                        }
                                    }
                                }
                                if(fl==1){
                                    //System.out.println(d.get(m));
                                    cl2.add(d2.get(m));

                                }
                                else
                                {	 }

                            }
                        }
                    }
                }//System.out.println("a"+c2);

                for(int v=0;v<p2;v++)
                {
                    System.out.println(/*"Distance:  "+cl2.get(v)+"\n"+*/"Cluster"+v+":  "+map2.get(cl2.get(v)));
                }


                for(int count_i=0;count_i<p;count_i++)
                {
                    List<Float> inner= new ArrayList<> ();
                    for(int count_j=0;count_j<3;count_j++)
                    {
                        inner=map.get(cl.get(count_j));

                    }
                    Result_1.add(inner);
                }

                for(int count_i=0;count_i<p;count_i++)
                {
                    for(int count_j=0;count_j<3;count_j++)
                    {
                        //System.out.print(Result_1.get(count_i).get(count_j)+" ");
                    }
                  //  System.out.println();
                }

                System.out.println();
                for(int count_i=0;count_i<p2;count_i++)
                {
                    List<Float> inner= new ArrayList<> ();
                    for(int count_j=0;count_j<3;count_j++)
                    {
                        inner=map2.get(cl2.get(count_j));
                    }
                    Result_2.add(inner);
                }

                for(int count_i=0;count_i<p2;count_i++)
                {
                    for(int count_j=0;count_j<3;count_j++)
                    {
                        System.out.print(Result_2.get(count_i).get(count_j)+" ");
                    }
                    System.out.println();
                }

                int accu[][]=new int[p][p2];


                for(int pp=0;pp<p;pp++)
                {
                    for(int rr=0;rr<p2;rr++)
                    { int count=0;
                        for(int qq=0;qq<5;qq++)
                        {
                            for(int ss=0;ss<5;ss++)
                            {
                                if(Result_2.get(rr).get(ss).equals((Result_1.get(pp).get(qq))));
                                {
                                    count++;
                                }
                                accu[pp][rr]=count;
                            }
                        }
                    }
                }

                for(int i=0;i<p;i++)
                {
                    for(int j=0;j<p2;j++)
                    {
                       // System.out.print(" "+accu[i][j]);
                    }
                   // System.out.println();
                }

                double max_ele,sum=0,accuracy;
                for(int ii=0;ii<p;ii++)
                {
                    max_ele=accu[ii][0];
                    for(int jj=1;jj<p2;jj++)
                    {
                        if(accu[ii][jj]>max_ele)
                        { max_ele=accu[ii][jj]; }
                    }
                    sum+=max_ele;
                }
                accuracy=sum/(p*p2);

                System.out.println("Accuracy for k-means will be " +accuracy);

            }




            catch (IOException e)
            {
                System.out.println("File Read Error");
                JOptionPane.showMessageDialog(null,e);
            }
//            java.awt.EventQueue.invokeLater(() -> {
//                new sbc().setVisible(true);
//            });
            System.out.print("\nContinue to see working of K-MEANS Alorithm\n");
            System.out.print("Press Y to continue: ");
            String ans;
            Scanner scan = new Scanner(System.in);

            ans=scan.next();
            if(ans.equalsIgnoreCase("y"))
            {
                kmeans.main(args);
                //km.getClass();
                //System.out.print( km.ac);
            }
            else
            {
                System.exit(0);
            }
        }






}
