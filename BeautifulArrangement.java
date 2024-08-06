public class BeautifulArrangement {
    int count;
    public int countArrangement(int n) {
        //optimization
        if(n == 1) return 1;

        int[] arr = new int[n+1]; //as it is 1 indexed array
        for(int i=1; i<=n; i++) {
            arr[i] = i; //make index map to its own value
        }

        this.count = 0;

        backtrack(arr, 1);
        return count;
    }

    void backtrack(int[] arr, int index) { //O(n!) T.C for permutations, O(n) S.C recursive stack space
        if(index == arr.length) { //when the index reaches length of array and recursion is called once again
            count++; //this means a beautiful arrangement is formed, so increment the counter
        }

        for(int i=index; i<arr.length; i++) {
            //action
            swap(arr, i, index); //in the for loop, swap ith indexed value with current index

            //recurse
            //if beautiful arrangement requirement is satisfied with the current swapped index
            if((arr[index] % index == 0) || (index % arr[index] == 0)) {
                backtrack(arr, index+1); //continue recursion by moving the index
            }

            //backtrack
            swap(arr, i, index);
        }
    }

    void swap(int[] arr, int i, int j) { //swap method
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 4;
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();

        System.out.println("Number of beautiful arrangements based on input " + n + " is: " +
                beautifulArrangement.countArrangement(n));
    }
}
