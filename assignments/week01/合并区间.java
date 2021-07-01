class Solution {
    public int[][] sort(int[][] intervals,int index){
        int[][] newArray = new int[intervals.length][2];
        
        for (int i = 0; i < newArray.length;i++){
            if (i < index - 1){
                newArray[i] = intervals[i];
            }else if(i == index - 1){
                newArray[i] = intervals[index];
            }else if(i == index){
                newArray[i] = intervals[index-1];
            }else if(i > index){
                newArray[i] = intervals[i];
            }
        }
        return newArray;

    }
    public int[][] everyMerge(int[][] intervals,int index){
        int start = Math.min(intervals[index-1][0],intervals[index][0]);
        int end = Math.max(intervals[index][1],intervals[index-1][1]);
        int[] temp = new int[]{start,end};
        int[][] newArray = new int[intervals.length-1][2];
        for (int i = 0; i < newArray.length;i++){
            if (i < index - 1){
                newArray[i] = intervals[i];
            }else if(i == index - 1){
                newArray[i] = temp;
            }else if(i > index -1){
                newArray[i] = intervals[i+1];
            }
        }
        return newArray;

    }
    public int[][] merge(int[][] intervals) {
        int count = intervals.length;
        int[][] sortArray = intervals;
        for (int i=1; i < count; i++){
            if(intervals[i][0] < intervals[i-1][0]){
                sortArray = sort(sortArray,i);
            }
        }
        int[][] newArray = sortArray;
        for(int j=1; j < count; j++){
            System.out.println("-----------");
            if(sortArray[j][0] <= sortArray[j-1][1]){
                newArray = everyMerge(newArray,j);
                System.out.println(newArray[j-1][0]);
                System.out.println(newArray[j][0]);
            }
        }
        return newArray;
    }
}