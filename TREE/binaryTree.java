import java.util.*;
public class binaryTree{
    class Node{
        int val;
        Node left;
        Node right;

    }
    private Node root;
    Scanner sc=new Scanner(System.in);
    public binaryTree(){
        root=CreateTree();
    }
    private Node CreateTree(){
        int item=sc.nextInt();
        Node nn=new  Node();
        nn.val=item;
        boolean hlc=sc.nextBoolean();
        if(hlc){
            nn.left=CreateTree();
        }
        boolean hrc=sc.nextBoolean();
        if(hrc){
            nn.right=CreateTree();

        }
        return nn;


    }
    public void display(){
        display(root);


    }
    private void display(Node nn){
        if(nn==null){
            return;
        }
        String s ="<--" + nn.val +"-->";
        if(nn.left!=null){
            s=nn.left.val+s;

        }
        else{
            s="."+s;
        }
        if(nn.right!=null){
            s=s+nn.right.val;

        }
        else{
            s=s+".";
        }
        System.out.println(s);
        display(nn.left);
        display(nn.right);


    }
    public int max(){
        return max(this.root);
    }
    private int max(Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int lmax=max(node.left);
        int rmax=max(node.right);
        return Math.max(node.val,Math.max(lmax,rmax));

        
    }
    public boolean find(int item){
        return find(this.root,item);
    }
    private boolean find(Node nn,int item){
        if(nn==null){
            return false;
        }
        if(nn.val==item){
            return true;
        }
        boolean left=find(nn.left,item);
        boolean right =find(nn.right,item);
        return left || right;
    }
}