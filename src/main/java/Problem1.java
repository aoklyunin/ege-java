import org.ejml.data.DMatrix;
import org.ejml.simple.SimpleMatrix;

import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println("test");
        double[][] roadsArr = new double[][]{
                {0, 10, 15, 0, 0, 0, 0},
                {10, 0, 0, 13, 17, 0, 0},
                {15, 0, 0, 0, 19, 0, 9},
                {0, 14, 0, 0, 10, 20, 11},
                {0, 17, 19, 10, 0, 0, 20},
                {0, 0, 0, 20, 0, 0, 25},
                {0, 0, 9, 11, 20, 25, 0}
        };
        for (int i = 0; i < roadsArr.length; i++) {
            for (int j = 0; j < roadsArr[i].length; j++) {
                roadsArr[i][j] = Math.signum(roadsArr[i][j]);
            }
        }

        double[] roadsColTrace = new double[roadsArr.length];
        for (int i = 0; i < roadsArr[0].length; i++) {
            roadsColTrace[i] = 0;
            for (int j = 0; j < roadsArr.length; j++) {
                roadsColTrace[i] = roadsColTrace[i] * 2 + roadsArr[j][i];
            }
        }

        double[][] linksArr = new double[][]{
                {0, 1, 1, 0, 0, 0, 0}, // A
                {1, 0, 0, 1, 1, 0, 0}, // Б
                {1, 0, 0, 1, 0, 1, 0}, // В
                {0, 1, 1, 0, 1, 1, 0}, // Г
                {0, 1, 0, 1, 0, 1, 1}, // Д
                {0, 0, 1, 1, 1, 0, 1}, // Е
                {0, 0, 0, 0, 1, 1, 0}  // Ж
        };



        double[] linksColTrace = new double[linksArr.length];
        for (int i = 0; i < linksArr[0].length; i++) {
            linksColTrace[i] = 0;
            for (int j = 0; j < linksArr.length; j++) {
                linksColTrace[i] = linksColTrace[i] * 2 + linksArr[j][i];
            }
        }

        SimpleMatrix links = new SimpleMatrix(linksArr);
        SimpleMatrix roads = new SimpleMatrix(roadsArr);


        System.out.println(links.eig().getEigenvalues());
//        for (int i = 0; i < roadsArr.length; i++) {
//            for (int j = 0; j < roadsArr[i].length; j++) {
//                System.out.printf("%.2f ", roads.get(i, j));
//            }
//            System.out.println();
//        }
//        System.out.println("__________________________");
//
//        SimpleMatrix res = roads.transpose().mult(roads);
//        for (int i = 0; i < roadsArr.length; i++) {
//            for (int j = 0; j < roadsArr[i].length; j++) {
//                System.out.printf("%.2f ", res.get(i, j));
//            }
//            System.out.println();
//        }
        System.out.println("links trace: " + Arrays.toString(linksColTrace));
        System.out.println("roads trace: " + Arrays.toString(roadsColTrace));

    }
}
