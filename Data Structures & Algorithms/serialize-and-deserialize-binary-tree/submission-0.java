
public class Codec {
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0 || data == null || data == "") return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(q);
    }
    private TreeNode helper(Queue<String> q){
        if(q.isEmpty()) return null;
        String s = q.poll();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }
}
