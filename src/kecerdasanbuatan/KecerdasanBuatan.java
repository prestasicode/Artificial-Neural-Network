package kecerdasanbuatan;

public class KecerdasanBuatan {

    public static void main(String[] args) {
        // mencari x = 4;
        /*
        int x = 4;
        int a[] = {1};
        Library.Print1(a);
        Library.BreadthFirstSearch1(a, x);
        System.out.print(a[0]);
        Library.result();
        
        */
        // mencari x = {{1,2},{3,0}}
        /*
        int x[][] = {{0,1}, 
                     {2,3}};
        
        int a[][][] = {{{1,3},
                        {0,2}}};
        
        Library.BreadthFirstSearch3(a, x);
        System.out.println("Awal :");
        Library.printmatrix(a[0]);
        Library.result2();
        */
        /*
        System.out.println("Awal :");
        System.out.println("[Petani Serigala Domba Rumput ]");
        int x[][] = {{0,0,0,0}, 
                     {1,1,1,1}};
        
        int a[][][] = {{{1,1,1,1},
                        {0,0,0,0}}};
        Library.BreadthFirstSearch4(a);
        Library.result3();
        */
        int x[][] = {{1,2,3},
                     {4,5,6},
                     {7,8,0}};
        
        int a[][][] = {{{0,1,2},
                        {5,6,3},
                        {4,7,8}}};
                
        Library.BreadthFirstSearch3(a, x);
        System.out.println("Awal :");
        Library.printmatrix(a[0]);
        Library.result2();
        
        /*
        // mencari x = {{1,2,3},{4,5,6},{7,8,0}}
        int x[][] = {{1,2,3},
                     {4,5,6},
                     {7,8,0}};
        
        int a[][][] = {{{1,0,3},
                        {4,2,6},
                        {7,5,8}}};
        
        Library.Print3(a);
        Library.BreadthFirstSearch3(a, x);
        */
        
        /*
        int x[] = {0,0,0,0,1,1,1,1};
        int a[][] = {{1,1,1,1,0,0,0,0}};
        Library.Print4(a);
        Library.BreadthFirstSearch4(a, x);
        */
    }
    
}