package com.example;

public class MyClass {


    public static void main(String[] args) {

    }


    /**
     * 冒泡排序
     *
     * @param data
     */
    private void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                }
            }
        }

    }

    /**
     * 选择排序
     *
     * @param data
     */
    private void chooseSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i; j < data.length; j++) {
                if (data[min] > data[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = data[min];
                data[min] = data[i];
                data[i] = tmp;
            }
        }
    }


    private void printData(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
    }


    /**
     * 二分查找
     *
     * @param data
     * @param target
     */
    private static int search(int[] data, int target) {

        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (data[middle] < target) {
                low = middle + 1;
            } else if (data[middle] > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    /**
     * 单例 饿汉式 final修饰
     * 当类SingletonTest被加载的时候，会初始化static的instance，静态变量被创建并分配内存空间，
     * 从这以后，这个static的instance对象便一直占着这段内存（即便你还没有用到这个实例）
     */
    static class SingletonTest_1 {
        private SingletonTest_1() {
        }

        private final static SingletonTest_1 mInstance = new SingletonTest_1();

        public static SingletonTest_1 getmInstance() {
            return mInstance;
        }
    }


    /**
     * 饱汉+线程安全
     */
    static class SingletonTest_2 {

        private SingletonTest_2() {
        }

        private static SingletonTest_2 mInstance;

        public static synchronized SingletonTest_2 getmInstance() {
            if (mInstance == null) {
                mInstance = new SingletonTest_2();
            }
            return mInstance;
        }
    }


    /**
     * 用volatile关键字保证变量可见性，一旦被某线程改变，另一线程立即可见。
     */
    static class SingletonTest_3 {
        private SingletonTest_3() {
        }

        private static volatile SingletonTest_3 mInstance;

        public static SingletonTest_3 getmInstance() {
            if (mInstance == null) {
                synchronized (SingletonTest_3.class) {
                    if (mInstance == null) {
                        mInstance = new SingletonTest_3();
                    }
                }
            }
            return mInstance;
        }
    }


}
