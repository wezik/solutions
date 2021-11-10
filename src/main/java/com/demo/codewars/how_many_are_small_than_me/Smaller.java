package com.demo.codewars.how_many_are_small_than_me;

public class Smaller {


    private static Node insert(Node root, int num, int[] result, int sum, int i) {
        if (root == null) {
            result[i] = sum;
            return new Node(num);
        }
        if (root.value == num) {
            root.dup++;
            result[i] = sum + root.count;
        } else if (root.value > num) {
            root.count++;
            root.left = insert(root.left, num, result, sum, i);
        } else root.right = insert(root.right, num, result, sum + root.count + root.dup, i);
        return root;
    }

    public static int[] smaller(int[] unsorted) {
        int[] result = new int[unsorted.length];
        Node root = null;
        for (int i=unsorted.length-1; i>=0; i--) root = insert(root, unsorted[i], result, 0, i);
        return result;
    }
}

class Node {
    public Node left;
    public Node right;
    public int value;
    public int count;
    public int dup;

    public Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
        this.dup = 1;
        this.count = 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                ", count=" + count +
                ", dup=" + dup +
                '}';
    }
}

//    public static int[] smallder(int[] unsorted) {
//        if (unsorted.length>10000) System.out.println("Progress [----------] 0%");
//        int[] result = new int[unsorted.length];
//        SortedMap<Integer,Integer> values = new TreeMap<>();
//        int progress = 0;
//        for (int i=unsorted.length-1; i>=0; i--) {
//            if (unsorted.length>10000) {
//                if (i%(unsorted.length/10)==0) {
//                    progress+=10;
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("Progress [");
//                    for (int j=1; j<=progress/10; j++) sb.append("=");
//                    for (int j=10; j>progress/10; j--) sb.append("-");
//                    sb.append("] ").append(progress).append("%");
//                    System.out.print("\r"+sb);
//                }
//            }
//            result[i] = getAmountOfSmaller(i,unsorted);
//        }
//        return result;
//    }
//
//    private static int getAmountOfSmaller(int index, int[] unsorted) {
//        int sum=0;
//        for (int i=index; i<unsorted.length; i++) {
//            if (unsorted[index] > unsorted[i]) sum+=1;
//        }
//        return sum;
//    }
//
//    private static int getAmountOfSmallerNumbers(int number, SortedMap<Integer,Integer> values) {
//        return values.headMap(number).keySet().stream().mapToInt(values::get).sum();
//    }

//    public static int[] smaller(int[] unsorted) {
//        int[] result = new int[unsorted.length];
//        List<Node> list = new ArrayList<>();
//        Node startingNode = new Node(unsorted[unsorted.length-1]);
//        list.add(startingNode);
//        int j=0;
//        for (int i=unsorted.length-2; i>=0; i--, j++) {
//            Map<Integer,Integer> values = list.get(j).getValues();
//            values.put(unsorted[i],values.get(unsorted[i])+1);
//            list.add(new Node(values));
//        }
//        for (int i=0; i<unsorted.length; i++) {
//            System.out.println(list.get(i).getValues());
//        }
//        Collections.reverse(list);
//        for (int i=0; i<unsorted.length; i++) result[i] = list.get(i).getNumberOfSmallerThan(unsorted[i]);
//        return result;
//    }
//}
//
//class Node {
//
//    private final Map<Integer, Integer> values;
//
//    public Map<Integer, Integer> getValues() {
//        return new HashMap<>(values);
//    }
//
//    public Node(int firstNumber) {
//        this.values = new HashMap<>();
//        for (int i=0; i<10; i++) {
//            values.put(i, i == firstNumber ? 1 : 0);
//        }
//    }
//
//    public Node(Map<Integer, Integer> values) {
//        this.values = values;
//    }
//
//    public int getNumberOfSmallerThan(int n) {
//        if (n==0) return n;
//        int sum = 0;
//        for (int i=n-1; i>=0; i--) sum += values.get(i);
//        return sum;
//    }
