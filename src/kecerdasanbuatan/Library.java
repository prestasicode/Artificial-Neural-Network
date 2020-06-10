package kecerdasanbuatan;
import java.util.*;
public class Library {
    static int index;
    static Stack s;
    static int[][][] results;
    static int sumresult;
    static String[] moveres;
    static int trip;
    
    public static void BreadthFirstSearch2(int a[][][], int x[][]) {
        boolean cari_lagi = true;
        sumresult++;
        moveres = new String[sumresult];
        results = new int[sumresult][2][2];
        // untuk setiap x di a, dicari elemen-elemen di bawahnya
        int b[][][] = new int[2*a.length][2][2];
        String[] move = new String[2*a.length];
        for(int i = 0; i < a.length; i++) {
            int c[][] = new int[x.length][x[0].length];
            equal(c,a[i]);
            int d[][] = new int[c.length][c[0].length];
            equal(d,c);
            int e[][] = new int[c.length][c[0].length];
            equal(e,c);
            
            if(c[0][0] == 0) {
                
                d[0][0] = d[1][0];
                d[1][0] = 0;
                
                equal(b[2*i],d);
                move[2*i] = "bawah";
                if(finish(d,x)) {
                    cari_lagi = false;
                    index = 2*i;
                    break;
                }
                
                
                e[0][0] = e[0][1];
                e[0][1] = 0;
                
                equal(b[2*i+1],e);
                move[2*i+1] = "kanan";
                if(finish(e,x)) {
                    cari_lagi = false;
                    index = 2*i+1;
                    break;
                }
            }
            else if(c[0][x[0].length-1] == 0) {
                
                d[0][x[0].length-1] = d[0][x[0].length-2];
                d[0][x[0].length-2] = 0;
                
                equal(b[2*i],d);
                move[2*i] = "kiri";
                if(finish(d,x)) {
                    cari_lagi = false;
                    index = 2*i;
                    break;
                }
                
                e[0][x[0].length-1] = e[1][x[0].length-1];
                e[1][x[0].length-1] = 0;
                
                equal(b[2*i+1],e);
                move[2*i+1] = "bawah";
                if(finish(e,x)) {
                    cari_lagi = false;
                    index = 2*i+1;
                    break;
                }
            }
            else if(c[x.length-1][0] == 0) {
                
                d[x.length-1][0] = d[x[0].length-1][1];
                d[x.length-1][1] = 0;
                
                equal(b[2*i],d);
                move[2*i] = "kanan";
                if(finish(d,x)) {
                    cari_lagi = false;
                    index = 2*i;
                    break;
                }
                
                e[x.length-1][0] = e[x.length-2][0];
                e[x.length-2][0] = 0;
                
                equal(b[2*i+1],e);
                move[2*i+1] = "atas";
                if(finish(e,x)) {
                    cari_lagi = false;
                    index = 2*i+1;
                    break;
                }
            }
            else if(c[x.length-1][x[0].length-1] == 0){
                
                d[x.length-1][x[0].length-1] = d[x.length-2][x[0].length-1];
                d[x.length-2][x[0].length-1] = 0;
                
                equal(b[2*i],d);
                move[2*i] = "atas";
                if(finish(d,x)) {
                    cari_lagi = false;
                    index = 2*i;
                    break;
                }
                
               
                e[x.length-1][x[0].length-1] = e[x.length-1][x[0].length-2];
                e[x.length-1][x[0].length-2] = 0;
                
                equal(b[2*i+1],e);
                move[2*i+1] = "kiri";
                if(finish(e,x)) {
                    cari_lagi = false;
                    index = 2*i+1;
                    break;
                }
            }
            
        }
        
        Print2(b);
        
        // jika belum ditemukan, maka perlu dilakukan proses berikutnya
        if(cari_lagi == true) {
            BreadthFirstSearch2(b, x);
        }
        sumresult--;
        for(int i = 0;i<2;i++)
            for(int j = 0;j<2;j++)
                results[sumresult][i][j] = b[index][i][j];
        moveres[sumresult] = move[index];
        index = index/2;
    }
    
    public static void BreadthFirstSearch3(int a[][][], int x[][]) {
        boolean cari_lagi = true;
        sumresult++;
        moveres = new String[sumresult];
        results = new int[sumresult][x.length][x[0].length];
        // untuk setiap x di a, dicari elemen-elemen di bawahnya
        int b[][][] = new int[4*a.length][x.length][x[0].length];
        String[] move = new String[4*a.length];
        for(int i = 0; i < a.length; i++) {
            int c[][] = new int[x.length][x[0].length];
            equal(c,a[i]);
            int d[][] = new int[c.length][c[0].length];
            equal(d,c);
            int e[][] = new int[c.length][c[0].length];
            equal(e,c);
            if(c[0][0] == 0 && c[0][1] == 0)
                continue;
            if(c[0][0] == 0) {
                
                d[0][0] = d[1][0];
                d[1][0] = 0;
                
                equal(b[4*i+2],d);
                move[4*i+2] = "bawah";
                if(finish(d,x)) {
                    cari_lagi = false;
                    index = 4*i+2;
                    break;
                }
                
                
                e[0][0] = e[0][1];
                e[0][1] = 0;
                
                equal(b[4*i+1],e);
                move[4*i+1] = "kanan";
                if(finish(e,x)) {
                    cari_lagi = false;
                    index = 4*i+1;
                    break;
                }
            }
            else if(c[0][x[0].length-1] == 0) {
                
                d[0][x[0].length-1] = d[0][x[0].length-2];
                d[0][x[0].length-2] = 0;
                
                equal(b[4*i+3],d);
                move[4*i+3] = "kiri";
                if(finish(d,x)) {
                    cari_lagi = false;
                    index = 4*i+3;
                    break;
                }
                
                e[0][x[0].length-1] = e[1][x[0].length-1];
                e[1][x[0].length-1] = 0;
                
                equal(b[4*i+2],e);
                move[4*i+2] = "bawah";
                if(finish(e,x)) {
                    cari_lagi = false;
                    index = 4*1+2;
                    break;
                }
            }
            else if(c[x.length-1][0] == 0) {
                
                d[x.length-1][0] = d[x[0].length-1][1];
                d[x.length-1][1] = 0;
                
                equal(b[4*i+1],d);
                move[4*i+1] = "kanan";
                if(finish(d,x)) {
                    cari_lagi = false;
                    index = 4*i+1;
                    break;
                }
                
                e[x.length-1][0] = e[x.length-2][0];
                e[x.length-2][0] = 0;
                
                equal(b[4*i],e);
                move[4*i] = "atas";
                if(finish(e,x)) {
                    cari_lagi = false;
                    index = 4*i;
                    break;
                }
            }
            else if(c[x.length-1][x[0].length-1] == 0){
                
                d[x.length-1][x[0].length-1] = d[x.length-2][x[0].length-1];
                d[x.length-2][x[0].length-1] = 0;
                
                equal(b[4*i],d);
                move[4*i] = "atas";
                if(finish(d,x)) {
                    cari_lagi = false;
                    index = 4*i;
                    break;
                }
                
               
                e[x.length-1][x[0].length-1] = e[x.length-1][x[0].length-2];
                e[x.length-1][x[0].length-2] = 0;
                
                equal(b[4*i+3],e);
                move[4*i+3] = "kiri";
                if(finish(e,x)) {
                    cari_lagi = false;
                    index = 4*i+3;
                    break;
                }
            }
            else {
                int[] nowloc = find(0,c);
                int f[][] = new int[c.length][c[0].length];
                equal(f,c);
                
                if (nowloc[0] == 0){
                    d[nowloc[0]][nowloc[1]] = d[nowloc[0]][nowloc[1]-1];
                    d[nowloc[0]][nowloc[1]-1] = 0;

                    equal(b[4*i+3],d);
                    move[4*i+3] = "kiri";
                    if(finish(d,x)) {
                        cari_lagi = false;
                        index = 4*i+3;
                        break;
                    }

                    
                    e[nowloc[0]][nowloc[1]] = e[nowloc[0]][nowloc[1]+1];
                    e[nowloc[0]][nowloc[1]+1] = 0;

                    equal(b[4*i+1],e);
                    move[4*i+1] = "kanan";
                    if(finish(e,x)) {
                        cari_lagi = false;
                        index = 4*i+1;
                        break;
                    }
                    
                   
                    f[nowloc[0]][nowloc[1]] = f[nowloc[0]+1][nowloc[1]];
                    f[nowloc[0]+1][nowloc[1]] = 0;

                    equal(b[4*i+2],f);
                    move[4*i+2] = "bawah";
                    if(finish(f,x)) {
                        cari_lagi = false;
                        index = 4*i+2;
                        break;
                    }
                }
                else if (nowloc[1] == 0){
                    d[nowloc[0]][nowloc[1]] = d[nowloc[0]-1][nowloc[1]];
                    d[nowloc[0]-1][nowloc[1]] = 0;
                    
                    equal(b[4*i],d);
                    move[4*i] = "atas";
                    if(finish(d,x)) {
                        cari_lagi = false;
                        index = 4*i;
                        break;
                    }

                    e[nowloc[0]][nowloc[1]] = e[nowloc[0]][nowloc[1]+1];
                    e[nowloc[0]][nowloc[1]+1] = 0;

                    equal(b[4*i+1],e);
                    move[4*i+1] = "kanan";
                    if(finish(e,x)) {
                        cari_lagi = false;
                        index = 4*i+1;
                        break;
                    }
                    

                    f[nowloc[0]][nowloc[1]] = f[nowloc[0]+1][nowloc[1]];
                    f[nowloc[0]+1][nowloc[1]] = 0;

                    equal(b[4*i+2],f);
                    move[4*i+2] = "bawah";
                    if(finish(f,x)) {
                        cari_lagi = false;
                        index = 4*i+2;
                        break;
                    }
                }
                else if (nowloc[0] == x.length-1){
                    d[nowloc[0]][nowloc[1]] = d[nowloc[0]][nowloc[1]-1];
                    d[nowloc[0]][nowloc[1]-1] = 0;

                    equal(b[4*i+3],d);
                    move[4*i+3] = "kiri";
                    if(finish(d,x)) {
                        cari_lagi = false;
                        index = 4*i+3;
                        break;
                    }

                    e[nowloc[0]][nowloc[1]] = e[nowloc[0]][nowloc[1]+1];
                    e[nowloc[0]][nowloc[1]+1] = 0;

                    equal(b[4*i+1],e);
                    move[4*i+1] = "kanan";
                    if(finish(e,x)) {
                        cari_lagi = false;
                        index = 4*i+1;
                        break;
                    }

                    f[nowloc[0]][nowloc[1]] = f[nowloc[0]-1][nowloc[1]];
                    f[nowloc[0]-1][nowloc[1]] = 0;

                    equal(b[4*i],f);
                    move[4*i] = "atas";
                    if(finish(f,x)) {
                        cari_lagi = false;
                        index = 4*i;
                        break;
                    }
                }
                else if (nowloc[1] == x[0].length-1){
                    d[nowloc[0]][nowloc[1]] = d[nowloc[0]][nowloc[1]-1];
                    d[nowloc[0]][nowloc[1]-1] = 0;

                    equal(b[4*i+3],d);
                    move[4*i+3] = "kiri";
                    if(finish(d,x)) {
                        cari_lagi = false;
                        index = 4*i+3;
                        break;
                    }

                    e[nowloc[0]][nowloc[1]] = e[nowloc[0]-1][nowloc[1]];
                    e[nowloc[0]-1][nowloc[1]] = 0;

                    equal(b[4*i],e);
                    move[4*i] = "atas";
                    if(finish(e,x)) {
                        cari_lagi = false;
                        index = 4*i+1;
                        break;
                    }

                    f[nowloc[0]][nowloc[1]] = f[nowloc[0]+1][nowloc[1]];
                    f[nowloc[0]+1][nowloc[1]] = 0;

                    equal(b[4*i+2],f);
                    move[4*i+2] = "bawah";
                    if(finish(f,x)) {
                        cari_lagi = false;
                        index = 4*i+2;
                        break;
                    }
                }
                else{
                    d[nowloc[0]][nowloc[1]] = d[nowloc[0]][nowloc[1]-1];
                    d[nowloc[0]][nowloc[1]-1] = 0;

                    equal(b[4*i+3],d);
                    move[4*i+3] = "kiri";
                    if(finish(d,x)) {
                        cari_lagi = false;
                        index = 4*i+3;
                        break;
                    }

                    e[nowloc[0]][nowloc[1]] = e[nowloc[0]-1][nowloc[1]];
                    e[nowloc[0]-1][nowloc[1]] = 0;

                    equal(b[4*i],e);
                    move[4*i] = "atas";
                    if(finish(e,x)) {
                        cari_lagi = false;
                        index = 4*i;
                        break;
                    }

                    f[nowloc[0]][nowloc[1]] = f[nowloc[0]+1][nowloc[1]];
                    f[nowloc[0]+1][nowloc[1]] = 0;

                    equal(b[4*i+2],f);
                    move[4*i+2] = "bawah";
                    if(finish(f,x)) {
                        cari_lagi = false;
                        index = 4*i+2;
                        break;
                    }
                    int[][] g = new int[c.length][c.length];
                    equal(g,c);
                    g[nowloc[0]][nowloc[1]] = g[nowloc[0]][nowloc[1]+1];
                    g[nowloc[0]][nowloc[1]+1] = 0;

                    equal(b[4*i+1],g);
                    move[4*i+1] = "kanan";
                    if(finish(g,x)) {
                        cari_lagi = false;
                        index = 4*i+1;
                        break;
                    }
                }
            }
        }
        
        print3(b);
        System.out.println("---------------------------------------");
        
        // jika belum ditemukan, maka perlu dilakukan proses berikutnya
        if(cari_lagi == true) {
            BreadthFirstSearch3(b, x);
        }
        sumresult--;
        for(int i = 0;i<x.length;i++)
            for(int j = 0;j<x[0].length;j++)
                results[sumresult][i][j] = b[index][i][j];
        moveres[sumresult] = move[index];
        index = index/4;
    }
    
    public static void print3(int[][][]a){
        for(int j=0;j<a[0].length;j++){
            for(int k = 0;k<a.length;k++){
                for(int i= 0;i<a[0][0].length;i++)
                    System.out.print(a[k][j][i]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    public static void equal(int[][]a, int[][] b){
        for(int i=0;i<a.length;i++)
            for(int j =0;j<a[0].length;j++)
                a[i][j]=b[i][j];
    }
    
    public static boolean finish(int[][] a,int[][] b){
        for(int i=0;i<a.length;i++)
            for(int j =0;j<a[0].length;j++)
                if(a[i][j]!=b[i][j])
                    return false;
        return true;
                
    }
    
    public static int[] find(int a , int[][]x){
        int[] temp = new int[2]; 
        for(int i =0;i<x.length;i++)
            for(int j = 0; j<x[0].length;j++)
                if(x[i][j] == a){
                    temp[0] = i;
                    temp[1] = j;
                }
        return temp;
    }
    
    public static void result2(){
        for(int i = 0;i<results.length;i++){
            System.out.println("Langkah "+(i+1));
            System.out.println("0 menuju ke"+moveres[i]);
            printmatrix(results[i]);
        }
    }
    
    public static void result3(){
        for(int i = 0;i<results.length;i++){
            System.out.println("");
            System.out.println("Langkah "+(i+1));
            System.out.println("Penyebrangan dilakukan oleh "+moveres[i]);
            printmatrix2(results[i]);
        }
    }
    
    public static void Print2(int a[][]) {
        System.out.print(a[0][0] + " ");
        System.out.println(a[0][1]);
        System.out.print(a[1][0] + " ");
        System.out.println(a[1][1]);
    }
    
    public static void Print2(int a[][][]) {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < a.length; j++) {
                for(int k = 0; k < 2; k++) {
                    System.out.print(a[j][i][k] + " ");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    
    public static void printmatrix(int a[][]){
        for (int i = 0;i<a.length;i++){
            for (int j = 0; j<a[0].length;j++)
                System.out.print(a[i][j]+" ");
        System.out.println("");
        }
        
    }
    
    public static void printmatrix2(int a[][]){
        for (int i = 0;i<a.length;i++){
            System.out.print("[");
            for (int j = 0; j<a[0].length;j++)
                if(a[i][j]==1){
                    switch (j){
                        case 0 :
                            System.out.print("Petani ");
                            break;
                        case 1 :
                            System.out.print("Serigala ");
                            break;
                        case 2 :
                            System.out.print("Domba ");
                            break;
                        default :
                            System.out.print("Rumput ");
                            break;
                    }
                }
            System.out.println("]");
        }
        
    }
    
    public static void BreadthFirstSearch1(int a[], int x) {
        boolean cari_lagi = true;
        s = new Stack();
        // untuk setiap x di a, dicari elemen-elemen di bawahnya
        int b[] = new int[2*a.length];
        for(int i = 0; i < a.length; i++) {
            b[2*i] = a[i]-1;
            
            // jika ditemukan maka berhenti
            if(b[2*i] == x) {
                cari_lagi = false;
                index = 2*i;
                break;
            }
            
            b[2*i+1] = a[i]+1;
            
            // jika ditemukan maka berhenti
            if(b[2*i+1] == x) {
                cari_lagi = false;
                index = 2*i+1;
                break;
            }
        }
        
        Print1(b);
        
        // jika belum ditemukan, maka perlu dilakukan proses berikutnya
        if(cari_lagi == true) {
            BreadthFirstSearch1(b, x);
        }
        s.push(b[index]);
        index = index/2;
    }
    
    public static void Print1(int a[]) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void result(){
        while(s.empty()==false)
            System.out.print(" -> "+s.pop());
        System.out.println("");
    }
    
    public static void BreadthFirstSearch4(int[][][] a){
        boolean cari_lagi = true;
        trip++;
        sumresult++;
        moveres = new String[sumresult];
        results = new int[sumresult][2][4];
        // untuk setiap x di a, dicari elemen-elemen di bawahnya
        int b[][][] = new int[4*a.length][2][4];
        String[] move = new String[4*a.length];
        for(int i = 0; i < a.length; i++) {
            if (a[i][0][0]==0&&a[i][1][0]==0)
                continue;
            int [][]c = new int[2][4];
            int [][]d = new int[2][4];
            int [][]e = new int[2][4];
            int [][]f = new int[2][4];
            
            
            equal(c,a[i]);
            c[0][0] = (c[0][0]+1)%2;
            c[1][0] = (c[1][0]+1)%2;
            equal(e,c);
            equal(d,c);
            equal(f,c);
            if(lose(c)){
                c[trip%2][0] = 0;
            }
            move[4*i] = "petani";
            // jika ditemukan maka berhenti
            equal(b[4*i],c);
            if(win(c)) {
                cari_lagi = false;
                index = 4*i;
                break;
            }
            d[(trip-1)%2][1]--;
            d[(trip)%2][1]++;
            move[4*i+1] = "petani dan serigala";
            if((d[(trip-1)%2][1]==-1)||lose(d)){
                d[(trip)%2][0] = 0;
            }
            equal(b[4*i+1],d);
            // jika ditemukan maka berhenti
            if(win(d)) {
                cari_lagi = false;
                index = 4*i+1;
                break;
            }
            e[(trip-1)%2][2]--;
            e[(trip)%2][2]++;
            move[4*i+2] = "petani dan domba";
            if((e[(trip-1)%2][2]==-1)||lose(e)){
                e[(trip)%2][0] = 0;
            }
            equal(b[4*i+2],e);
            // jika ditemukan maka berhenti
            if(win(e)) {
                cari_lagi = false;
                index = 4*i+2;
                break;
            }
            f[(trip-1)%2][3]--;
            f[(trip)%2][3]++;
            move[4*i+3] = "petani dan Yohanes";
            if((f[(trip-1)%2][3]==-1)||lose(f)){
                f[(trip)%2][0] = 0;
            }
            equal(b[4*i+3],f);
            // jika ditemukan maka berhenti
            if(win(f)) {
                cari_lagi = false;
                index = 4*i+3;
                break;
            }
            
        }
        //print3(b);
        //System.out.println("------------------------");
        
        if(cari_lagi == true){
            BreadthFirstSearch4(b);
        }
        sumresult--;
        for(int i = 0;i<a[0].length;i++)
            for(int j = 0;j<a[0][0].length;j++){
                results[sumresult][i][j] = b[index][i][j];
            }
        moveres[sumresult] = move[index];
        index = index/4;
    }
    
    public static boolean lose(int[][] a){
        if((a[(trip-1)%2][2]==1&&a[(trip-1)%2][3]==1)||(a[(trip-1)%2][2]==1&&a[(trip-1)%2][1]==1))
            return true;
        return false;
    }
    
    public static boolean win(int[][] a){
        for(int i =0;i<4;i++)
            if(a[1][i] != 1)
                return false;
        
        return true;
    }
}