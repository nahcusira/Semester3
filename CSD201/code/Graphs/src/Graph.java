
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class Graph {

    int[][] a;//graph
    int n;//so diem cua graph
    char[] v;//dinh cua graph

    public Graph() {
        v = "ABCDEFGHI".toCharArray();//-> dinh thu bao nhieu thi -> chu nao
    }

    void setData(int[][] b) {
        n = b.length;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void displayAdj() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    void visit(int i) {
        System.out.println(v[i] + " ");
    }

    void breadth(boolean[] en, int i) {
        MyQueue q = new MyQueue();
        int r;//
        q.enqueue(i);
        //danh dau nhung thang da enqueue vao
        en[i] = true;
        while (!q.isEmpty()) {
            r = (int) q.dequeue();//dequeue luu vao r
            visit(r);
            for (int j = 0; j < n; j++) {//add nhung thang ke vs r
                if (!en[j] && a[r][j] > 0) {//nhung phan tu chua vao hang doi && co duong di tu r->j ( ke gan nhat vs r )
                    q.enqueue(j);
                    en[j] = true;//dinh j dc visit thi gan=true
                }
            }
        }
    }

    void breadth(int i) {
        boolean en[] = new boolean[n];//toan bo mang en co gia tri false
        for (int j = 0; j < n; j++) {
            en[j] = false;
        }
        breadth(en, i);//tham den dau thi gan = true, duyet den luc q.isEmpty
        //kiem tra xem duyet het cac dinh chua, neu chua thi duyet tiep dinh chua duyet
        for (int j = 0; j < n; j++) {
            if (!en[j]) {//en[j] chua dc duyet
                breadth(en, j);
                //tat ca cac dinh da dc duyet thi se chuyen thanh true
            }
        }
    }

    void depth(boolean[] vis, int i) {
        visit(i);
        vis[i] = true;//tham dc dinh nao thi danh dau dinh do = true
        for (int j = 0; j < n; j++) {//tim dinh ke vs i ( dinh gan i nhat )
            if (!vis[j] && a[i][j] > 0) {//j chua dc tham va ke gan nhat vs i
                depth(vis, j);
            }
        }
    }

    void depth(int i) {
        boolean vis[] = new boolean[n];//toan bo mang en co gia tri false
        for (int j = 0; j < n; j++) {
            vis[j] = false;
        }
        depth(vis, i);
        //kiem tra xem duyet het cac diem chua
        for (int j = 0; j < n; j++) {
            if (!vis[i]) {//kiem tra 1 diem chua dc visit thi duyet tu diem day ->
                depth(vis, j);
            }
        }
    }

    void dijikstra(int from, int to) {
        int inf = 99;
        boolean[] s = new boolean[n];
        int[] d = new int[n];//khoang cach tu goc den dich
        int[] p = new int[n];//luu lai cac dinh cua duong di ngan nhat
        int i, j, k, x;
        for (i = 0; i < n; i++) {
            s[i] = false;
            d[i] = a[from][i];//khoang cach tu from den dinh i
            p[i] = from;
        }
        s[from] = true;
        while (true) {
            //tim k sao cho d[k]=min
            x = inf;
            k = -1;
            for (i = 0; i < n; i++) {
                if (s[i]) {
                    continue;//dinh nao dc chon thi bo qua
                }
                if (d[i] < x) {//neu khoang cach nho hon thi cap nhat lai
                    x = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("No solution");
                return;
            }
            //chon k vao tap s
            s[k] = true;
            if (k == to) {
                break;//gap dinh dich thi dung lai
            }//update d[i] va p[i]
            for (i = 0; i < n; i++) {
                if (s[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {//neu duong di cu > duong di moi
                    d[i] = d[k] + a[k][i];
                    p[i] = k;//bo sung dinh trc la dinh k
                }
            }
        }
        System.out.println("the shortest distance is " + d[to]);
        System.out.println("the path is ");
        i = to;
        Stack st = new Stack();
        st.push(i);
        while (true) {
            i = p[i];
            st.push(i);
            if (i == from) {
                break;
            }
        }
        i = (int) st.pop();
        System.out.print(i);
        while (!st.isEmpty()) {
            i = (int) st.pop();
            System.out.print(" -> " + i);
        }
        System.out.println();
    }

    //cac dinh co degree la chan -> cycle
    //chi  co 2 dinh co degree la le va tat ca cac dinh con lai chan - > path
    //tim degree tai 1 dinh i
    int deg(int i) {
        int s = 0;
        for (int j = 0; j < n; j++) {
            s += a[i][j];//tong gia tri tai dinh i
        }
        s += a[i][i];//neu tai dinh co gia tri thi + 2 lan
        return s;
    }

    //kiem tra tat ca cac dinh co degree chan k?
    boolean allDegEven() {
        for (int i = 0; i < n; i++) {
            if (deg(i) % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    //kiem tra co lien ket k?
    boolean isConnect() {
        Stack s = new Stack();//meu lien ket thi push vao stack s
        boolean[] p = new boolean[n];//kiem tra cac dinh dc push vao stack chua
        int i, j, k;//cac bien de duyet
        for (i = 0; i < n; i++) {//gan cac phan tu khi chua dc push vao stack s
            p[i] = false;
        }
        s.push(0);//push thag dau tien vao stack s
        p[0] = true;//danh dau = true
        while (!s.isEmpty()) {
            k = (int) s.pop();//lay ra den khi stack empty
            for (i = 0; i < n; i++) {//kiem tra co dinh vao lien ket vs dinh vua pop ra k neu co dinh nao lien ket thi tiep tuc push vao stack de danh dau la true , nhung dinh dc push vao stack thi dinh co connect
                if (!p[i] && a[k][i] > 0) {//i chua dc push vao stack && lien ket vs k
                    s.push(i);//i lien ket dc vs k
                    p[i] = true;
                }
            }
        }//kiem tra k connect
        for (i = 0; i < n; i++) {
            if (!p[i]) {//dinh nao do k dc push vao stack -> dinh do la co lap
                return false;
            }
        }
        return true;
    }

    //kiem tra co euler cycle k
    boolean hasEulerCycle() {
        if (isConnect() && allDegEven()) {
            return true;
        }
        return false;
    }

    void eulerCycle(int k) {
        if (!hasEulerCycle()) {
            System.out.println("No euler cycle");
            return;
        }
        MyStack s = new MyStack();
        int[] eu = new int[100];//chua cac dinh cua euler cycle.. co the >n vi cac dinh co the lap > 1 lan
        int i, r, m;
        m = 0;//m la diem hien tai cua [] eu 
        s.push(k);//euler cycle bat dau tu diem k
        while (!s.isEmpty()) {
            r = (int) s.top();//lay gia tri dau tien cua stack ma k day phan tu ra khoi stack
            for (i = 0; i < n; i++) {//tim diem i xem co lien ket vs r ?
                if (a[r][i] > 0) {
                    break;
                }
            }
            if (i == n) {//r dang bi co lap
                s.pop();//loai ra khoi stack
                eu[m++] = r;
            } else {//tim dc tu r -> diem i co duong di
                s.push(i);
                a[r][i]--;//duyet qua 1 lan thi giam di 1 don vi
                a[i][r]--;
            }
        }
        System.out.println("the euler cycle is : ");
        System.out.print(v[eu[0]]);//in dinh dau tien
        for (i = 1; i < m; i++) {//in cac dinh tiep theo
            System.out.print(" -> " + v[eu[i]]);
        }
        System.out.println();
    }
}
