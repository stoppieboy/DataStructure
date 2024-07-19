import java.util.*;

class Trie{
    
    class TrieNode{
        TrieNode[] childNode;
        boolean wordEnd;
        public TrieNode(){
            childNode = new TrieNode[26];
            wordEnd = false;
        }
    }
    
    TrieNode root;
    
    Trie(){
        root = new TrieNode();
    }
    
    public void insert(String key){
        key = key.toLowerCase();
        TrieNode ptr = root;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(ptr.childNode[index] == null){
                ptr.childNode[index] = new TrieNode();
            }
            ptr = ptr.childNode[index];
        }
        ptr.wordEnd = true;
    }
    
    public boolean search(String key){
        key = key.toLowerCase();
        TrieNode ptr = root;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(ptr.childNode[index] == null){
                return false;
            }
            ptr = ptr.childNode[index];
        }
        return ptr.wordEnd;
    }
    
    private void dfs(TrieNode root, String key, List<String> results){
        if(root.wordEnd){
            results.add(key);
        }
        
        for(int i = 0; i < 26; i++){
            if(root.childNode[i] != null){
                dfs(root.childNode[i], key+Character.toString('a'+i), results);
            }
        }
        return;
    }
    
    public List<String> searchQuery(String key){
        key = key.toLowerCase();
        TrieNode ptr = root;
        List<String> results = new ArrayList<>();
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i) - 'a';
            if(ptr.childNode[index] == null){
                return results;
            }
            ptr = ptr.childNode[index];
        }
        dfs(ptr, key, results);
        return results;
    }
    
    private void autocompleteFormatting(String query){
        System.out.println("Query String: "+query);
        List<String> results = this.searchQuery(query);
        System.out.println("autocomplete suggestions:- ");
        for(String result: results){
            System.out.print(result+" ");
        }
        System.out.println("\n");
    }
    
    public static void main(String args[]){
        Trie one = new Trie();
        String[] words = {"and", "ant", "do", "Adam", "something", "okay", "ohio", "geekforgeeks", "gee", "geezer", "geesh"};
        for(String word: words){
            one.insert(word);
        }
        
        // String[] searchQueryStrings = {"a", "geek", "bat"};
        // for(String query: searchQueryStrings){
        //     System.out.println("Query String: "+query);
        //     if(one.search(query)){
        //         System.out.println("The query string is present in the Trie");
        //     }else{
        //         System.out.println("The query string is not present in the Trie");
        //     }
        // }
        
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        do{
            System.out.println("Enter the query string: ");
            String[] queryStrings = sc.nextLine().split(" ");
            for(String query: queryStrings){
                one.autocompleteFormatting(query);
            }
            System.out.println("Continue ?(no/yes)");
            loop = !(sc.nextLine().equalsIgnoreCase("no"));
        }while(loop);
        
        // for(String query: searchQueryStrings){
        //     autocompleteFormatting(query, one);
        // }
    }
}
