package binarysearch;
public class BookAllocation {
    public static void main(String[] args) {
        
    }



    public static int book_Allocation(int books[], int students){
        if(books.length < students){
            return -1;
        }

        // range will be max of array and sum of array

        int start = Integer.MIN_VALUE; // for finding max element
        int end = 0; // sum of array

        for(int i=0;i<books.length;i++){
            if(books[i]>start){
                start = books[i];
            }
            end = end + books[i];
        }

        int res = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(isAllocationPossible(books,mid,students)){
                res = mid;
                end = mid - 1;

            }
            else{
                 start = mid + 1;
            }
        }
        return res;
    }

    static boolean isAllocationPossible(int books[], int maxPages, int students){
        int currStudent = 1;
        int pages = 0;
        for(int i=0;i<books.length;i++){
            pages += books[i];
            //if pages exceed max pages
            if(pages>maxPages){
                // allocation to next student
                currStudent+=1;
                pages = books[i];
            }
            if(currStudent > students){
                return false;
            }
        }
        return true;
    }





    public static int kokoEating(int piles[], int h){
        int start = 0;
        int end = Integer.MIN_VALUE; //for finding largets value in piles

        for(int i=0;i<piles.length;i++){
            if(piles[i]>end){
                end = piles[i];
            }
        }
        int ans = -1;
        //apply binary search on the possible values of k --> (1, max(piles))
        while(start<=end){
            int mid = start + (end - start)/2;
            if(isEatingPossible(piles, mid, h)){
                ans = mid;
                end = mid-1;
            } 
            else{
                start = mid +1;
            }
        }
        return ans;
    }

    public static boolean isEatingPossible(int piles[], int eatingSpeed, int hours){
        int hoursSpent = 0;
        for (int i=0;i<piles.length;i++){
            hoursSpent += piles[i]/eatingSpeed;
            if(piles[i]%eatingSpeed!=0){
                hoursSpent += 1;
            }
            if(hoursSpent>hours){
                return false;
            }
        }
        return true;
    }
}



