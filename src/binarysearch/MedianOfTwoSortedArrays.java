package binarysearch;

public class MedianOfTwoSortedArrays {

    private static double avg(int num1, int num2) {
        return (double) (num1 + num2) / 2;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findMedian(nums2);
        }

        if (nums2 == null || nums2.length == 0) {
            return findMedian(nums1);
        }

        // Lengths of the two arrays.
        int length1 = nums1.length;
        int length2 = nums2.length;

        // Make sure the left array is always the smalled one.
        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0;
        int end = length1;
        int mid = (length1 + length2 + 1) / 2;
        while (start <= end) {

            int partition1 = (start + end) / 2;
            int partition2 = mid - partition1;

            int leftMax1 =
                    partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int leftMax2 =
                    partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int rightMin1 = partition1 == length1 ? Integer.MAX_VALUE :
                    nums1[partition1];
            int rightMin2 = partition2 == length2 ? Integer.MAX_VALUE :
                    nums2[partition2];

            if (leftMax1 > rightMin2) {
                end = partition1 - 1;
            } else if (leftMax2 > rightMin1) {
                start = partition1 + 1;
            } else {
                if ((length1 + length2) % 2 == 0) {
                    return avg(Math.max(leftMax1, leftMax2),
                            Math.min(rightMin1, rightMin2));
                }

                return Math.max(leftMax2, leftMax1);
            }

        }
        throw new IllegalArgumentException();
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findMedian(nums2);
        }

        if (nums2 == null || nums2.length == 0) {
            return findMedian(nums1);
        }
        int newSize = nums1.length + nums2.length;
        int[] mergedArray = mergeArrays(nums1, nums2);
        return findMedian(mergedArray);
    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int counter1 = 0;
        int counter2 = 0;
        int counter = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];
        while (counter1 < nums1.length && counter2 < nums2.length) {
            int number =
                    nums1[counter1] < nums2[counter2] ? nums1[counter1++] :
                            nums2[counter2++];
            mergedArray[counter++] = number;
        }

        while (counter1 < nums1.length) {
            mergedArray[counter++] = nums1[counter1++];
        }

        while (counter2 < nums2.length) {
            mergedArray[counter++] = nums2[counter2++];
        }
        return mergedArray;
    }

    private double findMedian(int[] numArray) {

        int size = numArray.length;

        if (size % 2 != 0) {
            return numArray[size / 2];
        } else {
            return ((double) numArray[(size / 2) - 1] +
                    (double) numArray[size / 2]) / 2;
        }

    }
}
