package download.dsalgo.problems;

import java.util.Arrays;
import java.util.Stack;

import download.dsalgo.poc.Strings;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * Examples:
 * 
 * path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c" Note that
 * absolute path always begin with ‘/’ ( root directory ) Path will not have
 * whitespace characters.
 * 
 * @author kaussark
 *
 */
public class Problem104 {

	public static void main(String[] args) {
		String director =
				//"/../";
				//"/home/"; 
				"/a/./b/../..//c/";
		System.out.println(new Problem104().simplifyPath(director));
	}

	public String simplifyPath(String A) {
		StringBuilder simplified = new StringBuilder();
		String[] directories = A.split("/");

		Stack<String> visitedDir = new Stack<>();

		for (String dir : directories) {
			if (dir.equals("..") && !visitedDir.isEmpty()) {
				visitedDir.pop();
			} else if (!dir.equals(".") && !dir.isEmpty() && !dir.equals(" ") && !dir.equals("..")) {
				visitedDir.push(dir);
			}
		}
		
		Stack<String> temp = new Stack<>();
		while(!visitedDir.isEmpty()) {
			temp.push(visitedDir.pop());
		}
		simplified.append("/");
		while(!temp.isEmpty()) {
			simplified.append(temp.pop());
			if(!temp.isEmpty()) {
				simplified.append("/");
			}
		}

		return simplified.toString();
	}
}
