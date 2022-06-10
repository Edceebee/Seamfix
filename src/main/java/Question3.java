import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of days");
        int n = input.nextInt();

        System.out.println("Enter days of prior transactions");
        int d = input.nextInt();

        boolean isEven = true;
        if (d % 2 != 0)
            isEven = false;
        int warning_count = 0;
        int[] expenditure = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter transaction amount for given days");
            expenditure[i] = input.nextInt();
        }
        int[] data = new int[201];
        for (int i = 0; i < d; i++) {
            data[expenditure[i]]++;
        }
        for (int i = d; i < expenditure.length; i++) {

            double median_double = 0;
            if (isEven) {
                int m1 = -1;
                int m2 = -1;
                int count = 0;
                for (int j = 0; j < data.length; j++) {
                    count += data[j];
                    if (m1 < 0 && count >= d / 2) {
                        m1 = j;
                    }
                    if (m2 < 0 && count >= d / 2 + 1) {
                        m2 = j;
                        break;
                    }
                }
                median_double = m1 + m2;
            } else {
                int count = 0;
                for (int j = 0; j < data.length; j++) {
                    count += data[j];
                    if (count > d / 2) {
                        median_double = j * 2;
                        break;
                    }
                }
            }

            if (expenditure[i] >= median_double) {
                warning_count++;
            }
            data[expenditure[i]]++;
            data[expenditure[i - d]]--;
        }
        System.out.println(warning_count);
        input.close();
    }
}
