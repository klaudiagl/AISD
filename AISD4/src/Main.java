

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		BST tree = new BST();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/Commands.txt")));
			String cmd;
			String[] cmdArgs;
			int count = Integer.parseInt(br.readLine());
			for(int i=0; i<count; i++){
				cmd = br.readLine();
				cmdArgs = cmd.split(" ");
				switch(cmdArgs[0]){
				case "insert": tree.addNode(Integer.parseInt(cmdArgs[1])); break;
				case "delete": tree.delete(Integer.parseInt(cmdArgs[1])); break;
				case "find": tree.find(Integer.parseInt(cmdArgs[1])); break;
				case "print": tree.printInorder(); break;
				case "max": tree.maximum(); break;
				case "min": tree.minimum(); break;
				default: break;
				}

			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}

	}
	
}
