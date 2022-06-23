package site.mizhuo.code;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Rectangle Area
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 *
 * X1,X2,Y1,Y2 = max(A,E),min(C,G),max(B,F),min(D,H)
 *         area1 = (C-A)*(D-B)
 *         area2 = (G-E)*(H-F)
 *         if X1 >= X2 or Y1 >= Y2:
 *             area3=0
 *         else:
 *             area3 = (X2-X1)*(Y2-Y1)
 */
public class ComputeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //first area
        int area1 = (C - A) * (D -B);
        //second area
        int area2 = (G - E) * (H -F);
        //判断是否有交叉
        int X1 = max(A,E);
        int X2 = min(C,G);
        int Y1 = max(B,F);
        int Y2 = min(D,H);
        //交叉面积
        int area3 = 0;
        if ( X1 >= X2 || Y1 >= Y2)
            area3=0;
        else
            area3 = (X2-X1)*(Y2-Y1);
        return area1 + area2 - area3;
    }
    public int max(int a,int b){
        return a > b ? a:b;
    }
    public int min(int a,int b){
        return a > b?b : a;
    }

}
