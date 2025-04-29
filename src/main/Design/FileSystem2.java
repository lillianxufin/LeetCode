package main.Design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileSystem2 {
	class File{
		String content = "";
		HashMap<String, File> children;
		boolean isFile = false;
		public File() {
			children = new HashMap<>();
		}
	}
	
	File root;
	public FileSystem2() {
		root = new File();
	}
	
	private File search(String path) {
		String[] dirs = path.split("/");
		
		File node = root;
		for(String dir : dirs) {
			if(dir.length() == 0) continue;
			if(!node.children.containsKey(dir)) node.children.put(dir, new File());
			node = node.children.get(dir);
		}
		return node;
	}
	
	public void mkdir(String path) {
		search(path);
	}
	
	public void addContentToFile(String filePath, String content) {
		File node = search(filePath);
		
		node.isFile = true;
		node.content += content;
	}
	
	public String readContentFromFile(String filePath) {
		File node = search(filePath);
		
		return node.content;
	}
	
	
	public List<String> ls(String path) {
		String[] dirs = path.split("/");
		List<String> result = new ArrayList<>();
		
		File node = root;
		String name = "";
		for(String dir : dirs) {
			if(dir.length() == 0) continue;
			if(!node.children.containsKey(dir)) return new ArrayList<>();
			node = node.children.get(dir);
			name = dir;
		}
		if(node.isFile) {
			result.add(name);
		} else {
			for(String child : node.children.keySet()) result.add(child);
		}
		Collections.sort(result);
		return result;
	}
    
    public static void main(String[] args) {
    	FileSystem2 fs = new FileSystem2();
    	fs.mkdir("/a/b");
    	System.out.println(fs.ls("/"));
    	fs.mkdir("/c/d");
    	System.out.println(fs.ls("/a/"));
    	fs.addContentToFile("/a/file", "hello");
    	System.out.println(fs.readContentFromFile("/a/file"));
    	System.out.println(fs.ls("/a"));
    	fs.mkdir("/c/d/e");
    	System.out.println(fs.ls("/c/d"));
    	System.out.println(fs.ls("/c/d/test"));
    	System.out.println(fs.ls("/c/d/"));
    	fs.mkdir("/c/d/test3");
    	fs.mkdir("/c/d/test2");
    	fs.mkdir("/c/d/test");
    	System.out.println(fs.ls("/c/d/"));
    	fs.addContentToFile("/a/file", "hello");
    	System.out.println(fs.readContentFromFile("/a/file"));
    }
   
}
