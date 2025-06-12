import org.w3c.dom.Node;

static Node insert(Node root, int val) {
    
    if (root == null) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.ht = 0;
        return newNode;
    }
    
    if (val < root.val) {
        root.left = insert(root.left, val);
    } else if (val > root.val) {
        root.right = insert(root.right, val);
    } else {
        return root;
    }
    
    root.ht = 1 + Math.max(height(root.left), height(root.right));
    
    int balance = getBalance(root);
    
    
    if (balance > 1 && val < root.left.val) {
        return rightRotate(root);
    }
    
    if (balance < -1 && val > root.right.val) {
        return leftRotate(root);
    }
    
    if (balance > 1 && val > root.left.val) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }
    
    if (balance < -1 && val < root.right.val) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }
    
    return root;
}

static int height(Node node) {
    if (node == null) {
        return -1;
    }
    return node.ht;
}

static int getBalance(Node node) {
    if (node == null) {
        return 0;
    }
    return height(node.left) - height(node.right);
}

static Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;
    
    x.right = y;
    y.left = T2;
    
    y.ht = Math.max(height(y.left), height(y.right)) + 1;
    x.ht = Math.max(height(x.left), height(x.right)) + 1;
    
    return x;
}

static Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;
    
    y.left = x;
    x.right = T2;
    
    x.ht = Math.max(height(x.left), height(x.right)) + 1;
    y.ht = Math.max(height(y.left), height(y.right)) + 1;
    
    return y;
}