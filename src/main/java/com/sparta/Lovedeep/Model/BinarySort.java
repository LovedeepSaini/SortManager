package com.sparta.Lovedeep.Model;

import com.sparta.Lovedeep.Controller.Sorter;
import com.sparta.Lovedeep.View.Starter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySort implements Sorter {
    public static Logger logger= LogManager.getLogger(Starter.class);

    static class Node
    {

        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }


    static Node root;

    // Constructor
    public  BinarySort()
    {
        root = null;
    }


    static void insert(int key)
    {
        root = insertRec(root, key);
    }


    static Node insertRec(Node root, int key)
    {

        /* If the tree is empty,
        return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur
        down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the root */
        return root;

    }

    // function to do
    // inorder traversal of BST
    static void inorderRec(Node root)
    {

        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }

    }
    static void treeins(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }

    }



    @Override
    public  int[] sortArray(int[] arrayToSort) throws EmptyArrayException,SmallArrayException {
        if (arrayToSort == null) {
            logger.error("NullPointerException: Array is null!");
           // throw new NullPointerException("Array is null!");
        } else if (arrayToSort.length == 0) {
            logger.error("EmptyArrayException: Empty array!");
           // throw new EmptyArrayException("Empty array!");
        } else if (arrayToSort.length == 1) {
            logger.error("ArrayTooSmallException: Array must be larger than one!");
           // throw new SmallArrayException("Array must be larger than one!");
        }


            BinarySort.treeins( arrayToSort);

            BinarySort.inorderRec(BinarySort.root);

            System.out.println("Original Array:");

        return arrayToSort;
    }
    public static boolean isSorted(int[] arrayToCheck) {

        for(int i = 0; i < arrayToCheck.length - 1; i++) {
            if(arrayToCheck[i] > arrayToCheck[i+1]) {
                return false;
            }
        }
        return true;
    }


   }