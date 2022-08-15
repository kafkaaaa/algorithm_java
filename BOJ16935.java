/**
 * BOJ 16935번(S1) - 배열 돌리기 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16935 {

    static int N, M, R;
    static int[][] arr, tmp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<R; i++) {
            operation(Integer.parseInt(st.nextToken()));
        }

        for (int[] a : arr) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }

    }


    private static void operation(int num) {

        N = arr.length;
        M = arr[0].length;

        switch (num) {

            // 상하 반전
            case 1: {
                tmp = new int[N][M];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        tmp[N - i - 1][j] = arr[i][j];
                    }
                }
                arr = tmp;
            } break;


            // 좌우 반전
            case 2: {
                tmp = new int[N][M];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        tmp[i][M - j - 1] = arr[i][j];
                    }
                }
                arr = tmp;
            } break;

            // 90도 회전 (시계 방향)
            case 3: {
                tmp = new int[M][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        tmp[j][N - 1 - i] = arr[i][j];
                    }
                }
                arr = tmp;
            } break;

            // 90도 회전 (반시계 방향)
            case 4: {
                tmp = new int[M][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        tmp[M - 1 - j][i] = arr[i][j];
                    }
                }
                arr = tmp;
            } break;


            // 그룹별 이동1
            case 5: {
                tmp = new int[N][M];
                int NN = N / 2;
                int MM = M / 2;

                // 1번그룹 -> 2번그룹 자리로 이동
                for (int i = 0; i < NN; i++) {
                    for (int j = 0; j < MM; j++) {
                        tmp[i][j + MM] = arr[i][j];
                    }
                }
                // 2번그룹  -> 3번그룹 자리로 이동
                for (int i = 0; i < NN; i++) {
                    for (int j = MM; j < M; j++) {
                        tmp[i + NN][j] = arr[i][j];
                    }
                }
                // 3번그룹 -> 4번그룹 자리로 이동
                for (int i = NN; i < N; i++) {
                    int c = 0;
                    for (int j = MM; j < M; j++, c++) {
                        tmp[i][c] = arr[i][j];
                    }
                }
                // 4번그룹 -> 1번그룹 자리로 이동
                int r = 0;
                for (int i = NN; i < N; i++, r++) {
                    for (int j = 0; j < MM; j++) {
                        tmp[r][j] = arr[i][j];
                    }
                }
                arr = tmp;
            } break;


            // 그룹별 이동2
            case 6: {
                tmp = new int[N][M];
                int NN = N / 2;
                int MM = M / 2;

                // 1번그룹 -> 4번그룹 자리로 이동
                for (int i=NN; i<N; i++) {
                    for (int j=0; j<MM; j++) {
                        tmp[i][j] = arr[i-NN][j];
                    }
                }

                // 4번그룹  -> 3번그룹 자리로 이동
                for (int i=NN; i<N; i++) {
                    for (int j=MM; j<M; j++) {
                        tmp[i][j] = arr[i][j-MM];
                    }
                }

                // 3번그룹 -> 2번그룹 자리로 이동
                for (int i=0; i<NN; i++) {
                    for (int j=MM; j<M; j++) {
                        tmp[i][j] = arr[i+NN][j];
                    }
                }

                // 2번그룹 -> 1번그룹 자리로 이동
                for (int i=0; i<NN; i++) {
                    for (int j=0; j<MM; j++) {
                        tmp[i][j] = arr[i][j+MM];
                    }
                }
                arr = tmp;
            } break;
        }
    }

}
