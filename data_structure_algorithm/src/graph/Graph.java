package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList;  // 存储顶点的集合
    private int[][] edges; // 存储图对应的邻接矩阵
    private int numOfEdges; // 表示边的数目
    private boolean[] isVisted; // 判断是否已经被访问过了

    /**
     * 得到第一个邻接节点的下标
     *
     * @param index 下标为index的节点
     * @return 返回
     */
    public int getFirstNeighbor(int index){ // index节点的第一个邻接节点
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    /**
     *
     * @param v1 当前节点为v1
     * @param v2  v1当前的邻接节点为v2
     * @return 寻找v1的下一个邻接节点
     *
     */
    public int getNextNeighbor(int v1, int v2){
        for (int j = v2 + 1; j < getNumOfVertex(); j++) {
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 对一个节点进行深度优先遍历,
     * @param isVisted 判断是否已经被访问过了
     * @param i 当前节点的下标
     */
    private void dfs(boolean[] isVisted, int i){
        // 首先访问该节点，输出
        System.out.print(getValueByIndex(i) + "-->");

        // 将该节点设置为已经访问过了
        isVisted[i] = true;

        // 查找节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);

        while (w != -1){  //说明有
            if(!isVisted[w]){
                dfs(isVisted, w);
            }
            // 如果w节点已经被访问过了
            w = getNextNeighbor(i, w);

        }

    }

    /**
     * 对dfs进行重载，遍历所有的节点，进行dfs
     */
    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisted[i]){
                dfs(isVisted,i);
            }
        }
    }

    /**
     * 对一个节点进行广度优先遍历,
     * @param isVisted 判断是否已经被访问过了
     * @param i 当前节点的下标
     */
    private void bfs(boolean[] isVisted, int i){
        int u; // 表示队列头节点所对应的下标
        int w; // 邻接节点
        // 该队列用于记录节点访问的顺序
        LinkedList queue = new LinkedList();
        // 访问节点，输出节点信息
        System.out.print(getValueByIndex(i) + "=>");
        // 标记为已访问
        isVisted[i] = true;

        // 将节点加入到队列中
        queue.addLast(i);

        while (! queue.isEmpty()){
            // 取出队列的头节点
            u = (Integer)queue.removeFirst();
            // 得到第一个邻接节点的下标
            w = getFirstNeighbor(u);
            while (w != -1){ // 表示找到邻接节点
                if(!isVisted[w]){  // 如果邻接节点未被访问过
                    System.out.print(getValueByIndex(w) + "=>");
                    // 标记已经访问过了
                    isVisted[w] = true;
                    // 入队
                    queue.addLast(w);
                }
                // 以u为前驱结点，找w后面的下一个邻接节点
                w = getNextNeighbor(u,w);  // 体现出广度优先
            }
        }


    }
    /**
     * 对bfs进行重载，遍历所有的节点，进行bfs
     */
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisted[i]){
                bfs(isVisted,i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // 节点的个数
        String[] Vertex = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);

        // 循环添加顶点
        for (String vertext :  Vertex) {
            graph.insertVertext(vertext);
        }

        // 添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        // 显示图
        graph.showGraph();

//        System.out.println("深度优先遍历~~");
//        graph.dfs();
//        System.out.println();
        System.out.println("广度优先遍历~~");
        graph.bfs();
    }

    // 构造器
    public Graph(int n) {
        this.edges = new int[n][n];
        numOfEdges = 0;
        vertexList = new ArrayList<String>(n);
        isVisted = new boolean[n];
    }

    // 插入节点
    public void insertVertext(String vertex){
        vertexList.add(vertex);
    }

    // 图的常用方法
    // 返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    // 返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    // 返回顶点的信息, 返回数组某个下标所对应的值
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    // 返回v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //显示图的矩阵
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     *
     * @param v1 表示点的下标即是第几个顶点
     * @param v2 表示第二个顶点对应的下标
     * @param weight 表示连接权重
     */
    // 添加边
    public  void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }



}
