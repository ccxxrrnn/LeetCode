package Top100.FindMedianSortedArrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-19 18:55
 **/


public class Test {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1=0;
        int end1=nums1.length-1;
        int start2=0;
        int end2=nums2.length-1;
        while(start1<=end1 && start2<=end2){
            if (start1==end1 && start2==end2){
                double i=nums1[start1];
                double j=nums2[start2];
                return (i+j)/2;
            }
            if (nums1[start1]>nums2[start2]){
                start2++;
            }else{
                start1++;
            }
            if (nums1[end1]>nums2[end2]){
                end1--;
            }else{
                end2--;
            }
        }
        while(start1<=end1){
            if (start1==end1) return nums1[start1];
            if (++start1 - --end1==1){
                double i=nums1[start1];
                double j=nums1[end1];
                return (i+j)/2;
            }
        }
        while(start2<=end2){
            if (start2==end2) return nums2[start2];
            if (++start2 - --end2==1){
                double i=nums2[start2];
                double j=nums2[end2];
                return (i+j)/2;
            }
        }
        return 0;
    }

}
