//Initial Template for Java

import java.util.*;
import java.io.*;


class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            KSmallestAnDLargestElement ob = new KSmallestAnDLargestElement();
            ArrayList<Integer> list = ob.kLargest(arr, n, k);
            for(int i = 0; i<list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class KSmallestAnDLargestElement
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here 
        ArrayList<Integer> result = new ArrayList<>();
        buildHeap(arr,n);
        heapSort(arr,n);
        /*for(int i=n-1;i>=0;i--){
            System.out.print(arr[i]+" ");
        }*/
        for(int i=n-1;i>=n-k;i--){
            result.add(arr[i]);
        }
        //System.out.println(" ");
        return result;
    }

    public static void heapSort(int arr[], int n)
    {
        //buildHeap(arr, n);
        for(int i = n-1; i >= 0; --i){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void buildHeap(int arr[], int n)
    {
        for(int i = n/2 - 1; i >= 0; --i){
            heapify(arr, n, i);
        }
    }

    public static void heapify(int arr[], int n, int i)
    {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[largest] < arr[l])
            largest = l;
        if (r < n && arr[largest] < arr[r])
            largest = r;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}