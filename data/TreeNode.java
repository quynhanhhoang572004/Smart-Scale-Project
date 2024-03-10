package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String data;
    private ArrayList<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public static void saveTreeToFile(TreeNode root, String filePath) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        // Pre-order traversal
        writeNode(writer, root, 0);

        writer.close();
    }

    private static void writeNode(BufferedWriter writer, TreeNode node, int depth) throws Exception {
        // Indentation based on depth
        for (int i = 0; i < depth; i++) {
            writer.write("\t");
        }

        writer.write(node.getData());
        writer.newLine();

        // Write children recursively
        for (TreeNode child : node.getChildren()) {
            writeNode(writer, child, depth + 1);
        }
    }

    public static TreeNode readTreeFromFile(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        TreeNode root = null;
        int currentDepth = -1;

        while ((line = reader.readLine()) != null) {
            line = line.trim();  // Remove leading/trailing whitespace

            int depth = countTabs(line);

            if (depth > currentDepth) {
                // Child node
                TreeNode child = new TreeNode(line.substring(depth + 1));
                if (root == null) {
                    root = child;
                } else {
                    // Add child to the last parent encountered at the correct depth
                    findParent(root, currentDepth).addChild(child);
                }
            } else if (depth == currentDepth) {
                // Sibling node (shouldn't happen in a proper tree)
                throw new Exception("Invalid tree format: Unexpected sibling node");
            } else {
                // New parent node
                root = new TreeNode(line);
                currentDepth = depth;
            }
        }

        reader.close();
        return root;
    }

    private static int countTabs(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == '\t') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static TreeNode findParent(TreeNode node, int depth) {
        if (node.getChildren().isEmpty() || depth == 0) {
            return node;
        }
        for (TreeNode child : node.getChildren()) {
            TreeNode parent = findParent(child, depth - 1);
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }
}
