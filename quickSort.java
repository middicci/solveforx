public class Sort {
    
    int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j=low; j<high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i+1;
    }
    
    void sort(int arr[], int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    
    void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.println(" " + arr[i]);
        }
    }
    
    public static void main(String args[]) {
        int arr[] = {10, 30, 80, 50, 100, 90, 70};
        Sort srt = new Sort();
        srt.sort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array:");
        srt.printArr(arr);
    }
}
