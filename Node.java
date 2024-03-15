//import java.util.ArrayList;
//
//class TreeArr {
//    private ArrayList<String> arrayList;
//
//    public TreeArr(ArrayList<String> arrayList) {
//        this.arrayList = arrayList;
//    }
//
//    public void display() {
//        for (String fruit : arrayList) {
//            System.out.println(fruit);
//        }
//    }
//}


//import java.util.ArrayList;
//
//public class treeArr {
//    private String name;
//    private ArrayList<treeArr> children;
//
//    public treeArr(String name) {
//        this.name = name;
//        this.children = new ArrayList<treeArr>();
//    }
//
//    public void addChild(treeArr tree) {
//        children.add(tree);
//    }
//
//    public void display() {
//        System.out.println(name);
//        for (treeArr child : children) {
//            child.display();
//        }
//    }
//}


import java.util.ArrayList;

public class Node {
    private String name;

    public String getName() {
        return name;
    }

    private ArrayList<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<Node>();
    }

    public void addChild(Node node) {
        children.add(node);
    }
    public void display(int tab) {
        System.out.println(name);
        for (Node child : children) {
            for (int i = 0 ; i < tab ; i++)
                 System.out.print("  ");
            child.display(tab+1);
        }
    }
    public void addChild(Object obj) {
        if (obj instanceof Node) {
            children.add((Node) obj);
        } else if (obj instanceof String) {
            children.add(new Node(obj.toString()));
        }
    }
}