package week3;

/*
 Given a sorted array the running time is O(n)
 If it is necessary to sorting the array, the running time is O(n log n)
 It's a polynomial solution.
 */
public class ChildrenGroup2 {

    static int getGroups(float[] children) {
        int groups = 0;
        int n = children.length - 1;
        int i = 0;

        while (i <= n) {
            //float left = children[i];
            float right = children[i] + 1;
            groups++;
            i++;

            while (i <= n && children[i] <= right) {
                i++;
            }
        }

        return groups;
    }

    public static void main(String[] args) {
        //float[] children = new float[]{2.5f, 3.2f, 3.5f, 4.0f, 4.8f, 5.2f, 6.0f};
        float[] children = new float[]{5f, 5.5f, 5.8f, 6f, 7f};

        System.out.printf("Groups: " + getGroups(children));
    }
}
