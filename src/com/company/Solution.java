package com.company;

import java.util.*;

public class Solution {
    public static void main(String args[]) {
        String str = "1,3,$,$,4,$,$";
        TreeNode pNode = deserialize(str);
        TreeNode.preorderTraversal(pNode);
    }

    public static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pNode = stack.pop();
                if (pNode == null) {
                    res.append("$");
                } else {
                    res.append(pNode.val);
                    stack.push(pNode.right);
                    stack.push(pNode.left);
                }
                res.append(",");
            }
        }
        return res.deleteCharAt(res.length()-1).toString();
    }


    private static int index;
    public static TreeNode deserialize(String str) {
        if (str == null || str.length() == 0)
            return null;
        index = -1;
        String[] strs = str.split(",");
        return deserializeCore(strs);
    }
    public static TreeNode deserializeCore(String[] strs) {
        index++;
        TreeNode pNode = null;
        if (!strs[index].equals("$")) {
            pNode = new TreeNode(Integer.valueOf(strs[index]));
            pNode.left = deserializeCore(strs);
            pNode.right = deserializeCore(strs);
        }
        return pNode;
    }

    public static int GetNumberOfK(int [] array , int k) {
        int res = 0;

        if (array != null && array.length > 0) {
            int first = GetFirstK(array, k);
            int last = GetLastK(array, k);

            if (first > -1 && last > -1)
                res = last - first + 1;
        }

        return res;
    }

    public static int GetFirstK(int [] array , int k) {
        int start = 0;
        int end = array.length - 1;
        int midIndex, midData;

        while (start <= end) {
            midIndex = start + (end-start)/2 ;
            midData = array
                    [midIndex];
            if (midData == k) {
                if ((midIndex > 0 && array[midIndex-1] != k) || midIndex == 0)
                    return midIndex;
                else
                    end = midIndex - 1;
            }
            else if (midData > k)
                end = midIndex - 1;
            else
                start = midIndex + 1;
        }

        return -1;
    }

    public static int GetLastK(int [] array , int k) {
        int start = 0;
        int end = array.length - 1;
        int midIndex, midData;

        while (start <= end) {
            midIndex = start + (end-start)/2;
            midData = array[midIndex];

            if (midData == k) {
                if (midIndex == array.length-1 || (midIndex < array.length-1 && array[midIndex+1] != k))
                    return midIndex;
                else
                    start = midIndex + 1;
            }
            else if (midData > k)
                end = midIndex - 1;
            else
                start = midIndex + 1;
        }

        return -1;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] <= pivot) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] >= pivot) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return arr[start];
    }
}