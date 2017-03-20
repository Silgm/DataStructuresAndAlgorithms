package src.MyGraph;

import java.util.LinkedList;

public class Graph {
    public int vertexCount = 0;
    private int[][]map;
    private  Vertex[] vertexarray;

    public Graph(int[][] map, Vertex[] vertexarray) {
        this.map = map;
        this.vertexarray = vertexarray;
        vertexCount=map.length;
    }

    //深度优先遍历
    public void dfs(){
        LinkedList<Integer> stack = new LinkedList<>();
        vertexarray[0].visited=true;
        stack.push(0);
        System.out.print(vertexarray[0].label+"  ");
        while(!stack.isEmpty()){
            int x = stack.getFirst();
            for (int y=0;y<vertexCount;y++){
                if(map[x][y]>=1&&vertexarray[y].visited==false){
                    System.out.print(vertexarray[y].label+"  ");
                    vertexarray[y].visited=true;
                    stack.push(y);
                    break;
                }
                if(y+1==vertexCount){
                    stack.pop();
                }
            }
        }
        for (Vertex v:vertexarray) {
            v.visited=false;
        }
    }
    //广度优先遍历
    public void bfs(){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        vertexarray[0].visited=true;
        System.out.print(vertexarray[0].label+"  ");
        while(!queue.isEmpty()){
            int x = queue.removeFirst();
            for (int y = 0;y<vertexCount;y++){
                if(map[x][y]>=1&&vertexarray[y].visited==false){
                    vertexarray[y].visited=true;
                    System.out.print(vertexarray[y].label+"  ");
                    queue.add(y);
                }
            }
        }
        for (Vertex v:vertexarray) {
            v.visited=false;
        }
    }
    public static void main(String[] args) {
        int[][]map= {{0,1,0,0,0,0,0,0}, {1,0,1,0,0,0,0,1},{0,1,0,1,1,0,0,0},{0,0,1,0,0,0,0,0}
                ,{0,0,1,0,0,1,1,1},{0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0},{0,1,0,0,1,0,0,0}};
        Vertex[] vertexarray = {new Vertex('A'),new Vertex('B'),new Vertex('C'),new Vertex('D'),new Vertex('E'),new Vertex('F'),new Vertex('G')
        ,new Vertex('H')};
        Graph g = new Graph(map,vertexarray);
        g.bfs();
    }
}
class Vertex{
    public char label;
    public boolean visited=false;
    public Vertex(char c){
        label=c;
    }
}