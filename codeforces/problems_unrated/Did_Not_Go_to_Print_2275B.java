package problems_unrated;


import java.io.*;
import java.util.*;

public class Did_Not_Go_to_Print_2275B {
    public static void main(String[] args) throws Exception {
        FastScanner read = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = 1;
        t = read.nextInt();

        while (t-- > 0) {
            int count = 0;
            int n = read.nextInt();
            int printcount = n;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            String a = read.next();
            boolean[] printed = new boolean[n+1];
            for (char c : a.toCharArray()) {
                int temp = c - '0';


                if (temp == 1) {
                    stack.push(++count);
                } else if (temp == 2) {
                    if (!stack.isEmpty()) {
                        int p=stack.pop();
                        printed[p]=true;
                        printcount--;
                    }
                    else{
                        printed[count+1]=true;
                        printcount--;
                    }
                    count++;
                } else if (temp == 3) {
                    count++;
                    printed[count]=true;
                    printcount--;
                }
            }
            out.println(printcount);
            for(int i=1;i<=n;i++){
                if(!printed[i]) out.print(i+" ");
            }
            out.println();
        }

        out.flush();
    }

    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}

