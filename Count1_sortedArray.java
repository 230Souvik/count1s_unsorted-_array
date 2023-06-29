
package count1_sorted.array;
import java.util.*;
//import java.util.Scanner;

public class Count1_sortedArray {

    
    public void sort(int arr[],int l,int r){
        if (l < r) {
 
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            marge(arr, l, m, r);
        }
    }
    public void marge(int arr[],int l,int m,int r){
            int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public void display(int arr[]){
        int n = arr.length;
        System.out.println("display");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void count(int arr[],int n){
         int ct = 0;
    for (int i = 0; i < n; i++)
        if (arr[i] == 1)
            ct++;
        System.out.println("no of 1 in array is "+ct);
    }
    
    public static void main(String[] args) {
        Count1_sortedArray c=new Count1_sortedArray();
        System.out.println("no of element in array");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enter ele of array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        c.sort(arr,0,n-1);
        c.display(arr);
        c.count(arr, n);
    }
    
}
