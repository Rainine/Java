package 享元模式;

import java.util.HashMap;

/**
 * @author lxy
 * @date 2021/1/23 15:27
 **/
public class TreeFactory {

    private HashMap<String, AbstractTree> treeHashMap = new HashMap<>();



    public AbstractTree getTree(String type) {
        if (!treeHashMap.containsKey(type)) {
            treeHashMap.put(type, new TreeImpl(type));
        }
        return treeHashMap.get(type);
    }
    public int getSize(){
        System.out.println("树的种类(对象)"+treeHashMap.size()+"种");
        return treeHashMap.size();
    }
}
