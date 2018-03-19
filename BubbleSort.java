class Sort{
 
 public static void bSort(int a[],int n){
     int i,j,tmp;
	 double starttime = System.nanoTime();
	   starttime = starttime/1000;
     for(i=0;i<n;i++)
     {
	for(j=i;j<n;j++){
	  if(a[i]>=a[j])
	   {
      	      tmp = a[i];
	      a[i] = a[j];
	      a[j] = tmp;
	   }
        }
     }

	 double endtime = System.nanoTime();
	endtime = endtime/1000;
	for(i=0;i<n;i++)
       {
	 System.out.println(a[i]); 
	}

	System.out.println(endtime - starttime);
     
  }

}