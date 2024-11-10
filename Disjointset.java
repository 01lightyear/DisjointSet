package Disjointset;
import java.util.*;
public class Disjointset {
    public int find(int[] parent, int target) {
        if(parent[target]>=0){
            parent[target]=find(parent,parent[target]);//path compression
            return parent[target];
        }
    return target;
    }
    public void union(int[] parent,int node1,int node2){
        int root1=find(parent,node1);
        int root2=find(parent,node2);
        if(root1!=root2){//union by rank
            if(parent[root1]<=parent[root2]){
                parent[root1]+=parent[root2];
                parent[root2]=root1;
            }
            else if(parent[root1]>parent[root2]){
                parent[root2]+=parent[root1];
                parent[root1]=root2;
            }
            else{//if ranks are equal,make one as parent of other
                parent[root2]=root1;
                parent[root1]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] parent={-1,-1,-1,-1,-1,-1};//initial parent array where all nodes are single nodes
        Disjointset ds=new Disjointset();
        ds.union(parent,1,2);
        System.out.println(Arrays.toString(parent));
        ds.union(parent,2,3);
        System.out.println(Arrays.toString(parent));
        ds.union(parent,4,5);
        System.out.println(Arrays.toString(parent));
        ds.union(parent,3,5);
        System.out.println(ds.find(parent,5));
        System.out.println(Arrays.toString(parent));
    }
}
