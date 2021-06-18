
public class SearchBook {
    public static TreeNode root;
    private Book books[];
    
    public SearchBook(Book books[]){
        this.books = books;
        generateTree();
    }
    
    public Book find(int bookID){
        TreeNode current = this.root;
        while(current != null){
            Book currBook = current.getData();
            if(currBook.getID() == bookID){
                Menu.printMessage("Book Exists in library");
                return currBook;
            }else if(bookID < currBook.getID()){
                current = current.getLeft();
            }else{
                current= current.getRight();
            }
        }
        Menu.printMessage("Book with the ID " + bookID +",is not found in the library");
        return null;
    }
    
    private void generateTree () {        
        for (int idx = 0;idx < books.length;idx++) {
            this.root = insertIntoTree(this.root, books[idx]);
        }
    }
    
    private TreeNode insertIntoTree(TreeNode root, Book currBook){
        TreeNode newNode = new TreeNode(currBook);
        if(root == null){
            return newNode;
        }else {
            if (currBook.getID() < root.getData().getID()) {
                root.setLeft(insertIntoTree(root.getLeft(), currBook));
            }else {
                root.setRight(insertIntoTree(root.getRight(), currBook));
            }
        }
        return root;
    }
    
    //for testing the position
    public void displayTree (TreeNode root) {
        if (root == null)
            return;
        displayTree(root.getLeft());
        System.out.print(root.getData().getID() + "   ");
        displayTree(root.getRight());
    }
}
class TreeNode{
    private Book currBook;
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode(Book currBook){
        this.currBook = currBook;
        left = null;
        right = null;
    }
    
    public void setLeft (TreeNode newLeft) {
        this.left = newLeft;
    }
    
    public void setRight (TreeNode newRight) {
        this.right = newRight;
    }
    
    public void setData (Book newBook) {
        this.currBook = newBook;
    }
    
    public TreeNode getLeft () {
        return this.left;
    }
    
    public TreeNode getRight () {
        return this.right;
    }
    
    public Book getData () {
        return this.currBook;
    }
}